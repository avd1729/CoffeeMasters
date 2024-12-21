package com.example.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.coffeemasters.pages.InfoPage
import com.example.coffeemasters.pages.MenuPage
import com.example.coffeemasters.pages.OffersPage
import com.example.coffeemasters.pages.OrderPage


@Composable
fun AppTitle() {
    Box(modifier = Modifier.fillMaxWidth()
        .background(Color.Red),
        contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataManager: DataManager) {

    // State hoisting
    var selectedRoute = remember {
        mutableStateOf(Routes.OffersPage.route)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { AppTitle() })
        },
        content = { padding -> // Add padding parameter
           when(selectedRoute.value){
               Routes.OffersPage.route -> OffersPage(padding)
               Routes.MenuPage.route -> MenuPage(dataManager)
               Routes.InfoPage.route -> InfoPage(dataManager)
               Routes.OrderPage.route -> OrderPage(dataManager)
           }
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