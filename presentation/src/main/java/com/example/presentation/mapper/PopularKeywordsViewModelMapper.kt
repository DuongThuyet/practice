package com.example.presentation.mapper

import com.example.presentation.model.PopularKeywordsViewModel
import com.example.presentation.util.formatToTikiTemplate
import com.example.presentation.util.valueOrEmpty

class PopularKeywordsViewModelMapper {
    fun map(input: List<String?>): PopularKeywordsViewModel {
        val keywords = mutableListOf<String>()
        val isInitBgs = mutableListOf<Boolean>()
        input.forEach { item ->
            keywords.add(item.valueOrEmpty().formatToTikiTemplate())
            isInitBgs.add(false)
        }
        return PopularKeywordsViewModel(keywords, isInitBgs)
    }
}