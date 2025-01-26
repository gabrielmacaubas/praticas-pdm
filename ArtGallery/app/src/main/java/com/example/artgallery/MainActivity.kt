package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GalleryArea()
                }
            }
        }
    }
}

@Composable
fun GalleryArea(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.arte1)
    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(bottom = 16.dp, top = 128.dp, end = 16.dp, start = 16.dp)

    ) {
        Column (

            modifier = modifier
                .shadow(
                    elevation = 3.dp,
                    clip = true
                )
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = image,
                contentDescription = "Café e Risole",
                modifier = modifier
                    .padding(40.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
        Column (
            modifier = modifier
                .background(Color(0xECCBDBEE))
                .padding(16.dp)
        ) {
            Text (
                text = "Coffee is a part of life that never goes away",
                textAlign = TextAlign.Left,
                fontSize = 24.sp,
                fontWeight = FontWeight.W300
            )
            Text (
                text = "Owen Scott (2021)",
                fontWeight = FontWeight.W900
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.2f)
        ) {
            Button(
                modifier = modifier.size(width = 160.dp, height = 250.dp),
                onClick = { }) {
                Text(
                    text = "Previous",
                    fontSize = 18.sp
                )
            }
            Button(
                onClick = { },
                modifier = modifier.size(width = 160.dp, height = 250.dp)
            ) {
                Text(
                    text = "Next",
                    fontSize = 18.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GalleryAreaPreview() {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        GalleryArea()
    }
}