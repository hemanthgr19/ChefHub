package com.example.chefhub

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

class SplashFragment: Fragment(R.layout.splash_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ComposeView>(R.id.compose_view).setContent {
            SplashScreen()
            object : Thread() {
                override fun run() {
                    try {
                        sleep(5000)
                    } catch (e: Exception) {
                    } finally {
                        val intent = Intent(requireContext(), DashBoardActivity::class.java)
                        startActivity(intent)
                        // Finish the current activity if needed
                        activity?.finish()
                    }
                }
            }.start()
        }
    }


}
@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your logo
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp) // Adjust the size as needed
                .padding(16.dp)
        )

        Text(
            text = "ChefHub",
            style = TextStyle(
                fontSize = 24.sp, // Adjust the font size as needed
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 8.dp) // Adjust the top padding as needed
        )
    }
}