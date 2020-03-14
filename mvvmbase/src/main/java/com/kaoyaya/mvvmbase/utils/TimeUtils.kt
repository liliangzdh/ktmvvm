package com.kaoyaya.mvvmbase.utils

import android.text.TextUtils

import java.text.SimpleDateFormat
import java.util.Date

object TimeUtils  {


    fun getTime(startTime: String?): Int {
        try {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val parse = sdf.parse(startTime)
            val now = Date()
            return ((parse!!.time - now.time) / 1000).toInt()
        } catch (e: Exception) {
            return -1
        }

    }


    fun getFormatTimeStr(startTime: String): String {
        val time = getTime(startTime)
        if (time > 0) {
            val second = time % 60
            val minute = time / 60 % 60
            val hour = time / 60 / 60
            return (if (hour >= 10) hour else "0$hour").toString() + "小时" + (if (minute >= 10) minute else "0$minute") + "分" + (if (second >= 10) second else "0$second") + "秒"
        }
        return "00小时00分00秒"
    }

    fun formatTime(startTime: String?, dateFormat: String = "HH:mm"): String {
        if (TextUtils.isEmpty(startTime)) {
            return ""
        }
        try {
            var sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val parse = sdf.parse(startTime)
            sdf = SimpleDateFormat(dateFormat)
            return sdf.format(parse!!)
        } catch (e: Exception) {
            return startTime?:""
        }

    }
}
