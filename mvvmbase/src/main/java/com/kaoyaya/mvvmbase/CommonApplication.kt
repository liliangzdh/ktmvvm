package com.kaoyaya.mvvmbase

import android.content.Context

object CommonApplication {


    lateinit var appContext: Context

    /**
     * 子模块和主模块需要共享全局上下文，故需要在app module初始化时传入
     */
    fun init(context: Context) {
        this.appContext = context
    }


}
