package com.example.navigation.screens

import android.text.TextUtils
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewParameter


@Composable
fun HomeView(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize()){
        Text(text="Inicio")

        Button(onClick={
            navController.navigate("SegundaVista")
        }){
            Text(text="Siguiente")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondView(navController:NavHostController){
    var age:String by remember{
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize()){
        Text(text="Segunda Pantalla")

        Button(onClick = {
            navController.popBackStack()
        }){
            Text(text = "Regresar")
        }
        Button(onClick={
            navController.navigate("TerceraVista/$age")
        }){
            Text(text="Siguiente")
        }
        OutlinedTextField(value = age, onValueChange ={
            age = it
        }, label = {
            Text(text = "Edad")
        }, placeholder = {
            Text(text = "Por Favor escribe tu edad")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.Info, contentDescription = "Icono de Info")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun ThirdView(navController:NavHostController, age:Int){
    Column(modifier = Modifier.fillMaxSize()){
        Text(text="Tercera Pantalla")
        Text(text="Su edad es $age")

        Button(onClick = {
            navController.popBackStack()
        }){
            Text(text = "Regresar")
        }
    }
}

fun checkWroteNumber(text: String):Int{
    if (text.toIntOrNull() != null) {
        return text.toInt()
    }else if (TextUtils.isEmpty(text)){
        return 0
    }
    return 1
}