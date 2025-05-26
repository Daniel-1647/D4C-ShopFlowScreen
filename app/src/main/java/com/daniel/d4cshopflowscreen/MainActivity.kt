package com.daniel.d4cshopflowscreen

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniel.d4cshopflowscreen.data.model.ProductCardModel
import com.daniel.d4cshopflowscreen.ui.components.CategoriesCarousel
import com.daniel.d4cshopflowscreen.ui.components.FeaturedCarousel
import com.daniel.d4cshopflowscreen.ui.components.ProductCard
import com.daniel.d4cshopflowscreen.ui.components.mainScreenTopBar
import com.daniel.d4cshopflowscreen.ui.theme.D4CShopFlowScreenTheme
import com.daniel.d4cshopflowscreen.ui.theme.MineShaft
import com.daniel.d4cshopflowscreen.ui.theme.century_old_style_std_bold
import com.daniel.d4cshopflowscreen.ui.theme.neuzeitsbookFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        }

        setContent {
            D4CShopFlowScreenTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val cartItemCount = remember { mutableStateOf(0) }
    val favItemCount = remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MineShaft,
        topBar = mainScreenTopBar(
            onBackBtnPressed = {

            },
            onFavouriteClicked = {
                favItemCount.value++
            },
            onShoppingCartClicked = {
                cartItemCount.value++
            },
            favItemCount = favItemCount.value,
            cartItemCount = cartItemCount.value
        ),
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            MainScreenContent()
        }
    }
}

@Composable
fun MainScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        FeaturedCarousel()
        Categories()
        NewProductsList()
    }
}

@Composable
fun Categories(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(vertical = 24.dp, horizontal = 16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Categories", fontFamily = century_old_style_std_bold, color = Color.White, fontSize = 26.sp)
        Text(text = "See all", fontFamily = neuzeitsbookFontFamily, style = TextStyle(
            textDecoration = TextDecoration.Underline,
            color = Color.White
        ))
    }

    CategoriesCarousel()
}

@Composable
fun NewProductsList(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(vertical = 24.dp, horizontal = 16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "New products", fontFamily = century_old_style_std_bold, color = Color.White, fontSize = 26.sp)
        Text(text = "See all", fontFamily = neuzeitsbookFontFamily, style = TextStyle(
            textDecoration = TextDecoration.Underline,
            color = Color.White
        ))
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        sampleProductDataList.forEach {
            ProductCard(it)
        }
    }
}

val sampleProductDataList = listOf(
    ProductCardModel(
        name = "clencera",
        description = "French clay and algae-powered cleanser",
        skinTypes = "Skin tightness ● Dry and dehydrated skin",
        discountedPrice = 355.20f,
        originalPrice = 444.20f,
        reviewCount = 249,
        rating = 5,
        isInStock = true,
        productImage = R.drawable.productimage
    ),
    ProductCardModel(
        name = "glow",
        description = "French clay and algae-powered cleanser",
        skinTypes = "Skin tightness ● Dry and dehydrated skin",
        discountedPrice = 355.20f,
        originalPrice = 444.20f,
        reviewCount = 249,
        rating = 5,
        isInStock = true,
        productImage = R.drawable.productimage
    ),
    ProductCardModel(
        name = "afterglow",
        description = "French clay and algae-powered cleanser",
        skinTypes = "Skin tightness ● Dry and dehydrated skin",
        discountedPrice = 355.20f,
        originalPrice = 444.20f,
        reviewCount = 249,
        rating = 5,
        isInStock = false,
        productImage = R.drawable.productimage
    ),
)