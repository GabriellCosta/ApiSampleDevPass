package dev.tigrao.devpass.domain.model

sealed interface FetchMovieListModelError {

    // 401
    object UnauthorizedAccess : FetchMovieListModelError

    object EmptyList : FetchMovieListModelError

    object GenericError : FetchMovieListModelError
}