package br.com.zup.samples.kotlinnative.data.entity

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResultsEntity(
    @Optional @SerialName("Search") val search: List<MovieEntity>? = null,
    @Optional @SerialName("totalResults") val totalResults: String? = null,
    @Optional @SerialName("Response") val response: String? = null
) {
    @Serializable
    data class MovieEntity(
        @Optional @SerialName("Title") val title: String? = null,
        @Optional @SerialName("Year") val year: String? = null,
        @Optional @SerialName("Rated") val rated: String? = null,
        @Optional @SerialName("Released") val released: String? = null,
        @Optional @SerialName("Runtime") val runtime: String? = null,
        @Optional @SerialName("Genre") val genre: String? = null,
        @Optional @SerialName("Director") val director: String? = null,
        @Optional @SerialName("Writer") val writer: String? = null,
        @Optional @SerialName("Actors") val actors: String? = null,
        @Optional @SerialName("Plot") val plot: String? = null,
        @Optional @SerialName("Language") val language: String? = null,
        @Optional @SerialName("Country") val country: String? = null,
        @Optional @SerialName("Awards") val awards: String? = null,
        @Optional @SerialName("Poster") val poster: String? = null,
        @Optional @SerialName("Metascore") val metascore: String? = null,
        @Optional @SerialName("imdbRating") val imdbRating: String? = null,
        @Optional @SerialName("imdbVotes") val imdbVotes: String? = null,
        @Optional @SerialName("imdbID") val imdbID: String? = null,
        @Optional @SerialName("Type") val Type: String? = null,
        @Optional @SerialName("DVD") val dvd: String? = null,
        @Optional @SerialName("BoxOffice") val boxOffice: String? = null,
        @Optional @SerialName("Production") val production: String? = null,
        @Optional @SerialName("Website") val website: String? = null,
        @Optional @SerialName("Response") val response: String? = null,
        @Optional @SerialName("Ratings") val ratings: List<Rating>? = null
    )

    @Serializable
    data class Rating(
        @Optional @SerialName("Source") val source: String? = null,
        @Optional @SerialName("Value") val value: String? = null
    )
}