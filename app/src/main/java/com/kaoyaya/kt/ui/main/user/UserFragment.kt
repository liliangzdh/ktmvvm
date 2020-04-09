package com.kaoyaya.kt.ui.main.user

import com.gyf.immersionbar.ktx.immersionBar
import com.kaoyaya.kt.BR
import com.kaoyaya.kt.R
import com.kaoyaya.kt.databinding.FragmentUserBinding
import com.kaoyaya.mvvmbase.base.BaseVMFragment

class UserFragment : BaseVMFragment<FragmentUserBinding, UserViewModel>() {
    override fun getLayoutId() = R.layout.fragment_user

    override fun initVariableId() = BR.viewModel

    override fun initView() {
        initStatusBar()
    }

    override fun initData() {
    }

    override fun startObserve() {
    }

    fun initStatusBar() {
        immersionBar {
            statusBarDarkFont(false)
            titleBar(binding.toolbar)
        }
    }

}