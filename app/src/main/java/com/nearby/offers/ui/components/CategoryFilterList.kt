package com.nearby.offers.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.nearby.offers.model.NearbyCategory


// essa funcao vai ser chamada toda vez que o usuario clicar em algum icone da categoria.
// Dessa forma ela vai atualizar a lista com as opcoes de categoria
@Composable
fun CategoryFilterList(
    modifier: Modifier = Modifier,
    categories : List<NearbyCategory>,
    onSelectedCategoryChanged: ( variable : NearbyCategory) -> Unit
) {

    var selectedCategoryId by remember {  // remember ira lembrar do conteudo previamente setado nas variaveis para registrar o State do app, evitando recomposicoes desnecessarias
        mutableStateOf( value = categories.firstOrNull<NearbyCategory>()?.id.orEmpty() ) // se id for nulo, sera retornada uma string vazia do 'orEmpty()'
        // 'mutableStateOf' Cria um estado observável (o Compose sabe que precisa redesenhar se o valor mudar)
    }

    // Faz o bloco ser executado toda vez que 'selectedCategoryId' mudar
    LaunchedEffect( key1 = selectedCategoryId ) // 'selectedCategoryId' eh a variavel que quando alterada, ira disparar o callback na propriedade '' abaixo:
    {
        val selectedCategoryOrNull = categories.find { it.id == selectedCategoryId }

        selectedCategoryOrNull?.let{ // se nao for nulo, o codigo do bloco 'let' abaixo sera executado:
            onSelectedCategoryChanged( it) // ativa do disparo que indica a alteracao da variavel 'categoria'
        }
    }


}