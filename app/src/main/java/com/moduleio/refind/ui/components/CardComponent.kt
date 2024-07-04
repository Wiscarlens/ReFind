package com.moduleio.refind.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moduleio.refind.R

@Composable
fun SquareCardWithContent(image: Painter, title: String, description: String) {
    Card(
        shape = RoundedCornerShape(10.dp), // Rounded corners
        modifier = Modifier
            .size(200.dp) // Ensures the card is square
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centers content horizontally
            verticalArrangement = Arrangement.Center, // Centers content vertically
            modifier = Modifier.padding(20.dp).fillMaxSize()
        ) {
            Image(
                painter = image,
                contentDescription = null, // Accessibility description
                modifier = Modifier
                    .size(100.dp) // Adjust the size as needed
                    .clip(RoundedCornerShape(10.dp)) // Rounded corners for the image
            )
            Spacer(modifier = Modifier.height(8.dp)) // Space between image and text
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = description,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSquareCardWithContent() {
    SquareCardWithContent(
        image = painterResource(id = R.drawable.dasani),
        title = "Title Here",
        description = "Description Here"
    )
}