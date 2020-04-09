package com.kaoyaya.mvvmbase.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kaoyaya.mvvmbase.view.LoadingDialog
import java.lang.reflect.ParameterizedType


abstract class BaseVMFragment<V : ViewDataBinding, VM : BaseViewModel> : Fragment() {


    lateinit var binding: V

    lateinit var viewModel: VM

    lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mContext = inflater.context
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingDialog = LoadingDialog(mContext)
        viewModel = getVM()
        binding.setVariable(initVariableId(), viewModel)
        initView()
        initData()
        startObserve()
        addObserve()

    }

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


    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    abstract fun getLayoutId(): Int

//    abstract fun initVM(): VM

    abstract fun initVariableId(): Int
    abstract fun initView()
    abstract fun initData()

    abstract fun startObserve()

    private fun addObserve() {
        //定义toast
        viewModel.toastMessage.observe(this, Observer {
            Toast.makeText(mContext, it, Toast.LENGTH_SHORT).show()
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

    private fun showLoading(text: String = "加载中...") {
        loadingDialog.setText(text)
    }

    private fun dismissLoading() {
        loadingDialog.dismiss()
    }

}