package com.kaoyaya.kt.http

import com.kaoyaya.kt.entity.*
import com.kaoyaya.mvvmbase.entity.BaseResponse
import retrofit2.http.*
import java.util.*

interface UserApi {

    @GET("api/v1/users/info")
    suspend fun userInfo(): BaseResponse<UserInfo>


    //获取我的学习资源
    @GET("api/v1/users/studyResource")
    suspend fun studyResource(): BaseResponse<HashMap<String, List<StudyResourceItem>>>

    @GET("api/v1/users/getLiveIdAndClassIdByReplayLive")
    suspend fun liveIdAndClassId(): BaseResponse<LiveIdAndClassIdResponse>

    //
    @POST("api/v1/login/password")
    suspend fun passWord(@Body body: LoginReqParam): BaseResponse<LoginResponse>

    // 获取用户分发资源
    @GET("api/v1/distribute/resource")
    suspend fun getUserDistribute(@Query("examType") examType: Int): BaseResponse<ArrayList<HomeResourseDistribute>>

    //获取我的回放直播
    @POST("api/v1/users/replayLive")
    suspend fun replayLive(@Body body: LiveBackRequest): BaseResponse<List<LiveInfo>>

    //    @POST("api/v1/users/replayLiveWithCount")
    //    Observable<BaseResponse<>> replayLiveWithCount(@Body LiveBackRequest body);

    // 获取我的直播列表
    @GET("api/v1/users/preLive?isAllLive=1")
    suspend fun GetPreLive(): BaseResponse<List<LiveInfo>>

    //根据产品分类id获取用户课程信息
    @GET("api/v1/users/myCourse")
    suspend fun getUserCourses(@Query("topId") topId: Int): BaseResponse<UserCoursesResponse>

}
