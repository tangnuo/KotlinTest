package com.kedacom.widget.photoview

import android.view.MotionEvent
import android.widget.ImageView

internal object Util {

    @JvmStatic
    fun checkZoomLevels(minZoom: Float, midZoom: Float,
                        maxZoom: Float) {
        require(minZoom < midZoom) { "Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value" }
        require(midZoom < maxZoom) { "Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value" }
    }

    @JvmStatic
    fun hasDrawable(imageView: ImageView): Boolean {
        return imageView.drawable != null
    }

    @JvmStatic
    fun isSupportedScaleType(scaleType: ImageView.ScaleType?): Boolean {
        when (scaleType) {
            null -> return false
            ImageView.ScaleType.MATRIX -> throw IllegalStateException("Matrix scale type is not supported")
            else -> {
            }
        }
        return true
    }

    @JvmStatic
    fun getPointerIndex(action: Int): Int {
        return action and MotionEvent.ACTION_POINTER_INDEX_MASK shr MotionEvent.ACTION_POINTER_INDEX_SHIFT
    }
}
