package com.kaoyaya.kt.http

import com.kaoyaya.kt.entity.TiKuExamInfo
import com.kaoyaya.kt.entity.TiKuExamResponse
import com.kaoyaya.kt.entity.TiKuStatistic
import com.kaoyaya.mvvmbase.entity.BaseResponse

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TiKuApi {

    //http://www.kaoyaya.com/api/v1/distribute/subject?examType=6

    /***
     * 获取分发的题库
     */
    @GET("/api/v1/distribute/subject")
    suspend fun getDistributeSubject(@Query("examType") examType: Int): BaseResponse<List<TiKuExamInfo>>


    // http://www.kaoyaya.com/api/v1/subjects/8190/subjects
    /**
     * 获取考试类型下的科目
     */
    @GET("/api/v1/subjects/{subjectID}/subjects")
    suspend fun getSubjects(@Path("subjectID") subjectID: Int): BaseResponse<TiKuExamResponse>


    @GET("/api/v1/subjects/{subjectID}/statistic")
    suspend fun getSubjectStatistic(@Path("subjectID") subjectID: Int): BaseResponse<TiKuStatistic>


}
