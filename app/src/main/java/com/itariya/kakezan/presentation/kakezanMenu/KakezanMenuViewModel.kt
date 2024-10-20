package com.itariya.kakezan.presentation.kakezanMenu

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class KakezanMenuViewModel @Inject constructor (
): ViewModel() {

    fun init() {
        Timber.d("KakezanMenuViewModel init!!")
    }
}
