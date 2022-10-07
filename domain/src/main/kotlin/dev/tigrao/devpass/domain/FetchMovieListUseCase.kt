package dev.tigrao.devpass.domain

import dev.tigrao.devpass.api.states.ResultDomain
import dev.tigrao.devpass.domain.data.FetchMovieListRepository
import dev.tigrao.devpass.domain.mapper.list.ErrorMapper
import dev.tigrao.devpass.domain.mapper.list.SuccessMapper
import dev.tigrao.devpass.domain.model.FetchMovieListModel
import dev.tigrao.devpass.domain.model.FetchMovieListModelError

interface FetchMovieListUseCase {

    suspend operator fun invoke(
        parameter: Parameter,
    ): ResultDomain<FetchMovieListModel, FetchMovieListModelError>

    data class Parameter(val page: Int)
}

internal class FetchMovieListUseCaseImpl(
    private val repository: FetchMovieListRepository,
    private val successMapper: SuccessMapper,
    private val errorMapper: ErrorMapper,
) : FetchMovieListUseCase {

    override suspend fun invoke(
        parameter: FetchMovieListUseCase.Parameter,
    ): ResultDomain<FetchMovieListModel, FetchMovieListModelError> {
        return repository(
            FetchMovieListRepository.Parameter(parameter.page)
        ).transformMap(
            success = {
                successMapper.mapFrom(it)
            },
            error = errorMapper::mapFrom
        )
    }
}