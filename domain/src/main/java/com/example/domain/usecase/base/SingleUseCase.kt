package com.example.domain.usecase.base

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver


/**
 * Abstract class for a UseCase that returns an instance of a [Single].
 */
abstract class SingleUseCase<T, in Params> constructor(private val useCaseExecution: UseCaseExecution) {

    private var disposables = CompositeDisposable()

    /**
     * Builds a [Single] which will be used when the current [SingleUseCase] is executed.
     */
    protected abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

    /**
     * Executes the current use case.
     */
    open fun execute(singleObserver: DisposableSingleObserver<T>, params: Params? = null): UseCaseTask {
        val single = this.buildUseCaseObservable(params)
            .subscribeOn(useCaseExecution.execution)
            .observeOn(useCaseExecution.postExecution) as Single<T>
        val disposable = single.subscribeWith(singleObserver)
        addDisposable(disposable)
        return UseCaseTask(disposable)
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun cancel() {

        if(!disposables.isDisposed) {
            disposables.dispose()
        }
        disposables = CompositeDisposable()
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}