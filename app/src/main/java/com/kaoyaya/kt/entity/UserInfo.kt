package com.kaoyaya.kt.entity

import android.text.TextUtils

class UserInfo {
    /**
     * uid : 1123761
     * username : 13714996607
     * name :
     * nickname : 正式
     * avatar : http://thirdwx.qlogo.cn/mmopen/kNiakvQjaCpn22ibRVb7lPzqiafJvaOy5nibu5HpvYo0tmSSESnXC2K1d9Q8NjfBEsBLiajPtIm8ZjplVvttlmvT9we7C61j4Dn47/132
     * sex : 0
     * qq :
     * mobile : 13714996607
     * email :
     * idCard :
     * regID : 0
     * currentExamType : 2
     * status : true
     */

    var uid: Int = 0
    var username: String? = null
    var name: String? = null
    var nickname: String? = null
    var avatar: String? = null
    var sex: Int = 0
    var qq: String? = null
    var mobile: String? = null
    var email: String? = null
    var idCard: String? = null
    var isStatus: Boolean = false


    val realName: String?
        get() = if (!TextUtils.isEmpty(nickname)) {
            nickname
        } else username
}
