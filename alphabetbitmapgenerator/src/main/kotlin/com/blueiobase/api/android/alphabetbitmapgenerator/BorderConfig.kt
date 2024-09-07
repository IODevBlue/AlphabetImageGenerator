package com.blueiobase.api.android.alphabetbitmapgenerator

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Paint
import androidx.annotation.ColorInt

/**
 * This class represents configurations for a colored border used by the [AlphabetBitmapGenerator]
 * to surround the generated [Bitmap].
 * @author IO DevBlue
 * @since 1.2.0
 */
class BorderConfig {

    /**
     * Thickness of the border.
     *
     * **NOTE:** For the border to be visible, this value has to be greater than 0.
     */
    var borderThickness = 0F
        set(value) {
            value.let {
                borderPaint.strokeWidth = it
                field = it
            }
        }
    /** Color of the border. */
    @ColorInt
    var borderColor = Color.TRANSPARENT
        set(value) {
            value.let {
                borderPaint.color = it
                field = it
            }
        }

    /** [Paint] object used in drawing the border. */
    internal val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        borderPaint.apply {
            color = borderColor
            style = Paint.Style.STROKE
            strokeWidth = borderThickness
            isAntiAlias = true
        }
    }
}