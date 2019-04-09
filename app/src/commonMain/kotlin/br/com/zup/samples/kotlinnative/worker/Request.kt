package br.com.zup.samples.kotlinnative.worker

data class HttpRequest(
    val path: String,
    val method: HttpMethod,
    val body: String? = null,
    val headers: Map<String, String>? = null
)

enum class HttpMethod {
    GET,
    POST,
    PUT,
    DELETE,
}