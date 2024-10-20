package com.itariya.kakezan.presentation.title

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TitleViewModel @Inject constructor (
): ViewModel() {

    fun init() {
        Timber.d("TitleViewModel init!!")
    }
}
