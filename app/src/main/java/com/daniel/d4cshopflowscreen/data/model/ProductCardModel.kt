package com.daniel.d4cshopflowscreen.data.model

import androidx.annotation.DrawableRes

data class ProductCardModel(
    val name: String,
    val description: String,
    val skinTypes: String,
    val discountedPrice: Float,
    val originalPrice: Float,
    val isInStock: Boolean,
    val rating: Int,
    val reviewCount: Int,
    @DrawableRes val productImage: Int
)
