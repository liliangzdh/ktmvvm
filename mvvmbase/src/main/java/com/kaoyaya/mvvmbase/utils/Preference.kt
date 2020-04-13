package com.kaoyaya.mvvmbase.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.kaoyaya.mvvmbase.CommonApplication
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

//使用 代理  todo default 不能为null
class Preference<T : Any>(val name: String, private val default: T) : ReadWriteProperty<Any?, T> {


    companion object {
        const val Token = "x-token"
        const val ExamInfo = "ExamInfo"
        // 是否含有token，含有就是登录成功，没有就是没有登录
        fun isLogin(): Boolean {
            val token by Preference(Token, "")
            return token.isNotEmpty()
        }
    }


    private val prefs: SharedPreferences by lazy {
        CommonApplication.appContext.getSharedPreferences("kyy", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        Log.e("test", "正在获取：${name}")
        return getValue(name, default)
    }


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        Log.e("test", "正在保存：${name}   ：${value}")
        putValue(name, value)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getValue(name: String, value: T): T {
        with(prefs) {
            val res: Any? = when (default) {
                is Long -> getLong(name, default)
                is Int -> getInt(name, default)
                is Boolean -> getBoolean(name, default)
                is String -> getString(name, default)
                is Float -> getFloat(name, default)
                else -> parse(getString(name, "")) ?: default
            }
            return res as T
        }
    }


    private fun <T> putValue(name: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is String -> putString(name, value)
            is Float -> putFloat(name, value)
            is Long -> putLong(name, value)
            else -> putString(name, json(value))
        }
        // commit 代表同步  apply 代表异步
    }.commit()


    // 把对象转成 String
    private fun <T> json(value: T): String {
        return Gson().toJson(value)
    }

    // 把 字符串转成 对象
    private fun parse(json: String?): T? {
        return Gson().fromJson(json, default::class.java)
    }


}
