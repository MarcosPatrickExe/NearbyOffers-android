package com.nearby.offers.ui.components

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nearby.offers.model.NearbyCategory
import com.nearby.offers.ui.theme.Gray400
import com.nearby.offers.ui.theme.GreenBase
import com.nearby.offers.ui.theme.Typography
import java.util.logging.Filter


@Composable
fun NearbyCategoryFilterChip (
    modifierBtn: Modifier = Modifier,
    category: NearbyCategory,
    isSelected : Boolean,
    onClickEvent: (isSelected: Boolean) -> Unit
) {
    var test: String = String().plus( true ) // only test

    FilterChip(
        selected = isSelected,
        modifier = modifierBtn.padding( 2.dp).heightIn( min= 36.dp),
        onClick = {
            onClickEvent( !isSelected )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = GreenBase,
        ),
        elevation = FilterChipDefaults.filterChipElevation( elevation = 8.dp), // adicionando sombreamento
        leadingIcon = { category.icon?.let {
            Icon(
                modifier = androidx.compose.ui.Modifier.size(16.dp),
                painter = painterResource( id = it),
                contentDescription = "Ícone de Filtro de cadategoria",
                tint = if (isSelected) Color.White else Gray400,
            )

        } }, // icone no inicio do Chip
        border = FilterChipDefaults.filterChipBorder(
            enabled = false,
            selected = isSelected,
            disabledBorderColor = com.nearby.offers.ui.theme.Gray400,
            borderWidth = 1.dp,
            selectedBorderWidth = 0.dp,
            selectedBorderColor = Color.Transparent
        ),
        label = {
            Text(
                text = category.name,
                style = Typography.bodyMedium,
                color = if (isSelected) Color.White else Gray400,
            )
        }
    )
}



@Preview
@Composable
private fun NearbyCategoryFilterChipPreview() {

    NearbyCategoryFilterChip(
        category = NearbyCategory( id = "1", name ="Alimentação" ),
        isSelected = true,
        onClickEvent = { println( message= "testandoooo1")  }
    )
}

@Preview
@Composable
private fun NearbyCategoryFilterChipPreviewNoSelected() {

    NearbyCategoryFilterChip(
        category = NearbyCategory( id = "1", name ="Combustível" ),
        isSelected = false,
        onClickEvent = { println( message= "testandoooo1")  }
    )

}