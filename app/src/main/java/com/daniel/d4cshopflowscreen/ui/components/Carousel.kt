package com.daniel.d4cshopflowscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniel.d4cshopflowscreen.R
import com.daniel.d4cshopflowscreen.data.model.CategoryCarouselData
import com.daniel.d4cshopflowscreen.data.model.FeaturedCarouselData
import com.daniel.d4cshopflowscreen.ui.theme.Pear
import com.daniel.d4cshopflowscreen.ui.theme.neuzeitsbookFontFamily

val sampleFeaturedCarouselData = listOf(
    FeaturedCarouselData(
        headline = "GET 20% OFF",
        subtitle = "Get 20% off",
        date = "12 - 16 October"
    ),
    FeaturedCarouselData(
        headline = "GET 20% OFF",
        subtitle = "Get 20% off",
        date = "12 - 16 October"
    ),
    FeaturedCarouselData(
        headline = "GET 20% OFF",
        subtitle = "Get 20% off",
        date = "12 - 16 October"
    ),
)

//Categorysample.png is in low quality so gonna use productimage for now
val sampleCategoryCarouselData = listOf(
    CategoryCarouselData(
        label = "Cleaners",
        image = R.drawable.productimage
    ),
    CategoryCarouselData(
        label = "Toners",
        image = R.drawable.productimage
    ),
    CategoryCarouselData(
        label = "Sunscreens",
        image = R.drawable.productimage
    ),
    CategoryCarouselData(
        label = "Serums",
        image = R.drawable.productimage
    ),
    CategoryCarouselData(
        label = "Moisturizers",
        image = R.drawable.productimage
    ),
)

@Composable
fun FeaturedCarousel(
    featuredCarouselDataList: List<FeaturedCarouselData> = sampleFeaturedCarouselData
) {
    //Instead of HorizontalPager we can use LazyRow as well to not show the
    //other page on the view

    val pageCount = featuredCarouselDataList.size
    val pagerState = rememberPagerState(pageCount = {
        pageCount
    })

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        HorizontalPager(
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp,
            state = pagerState
        ) { page ->
            FeaturedCarouselCard(
                data = featuredCarouselDataList[page]
            )
        }
        Row(
            Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Pear else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(color, CircleShape)
                        .size(10.dp)
                )
            }
        }
    }
}


@Composable
fun FeaturedCarouselCard(
    modifier: Modifier = Modifier,
    data: FeaturedCarouselData
) {
    Card (
        modifier = modifier.size(360.dp, 200.dp),
        colors = CardDefaults.cardColors(Color.Black),
        shape = RoundedCornerShape(24.dp)
    ){
        Column(
            modifier = Modifier.padding(top = 40.dp, start = 40.dp)
        ){
            Text(
                text = data.headline,
                color = Color.White,
                fontFamily = neuzeitsbookFontFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 26.sp
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = data.subtitle,
                color = Color.White,
                fontFamily = neuzeitsbookFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
            Card(
                modifier = Modifier.padding(top = 32.dp),
                colors = CardDefaults.cardColors(Pear),
                shape = RoundedCornerShape(50)

            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = data.date,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun CategoriesCarousel(
        categoryCarouselDataList: List<CategoryCarouselData> = sampleCategoryCarouselData
    ) {
    val state = rememberLazyListState()
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        state = state,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categoryCarouselDataList){data->
            CategoryCarouselCard(data)
        }
    }
}

@Composable
fun CategoryCarouselCard(data: CategoryCarouselData) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(64.dp).clip(CircleShape).background(Color.Black)
        ){
            Image(
                painter = painterResource(data.image),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.padding(top = 2.dp))
        Text(text = data.label, color = Color.White, fontFamily = neuzeitsbookFontFamily)
    }
}

@Preview
@Composable
private fun FC() {
    FeaturedCarousel()
}

@Preview
@Composable
private fun CCC() {
    CategoryCarouselCard(
        sampleCategoryCarouselData[0]
    )
}