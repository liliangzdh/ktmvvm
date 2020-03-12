package com.kaoyaya.kt.ui.login

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.kaoyaya.kt.http.AppApi
import com.kaoyaya.mvvmbase.http.base.RetrofitClient
import com.kaoyaya.mvvmbase.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginViewModel : BaseViewModel() {
    val userName = ObservableField<String>("")
    val password = ObservableField<String>("")


    fun login() {
        Log.e("test", "${userName.get()}  :======:  ${password.get()}")
        val appApi = RetrofitClient.create(AppApi::class.java)
        viewModelScope.launch(Dispatchers.Main) {
            val res = safeApi(call = {appApi.getLastVersion()})
            Log.e("test",":${res.code}")
        }
    }
}