package com.nearby.offers.model

import androidx.annotation.DrawableRes

data class NearbyCategory(
    val id :String,
    val name: String
){
    @get:DrawableRes // simboliza que o retorno de Get representa um Id de resource do projeto
    val icon: Int? get() = NearbyCategoryFilterChipView.fromDescription( descriptionToBeChecked = name )?.icon
}
