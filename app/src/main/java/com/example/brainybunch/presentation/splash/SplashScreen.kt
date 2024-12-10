package com.example.brainybunch.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.brainybunch.R

@Composable
fun SplashScreen(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF3D3D3D)), contentAlignment = Alignment.Center) {
        AsyncImage(model = R.drawable.logo_only, contentDescription = "Logo Icon")
    }
}