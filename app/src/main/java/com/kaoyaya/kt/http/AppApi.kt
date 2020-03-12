package com.kaoyaya.kt.http


import com.kaoyaya.kt.entity.AppVersion
import com.kaoyaya.mvvmbase.entity.BaseResponse
import retrofit2.http.GET

interface AppApi {

//    @GET("api/v1/app/latest")
//    fun getLastVersion(): BaseResponse<AppVersion>


    //
//    @GET("api/v1/app/latest")
//    fun getLastVersionAsync(): Deferred<BaseResponse<AppVersion>>



    @GET("api/v1/app/latest")
    suspend fun getLastVersion(): BaseResponse<AppVersion>

}