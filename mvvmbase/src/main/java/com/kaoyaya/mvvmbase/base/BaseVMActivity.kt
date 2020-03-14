package com.kaoyaya.mvvmbase.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer

abstract class BaseVMActivity<V : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {


    public lateinit var viewModel: VM

    public lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        viewModel = initVM()
        startObserve()

        binding = DataBindingUtil.setContentView(this, getLayoutId())

        binding.setVariable(initVariableId(), viewModel)
        initView()

        initData()


        //定义toast
        viewModel.toastMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    abstract fun getLayoutId(): Int

    abstract fun initVM(): VM

    abstract fun initVariableId(): Int

    abstract fun initView()


    abstract fun initData()

    abstract fun startObserve()


}

