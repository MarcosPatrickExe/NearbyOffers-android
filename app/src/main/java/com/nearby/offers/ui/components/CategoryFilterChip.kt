package com.nearby.offers.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nearby.offers.model.NearbyCategory


@Preview
@Composable
private fun NearbyCategoryFilterChipPreview() {
    NearbyCategoryFilterChip()
}

@Composable
fun NearbyCategoryFilterChip (
    modifierBtn: Modifier = Modifier,
    category: NearbyCategory,
    isSelected : Boolean,
    onClick: (isSelected: Boolean) -> Unit
) {
    
}