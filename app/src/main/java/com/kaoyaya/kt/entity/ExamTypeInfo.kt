package com.kaoyaya.kt.entity

class ExamTypeInfo {
    var id = 0
    var name = ""
    var children: MutableList<ExamInfo> = mutableListOf()
}
