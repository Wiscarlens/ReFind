import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
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
import androidx.compose.ui.unit.sp
import com.moduleio.refind.R

@Composable
fun CardComponent(image: Painter, title: String, description: String) {
    Card(
        shape = RoundedCornerShape(5.dp), // Adjusted rounded corners
        modifier = Modifier
            .requiredSize(100.dp) // Keeps the card square
            .padding(4.dp), // Reduced padding
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centers content horizontally
            verticalArrangement = Arrangement.Center, // Centers content vertically
            modifier = Modifier.padding(8.dp).fillMaxSize() // Reduced padding inside the card
        ) {
            Image(
                painter = image,
                contentDescription = null, // Accessibility description
                modifier = Modifier
                    .size(50.dp) // Reduced image size
                    .clip(RoundedCornerShape(5.dp)) // Rounded corners for the image
            )
            Spacer(modifier = Modifier.height(2.dp)) // Reduced space between image and text
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 10.sp // Reduced font size for title
            )
            Text(
                text = description,
                textAlign = TextAlign.Center,
                fontSize = 8.sp // Reduced font size for description
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSquareCardWithContent() {
    CardComponent(
        image = painterResource(id = R.drawable.dasani),
        title = "Title Here",
        description = "Description Here"
    )
}