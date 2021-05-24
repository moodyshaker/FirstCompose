package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DataListItem(item: Int) {
    Card(
        shape = RoundedCornerShape(8.dp), modifier =
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = 10.dp
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text("$item", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
//            Text(item.description, fontSize = 16.sp, color = Color.Gray)
        }
    }
}