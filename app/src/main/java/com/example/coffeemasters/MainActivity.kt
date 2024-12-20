package com.example.coffeemasters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeemasters.ui.theme.CoffeeMastersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeMastersTheme {
                FirstComposable()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstComposable() {
//    Column(){
//        Text(text = "Hello Again",
//            modifier = Modifier
//                .background(Color.Cyan)
//                .padding(20.dp)
//        )
//
//        Text(text = "Heyy",
//            modifier = Modifier
//                .background(Color.Red)
//                .padding(20.dp))
//    }

    Row(){
        Text(text = "Heyy",
            modifier = Modifier
                .background(Color.Red)
                .padding(20.dp))

        Text(text = "Hello Again",
            modifier = Modifier
                .background(Color.Cyan)
                .padding(20.dp)
        )
    }
}