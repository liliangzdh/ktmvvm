package com.kaoyaya.mvvmbase.http.base

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import java.net.ConnectException


object ExceptionHandle {


    fun handleException(e: Exception): String {
        val ex: String
        if (e is JsonParseException
            || e is JSONException
            || e is ParseException || e is MalformedJsonException
        ) {
            ex = "解析错误"
            return ex
        } else if (e is ConnectException) {
            ex = "连接失败"
            return ex
        } else if (e is javax.net.ssl.SSLException) {
            ex = "证书验证失败"
            return ex
        } else if (e is ConnectTimeoutException) {
            ex = "连接超时"
            return ex
        } else if (e is java.net.SocketTimeoutException) {
            ex = "连接超时"
            return ex
        } else if (e is java.net.UnknownHostException) {
            ex = "没有网络"
            return ex
        } else {
            ex = e.message ?: "未知错误"
            return ex
        }
    }


}
