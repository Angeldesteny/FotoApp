package com.foto.app.feature.calculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.foto.app.feature.photo.FotoScreenViewState
import com.foto.app.feature.photo.FotoViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun CalculatorScreen() {
    val viewModel: CalculatorViewModel = hiltViewModel()
    val viewSTate = viewModel.viewState.collectAsState().value
    CalculatorScreenContent(
        viewState = viewSTate,
add = { viewModel.add(it) }
    )
}

@Composable
private fun CalculatorScreenContent(
    viewState: CalculatorViewState,
    add: (String) -> Unit,

) {
    Column(
        modifier = Modifier.padding(16.dp)
    ){
        TextField(
            value = viewState.result.toString(),
            //onValueChange = { newText -> updateResult(newText) },
            label = { Text("Введите цифру") },
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                add("5")
            },
        )
        {
            Text("+5")
        }

    }
}


@Preview
@Composable
fun CalculatorScreenContentPreview() {
    CalculatorScreenContent(CalculatorViewState(), {})
}


