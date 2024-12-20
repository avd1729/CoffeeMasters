package com.example.coffeemasters

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Offer() {

    val style =
        TextStyle(
            fontSize = 16.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
        )

    Column() {
        Text(text = "My Offer",
            fontSize = 16.sp,
            style = style
        )
        Text(text = "Up to 30% off")
    }

}