package br.com.fiap.reciclabem.screens

import Hyperlink
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.reciclabem.R
import br.com.fiap.reciclabem.ui.theme.backgroundApplicationColor
import br.com.fiap.reciclabem.ui.theme.darknedApplicationColor

@Composable
fun FaqScreen() {
    
    Column {
        Column(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth()
        ) {
        }
        Column(
            modifier = Modifier
                .weight(0.8f)
                .fillMaxWidth()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 23.dp, topEnd = 23.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(top = 0.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                Image(
                    modifier = Modifier
                        .width(283.dp)
                        .height(196.dp)
                        .offset(y = (-135).dp),
                    painter = painterResource(id = R.drawable.men_recycling),
                    contentDescription = "Homem reciclando")
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(top = 70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "PERGUNTAS FREQUENTES",
                        color = darknedApplicationColor,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light
                    )
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, top = 24.dp, end = 15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                colors = CardDefaults.cardColors(backgroundApplicationColor),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                ) {
                                    Hyperlink(
                                        fullText = " • Como funciona a reciclagem de plástico?",
                                        linkText = listOf(" • Como funciona a reciclagem de plástico?"),
                                        hyperlinks = listOf("https://www.reciclasampa.com.br/artigo/tudo-o-que-voce-precisa-saber-sobre-reciclagem-de-plastico?gad_source=1&gclid=CjwKCAjwzN-vBhAkEiwAYiO7oH38qcOOpZ2H1F8V7X7GhPqeQnKQprjcbFOQHhO9LP-E-zfC533ukBoC1a0QAvD_BwE"),
                                        fontSize = 16.sp
                                    )
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Hyperlink(
                                        fullText = " • Por que reciclar papel é importante?",
                                        linkText = listOf(" • Por que reciclar papel é importante?"),
                                        hyperlinks = listOf("https://portalresiduossolidos.com/a-importancia-da-reciclagem-de-papel/#:~:text=A%20reciclagem%20de%20papel%20traz,para%20a%20indústria%20da%20reciclagem"),
                                        fontSize = 16.sp
                                    )
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Hyperlink(
                                        fullText = " • O que é reciclagem e por que ela é tão importante?",
                                        linkText = listOf(" • O que é reciclagem e por que ela é tão importante?"),
                                        hyperlinks = listOf("https://blog.brkambiental.com.br/reciclagem/#:~:text=A%20reciclagem%20é%20o%20processo,a%20única%20medida%20para%20isso"),
                                        fontSize = 16.sp
                                    )
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Hyperlink(
                                        fullText = " • Como é o processo de reciclagem de eletrônicos?",
                                        linkText = listOf(" • Como é o processo de reciclagem de eletrônicos?"),
                                        hyperlinks = listOf("https://www.tendaatacado.com.br/dicas/a-reciclagem-de-eletronicos-contribui-para-o-meio-ambiente-veja-como-funciona/"),
                                        fontSize = 16.sp
                                    )
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Hyperlink(
                                        fullText = " • Qual é a importância da reciclagem de resíduos orgânicos para o meio ambiente",
                                        linkText = listOf(" • Qual é a importância da reciclagem de resíduos orgânicos para o meio ambiente"),
                                        hyperlinks = listOf("https://www.reciclasampa.com.br/artigo/entenda-como-a-compostagem-contribui-para-a-sustentabilidade?gad_source=1&gclid=CjwKCAjwzN-vBhAkEiwAYiO7oN_xNi0R2jJebpZVajn8_dh7LmFqIdPO4PqcO7-eW4Afn2pdlVC5iRoCXU4QAvD_BwE"),
                                        fontSize = 16.sp
                                    )
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Hyperlink(
                                        fullText = " • Reciclagem de pneus: qual a sua importância?",
                                        linkText = listOf(" • Reciclagem de pneus: qual a sua importância?"),
                                        hyperlinks = listOf("https://guaratingueta.sp.gov.br/a-importancia-do-descarte-correto-de-residuos-pneus-2/#:~:text=Um%20pneu%20pode%20demorar%20600,tóxicos%20que%20poluem%20o%20ar"),
                                        fontSize = 16.sp
                                    )
                                }
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                        item {
                            Text(text = "DICAS", fontWeight = FontWeight.Light, fontSize = 24.sp, color = darknedApplicationColor)
                        }
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                        item {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                colors = CardDefaults.cardColors(backgroundApplicationColor)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                ) {
                                    Text(text = "LEMBRE DE LIMPAR OS ITENS ANTES DE RECICLA-LOS!", color = Color.White)
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(text = "Limpeza simples é suficiente:", fontWeight = FontWeight.Medium, color = Color.White)
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier
                                            .padding(12.dp),) {
                                            Image(
                                                painter = painterResource(id = R.drawable.hand_with_climate),
                                                contentDescription = "Mão com uma gota de água",
                                                modifier = Modifier.size(48.dp)
                                            )
                                        }
                                        Column {
                                            Text(
                                                text = "Não é necessário realizar uma limpeza profunda. Um enxágue simples para remover resíduos é geralmente suficiente. Evite usar grandes quantidades de água, pois isso pode aumentar o consumo e o desperdício.",
                                                color = Color.White
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(text = "Remova etiquetas e adesivos:", fontWeight = FontWeight.Medium, color = Color.White)
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Retire etiquetas de papel e adesivos de produtos antes de reciclar. Isso facilita o processamento e a reciclagem do material.",
                                        color = Color.White
                                    )
                                }
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                        }
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
