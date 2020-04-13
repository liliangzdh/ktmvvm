package com.kaoyaya.mvvmbase.binding.viewAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter(value = ["image", "placeholderRes"], requireAll = false)
fun ImageView.loadImage(image: String?, placeholderRes: Int?) {
    placeholderRes?.run {
        Glide.with(this@loadImage).load(image).apply(RequestOptions().placeholder(placeholderRes)).into(this@loadImage)
        return
    }
    Glide.with(this).load(image).into(this)
}


@BindingAdapter(value = ["image"], requireAll = true)
fun ImageView.loadImage(image: Int) {
    Glide.with(this).load(image).into(this)
}




