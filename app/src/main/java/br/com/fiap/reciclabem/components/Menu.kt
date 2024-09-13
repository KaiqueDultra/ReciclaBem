package br.com.fiap.reciclabem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.fiap.reciclabem.R
import br.com.fiap.reciclabem.ui.theme.backgroundApplicationColor
import br.com.fiap.reciclabem.ui.theme.darknedApplicationColor

@Composable
fun Menu(navController: NavController) {

    val backStackEntry = navController.currentBackStackEntryAsState().value?.destination?.route.toString()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = backgroundApplicationColor),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
           IconButton(onClick = { navController.navigate("recycle") } ) {
               Icon(
                   modifier = Modifier
                       .width(40.dp)
                       .height(40.dp),
                   painter = painterResource(id = R.drawable.icon_recycle),
                   contentDescription = "Ícone de reciclagem",
                   tint = if (backStackEntry === "recycle") Color.White else darknedApplicationColor
               )
           }
            IconButton(onClick = { navController.navigate("discard") } ) {
                Icon(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp),
                    painter = painterResource(id = R.drawable.icon_place),
                    contentDescription = "Ícone de localização",
                    tint = if (backStackEntry === "discard") Color.White else darknedApplicationColor
                )
            }
            IconButton(onClick = { navController.navigate("faq") } ) {
                Icon(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp),
                    painter = painterResource(id = R.drawable.icon_question),
                    contentDescription = "Ícone de perguntas",
                    tint = if (backStackEntry === "faq") Color.White else darknedApplicationColor
                )
            }

        }
    }
}
