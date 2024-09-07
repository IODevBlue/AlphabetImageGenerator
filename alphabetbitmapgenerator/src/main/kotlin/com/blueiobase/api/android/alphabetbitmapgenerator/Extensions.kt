package com.blueiobase.api.android.alphabetbitmapgenerator

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import androidx.annotation.ColorInt


///////////////////////////////////////////////////////////////////////////
// CONTEXT
///////////////////////////////////////////////////////////////////////////
/**
 * Extension function on a [Context] to create an [AlphabetBitmapGenerator] instance.
 * @param init Initialization block for the [AlphabetBitmapGenerator].
 */
fun Context.alphabetBitmapGenerator(init: AlphabetBitmapGenerator.()->Unit): AlphabetBitmapGenerator {
    val abg = AlphabetBitmapGenerator(this)
    abg.init()
    return abg
}



///////////////////////////////////////////////////////////////////////////
// STRING
///////////////////////////////////////////////////////////////////////////
/**
 * Extension function on a [String] to generate a rectangular Alphabet Image [Bitmap] using the first character from the [String].
 * @param alphabetBitmapGenerator The [AlphabetBitmapGenerator] used to generate the rectangular image.
 * @param backgroundColor The background color to be applied to the [Bitmap].
 * @param borderConfig The configurations for a border if any.
 * @return A [Bitmap] containing either an Alphabet or the default bitmap set by the [alphabetBitmapGenerator]. If the [String] is empty, a null [Bitmap] is returned.
 * @see generateCircularAlphabetBitmap
 */
fun String.generateAlphabetBitmap(alphabetBitmapGenerator: AlphabetBitmapGenerator, @ColorInt backgroundColor: Int = Color.TRANSPARENT, borderConfig: BorderConfig? = null): Bitmap? {
    return alphabetBitmapGenerator.generateAlphabetBitmap(this, backgroundColor, borderConfig)
}

/**
 * Extension function on a [String] to generate a circular Alphabet Image [Bitmap] using the first character from the [String].
 * - When the [radius] parameter is set to 0 (the default value), it would result in the radius of the generated [Bitmap]
 * being calculated using the width or height set by invoking [AlphabetBitmapGenerator.setDimension] on the [alphabetBitmapGenerator] instance
 * or default width and height (Default = 50dp x 50dp).
 * @param alphabetBitmapGenerator The [AlphabetBitmapGenerator] used to generate the circular image.
 * @param radius The radius of the circle which would contain the Alphabet.
 * @param backgroundColor The background color to be applied to the [Bitmap].
 * @param borderConfig The configurations for a border.
 * @return A circular [Bitmap] containing either an Alphabet or the  the default bitmap set by the [alphabetBitmapGenerator].
 *        If the [String] is empty, a null [Bitmap] is returned.
 * @see generateAlphabetBitmap
 */
fun String.generateCircularAlphabetBitmap(alphabetBitmapGenerator: AlphabetBitmapGenerator, radius: Float = 0F, @ColorInt backgroundColor: Int = Color.TRANSPARENT, borderConfig: BorderConfig? = null): Bitmap? {
    return alphabetBitmapGenerator.generateCircularAlphabetBitmap(this, radius, backgroundColor, borderConfig)
}