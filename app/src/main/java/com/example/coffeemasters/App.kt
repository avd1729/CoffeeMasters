package com.example.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeemasters.ui.theme.CoffeeMastersTheme

@Preview
@Composable
fun App_Preview() {
    CoffeeMastersTheme {
        App()
    }
}

@Composable
fun AppTitle() {
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    // State hoisting
    var selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { AppTitle() })
        },
        content = { padding -> // Add padding parameter
            OffersPage(padding) // Pass padding to OffersPage
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onCallBack = { newRoute ->
                selectedRoute.value = newRoute
            })
        }
    )
}