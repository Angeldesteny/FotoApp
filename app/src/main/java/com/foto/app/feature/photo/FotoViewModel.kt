package com.foto.app.feature.photo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FotoViewModel @Inject constructor() : ViewModel() {
    private val _viewState = MutableStateFlow(FotoScreenViewState())
    val viewState = _viewState.asStateFlow()

    fun refreshUrl() {
        _viewState.update {
            it.copy(url = "https://picsum.photos/2000?random=" + System.currentTimeMillis())
        }
    }

    fun loadSmallImage() {
        _viewState.update {
            it.copy(url = "https://picsum.photos/20?random=" + System.currentTimeMillis())

        }
    }

    fun myFoto() {
        _viewState.update {
            it.copy(url = "https://scontent-waw2-2.xx.fbcdn.net/v/t39.30808-1/293043572_10159688" +
                    "075316346_3270066319182592138_n.jpg?stp=dst-jpg_s200x200_tt6&_nc_cat=101&ccb" +
                    "=1-7&_nc_sid=e99d92&_nc_ohc=oNSJ0CIsEBQQ7kNvgFOJZb5&_nc_zt=24&_nc_ht=scontent-" +
                    "waw2-2.xx&_nc_gid=AVVqusDllfT5h7qX8z2Y_7m&oh=00_AYBdavWdMaLQ1cYmt7GCzp0wZ2WWJ" +
                    "TSkdIkkgdp90hRo4w&oe=67A12E2F")
        }
    }

    fun updateSize(size: String) {
        _viewState.update {
            it.copy(size = size)

        }
    }
        fun ganarateUrl() {
            _viewState.update {
                it.copy(url = "https://picsum.photos/${viewState.value.size}")
            }
        }

}




