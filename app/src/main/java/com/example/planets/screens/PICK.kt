package com.example.planets.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.planets.components.BottomViews
import com.example.planets.components.LazyPicker
import com.example.planets.components.PickerView
import com.example.planets.components.TopViews
import com.example.planets.ui.theme.Back
import com.example.planets.ui.theme.PlanetsTheme

@Composable
fun PICK() {

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopViews()

        Column(Modifier.fillMaxSize()) {
            PickerView()
            BottomViews()
        }
    }
}

@Composable
@Preview
fun Pre() {
    PlanetsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Back
        ) {
            PICK()
        }
    }
}