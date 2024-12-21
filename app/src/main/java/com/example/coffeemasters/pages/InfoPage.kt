package com.example.coffeemasters.pages

import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.example.coffeemasters.DataManager

@Composable
fun InfoPage(dataManager: DataManager){
    WebView()
}

@Composable
fun WebView() {
    // Declare a string that contains a url
    val url = "https://firtman.github.io/coffeemasters/webapp"

    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(factory = {
        android.webkit.WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}