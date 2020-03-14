package com.kaoyaya.mvvmbase.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaoyaya.mvvmbase.entity.BaseResponse
import com.kaoyaya.mvvmbase.http.base.ExceptionHandle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseViewModel : ViewModel() {


    val toastMessage = MutableLiveData<String>()

    // call 是传递一个方法。 然后在这里 开启 io 协程 调用 请求方法。
    suspend fun <T : Any> safeApi(call: suspend () -> BaseResponse<T>): BaseResponse<T> {
        return try {
            withContext(Dispatchers.IO) {
                call()
            }
        } catch (e: Exception) {
            val errorMsg = ExceptionHandle.handleException(e)
            BaseResponse<T>(500, errorMsg, null)
        }
    }


    /**
     * 显示toast
     */
    fun showToast(msg: String?) {
        msg?.let {
            toastMessage.value = msg
        }
    }
}