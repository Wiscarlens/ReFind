package com.moduleio.refind.ui.screens

import ItemCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.moduleio.refind.R
import com.moduleio.refind.data.model.Item
import com.moduleio.refind.ui.theme.Green
import com.moduleio.refind.ui.theme.ReFindTheme

@Preview
@Composable
fun HomeScreen() {
    val cardItems = listOf(
        Item(R.drawable.dasani, "Dasani", "Description 1"),
        Item(R.drawable.dasani, "FIji", "Description 2"),
        Item(R.drawable.dasani, "Evian", "Description 3"),
        Item(R.drawable.dasani, "Dasani", "Description 1"),
        Item(R.drawable.dasani, "Fiji", "Description 2"),
        Item(R.drawable.dasani, "Evian", "Description 3"),
        // Add more items as needed
    )

    ReFindTheme {
        Column(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .fillMaxSize()
        ) {
//        TopBar()
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "ReFind Logo",
                modifier = Modifier
                    .size(120.dp)
                    .align(CenterHorizontally)
                    .padding(top = 30.dp)
            )
            Text(
                text = "ReFind",
                fontSize = 30.sp,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 5.dp, bottom = 8.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))

            SearchView(modifier = Modifier.fillMaxWidth())
            AnimationSection()
            Column{
                Text(
                    text = "Search History",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                // TODO: Lazy grid here
                LazyVerticalGrid(columns = GridCells.Adaptive(100.dp)) {
                    items(cardItems) { item ->
                        ItemCard(
                            image = painterResource(id = item.imageResId),
                            title = item.title,
                            description = item.description
                        )
                    }

                }
            }

//        FloatingButton()

        }
    }
}

@Composable
fun AnimationSection() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.search_animation))
    Box(modifier = Modifier.fillMaxWidth()) {
        LottieAnimation(composition = composition, modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
            iterations = LottieConstants.IterateForever
        )
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
        Text(
            text = "Sorting Guide",
            fontSize = 18.sp,
            modifier = Modifier.align(CenterVertically),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* Handle close button click */ }) {
            Icon(imageVector = Icons.Outlined.Close, contentDescription = "Close")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = "", // Replace with your search state
        onValueChange = { /* Handle search value change */ },
        label = { Text("Search for item") },
        modifier = modifier
            .fillMaxWidth(),
        leadingIcon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search") },
        trailingIcon = {
            IconButton(onClick = { /* Handle clear button click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                    contentDescription = "Clear")
            }
        },
        shape = RoundedCornerShape(20.dp),
        colors = outlinedTextFieldColors(
//            unfocusedBorderColor = Green, // Set the unfocused outline color to Green
            focusedBorderColor = Green,
            focusedLabelColor = Green,

        )

    )
}

@Composable
fun FloatingButton() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ){
        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
                .clip(CircleShape)
                .size(60.dp),
            containerColor = Color(0xFF2C972F),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                contentDescription = "Scan  Button",
                tint = Color.White)
        }
    }
}

