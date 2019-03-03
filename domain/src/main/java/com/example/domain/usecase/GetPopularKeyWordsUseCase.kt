package com.example.domain.usecase

import com.example.domain.repository.AppRepository
import com.example.domain.usecase.base.SingleUseCase
import com.example.domain.usecase.base.UseCaseExecution
import io.reactivex.Single

 class GetPopularKeyWordsUseCase(
    private val appRepository: AppRepository,
    useCaseExecution: UseCaseExecution
) : SingleUseCase<List<String?>?, Void?>(useCaseExecution) {

    override fun buildUseCaseObservable(params: Void?): Single<List<String?>?> {
        return appRepository.getPopularKeywords()
    }
}