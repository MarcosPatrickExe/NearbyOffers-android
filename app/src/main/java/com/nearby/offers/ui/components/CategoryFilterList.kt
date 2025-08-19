package com.nearby.offers.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nearby.offers.model.NearbyCategory


// essa funcao vai ser chamada toda vez que o usuario clicar em algum icone da categoria.
// Dessa forma ela vai atualizar a lista com as opcoes de categoria
@Composable
fun NearbyCategoryFilterList(
    modifier: Modifier = Modifier,
    categories : List<NearbyCategory>,
    onSelectedCategoryChanged: ( variable : NearbyCategory) -> Unit
) {

    var selectedCategoryId by remember {  // remember ira lembrar do conteudo previamente setado nas variaveis para registrar o State do app, evitando recomposicoes desnecessarias
        mutableStateOf<String>( value = categories.firstOrNull<NearbyCategory>()?.id.orEmpty() ) // se id for nulo, sera retornada uma string vazia do 'orEmpty()'
        // 'mutableStateOf' Cria um estado observável (o Compose sabe que precisa redesenhar se o valor mudar)
    }

    // Faz o bloco ser executado toda vez que 'selectedCategoryId' mudar
    LaunchedEffect( key1 = selectedCategoryId ) // 'selectedCategoryId' eh a variavel que quando alterada, ira disparar o callback na propriedade '' abaixo:
    {
        val selectedCategoryOrNull : NearbyCategory? = categories.find { it.id == selectedCategoryId }

        selectedCategoryOrNull?.let{ // se nao for nulo, o codigo do bloco 'let' abaixo sera executado:
            onSelectedCategoryChanged( it) // ativa do disparo que indica a alteracao da variavel 'selectedCategoryId'
        }
    }


    LazyRow(
        modifier = Modifier,
        contentPadding = PaddingValues( horizontal = 24.dp ),
        horizontalArrangement = Arrangement.spacedBy( 8.dp ),
    ) {

        items( items = categories, key = { it.id} ){ thisCategory  ->  // ou implicitamente: it -> ...

            NearbyCategoryFilterChip(
                category = thisCategory, // NearbyCategory( id = "1", name ="Alimentação" ),
                isSelected = (thisCategory.id == selectedCategoryId ),
                onClickEvent = { isSelected ->{
                        Log.d("teste", "======> CATEGORY: "+thisCategory.name+"  ===  isSelected: "+isSelected);
                        if( isSelected ) selectedCategoryId = thisCategory.id
                     }
                }

            )
        }

    }

}



@Preview
@Composable
private fun CategoryFilterListPreview(){

    NearbyCategoryFilterList(
        modifier = Modifier.fillMaxWidth(),
        categories = listOf(
            NearbyCategory( id = "1", name ="Alimentação" ),
            NearbyCategory( id = "2", name ="Compras" ),
            NearbyCategory( id = "3", name ="Hospedagem" ),
            NearbyCategory( id = "4", name ="Supermercado" ),
            NearbyCategory( id = "5", name ="Cinema" ),
            NearbyCategory( id = "6", name ="Farmácia" ),
            NearbyCategory( id = "7", name ="Combustível" ),
        ),
        onSelectedCategoryChanged = {  print("cliclou") },
    )
}
