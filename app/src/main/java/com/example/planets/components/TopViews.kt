package com.example.planets.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planets.R
import com.example.planets.ui.theme.Orange

@Composable
fun TopViews() {
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
}