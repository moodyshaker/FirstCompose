package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.math.absoluteValue

val dataList = mutableListOf(
    Data("Cairo", "North of Africa country"),
    Data("NewYork", "North of Africa country"),
    Data("Paris", "North of Africa country"),
    Data("London", "North of Africa country"),
    Data("Moscow", "North of Africa country"),
    Data("Alexandra", "North of Africa country"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PopulateUi()
                }
            }
        }
    }
}

@Composable
fun PopulateUi() {
    val counter = remember {
        mutableStateListOf<Int>()
    }
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("First Screen") }, backgroundColor = Color.Blue,
            contentColor = Color.White,
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_left_24),
                    contentDescription = null
                )
            },
        )
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    counter.add(1)
                },
                backgroundColor = Color.Blue,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                items(counter.size) {
                    DataListItem(item = it.absoluteValue)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        PopulateUi()
    }
}


