package com.nearby.offers.model

import androidx.annotation.DrawableRes
import com.nearby.offers.R

enum class NearbyCategoryFilterChipView (
    val description :String,
    @DrawableRes val icon : Int?
){
    ALIMENTACAO( description = "Alimentação", icon= R.drawable.ic_tools_kitchen_2,),
    COMPRAS( description = "Compras", icon= R.drawable.ic_shopping_bag ),
    HOSPEDAGEM( description = "Hospedagem", icon= R.drawable.ic_bed ),
    SUPERMERCADO( description = "Supermercado", icon= R.drawable.ic_shopping_cart ),
    ENTRETENIMENTO( description = "Cinema", icon= R.drawable.ic_movie ),
    FARMACIA( description = "Farmácia", icon= R.drawable.ic_first_aid_kit ),
    COMBUSTIVEL( description = "Combustível", icon= R.drawable.ic_gas_station ),
    PADARIA( description = "Padaria", icon= R.drawable.ic_bakery );

    companion object{
        public fun fromDescription( descriptionToBeChecked: String ): NearbyCategoryFilterChipView? {
            return entries.find { et -> et.description == descriptionToBeChecked }
        }
    }

}