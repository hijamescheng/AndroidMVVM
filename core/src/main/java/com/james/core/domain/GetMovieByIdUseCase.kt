package com.james.core.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.james.core.data.MovieRepository
import com.james.core.model.Movie
import com.james.core.util.Coroutines
import com.james.core.util.Result

class GetMovieByIdUseCase constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(id: String): LiveData<Result<Movie?>> {
        val result = MutableLiveData<Result<Movie?>>()
        Coroutines.ioThenMain(
            work = { movieRepository.getMovieById(id) },
            loadingCallback = { result.value = Result.isLoading() },
            successCallback = { result.value = Result.isSuccessful(it) },
            errorCallback = { result.value = Result.isError(it) }
        )
        return result
    }
}