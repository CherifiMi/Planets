package com.example.planets

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
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
import dev.chrisbanes.snapper.SnapperLayoutItemInfo
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PickerText (
    text: String,
    current: SnapperLayoutItemInfo?,
    index: Int
){
    val isHere = current?.index == index

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

    val scope = rememberCoroutineScope()

    scope.launch {
        textSpacing.animateTo(targetValue = if (isHere) 4f else 2f, animationSpec = tween(durationMillis = 50))
    }
    scope.launch {
        textSize.animateTo(targetValue = if (isHere) 28f else 17f, animationSpec = tween(durationMillis = 50))
    }
    scope.launch {
        textVer.animateTo(targetValue = if (isHere) 32f else 16f, animationSpec = tween(durationMillis = 50))
    }
    scope.launch {
        textStart.animateTo(targetValue = if (isHere) 72f else 88f, animationSpec = tween(durationMillis = 50))
    }

    Text(
        modifier = Modifier
            .padding(vertical = textVer.value.dp)
            .padding(start = textStart.value.dp),
        text=text,
        fontSize = textSize.value.sp,
        color = Orange,
        letterSpacing = textSpacing.value.sp,
        fontWeight = if (isHere) FontWeight.SemiBold else FontWeight.Light
    )
}