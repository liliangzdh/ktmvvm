package com.kaoyaya.mvvmbase.binding.viewAdapter

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("linear")
fun RecyclerView.linear(type: Int) {
    when (type) {
        1 -> this.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        2 -> this.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
    }
}

@BindingAdapter("grid")
fun RecyclerView.grad(num: Int) {
    this.layoutManager = GridLayoutManager(this.context, num)
}

