package com.daniel.d4cshopflowscreen.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniel.d4cshopflowscreen.R
import com.daniel.d4cshopflowscreen.data.model.ProductCardModel
import com.daniel.d4cshopflowscreen.ui.theme.BilobaFlower
import com.daniel.d4cshopflowscreen.ui.theme.Pear
import com.daniel.d4cshopflowscreen.ui.theme.neuzeitsbookFontFamily
import com.daniel.d4cshopflowscreen.ui.theme.tangerineFontFamily

val sampleProductData = ProductCardModel(
    name = "clencera",
    description = "French clay and algae-powered cleanser",
    skinTypes = "Skin tightness ● Dry and dehydrated skin",
    discountedPrice = 355.20f,
    originalPrice = 444.20f,
    reviewCount = 249,
    rating = 5,
    isInStock = true,
    productImage = R.drawable.productimage
)

@Composable
fun ProductCard(data: ProductCardModel) {
    Box {
        Image(
            modifier = Modifier.fillMaxWidth().height(600.dp),
            painter = painterResource(R.drawable.product_bg_card),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )

        val isFavourite = remember { mutableStateOf(false) }
        val icon = if (isFavourite.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder

        Column{
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = {
                            isFavourite.value = !isFavourite.value
                        }
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = BilobaFlower
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(end = 24.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.Black),
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Best seller",
                        color = Pear,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    modifier = Modifier.size(300.dp),
                    painter = painterResource(R.drawable.productimage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                painter = painterResource(R.drawable.product_title_card),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )

            OutlinedIconButton(
                border = BorderStroke(width = 1.dp, color = Pear),
                onClick = {

                },
                modifier = Modifier
                    .padding(end = 24.dp, bottom = 2.dp)
                    .align(Alignment.BottomEnd)
                    .size(56.dp),
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = null,
                    tint = Pear
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = data.name,
                        fontFamily = tangerineFontFamily,
                        color = Pear,
                        fontSize = 22.sp
                    )
                    Text(
                        text = if (data.isInStock) "● in stock" else "● out of stock",
                        fontFamily = neuzeitsbookFontFamily,
                        color = if (data.isInStock) Pear else Color.Red,
                        fontSize = 14.sp
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = data.description,
                    fontFamily = neuzeitsbookFontFamily,
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = data.skinTypes,
                    fontFamily = neuzeitsbookFontFamily,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = BilobaFlower,
                                fontWeight = FontWeight.Bold,
                                fontFamily = neuzeitsbookFontFamily
                            )
                        ) {
                            append("Rs ", data.discountedPrice.toString())
                        }
                        append("  ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray,
                                fontWeight = FontWeight.Light,
                                textDecoration = TextDecoration.LineThrough,
                                fontFamily = neuzeitsbookFontFamily
                            )
                        ) {
                            append("Rs ", data.originalPrice.toString())
                        }
                    },
                    fontSize = 16.sp
                )
                Row(
                    modifier = Modifier.padding(top = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    repeat(data.rating){
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = Color.Yellow
                        )
                    }
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "${data.reviewCount} reviews",
                        style = TextStyle(color = Color.White, textDecoration = TextDecoration.Underline)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PC() {
    ProductCard(sampleProductData)
}