package com.example.appwithroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appwithroom.ui.theme.takephoto.TakePhotoScreen

import com.example.appwithroom.ui.theme.userlist.UserListScreen
import com.example.appwithroom.ui.theme.userinput.UserInfoInputScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavGraph()
        }
    }
}

// NavController、NavHost 用於頁面管理
@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "user_list") {
        composable("user_list") {
            UserListScreen(navController)
        }
        composable("user_input") {
            UserInfoInputScreen(navController)
        }
        composable("take_photo") {
            TakePhotoScreen(navController)
        }

    }
}
