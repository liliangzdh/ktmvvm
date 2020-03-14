package com.kaoyaya.kt.ui.login

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
    }

    override fun startObserve() {

    }


}