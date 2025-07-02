package com.nearby.offers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nearby.offers.model.NearbyCategory
import com.nearby.offers.ui.components.NearbyCategoryFilterList
import com.nearby.offers.ui.theme.NearbyTheme



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge();
        setContent {
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

            // utilizando  Trailing Lambda Syntax no 'NearbyTheme'
            NearbyTheme {
                Scaffold( modifier = Modifier.fillMaxSize()) { innerPadding :PaddingValues ->

                    Column( modifier = Modifier
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
                    }
                }
            };


        }
    }
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
