package br.com.fiap.reciclabem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.reciclabem.ui.theme.backgroundApplicationColor
import br.com.fiap.reciclabem.ui.theme.darknedApplicationColor

@Composable
fun ItemCard(
    cardTitle: String,
    width: Int,
    height: Int,
    image: Int,
    imageDescription: String,
    onItemCardClicked: (Boolean) -> Unit
) {

    Card(
        modifier = Modifier
            .height(160.dp)
            .width(105.dp)
            .padding(8.dp)
            .clickable {
               onItemCardClicked(true)
            },
        colors = CardDefaults.cardColors(darknedApplicationColor),
    ) {
        Text(modifier = Modifier
            .padding(8.dp)
            .align(Alignment.CenterHorizontally),
            color = Color.White,
            text = cardTitle,
            fontSize = 14.sp
        )
        Card(
            modifier = Modifier
                .weight(0.05f)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(backgroundApplicationColor),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .width(width.dp)
                        .height(height.dp),
                    painter = painterResource(id = image),
                    contentDescription = imageDescription)
            }
        }
    }
}