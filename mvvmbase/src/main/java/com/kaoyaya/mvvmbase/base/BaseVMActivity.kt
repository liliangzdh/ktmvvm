package com.kaoyaya.mvvmbase.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.kaoyaya.mvvmbase.view.LoadingDialog

abstract class BaseVMActivity<V : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {


    lateinit var viewModel: VM

    lateinit var binding: V

    private lateinit var loadingDialog: LoadingDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        viewModel = initVM()

        binding = DataBindingUtil.setContentView(this, getLayoutId())

        binding.setVariable(initVariableId(), viewModel)
        initView()

        initData()
        startObserve()

        loadingDialog = LoadingDialog(this)
        addObserve()
    }

    abstract fun getLayoutId(): Int

    abstract fun initVM(): VM

    abstract fun initVariableId(): Int

    abstract fun initView()


    abstract fun initData()

    abstract fun startObserve()


    private fun showLoading(text: String = "加载中...") {
        loadingDialog.setText(text)
    }

    private fun dismissLoading() {
        loadingDialog.dismiss()
    }

    private fun addObserve() {
        //定义toast
        viewModel.toastMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        // 弹窗 设置
        viewModel.loadingEvent.observe(this, Observer {
            if (false.toString() == it) {
                dismissLoading()
            } else {
                showLoading(it)
            }
        })
    }
}

