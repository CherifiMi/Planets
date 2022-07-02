package com.example.planets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planets.ui.theme.Orange

@Composable
fun PickerText (
    text: String,
    current: String?
){
    val isHere = current == text && text.isNotBlank()

    Text(
        modifier = Modifier
            .padding(16.dp)
            .padding(
                start = if (isHere) 64.dp else 80.dp,
                top = if (isHere) 16.dp else 0.dp,
                bottom = if (isHere) 16.dp else 0.dp
            ),
        text=text,
        fontSize = if (isHere) 28.sp else 18.sp,
        color = Orange,
        letterSpacing = if (isHere) 4.sp else 2.sp,
        fontWeight = if (isHere) FontWeight.SemiBold else FontWeight.Normal
    )
}