package com.xenatronics.webagenda.screens

import android.content.pm.ActivityInfo
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.xenatronics.webagenda.R
import com.xenatronics.webagenda.navigation.Screen
import com.xenatronics.webagenda.ui.theme.dark_gray
import com.xenatronics.webagenda.util.Constants.DELAY_SPLASH
import com.xenatronics.webagenda.util.LockScreenOrientation
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = DELAY_SPLASH),
    )
    SplashContent(alpha = alphaAnim.value)
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(1500)
        navController.popBackStack()
        navController.navigate(Screen.LoginScreen.route)
    }
}

@Composable
fun SplashContent(alpha: Float) {
    Box(
        Modifier
            .fillMaxSize()
            .background(dark_gray),
        contentAlignment = Alignment.Center
    ) {
        Image(
            //ha = alpha),
            painterResource( id = R.drawable.logo ),
            contentDescription = ""
        )

    }
}