package com.kaoyaya.mvvmbase.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gyf.immersionbar.ktx.immersionBar
import com.kaoyaya.mvvmbase.R
import com.kaoyaya.mvvmbase.view.LoadingDialog
import java.lang.reflect.ParameterizedType


abstract class BaseVMActivity<V : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {


    lateinit var viewModel: VM

    lateinit var binding: V


    private lateinit var loadingDialog: LoadingDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        viewModel = getVM()
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(initVariableId(), viewModel)
        initView()

        initData()
        startObserve()

        loadingDialog = LoadingDialog(this)
        addObserve()
    }

    abstract fun getLayoutId(): Int

//    abstract fun initVM(): VM

    private fun getVM(): VM {
        val modelClass: Class<VM>
        val type = javaClass.genericSuperclass
        modelClass = if (type !is ParameterizedType) {
            //如果没有指定泛型参数，则默认使用BaseViewModel
            BaseViewModel::class.java as Class<VM>
        } else {
            type.actualTypeArguments[1] as Class<VM>
        }
        return createViewModel(modelClass)
    }

    /**
     * 创建ViewModel
     */
    private fun createViewModel(cls: Class<VM>): VM {
        return ViewModelProvider(this).get(cls)
    }


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


        viewModel.intentEvent.observe(this, Observer {
            val actClass = it["act"] as Class<*>
            val bundle = it["bundle"]
            val intent = Intent(this@BaseVMActivity, actClass)
            bundle?.run {
                intent.putExtra("bundle", bundle as Bundle)
            }
            startActivity(intent)
        })


        viewModel.finishEvent.observe(this, Observer {
            finish()
        })
    }


    fun initStatusBar(view: View) {
        immersionBar {
            statusBarDarkFont(true)
            titleBar(view)
        }
    }

    fun initStatusBar() {
        immersionBar {
            fitsSystemWindows(true)
            statusBarColor(R.color.white)
            statusBarDarkFont(true)
        }
    }


}

