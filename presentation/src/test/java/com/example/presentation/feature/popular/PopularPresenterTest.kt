package com.example.presentation.feature.popular

import com.example.domain.usecase.GetPopularKeyWordsUseCase
import com.example.presentation.mapper.PopularKeywordsViewModelMapper
import com.example.presentation.model.PopularKeywordsViewModel
import com.nhaarman.mockitokotlin2.*
import io.reactivex.observers.DisposableSingleObserver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PopularPresenterTest {

    private lateinit var popularPresenter: PopularPresenter
    private var getPopularKeyWordsUseCase: GetPopularKeyWordsUseCase = mock()
    private var popularKeywordsViewModelMapper: PopularKeywordsViewModelMapper = mock()
    private var view: PopularContract.View = mock()
    private var captor: KArgumentCaptor<DisposableSingleObserver<List<String?>?>> = mock()

    @BeforeEach
    fun setUp() {
        captor = argumentCaptor<DisposableSingleObserver<List<String?>?>>()
        popularPresenter = PopularPresenter(
            getPopularKeyWordsUseCase = getPopularKeyWordsUseCase,
            popularKeywordsViewModelMapper = popularKeywordsViewModelMapper
        )
        popularPresenter.attachView(view)
    }

    @Test
    fun `test GetPopularKeyWordsUseCase, View was called when view attached `() {
        inOrder(getPopularKeyWordsUseCase, view) {
            verify(getPopularKeyWordsUseCase).cancel()
            verify(view).showLoading()
            verify(getPopularKeyWordsUseCase).execute(captor.capture(), eq(null))

        }
    }

    @Test
    fun `test case getPopularKeyWordsUseCase was called onSuccess when view attached `() {
        //given
        val listDataResponse = listOf<String?>()
        val modelDataValid = PopularKeywordsViewModel(
            listOf(),
            mutableListOf()
        )
        whenever(popularKeywordsViewModelMapper.map(listDataResponse)).thenReturn(modelDataValid)
        //when
        //popularPresenter.loadData()
        //then
        verify(getPopularKeyWordsUseCase).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(listDataResponse)
        inOrder(view) {
            verify(view).hideLoading()
            verify(view).showDataValid(modelDataValid)
        }
    }

    @Test
    fun `test case getPopularKeyWordsUseCase was called onError when view attached `() {
        //given
        //when
        //popularPresenter.loadData()
        //then
        verify(getPopularKeyWordsUseCase).execute(captor.capture(), eq(null))
        captor.firstValue.onError(Throwable())
        verify(view).hideLoading()
        verify(view).showError("Get data fail, Pls try again")
    }

    @Test
    fun `test onDetachView `() {
        //given
        //when
        popularPresenter.detachView()
        //then
        verify(getPopularKeyWordsUseCase,atLeastOnce()).cancel()

    }


}
