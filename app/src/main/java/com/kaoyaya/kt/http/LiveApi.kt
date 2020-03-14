package com.kaoyaya.kt.http


import com.kaoyaya.kt.entity.LiveAppEnterInfo
import com.kaoyaya.kt.entity.LiveInfo
import com.kaoyaya.mvvmbase.entity.BaseResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface LiveApi {


    //http://www.kaoyaya.com/api/v1/live/newHotPreLive?isAll=1

    // 获取首页的直播数据
    @GET("/api/v1/live/newHotPreLive?isAll=1")
    suspend fun hotPreLive(): BaseResponse<List<LiveInfo>>


    // app App进去CC直播间
    @GET("/api/v1/live/appEnterLiveRoom")
    suspend fun appEnterLiveRoom(@Query("id") id: Int): BaseResponse<LiveAppEnterInfo>


}
