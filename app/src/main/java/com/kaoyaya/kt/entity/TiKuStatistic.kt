package com.kaoyaya.kt.entity

class TiKuStatistic {


    /**
     * totalQuestion : 3442
     * doneQuestion : 9
     * rightQuestion : 3
     * practiceRecord : {"subjectID":219,"practiceType":1,"practiceID":8486,"practiceMode":1,"lastPracticeName":"第一章总论"}
     * tiKuModal : {"isShowChapter":true,"isShowKnowledge":true,"isShowExamMock":true,"isShowTrueQuestion":true,"isShowTopSecret":false,"isExamHomework":true,"isErrorQuestion":true}
     */

    var totalQuestion: Int = 0
    var doneQuestion: Int = 0
    var rightQuestion: Int = 0
    var practiceRecord: PracticeRecordBean? = null
    var tiKuModal: TiKuModalBean? = null

    var name: String? = null


    val right: String
        get() = if (doneQuestion == 0) {
            "0"
        } else (rightQuestion * 100 / doneQuestion).toString() + ""

    val done: String
        get() = if (totalQuestion == 0) {
            "0"
        } else (doneQuestion * 100 / totalQuestion).toString() + ""

    val doneQuestionStr: String
        get() = "" + doneQuestion
}
