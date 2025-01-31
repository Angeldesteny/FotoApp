package com.foto.app.feature.photo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
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
        myFoto = { viewModel.myFoto()},
        updateSize = { viewModel.updateSize(it) },
        ganarateUrl = { viewModel.ganarateUrl() }
    )
}

@Composable
private fun FotoScreenContent(
    viewState: FotoScreenViewState,
    refreshUrl: () -> Unit,
    loadSmallImage: () -> Unit,
    myFoto: () -> Unit,
    updateSize: (String) -> Unit,
    ganarateUrl: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column {
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
        Row {
            TextField(
                value = viewState.size,
                onValueChange = { newText -> updateSize(newText) },
                label = { Text("Введите размер") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )
            Row {
                Button(
                    onClick = {
                        ganarateUrl()
                        keyboardController?.hide()
                    },
                )
                {
                    Text("OK")
                }
            }
        }

    }

}

@Preview
@Composable
fun FotoScreenContentPreview() {
    FotoScreenContent(FotoScreenViewState(), {}, {}, {}, {}, {})
}
