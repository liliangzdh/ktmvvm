package com.kaoyaya.mvvmbase.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kaoyaya.mvvmbase.entity.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

open class BaseViewModel : ViewModel() {


    // call 是传递一个方法。 然后在这里 开启 io 协程 调用 请求方法。
    suspend fun <T : Any> safeApi(call: suspend () -> BaseResponse<T>): BaseResponse<T> {
        return try {
            withContext(Dispatchers.IO) {
                Log.e("test","start")
                sleep(10 * 1000)
                Log.e("test","end")
                call()
            }
        } catch (e: Exception) {
            BaseResponse<T>(500, e.message, null)
        }
    }
}