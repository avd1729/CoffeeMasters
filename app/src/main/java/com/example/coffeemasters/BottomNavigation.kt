package com.example.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeemasters.ui.theme.Alternative1
import com.example.coffeemasters.ui.theme.Primary

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    val MenuPage = NavPage("Menu", Icons.Rounded.Menu, "menu")
    val OffersPage = NavPage("Offers", Icons.Rounded.Star, "offers")
    val OrderPage = NavPage("My Order", Icons.Rounded.ShoppingCart, "myorder")
    val InfoPage = NavPage("Info", Icons.Rounded.Info, "info")

    val pages = listOf(MenuPage, OffersPage, OrderPage, InfoPage)
}

//@Preview
@Composable
fun NavBarItem_Preview() {
    NavBarItem(page = Routes.MenuPage,
        modifier = Modifier.padding(8.dp))
}

@Preview
@Composable
fun NavBar(selectedRoute: String = Routes.MenuPage.route, onCallBack: (String) -> Unit = {}){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        for(page in Routes.pages){
            NavBarItem(page = page,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        onCallBack(page.route)
                    },
                selected = selectedRoute == page.route)
        }
    }
}

@Composable
fun NavBarItem(page: NavPage, selected: Boolean = false, modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Alternative1 else Primary
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) Alternative1 else Primary
        )
    }
}