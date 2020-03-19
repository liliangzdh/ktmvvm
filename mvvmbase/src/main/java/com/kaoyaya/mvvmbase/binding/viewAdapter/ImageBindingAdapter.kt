package com.kaoyaya.mvvmbase.binding.viewAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("image")
fun ImageView.loadImage(url: Int) {
    this.setImageResource(url)
}




