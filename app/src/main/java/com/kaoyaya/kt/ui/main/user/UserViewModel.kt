package com.kaoyaya.kt.ui.main.user

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.kaoyaya.kt.entity.UserInfo
import com.kaoyaya.kt.http.UserApi
import com.kaoyaya.kt.ui.login.LoginActivity
import com.kaoyaya.mvvmbase.base.BaseViewModel
import com.kaoyaya.mvvmbase.http.base.RetrofitClient
import com.kaoyaya.mvvmbase.utils.Preference
import kotlinx.coroutines.launch

class UserViewModel : BaseViewModel {


    val isLogin = ObservableField<Boolean>()
    val userInfoField = ObservableField<UserInfo>()

    private val token by Preference(Preference.Token, "")

    constructor() {
        isLogin.set(token.isNotEmpty())
//        if (token.isNotEmpty()) {
//            getUserInfo()
//        }
    }


    fun goLogin() {
        startAct(LoginActivity::class.java)
    }


    fun getUserInfo() {
        isLogin.set(token.isNotEmpty())
        val userApi = RetrofitClient.create(UserApi::class.java)
        viewModelScope.launch {
            val userInfoRes = safeApi { userApi.userInfo() }
            if (userInfoRes.code != 200) {
                return@launch
            }
            userInfoField.set(userInfoRes.result)
        }
    }
}
