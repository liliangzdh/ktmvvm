package com.kaoyaya.kt.entity

import android.text.TextUtils


import com.kaoyaya.mvvmbase.utils.TimeUtils

class LiveInfo {


    /**
     * access : 0
     * courseId : 99543
     * courseTitle : 管理会计直播课-加菲猫
     * free : 0
     * category :
     * expiryDay : 365
     * needLogin : 1
     * mediaId : 3275
     * lessonTitle : 《成本管理》1
     * end_time : 2019-11-13 21:30:00
     * start_time : 2019-11-13 20:00:00
     * picture : https://img.kaoyaya.com/Ntsl/www/10/1571370910.png
     * nickname : 加菲猫老师
     * livePlatform : 1
     * subscribeNum : 0
     * subscribeStatus : false
     *
     *
     * activation_time
     * deadline
     * is_activate
     * id :92301
     * type:
     */


    //首页的资源
    var access: Int = 0
    var courseId: Int = 0
    var courseTitle: String? = null
    var free: Int = 0
    var category: String? = null
    var expiryDay: Int = 0
    var needLogin: Int = 0
    var mediaId: Int = 0
    var lessonTitle: String? = null
    var end_time: String? = null
        get() = if (TextUtils.isEmpty(field)) {
            endTime
        } else field
    var start_time: String? = null
        get() = if (TextUtils.isEmpty(startTime)) {
            field
        } else startTime
    private val startTime: String? = null
    private val endTime: String? = null
    var picture: String? = null
    var nickname: String? = null
    var livePlatform: Int = 0
    var subscribeNum: Int = 0
    var isSubscribeStatus: Boolean = false
    var isStart: Boolean = false

    var title: String? = null
    var fromStartTimeStr: String = ""


    //直播 回放两个tad
    val id: Int = 0
    val activationTime: String? = null
    val deadline: String? = null
    private val is_activate: Int = 0
    val type: String? = null
    private val number: Int = 0

    val startAndEndTime: String
        get() = TimeUtils.formatTime(start_time) + "-" + TimeUtils.formatTime(
            end_time
        )


    val startAndEndTime2: String
        get() = TimeUtils.formatTime(
            start_time,
            "yyyy-MM-dd HH:mm"
        ) + "-" + TimeUtils.formatTime(end_time)

    val liveBackInfo: String
        get() = number.toString() + "播放 | " + start_time

    fun activate(): Int {
        return is_activate
    }

    fun getIsStart(): Boolean {
        return TimeUtils.getTime(start_time) <= 0
    }
}
