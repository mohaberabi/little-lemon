package com.example.littlelemon.ui.composables

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.Coil
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.littlelemon.data.MenuItemEntity
import com.example.littlelemon.ui.theme.Typography

@Composable

fun MenuItemCompose(item: MenuItemEntity) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.75f)
        ) {
            Text(
                text = item.title,
                style = Typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = item.description,
                style = Typography.bodyMedium.copy(
                    fontWeight = FontWeight.Light, color = Color.Gray
                )
            )
            Spacer(
                modifier = Modifier.height(6.dp)
            )
            Text(
                text = "$${item.price}",
                style = Typography.bodySmall
            )
        }
        Image(
            painter = rememberAsyncImagePainter(item.image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(85.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentDescription = null
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MenuItemComposePreview() {
    MenuItemCompose(
        item = MenuItemEntity(
            0,
            "Pizza",
            "loverly pizze dumy pizze",
            200.0,
            "https://s23209.pcdn.co/wp-content/uploads/2022/05/Sheet-Pan-Pizza211129_DAMN-DELICIOUS_Sheet-Pan-Pizza_482-500x375.jpg",
            ""
        )
    )
}