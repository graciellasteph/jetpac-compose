package com.example.jetpaccompose

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpaccompose.ui.theme.JetPacComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPacComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    column(){
                        ImageCard(
                            painter =painterResource(id = R.drawable.background)
                        contentDescription = "mycard"
                        title= "This is a strong man"
                        )
                        spacer(modifier = Modifier.height(10.dp))
                        Button(onClick = { /*TODO*/ }) {
                            val intent = Intent(this@LazyColumnActivity)
                            startActivity(intent)
                        }
                        )){
                            Text(text = "SCROLLABLE")

                    }
                    }


                }
            }
        }
    }
}

@Composable
fun ImageCard(painter: Painter, contentDescription : String ,title: String) {
    column{
        Card {
            modifier = Modifier.wrapContentWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(20.dp)
        }

    }
    Card(
        modifier = Modifier.wrapContentWidth(),
        shape = RoundedCornerShape(15),
        elevation = CardDefaults.cardElevation()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(20.dp)

        ){
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(15.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(
                    text = title,
                    color = Color.Red,
                    fontWeight = FontWeight(200),
                    fontsize = 20.sp
                    )
            }
        }



    }
}

fun Text(text: String, color: Color, fontWeight: FontWeight, fontsize: TextUnit) {

}


@Preview(showBackground = true)
@Composable
fun ImageCardPreview() {
    ImageCard(painter = painterResource(id = R.drawable.background), contentDescription = "mycard", title = "This is a strong man")

}
