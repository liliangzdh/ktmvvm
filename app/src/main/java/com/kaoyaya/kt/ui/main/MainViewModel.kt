package com.kaoyaya.kt.ui.main

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kaoyaya.kt.entity.ExamInfo
import com.kaoyaya.kt.entity.LoginReqParam
import com.kaoyaya.kt.http.EduApi
import com.kaoyaya.kt.http.UserApi
import com.kaoyaya.mvvmbase.base.BaseViewModel
import com.kaoyaya.mvvmbase.http.base.RetrofitClient
import com.kaoyaya.mvvmbase.utils.Preference
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel {
    val isExamInfoEmpty: ObservableField<Boolean> = ObservableField(false)

    val examInfoListLiveData = MutableLiveData<MutableList<ExamInfo>>()

    var saveExamInfo by Preference(Preference.ExamInfo, ExamInfo())

    init {
        isExamInfoEmpty.set(saveExamInfo.id == 0)
    }



    constructor() {
        Log.e("test", "hello world ---------")
    }

    fun saveExamInfo(examInfo: ExamInfo){
        saveExamInfo = examInfo
        isExamInfoEmpty.set(false)
    }

    fun request() {

        val eduApi = RetrofitClient.create(EduApi::class.java)


        viewModelScope.launch {
            val res = safeApi {
                eduApi.oemExamTypeList()
            }

            if (res.code != 200) {
                showToast(res.msg)
                return@launch
            }


            res.result?.run {
                if (size > 0) {
                    val children = get(0).children
                    for(exam in children){
                        exam.isSelect = exam.id == saveExamInfo.id
                    }
                    examInfoListLiveData.value = children
                }
            }
        }

    }


    fun closeCommend() {

    }
}