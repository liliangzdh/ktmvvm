package com.kaoyaya.kt.ui.main.study

import com.gyf.immersionbar.ktx.immersionBar
import com.kaoyaya.kt.BR
import com.kaoyaya.kt.R
import com.kaoyaya.kt.databinding.FragmentStudyBinding
import com.kaoyaya.mvvmbase.base.BaseVMFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class StudyFragment : BaseVMFragment<FragmentStudyBinding, StudyViewModel>() {
    override fun getLayoutId() = R.layout.fragment_study

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
