package com.example.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffeemasters.pages.InfoPage
import com.example.coffeemasters.pages.MenuPage
import com.example.coffeemasters.pages.OffersPage
import com.example.coffeemasters.pages.OrderPage
import com.example.coffeemasters.ui.theme.Ternary


@Composable
fun AppTitle() {
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo",
            modifier = Modifier.size(175.dp) // Adjust the size as needed
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataManager: DataManager) {

    // State hoisting
    val selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { AppTitle() },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Ternary // Set your desired color here
                ))
        },
        content = { padding ->
            // Apply the padding to the content to ensure it's not overlapped
            Box(modifier = Modifier.padding(padding)) {
                when (selectedRoute.value) {
                    Routes.OffersPage.route -> OffersPage(padding)
                    Routes.MenuPage.route -> MenuPage(dataManager)
                    Routes.InfoPage.route -> InfoPage(dataManager)
                    Routes.OrderPage.route -> OrderPage(dataManager)
                }
            }
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onCallBack = { newRoute ->
                    selectedRoute.value = newRoute
                }
            )
        }
    )
}