package com.kaoyaya.kt.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
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


    // 密码状态
    val pswState = ObservableField<Boolean>(false)

    val pswStateEvent = MutableLiveData<Boolean>()


    fun login() {
        val userApi = RetrofitClient.create(UserApi::class.java)
        viewModelScope.launch(Dispatchers.Main) {
            val username = userName.get() ?: ""
            val password = passWord.get() ?: ""

            if (username.isEmpty() || password.isEmpty()) {
                showToast("用户名或密码不能为空")
                return@launch
            }

            showLoading("正在登陆...")

            val res = safeApi {
                userApi.passWord(LoginReqParam(username, password))
            }
            if (res.code != 200) {
                showToast(res.msg)
                dismissLoading()
                return@launch
            }

            res.result?.apply {
                xToken = token
                showToast("登录成功")
                dismissLoading()
            }
        }
    }

    fun clearUsername() {
        userName.set("")
    }


    fun changePsw() {
        val state = pswState.get() ?: false
        pswState.set(!state)
        pswStateEvent.value = !state
    }


}