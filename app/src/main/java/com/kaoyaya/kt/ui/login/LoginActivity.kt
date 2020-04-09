package com.kaoyaya.kt.ui.login

import android.Manifest
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.github.florent37.runtimepermission.kotlin.PermissionException
import com.github.florent37.runtimepermission.kotlin.askPermission
import com.github.florent37.runtimepermission.kotlin.coroutines.experimental.askPermission
import com.hdl.elog.ELog
import com.kaoyaya.kt.BR
import com.kaoyaya.kt.R
import com.kaoyaya.kt.databinding.ActivityLoginBinding
import com.kaoyaya.mvvmbase.base.BaseVMActivity
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel


class LoginActivity : BaseVMActivity<ActivityLoginBinding, LoginViewModel>() {
    override fun getLayoutId() = R.layout.activity_login

//    override fun initVM(): LoginViewModel = getViewModel()

    override fun initVariableId(): Int = BR.viewModel

    override fun initView() {
        initStatusBar()
    }

    override fun initData() {

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

//        testInterfaceCallBack()
        testCoroutinePermission()
    }

    // 接口回调方式 请求权限
    private fun testInterfaceCallBack() {
        askPermission(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) {
            //all of your permissions have been accepted by the user
            ELog.e("57000000")
        }.onDeclined {
            //at least one permission have been declined by the user
            ELog.e("61000000")
        }
        ELog.e("63000000")
    }

    // 协程 方式 请求权限
    private fun testCoroutinePermission() {
        lifecycleScope.launch {
            Log.e("test", "start")
            try {
                val result = askPermission(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
                Log.e("test", "ok")
            } catch (e: PermissionException) {

                Log.e("test", "no ")
                if(e.hasDenied()){
                    // 拒绝了


                    //but you can ask them again, eg:
                }


                if(e.hasForeverDenied()){
                    //the list of forever denied permissions, user has check 'never ask again'


                    //you need to open setting manually if you really need it
                }
            }

            Log.e("test", "end")
        }
    }

}