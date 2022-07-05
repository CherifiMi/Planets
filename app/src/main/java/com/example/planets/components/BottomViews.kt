package com.example.planets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planets.R
import com.example.planets.ui.theme.Orange

@Composable
fun ColumnScope.BottomViews() {
    Row(
        modifier = Modifier.padding(bottom = 32.dp).fillMaxSize().weight(1f),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Orange) {
            Icon(
                painter = painterResource(id = R.drawable.rokit_icon),
                contentDescription = "")
        }
    }
}
