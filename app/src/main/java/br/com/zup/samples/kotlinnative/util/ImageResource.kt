package br.com.zup.samples.kotlinnative.util

import android.graphics.drawable.Drawable
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import kotlinx.io.ByteArrayOutputStream

actual fun getDataFromImage(imageType: ImageType): ByteArray {
    val image = getImageFromType(imageType)

    val bitmap = (image as BitmapDrawable).bitmap
    val stream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
    return stream.toByteArray()
}

private fun getImageFromType(imageType: ImageType): Drawable {
    throw NotImplementedError("Method getImageFromType not implemented")
}