package com.example.coffeemasters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeemasters.ui.theme.Purple80

@Preview(showBackground = true, widthDp = 400)
@Composable
fun Offer() {

    val style =
        TextStyle(
            fontSize = 16.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
        )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Purple80)
            .padding(16.dp)
    ) {
        Text(text = "My Offer",
            fontSize = 16.sp,
            style = style
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Up to 30% off",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(10.dp)
        )
    }

}