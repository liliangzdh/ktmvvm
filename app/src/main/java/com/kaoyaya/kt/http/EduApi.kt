package com.kaoyaya.kt.http


import com.kaoyaya.kt.entity.CourseSampleInfo
import com.kaoyaya.kt.entity.ExamTypeInfo
import com.kaoyaya.kt.entity.LearnInfoResponse
import com.kaoyaya.mvvmbase.entity.BaseResponse
import java.util.HashMap

import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EduApi {


    // 获取 首页 分发资源
    @GET("api/v1/distribute/examType")
    suspend fun oemExamTypeList(): BaseResponse<MutableList<ExamTypeInfo>>


    @POST("api/v1/edu/course/info")
    suspend fun getCourseWareInfo2(@Body data: HashMap<String, List<Int>>): BaseResponse<List<CourseSampleInfo>>


    @FormUrlEncoded
    @POST("api/v1/edu/course/info")
    suspend fun getCourseWareInfo3(@FieldMap data: HashMap<String, List<Int>>): BaseResponse<List<CourseSampleInfo>>


    @GET("api/v1/edu/class/{id}/learnInfo?isLiveAll=1")
    suspend fun getLearnInfo(@Path("id") id: Int): BaseResponse<LearnInfoResponse>

}
