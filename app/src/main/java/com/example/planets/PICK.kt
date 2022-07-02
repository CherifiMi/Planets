package com.example.planets

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planets.ui.theme.Back
import com.example.planets.ui.theme.Orange
import com.example.planets.ui.theme.PlanetsTheme

val pList = listOf(
    "MERCURY",
    "VENUS",
    "EARTH",
    "MARS",
    "JUPITER",
    "SATURN",
    "URANUS",
    "NEPTUNE"
)

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

@Composable
fun PICK() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    modifier = Modifier
                        .size(64.dp)
                        .background(
                            Orange,
                            RoundedCornerShape(
                                bottomStart = 50f,
                                topEnd = 50f
                            )
                        ),
                    onClick = { /*TODO click*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.menu_icon),
                        contentDescription = ""
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "PLANETS",
                    fontSize = 20.sp,
                    color = Orange,
                    letterSpacing = 7.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        //___________
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(650.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {

            }
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
        }
        //_________
        Row(
            modifier = Modifier.padding(bottom = 32.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Orange) {
                Icon(
                    painter = painterResource(id = R.drawable.rokit_icon),
                    contentDescription = "")
            }
        }

        //___________

    }
}