package com.example.planets

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planets.ui.theme.Orange
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PickerText (
    text: String,
    current: Int?,
    index: Int
){
    val isHere = current == index && text.isNotBlank()

    val textSize = remember {
        Animatable(
            if (isHere) 28f else 18f
        )
    }

    val textSpacing = remember {
        Animatable(
            if (isHere) 4f else 2f
        )
    }
    val textVer = remember {
        Animatable(
            if (isHere) 32f else 16f
        )
    }
    val textStart = remember {
        Animatable(
            if (isHere) 80f else 96f
        )
    }

    val scope = rememberCoroutineScope()

    scope.launch {
        textSpacing.animateTo(targetValue = if (isHere) 4f else 2f, animationSpec = tween(durationMillis = 50))
    }
    scope.launch {
        textSize.animateTo(targetValue = if (isHere) 28f else 18f, animationSpec = tween(durationMillis = 50))
    }
    scope.launch {
        textVer.animateTo(targetValue = if (isHere) 32f else 16f, animationSpec = tween(durationMillis = 50))
    }
    scope.launch {
        textStart.animateTo(targetValue = if (isHere) 80f else 96f, animationSpec = tween(durationMillis = 50))
    }

    Text(
        modifier = Modifier
            .padding(vertical = textVer.value.dp)
            .padding(start = textStart.value.dp),
        text=text,
        fontSize = textSize.value.sp,
        color = Orange,
        letterSpacing = textSpacing.value.sp,
        fontWeight = if (isHere) FontWeight.SemiBold else FontWeight.Normal
    )
}