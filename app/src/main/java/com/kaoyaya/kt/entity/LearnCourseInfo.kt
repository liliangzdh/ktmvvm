package com.kaoyaya.kt.entity


class LearnCourseInfo {
    val courseNum: Int = 0
    val id: Int = 0
    val lastLessonID: Int = 0
    val lastLessonName: String? = null
    val last_learn_time: String? = null
    val learnNum: Int = 0
    val lessonTitle: String? = null
    val picture: String? = null
    val title: String? = null
    val updateNum: Int = 0


    val progress: String
        get() {
            var progress = 0
            if (courseNum == 0) {
                progress = 0
            } else {
                progress = learnNum * 100 / courseNum

                if (progress >= 100) {
                    progress = 100
                }
            }

            return if (progress == 0) {
                "未学习"
            } else "已学$progress%"

        }

    val progressColor: String
        get() {
            val progress = progress

            return if ("未学习" == progress) {
                "#b2b2b2"
            } else "#5e8ffe"
        }
}
