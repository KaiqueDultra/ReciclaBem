package br.com.fiap.reciclabem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.reciclabem.R
import br.com.fiap.reciclabem.ui.theme.darknedApplicationColor

@Composable
fun ItemRecycle(title: String, image: Int, imageDescription: String, width: Dp, height: Dp, text: String, onItemRecycleClicked: (Boolean) -> Unit) {
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.05f)
        ) {
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.95f)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 23.dp, topEnd = 23.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = darknedApplicationColor
                )
            }
            IconButton(onClick = { onItemRecycleClicked(false) },
                modifier = Modifier.offset(x = 12.dp,y = (-40).dp)) {
                Icon(
                    modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .background(
                            color = darknedApplicationColor,
                            shape = RoundedCornerShape(30.dp)
                        ),
                    imageVector = Icons.Default.Close,
                    contentDescription = "Ícone de fechar",
                    tint = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(193.dp)
                    .offset(y = (-24).dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(id = R.drawable.star),
                    contentDescription = "Imagem de uma estrela com várias pontas",
                    modifier = Modifier
                        .size(193.dp),
                    alignment = Alignment.TopCenter
                )
                Image(
                    painterResource(id = image),
                    contentDescription = imageDescription,
                    modifier = Modifier
                        .width(width)
                        .height(height)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
              Text(
                  text = "Como Reciclar",
                  fontSize = 24.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = darknedApplicationColor
              )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    item {
                        Text(
                            text = text,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            color = darknedApplicationColor
                        )
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )
    }
}

