package com.kaoyaya.kt.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.kaoyaya.kt.entity.LoginReqParam
import com.kaoyaya.kt.http.UserApi
import com.kaoyaya.mvvmbase.base.BaseViewModel
import com.kaoyaya.mvvmbase.http.base.RetrofitClient
import com.kaoyaya.mvvmbase.utils.Preference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginViewModel : BaseViewModel() {

    private var xToken by Preference(Preference.Token, "")

    val userName = ObservableField<String>("")
    val passWord = ObservableField<String>("")

    fun login() {
        val userApi = RetrofitClient.create(UserApi::class.java)
        viewModelScope.launch(Dispatchers.Main) {
            val username = userName.get()
            val password = passWord.get()

            if (username.isNullOrBlank() || password.isNullOrBlank()) {
                showToast("用户名或密码不能为空")
                return@launch
            }

            val res = safeApi(call = {
                userApi.passWord(
                    LoginReqParam(
                        username = username,
                        password = password
                    )
                )
            })

            if (res.code != 200) {
                showToast(res.msg)
                return@launch
            }

            res.result?.let {
                xToken = it.token
                showToast("登录成功")
            }
        }
    }
}