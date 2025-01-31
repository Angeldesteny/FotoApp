package com.foto.app.feature.calculator

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CalculatorScreen() {
    val viewModel: CalculatorViewModel = hiltViewModel()
    val calculatorViewState = viewModel.viewState.collectAsState().value
    print("Введите a: ")
    val a = readLine()?.toIntOrNull() ?: 0

    print("Введите b: ")
    val b = readLine()?.toIntOrNull() ?: 0

    println("Сумма: ${a + b}")

}