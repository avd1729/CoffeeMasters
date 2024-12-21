package com.example.coffeemasters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.coffeemasters.ui.theme.CoffeeMastersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataManager = ViewModelProvider(this)
            .get(DataManager::class.java)
        enableEdgeToEdge()
        setContent {
            CoffeeMastersTheme {
               App(dataManager)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstComposable() {
    var name = remember {
        mutableStateOf("")
    }
    Row(){
        Text(text = "Heyy ${name.value}",
            modifier = Modifier
                .background(Color.Red)
                .padding(20.dp))

        TextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            label = { Text("Name")}
        )
    }
}