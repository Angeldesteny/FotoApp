package com.foto.app.feature.photo

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage

@Composable
fun FotoScreen() {
    val viewModel: FotoViewModel = hiltViewModel()
    val viewSTate = viewModel.viewState.collectAsState().value
    FotoScreenContent(
        viewState = viewSTate,
        refreshUrl = { viewModel.refreshUrl() },
        loadSmallImage = { viewModel.loadSmallImage() },
        myFoto = { viewModel.myFoto() }
    )
}

@Composable
private fun FotoScreenContent(viewState: FotoScreenViewState, refreshUrl: () -> Unit, loadSmallImage: () -> Unit, myFoto: () -> Unit) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .size(300.dp),
        model = viewState.url,
        contentDescription = null,
    )


    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = { refreshUrl() },
        modifier = Modifier.fillMaxWidth()

    ) {
        Text("Нормальная картинка")
    }
    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = { loadSmallImage() },
        modifier = Modifier.fillMaxWidth()

    ) {
        Text("Маленькая картинка")
    }
    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = { myFoto() },
        modifier = Modifier.fillMaxWidth()

    ) {
        Text("Свое фото")
    }
    Spacer(modifier = Modifier.height(16.dp))
    /*TextField(
        value = text.value,
        onValueChange = { newText -> text.value = newText },
        label = { Text("Введите текст") }
    )*/
}


@Preview
@Composable
fun FotoScreenContentPreview() {
    FotoScreenContent(FotoScreenViewState(), {}, {}, {})
}