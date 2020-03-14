package com.kaoyaya.kt.entity

import java.text.SimpleDateFormat

class CourseInfo {


    /**
     * picture : https://img.kaoyaya.com/Ntsl/www/09/1535939669.png
     * title : 2018税务师考试《涉税服务相关法律》精讲视频
     * id : 91220
     * type : normal
     * url :
     * is_activate : 1
     * activation_time : 2019-02-01 22:51:50
     * deadline : 2022-01-31 22:51:50
     * categoryId : 6958
     * expiryDay : 365
     * hitNum : 2107
     * studentNum : 2472
     * memberStart : 1580
     * lessonNum : 35
     * last_learn_lesson : 0
     * last_learn_time : 0001-01-01 00:00:00
     * mediaId : 0
     * lessonTitle :
     * topId : 541
     * progress : 0
     * updateNum : 0
     */

    var picture: String? = null
    var title: String? = null
    var id: Int = 0
    var type: String? = null
    var url: String? = null
    var is_activate: Int = 0
    var activation_time: String? = null
    var deadline: String? = null
    var categoryId: Int = 0
    var expiryDay: Int = 0
    var hitNum: Int = 0
    var studentNum: Int = 0
    var memberStart: Int = 0
    var lessonNum: Int = 0
    var last_learn_lesson: Int = 0
    var last_learn_time: String? = null
    var mediaId: Int = 0
    var lessonTitle: String? = null
    var topId: Int = 0
    var progress: Float = 0.toFloat()
    var updateNum: Int = 0

    val studyProgress: String
        get() = "已学" + progress.toInt() + "%"

    val periodTime: String
        get() = format(activation_time) + " - " + format(deadline)


    fun format(time: String?): String? {
        try {
            var formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val parse = formatter.parse(time!!)
            formatter = SimpleDateFormat("yyyy-MM-dd")
            return formatter.format(parse!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return time
    }
}
