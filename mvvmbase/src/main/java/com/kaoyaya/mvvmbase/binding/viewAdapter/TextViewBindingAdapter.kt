package com.kaoyaya.mvvmbase.binding.viewAdapter

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("textColor")
fun TextView.textColor(color: String) {
    setTextColor(Color.parseColor(color))
}

