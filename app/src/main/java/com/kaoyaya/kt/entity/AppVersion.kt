package com.kaoyaya.kt.entity

data class AppVersion(
    val downloadURL: String,
    val mustInstall: Boolean,
    val updateDescription: String,
    val updateTime: String,
    val versionCode: String,
    val versionName: String
){
    constructor():this("",false,"","","","")
}