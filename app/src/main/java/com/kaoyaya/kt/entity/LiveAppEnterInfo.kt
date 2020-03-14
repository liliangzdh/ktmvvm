package com.kaoyaya.kt.entity

class LiveAppEnterInfo {


    /**
     * ccId : E6214CDB2F09EB92
     * desc :
     * liveId : test
     * liveStartTime : 2020-01-16 19:30:00
     * playPass :
     * receivingInformation :
     * receivingIntro :
     * recordId : 2B940F71397797AB
     * roomId : 7FB0FBBB8D6994969C33DC5901307461
     * templateType : 4
     * title : CPA经济法预科02讲
     * viewName : 正式12_1123761
     */

    var ccId: String? = null
    var desc: String? = null
    var liveId: String? = null
    var liveStartTime: String? = null
    var playPass: String? = null
    var receivingInformation: String? = null
    var receivingIntro: String? = null
    var recordId: String? = null
    var roomId: String? = null
    var templateType: Int = 0
    var title: String? = null
    var viewName: String? = null

    override fun toString(): String {
        return "LiveAppEnterInfo{" +
                "ccId='" + ccId + '\''.toString() +
                ", desc='" + desc + '\''.toString() +
                ", liveId='" + liveId + '\''.toString() +
                ", liveStartTime='" + liveStartTime + '\''.toString() +
                ", playPass='" + playPass + '\''.toString() +
                ", receivingInformation='" + receivingInformation + '\''.toString() +
                ", receivingIntro='" + receivingIntro + '\''.toString() +
                ", recordId='" + recordId + '\''.toString() +
                ", roomId='" + roomId + '\''.toString() +
                ", templateType=" + templateType +
                ", title='" + title + '\''.toString() +
                ", viewName='" + viewName + '\''.toString() +
                '}'.toString()
    }
}
