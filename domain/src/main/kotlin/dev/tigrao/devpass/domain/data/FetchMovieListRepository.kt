package dev.tigrao.devpass.domain.data

import dev.tigrao.devpass.api.api.callApi
import dev.tigrao.devpass.api.states.ResultDomain
import dev.tigrao.devpass.api.states.ResultDomainError
import dev.tigrao.devpass.domain.data.response.MovieListItemResponse

internal interface FetchMovieListRepository {

    suspend operator fun invoke(
        parameter: Parameter,
    ): ResultDomain<List<MovieListItemResponse>, ResultDomainError>

    class Parameter(val page: Int)
}

internal class FetchMovieListRepositoryImpl(
    private val api: MovieApi,
) : FetchMovieListRepository {

    override suspend fun invoke(
        parameter: FetchMovieListRepository.Parameter,
    ): ResultDomain<List<MovieListItemResponse>, ResultDomainError> {
        return callApi {
            api.fetchMovieList(parameter.page)
        }
    }
}