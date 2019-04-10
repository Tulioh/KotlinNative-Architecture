package br.com.zup.samples.kotlinnative.util

enum class ImageType {
    IC_PERSON
}

expect fun getDataFromImage(imageType: ImageType): ByteArray