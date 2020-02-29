package com.kaoyaya.kt.entity


data class BaseResponse<out T>
    (
    val code: Int,
    val msg: String,
    val result: T
)