package com.example.planets.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planets.ui.theme.Orange
import dev.chrisbanes.snapper.SnapperLayoutItemInfo
import kotlinx.coroutines.launch

@Composable
fun PickerTextItem(
    text: String,
    current: Int?,
    index: Int
) {
    Log.d("HELLO", current.toString())
    val isHere = (current ?: 0) == index

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-152).dp)
            .height(if (isHere) 144.dp else 48.dp)
            .background(if (isHere) Color.Black else Color.Blue)
            .border(2.dp, Color.White)
    ){
        _PickerTextItem(text = text, current = current, index = index)
    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun _PickerTextItem (
    text: String,
    current: Int?,
    index: Int
){
    val isHere = current == index

    val textSize = remember {
        Animatable(
            if (isHere) 28f else 17f
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
            if (isHere) 72f else 88f
        )
    }

    val animeSpeed = 60
    val scope = rememberCoroutineScope()

    scope.launch {
        textSpacing.animateTo(targetValue = if (isHere) 4f else 2f, animationSpec = tween(durationMillis = animeSpeed))
    }
    scope.launch {
        textSize.animateTo(targetValue = if (isHere) 28f else 17f, animationSpec = tween(durationMillis = animeSpeed))
    }
    scope.launch {
        textVer.animateTo(targetValue = if (isHere) 32f else 16f, animationSpec = tween(durationMillis = animeSpeed))
    }
    scope.launch {
        textStart.animateTo(targetValue = if (isHere) 72f else 88f, animationSpec = tween(durationMillis = animeSpeed))
    }

    Text(
        modifier = Modifier.padding(start = textStart.value.dp),
        text=text,
        fontSize = textSize.value.sp,
        color = Orange,
        letterSpacing = textSpacing.value.sp,
        fontWeight = if (isHere) FontWeight.SemiBold else FontWeight.Light
    )
}