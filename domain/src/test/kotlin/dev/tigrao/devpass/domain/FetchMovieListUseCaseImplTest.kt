package dev.tigrao.devpass.domain

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dev.tigrao.devpass.domain.data.FetchMovieListRepositoryImpl
import dev.tigrao.devpass.domain.data.MovieApi
import dev.tigrao.devpass.domain.data.response.MovieListItemResponse
import dev.tigrao.devpass.domain.mapper.list.ErrorMapper
import dev.tigrao.devpass.domain.mapper.list.SuccessMapper
import dev.tigrao.devpass.domain.model.FetchMovieListDataModel
import dev.tigrao.devpass.domain.model.FetchMovieListModel
import dev.tigrao.devpass.domain.model.FetchMovieListModelError
import dev.tigrao.devpass.domain.model.ScheduleModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Type

class FetchMovieListUseCaseImplTest {

    private val moshi = Moshi.Builder().build()
    private val api = mockk<MovieApi>()
    private val repository = FetchMovieListRepositoryImpl(api)

    private val subject = FetchMovieListUseCaseImpl(
        repository,
        SuccessMapper(),
        ErrorMapper(),
    )

    @Test
    fun `invoke when Success with content should Return mapped values`() = runBlocking {
        // Arrange.
        val parameter = FetchMovieListUseCase.Parameter(1)

        val expected = FetchMovieListModel(
            data = listOf(
                FetchMovieListDataModel(
                    image = "",
                    title = "",
                    author = "",
                    description = "",
                    schedule = ScheduleModel(
                        time = "",
                        weekDay = listOf(""),
                    )
                )
            )
        )

        prepare(
            apiResult = ListApiMock.SUCCESS
        )

        // Act.
        val result = subject(parameter)

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun `invoke when Success without content should Return Empty Errors`() = runBlocking {
        // Arrange.
        val parameter = FetchMovieListUseCase.Parameter(1)

        val expected = FetchMovieListModelError.EmptyList

        prepare(
            apiResult = ListApiMock.EMPTY
        )

        // Act.
        val result = subject(parameter)

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun `invoke when Error because Unauthorized Return Unauthorized Error`() = runBlocking {
        // Arrange.
        val parameter = FetchMovieListUseCase.Parameter(1)

        val expected = FetchMovieListModelError.UnauthorizedAccess

        prepare(
            apiResult = ListApiMock.UNAUTHORIZED
        )

        // Act.
        val result = subject(parameter)

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun `invoke when Error without know the root cause Return Generic Error`() = runBlocking {
        // Arrange.
        val parameter = FetchMovieListUseCase.Parameter(1)

        val expected = FetchMovieListModelError.GenericError

        prepare(
            apiResult = ListApiMock.GENERIC_ERROR
        )

        // Act.
        val result = subject(parameter)

        // Assert
        assertEquals(expected, result)
    }

    private fun prepare(
        apiResult: ListApiMock,
    ) {
        coEvery {
            api.fetchMovieList(any())
        } answers {
            val listMyData: Type = Types.newParameterizedType(
                List::class.java,
                MovieListItemResponse::class.java
            )
            moshi.adapter<List<MovieListItemResponse>>(listMyData)
                .fromJson(apiResult.getResult())!!
        }
    }
}