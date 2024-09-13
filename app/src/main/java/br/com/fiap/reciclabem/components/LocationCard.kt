package br.com.fiap.reciclabem.components

import Hyperlink
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.reciclabem.calculations.calculateDistance
import br.com.fiap.reciclabem.calculations.formatDistance
import br.com.fiap.reciclabem.ui.theme.backgroundApplicationColor
import br.com.fiap.reciclabem.ui.theme.darknedApplicationColor

@Composable
fun LocationCard(name: String, address: String, placeId: String, userLat: Double, userLng: Double, placeLat: Double, placeLng: Double) {

    val distance = calculateDistance(userLat, userLng, placeLat, placeLng)

    val formattedDistance = formatDistance(distance)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 14.dp, end = 14.dp, bottom = 14.dp),
        colors = CardDefaults.cardColors(backgroundApplicationColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight()
                    .padding(8.dp)
            ) {
                Row {
                    Text(
                        text = name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = darknedApplicationColor
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(
                        text = address,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                ) {
                    Text(text = "Dist:", color = darknedApplicationColor, fontWeight = FontWeight.Medium)
                    Text(text = formattedDistance, color = Color.White)
                }
                Hyperlink(
                    modifier = Modifier
                        .background(color = darknedApplicationColor, shape = RoundedCornerShape(12.dp))
                        .padding(start = 24.dp, top=4.dp, bottom = 4.dp, end= 24.dp),
                    fullText = "Ir",
                    linkText = listOf("Ir"),
                    hyperlinks = listOf("https://google.com/maps/place/?q=place_id:${placeId}"),
                    fontSize = 14.sp,
                    linkTextDecoration = TextDecoration.None
                )
            }
        }
    }
}