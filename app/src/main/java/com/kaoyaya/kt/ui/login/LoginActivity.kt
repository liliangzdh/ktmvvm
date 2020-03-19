package com.kaoyaya.kt.ui.login

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.lifecycle.Observer
import com.kaoyaya.kt.BR
import com.kaoyaya.kt.R
import com.kaoyaya.kt.databinding.ActivityLoginBinding
import com.kaoyaya.mvvmbase.base.BaseVMActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel


class LoginActivity : BaseVMActivity<ActivityLoginBinding, LoginViewModel>() {
    override fun getLayoutId() = R.layout.activity_login

    override fun initVM(): LoginViewModel = getViewModel()

    override fun initVariableId(): Int = BR.viewModel

    override fun initView() {

    }

    override fun initData() {
//        val showPswPress = R.mipmap.show_psw_press
    }

    override fun startObserve() {
        viewModel.apply {
            pswStateEvent.observe(this@LoginActivity, Observer {
                if (it) {
                    binding.editPassWord.transformationMethod =
                        HideReturnsTransformationMethod.getInstance()
                } else {
                    binding.editPassWord.transformationMethod =
                        PasswordTransformationMethod.getInstance()
                }
                binding.editPassWord.setSelection(binding.editPassWord.text.toString().length)
            })
        }
    }


}