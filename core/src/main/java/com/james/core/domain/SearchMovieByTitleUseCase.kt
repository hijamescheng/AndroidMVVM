package com.james.core.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.james.core.data.MovieRepository
import com.james.core.model.Movie
import com.james.core.util.Coroutines
import com.james.core.util.Result

class SearchMovieByTitleUseCase constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(term: String): LiveData<Result<List<Movie>>> {
        val result = MutableLiveData<Result<List<Movie>>>()
        Coroutines.ioThenMain(
            work = { movieRepository.searchMovieByTitle(term) },
            loadingCallback = { result.value = Result.isLoading() },
            successCallback = { result.value = Result.isSuccessful(it) },
            errorCallback = { result.value = Result.isError(it) }
        )
        return result
    }
}