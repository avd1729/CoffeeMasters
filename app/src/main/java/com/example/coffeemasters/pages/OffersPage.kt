package com.example.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeemasters.R
import com.example.coffeemasters.ui.theme.Alternative2

@Preview(showBackground = true)
@Composable
private fun Offer_Preview() {
    Offer("Christmas Offer", "Up to 20% off during Holidays")
}

@Preview(showBackground = true)
@Composable
private fun OffersPage_Preview() {
    OffersPage(PaddingValues(0.dp))
}

@Composable
fun OffersPage(padding: PaddingValues) {
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
    }
}

@Composable
fun Offer(title: String, description: String = "") {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.background_pattern),
            contentDescription = "Background Pattern",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.matchParentSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative2)
                    .padding(16.dp)
            )
            Text(
                text = description,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative2)
                    .padding(16.dp)
            )

        }
    }

}