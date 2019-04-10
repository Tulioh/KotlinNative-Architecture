package br.com.zup.samples.kotlinnative.util

import platform.UIKit.UIImage

actual fun getDataFromImage(imageType: ImageType): ByteArray {
    val image = getImageFromType(imageType)

    // TODO: convert UIImage to ByteArray
    throw NotImplementedError("Method getDataFromImage not implemented")
}

private fun getImageFromType(imageType: ImageType): UIImage {
    throw NotImplementedError("Method getImageFromType not implemented")
}