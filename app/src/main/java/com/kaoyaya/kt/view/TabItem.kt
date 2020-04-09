package com.kaoyaya.kt.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.kaoyaya.kt.R
import me.majiajie.pagerbottomtabstrip.internal.RoundMessageView
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem

class TabItem : BaseTabItem {


    private var mDefaultDrawable: Int = 0
    private var mCheckedDrawable: Int = 0
    private var title = ""

    private val mIcon: ImageView
    private val mTitle: TextView
    private val mMessages: RoundMessageView
    private val linearLayout: View


    private var mDefaultTextColor = 0x56000000
    private var mCheckedTextColor = 0x56000000

    constructor(context: Context) : super(context) {
        LayoutInflater.from(context).inflate(R.layout.item_normal, this, true)
        mIcon = findViewById(R.id.icon)
        mTitle = findViewById(R.id.title)
        mMessages = findViewById(R.id.messages)
        linearLayout = findViewById(R.id.linearLayout)
    }

    /**
     * 方便初始化的方法
     *
     * @param drawableRes        默认状态的图标
     * @param checkedDrawableRes 选中状态的图标
     * @param title              标题
     */
    fun initialize(@DrawableRes drawableRes: Int, @DrawableRes checkedDrawableRes: Int, title: String) {
        mDefaultDrawable = drawableRes
        mCheckedDrawable = checkedDrawableRes
        mTitle.text = title
        this.title = title
    }


    override fun setChecked(checked: Boolean) {
        if (checked) {
            mIcon.setImageResource(mCheckedDrawable)
            mTitle.setTextColor(mCheckedTextColor)
        } else {
            mIcon.setImageResource(mDefaultDrawable)
            mTitle.setTextColor(mDefaultTextColor)
        }
    }

    override fun setSelectedDrawable(drawable: Drawable?) {
    }

    override fun getTitle() = title
    override fun setMessageNumber(number: Int) {
    }

    override fun setDefaultDrawable(drawable: Drawable) {
    }

    override fun setTitle(title: String) {
        mTitle.text = title
    }

    override fun setHasMessage(hasMessage: Boolean) {
    }

    fun setTextDefaultColor(@ColorInt color: Int) {
        mDefaultTextColor = color
    }

    fun setTextCheckedColor(@ColorInt color: Int) {
        mCheckedTextColor = color
    }


}