package com.foto.app.feature.photo

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun FotoScreen() {
    val viewModel: FotoViewModel = hiltViewModel()


    FotoScreenContent(

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FotoScreenContent(

) {

    val imageUrl = "https://picsum.photos/200"

    /*   Image(
           painter = rememberAsyncImagePainter(imageUrl),
           contentDescription = "Sample Image",
           modifier = Modifier.fillMaxWidth().height(200.dp)
       )*/

    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = { /* TODO */ }, modifier = Modifier.fillMaxWidth()) {
        Text("Первая кнопка")
    }
}

@Preview
@Composable
fun FotoScreenContentPreview() {
    FotoScreenContent()

}