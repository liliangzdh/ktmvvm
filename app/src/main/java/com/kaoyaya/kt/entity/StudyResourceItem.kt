package com.kaoyaya.kt.entity

class StudyResourceItem(var title: String?, var isHeader: Boolean) {

    var id: Int = 0

    var isClass: Boolean = false

    var courseType: String? = null
    var subjectID: Int = 0


    var isSelect: Boolean = false

    fun showLine(): Boolean {
        return "系统班级" != title
    }
}
