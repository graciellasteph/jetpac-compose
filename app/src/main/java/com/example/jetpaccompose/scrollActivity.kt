package com.example.jetpaccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpaccompose.ui.theme.JetPacComposeTheme

class scrollActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPacComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val students =listOf("james","john","Andrew","Mark","Nathan")
                    DashboardScreen(students)
                }
            }
        }
    }
}

@Composable
fun Rowcards(name:String) {
    Card(
       modifier = Modifier
           .padding(10.dp)
           .fillMaxWidth()
           .height(100.dp)
           .aspectRatio(3f), colors = CardDefaults.cardColors(containerColor = "Color.White")
    ){
        Box (
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(text = name)
        }
    }
}


@Composable
fun DashboardScreen(students:List<String>) {
    Box(modifier = Modifier.fillMaxWidth()) {
        image(
            painter = painterResource(id = R.drawable.background)
                    contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchparentsize
        )
    }
    column(modifier = Modifier.fillMaxWidth()) {
        LazyRow(contentPadding =. PaddingValues (20.dp)){
        items(items = students) { item->
            Rowcards(name = item)
            }
        }
    }
}