package com.nearby.offers

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nearby.offers.model.NearbyCategory
import com.nearby.offers.ui.components.NearbyCategoryFilterList
import com.nearby.offers.ui.theme.NearbyTheme



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge();
        setContent {
        /*
            MaterialTheme {
                LoginScreen()
            }

        */

        /*
            NearbyTheme (
                darkTheme = true,
                content ={
                    Scaffold( modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            );
        */

            // utilizando Trailing Lambda Syntax no 'NearbyTheme':

            NearbyTheme {
                Scaffold( modifier = Modifier.fillMaxSize()) { innerPadding :PaddingValues ->

                    Column(
                        modifier = Modifier.fillMaxSize()
                        .fillMaxSize()
                        .padding(innerPadding)
                    ) {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding( innerPadding)
                        )


                        NearbyCategoryFilterList(
                            modifier =  Modifier.padding(innerPadding ),// Modifier.fillMaxWidth(),
                            categories = listOf(
                                NearbyCategory(id = "1", name = "Alimentação"),
                                NearbyCategory(id = "2", name = "Compras"),
                                NearbyCategory(id = "3", name = "Hospedagem"),
                                NearbyCategory(id = "4", name = "Supermercado"),
                                NearbyCategory(id = "5", name = "Cinema"),
                                NearbyCategory(id = "6", name = "Farmácia"),
                                NearbyCategory(id = "7", name = "Combustível"),
                            ),
                            onSelectedCategoryChanged = {
                                println("clicou")
                            },
                        )

                        printMessageTest();

                    }
                }
            };


        }
    }
}

@Composable
fun printMessageTest(){
    println("new message test")

    println("===============> ")
    println("MENSAGEM AQUI: ")
    println("===============> ")

}


@Composable
fun Greeting( name: String, modifier: Modifier = Modifier ) {

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}


@Preview( showBackground = true )
@Composable
fun GreetingPreview() {
    NearbyTheme {
        Greeting("Android")
    }
}



@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf( value="") }

    Log.d(  "teste", "teste de valor");

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp ))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* ação de login aqui */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Entrar")
        }
    }
}