package com.kaoyaya.kt.ui.main

import android.util.Log
import androidx.databinding.ObservableField
import com.kaoyaya.mvvmbase.base.BaseViewModel

class MainViewModel : BaseViewModel {
    var isExamInfoEmpty: ObservableField<Boolean> = ObservableField()

    init {
        isExamInfoEmpty.set(false)
    }

    constructor(){
        Log.e("test","hello world ---------")
    }

    fun closeCommend(){

    }
}