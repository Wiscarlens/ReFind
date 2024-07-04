package com.moduleio.refind.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.moduleio.refind.R

@Preview
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
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
        Text(
            text = "Search History",
            fontSize = 20.sp,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(bottom = 8.dp)
        )
//        RecyclersSection()
//        GridSection(visible = false)
    }
}

@Composable
fun AnimationSection() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.search_animation))
    Box(modifier = Modifier.fillMaxWidth()) {
        LottieAnimation(composition = composition, modifier = Modifier.fillMaxWidth())
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

