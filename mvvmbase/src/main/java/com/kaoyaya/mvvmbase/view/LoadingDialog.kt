package com.kaoyaya.mvvmbase.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.kaoyaya.mvvmbase.R


class LoadingDialog : Dialog {


    private var mContext: Context

    private lateinit var textView: TextView

    constructor(context: Context) : super(context, R.style.dialog) {
        this.mContext = context
        setCancelable(true)
        setCanceledOnTouchOutside(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_dialog)
        textView = findViewById(R.id.content)
        findViewById<LinearLayout>(R.id.linear).background.alpha = 150
    }


    fun setText(text: String) {
        show()
        textView.text = text
    }


}