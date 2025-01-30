package com.foto.app.feature.photo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FotoViewModel @Inject constructor ()
    : ViewModel(){
    private val _viewState = MutableStateFlow("https://picsum.photos/200")
    val viewState = _viewState.asStateFlow()

    fun refreshUrl() {
        _viewState.update {
            "https://picsum.photos/20000?random=" + System.currentTimeMillis()
        }
    }
}






