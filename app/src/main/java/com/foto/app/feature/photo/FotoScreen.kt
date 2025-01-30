package com.foto.app.feature.photo

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
    FotoScreenContent(url = viewSTate,
        action = { viewModel.refreshUrl() })

}

@Composable
private fun FotoScreenContent(url: String, action: () -> Unit) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .size(300.dp),
        model = url,
        contentDescription = null,
    )


    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = { action() },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Первая кнопка")
    }
}


@Preview
@Composable
fun FotoScreenContentPreview() {
    FotoScreenContent("https://picsum.photos/200", {})
}