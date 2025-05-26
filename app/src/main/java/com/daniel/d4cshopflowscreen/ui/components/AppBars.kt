package com.daniel.d4cshopflowscreen.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.daniel.d4cshopflowscreen.ui.theme.MineShaft
import com.daniel.d4cshopflowscreen.ui.theme.Pear
import com.daniel.d4cshopflowscreen.ui.theme.century_old_style_std_bold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainScreenTopBar(
    onBackBtnPressed : () -> Unit,
    onFavouriteClicked: () -> Unit,
    onShoppingCartClicked: () -> Unit,
    favItemCount: Int,
    cartItemCount: Int
): @Composable () -> Unit = {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MineShaft
        ),
        title = {
            Text(text = "Shop", fontFamily = century_old_style_std_bold, color = Color.White, fontSize = 26.sp)
        },
        navigationIcon = {
            IconButton(
                onClick = onBackBtnPressed
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Sharp.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            BadgedBox(
                badge = {
                    if (favItemCount > 0) {
                        Badge(
                            containerColor = Pear,
                            contentColor = Color.Black
                        ) {
                            Text("$favItemCount")
                        }
                    }
                }
            ) {
                IconButton(
                    onClick = onFavouriteClicked
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            BadgedBox(
                badge = {
                    if (cartItemCount > 0) {
                        Badge(
                            containerColor = Pear,
                            contentColor = Color.Black
                        ) {
                            Text("$cartItemCount")
                        }
                    }
                }
            ) {
                IconButton(
                    onClick = onShoppingCartClicked
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    )
}