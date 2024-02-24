package com.example.navigation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Preview(showBackground = true)
@Composable
fun NavManager(){
    var navController:NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "PrimerPantalla"){
        //Definiendo Rutas
        composable(route="PrimerPantalla"){
            HomeView(navController)
        }
        composable(route="SegundaVista"){
            SecondView(navController)
        }
        composable(route="TerceraVista/{age}",
        arguments = listOf(
            navArgument("age"){
                type = NavType.IntType
            }
        )){
           parametros ->
            var edad:Int = parametros.arguments?.getInt("age") ?: 0
           ThirdView(navController,edad)
        }

        //composable(route="TerceraVista"){
            //ThirdView(navController)
        //}

    }
}