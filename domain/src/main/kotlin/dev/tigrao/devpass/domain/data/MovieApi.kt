package dev.tigrao.devpass.domain.data

import dev.tigrao.devpass.domain.data.response.MovieListItemResponse
import dev.tigrao.devpass.domain.data.response.MovieListItemSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieApi {

    @GET("shows")
    suspend fun fetchMovieList(
        @Query("page") page: Int
    ): List<MovieListItemResponse>

    @GET("search/shows")
    suspend fun searchMovieList(
        @Query("q") query: String,
        @Query("page") page: Int
    ): List<MovieListItemSearchResponse>
}