package com.kaoyaya.mvvmbase.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import com.kaoyaya.mvvmbase.R


class DialogUtils {

    /**
     * 设置dialog屏幕宽度
     */
    fun setDialogWidth(context: Context, scale: Double, dialog: Dialog) {

        val dialogWindow = dialog.window
        val dm = DisplayMetrics()

        if (context is Activity) {
            context.windowManager.defaultDisplay.getMetrics(dm)
        }
        val iWidth = (dm.widthPixels * scale).toInt()
        if (dialogWindow != null) {
            val p = dialogWindow.attributes
            p.width = iWidth
            dialogWindow.attributes = p
        }
    }

    fun setDialogWidth(context: Context, width: Int, dialog: Dialog) {

        val dialogWindow = dialog.window
        val dm = DisplayMetrics()

        if (context is Activity) {
            context.windowManager.defaultDisplay.getMetrics(dm)
        }

        if (dialogWindow != null) {
            val p = dialogWindow.attributes
            p.width = width
            dialogWindow.attributes = p
        }
    }

    fun setDialogHeight(context: Context, high: Int, dialog: Dialog) {

        val dialogWindow = dialog.window
        val dm = DisplayMetrics()

        if (context is Activity) {
            context.windowManager.defaultDisplay.getMetrics(dm)
        }

        if (dialogWindow != null) {
            val p = dialogWindow.attributes
            p.height = high
            dialogWindow.attributes = p
        }
    }





}
