package com.example.planets.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.planets.pList
import dev.chrisbanes.snapper.*

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun LazyPicker() {
    //___________________values
    val lazyListState: LazyListState = rememberLazyListState()
    val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)
    val contentPadding = PaddingValues(top = 508.dp, bottom = 93.dp)
    val MaxItemFling = 3

    //_______________________
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
}