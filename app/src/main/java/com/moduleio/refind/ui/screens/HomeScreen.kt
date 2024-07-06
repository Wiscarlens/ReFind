package com.moduleio.refind.ui.screens

import CardComponent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import com.airbnb.lottie.compose.rememberLottieComposition
import com.moduleio.refind.R
import com.moduleio.refind.data.model.Item
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
            Text(
                text = "ReFind",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 30.dp, bottom = 8.dp),
                fontWeight = FontWeight.Bold,
                color = androidx.compose.ui.graphics.Color.White
            )
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
                        CardComponent(
                            image = painterResource(id = item.imageResId),
                            title = item.title,
                            description = item.description
                        )
                    }

                }
            }

        FloatingButton()

        }
    }
}

@Composable
fun AnimationSection() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.search_animation))
    Box(modifier = Modifier.fillMaxWidth()) {
        LottieAnimation(composition = composition, modifier = Modifier
            .fillMaxWidth()
            .height(200.dp))
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

@Composable
fun SearchView(modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = "", // Replace with your search state
        onValueChange = { /* Handle search value change */ },
        label = { Text("Search for item") },
        modifier = modifier
            .fillMaxWidth(),
        leadingIcon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search") }
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
                .clip(CircleShape),
//            containerColor = DarkBleu,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_document_scanner_24),
                contentDescription = "Scan  Button",
                tint = Color.White)
        }
    }
}

