package com.example.planets.components

import android.util.Log
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.planets.R
import com.example.planets.pList
import dev.chrisbanes.snapper.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun ColumnScope.PickerView() {
    //___________________values
    val lazyListState: LazyListState = rememberLazyListState()
    val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)
    val contentPadding = PaddingValues(top = 390.dp, bottom = 100.dp)
    val MaxItemFling = 3

    // _________________Items picker snapper
    Box(
        modifier = Modifier
            .weight(5f)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            flingBehavior = rememberSnapperFlingBehavior(
                snapOffsetForItem = SnapOffsets.Start,
                lazyListState = lazyListState,
                endContentPadding = contentPadding.calculateBottomPadding(),
                snapIndex = { layoutInfo, startIndex, targetIndex ->
                    targetIndex.coerceIn(startIndex - MaxItemFling, startIndex + MaxItemFling)
                }
            ),
            horizontalAlignment = Alignment.Start,
            contentPadding = contentPadding,
            state = lazyListState

        ){
            itemsIndexed(pList){ index, item->
                PickerTextItem(
                    text = item,
                    current =  layoutInfo.currentItem?.index,
                    index = index
                )
            }

        }
        //_________________zoom space thing with the planet
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ){
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp),
                painter = painterResource(id = R.drawable.picker_icon),
                contentDescription = ""
            )

            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .matchParentSize()
                    .padding(end = 48.dp, top = 16.dp, bottom = 16.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.pic4),
                    contentDescription = ""
                )
            }
        }
        //___________shadow top and bottom
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = R.drawable.shadow_btm), contentDescription = "")
            Image(painter = painterResource(id = R.drawable.shadow_top), modifier = Modifier.offset(y = 2.dp), contentDescription = "")
        }
    }
}