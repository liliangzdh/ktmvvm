package com.kaoyaya.kt.ui.main.home

import com.gyf.immersionbar.ktx.immersionBar
import com.kaoyaya.kt.BR
import com.kaoyaya.kt.R
import com.kaoyaya.kt.databinding.FragmentHomeBinding
import com.kaoyaya.mvvmbase.base.BaseVMFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeFragment : BaseVMFragment<FragmentHomeBinding, HomeViewModel>() {
    override fun getLayoutId() = R.layout.fragment_home


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
            statusBarDarkFont(true)
            titleBar(binding.toolbar)
        }
    }


}