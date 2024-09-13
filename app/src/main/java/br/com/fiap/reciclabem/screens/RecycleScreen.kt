package br.com.fiap.reciclabem.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.reciclabem.R
import br.com.fiap.reciclabem.components.ItemCard
import br.com.fiap.reciclabem.components.ItemRecycle
import br.com.fiap.reciclabem.ui.theme.darknedApplicationColor

@Composable
fun RecycleScreen() {

    var showPlasticInfo by remember { mutableStateOf(false) }
    var showMetalInfo by remember { mutableStateOf(false) }
    var showBatteryInfo by remember { mutableStateOf(false) }
    var showPaperInfo by remember { mutableStateOf(false) }
    var showGlassInfo by remember { mutableStateOf(false) }
    var showOrganicInfo by remember { mutableStateOf(false) }
    var showEletronicInfo by remember { mutableStateOf(false) }
    var showOilInfo by remember { mutableStateOf(false) }
    var showWoodInfo by remember { mutableStateOf(false) }

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
                        .width(291.dp)
                        .height(158.dp)
                        .offset(y = (-112).dp),
                    painter = painterResource(id = R.drawable.woman_recycling),
                    contentDescription = "Mulher reciclando")
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(top = 70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "COMO RECICLAR",
                        color = darknedApplicationColor,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Light
                    )
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(105.dp),
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        item {
                            ItemCard(
                                "PLÁSTICO",
                                79,
                                72,
                                R.drawable.water_bottle,
                                "Garrafas de plástico",
                                onItemCardClicked = {
                                    showPlasticInfo = it
                                }
                            )
                        }
                        item {
                            ItemCard(
                                "METAL",
                                75,
                                70,
                                R.drawable.metals,
                                "Lata de metal",
                                onItemCardClicked = {
                                    showMetalInfo = it
                                }
                            )
                        }
                        item {
                            ItemCard(
                                "BATERIA",
                                79,
                                72,
                                R.drawable.battery,
                                "Bateria",
                                onItemCardClicked = {
                                    showBatteryInfo = it
                                }
                            )
                        }
                        item {
                            ItemCard(
                                "PAPEL",
                                75,
                                67,
                                R.drawable.paper,
                                "Papel",
                                onItemCardClicked = {
                                    showPaperInfo = it
                                }
                            )
                        }
                        item {
                            ItemCard(
                                "VIDRO",
                                75,
                                67,
                                R.drawable.bottle,
                                "Garrafa de vidro",
                                onItemCardClicked = {
                                    showGlassInfo = it
                                }
                            )
                        }
                        item {
                            ItemCard(
                                "ORGÂNICO",
                                80,
                                72,
                                R.drawable.food,
                                "Restos de comida",
                                onItemCardClicked = {
                                    showOrganicInfo = it
                                }
                            )
                        }
                        item {
                            ItemCard(
                                "ELETRÔNICO",
                                70,
                                70,
                                R.drawable.icon_eletronic,
                                "Eletrônicos",
                                onItemCardClicked = {
                                    showEletronicInfo = it
                                }
                            )
                        }
                        item {
                            ItemCard(
                                "ÓLEO",
                                70,
                                70,
                                R.drawable.icon_oil,
                                "Óleo de cozinha",
                                onItemCardClicked = {
                                    showOilInfo = it
                                }
                            )
                        }
                        item {
                            ItemCard(
                                "MADEIRA",
                                70,
                                70,
                                R.drawable.icon_wood,
                                "Tábuas de madeira",
                                onItemCardClicked = {
                                    showWoodInfo = it
                                }
                            )
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
    if (showPlasticInfo) {
        ItemRecycle(
            title = "PLÁSTICO",
            image = R.drawable.water_bottle,
            imageDescription = "Garrafas de água",
            112.dp,
            107.dp,
            text = "1.  PET (Código 1):\n" +
                    "  •  Reciclável: Garrafas de água, refrigerantes, recipientes de alimentos.\n" +
                    "  •  Descarte: Remova tampas e rótulos, lave e seque antes de reciclar.\n" +
                    "\n" +
                    "2.  PEAD (Código 2):\n" +
                    "  •  Reciclável: Garrafas de leite, detergentes, garrafas de água.\n" +
                    "  •  Descarte: Remova tampas, lave e seque antes de reciclar.\n" +
                    "\n" +
                    "3. PVC (Código 3):\n" +
                    "  •  Reciclável: Alguns programas de reciclagem aceitam PVC, como tubos e perfis para janelas.\n" +
                    "  •  Descarte: Verifique se há instalações de reciclagem locais que aceitam PVC.\n" +
                    "\n" +
                    "4. PEBD (Código 4):\n" +
                    "  •  Reciclável: Sacolas plásticas, filmes de embalagem, alguns recipientes.\n" +
                    "  •  Descarte: Algumas sacolas podem ser recicladas em locais específicos.",
            onItemRecycleClicked = {
            showPlasticInfo = it
        })
    }
    if (showMetalInfo) {
        ItemRecycle(
            title = "METAL",
            image = R.drawable.metals,
            imageDescription = "Lata de metal",
            width = 112.dp,
            height = 107.dp,
            text = "1.  Alumínio:\n" +
                    "  •  Reciclável: Latas de refrigerante, alimentos enlatados.\n" +
                    "  •  Descarte: Amasse as latas para economizar espaço, remova quaisquer resíduos sólidos e lave antes de reciclar.\n" +
                    "\n" +
                    "2.  Ferro:\n" +
                    "  •  Reciclável: Latas de conserva, ferramentas antigas.\n" +
                    "  •  Descarte: Verifique se há instalações de reciclagem locais que aceitem ferro e separe-o dos outros metais para reciclagem adequada.\n" +
                    "\n" +
                    "3. Aço:\n" +
                    "  •  Reciclável: Latas de alimentos, utensílios de cozinha.\n" +
                    "  •  Descarte: Separe o aço dos outros metais e entregue-o a centros de reciclagem locais.\n" +
                    "\n" +
                    "4. Cobre:\n" +
                    "  •  Reciclável: Fios elétricos, tubulações.\n" +
                    "  •  Descarte: Recolha fios de cobre antigos ou sobras de construção e leve-os para reciclagem em centros especializados.",
            onItemRecycleClicked = {
                showMetalInfo = it
            }
        )
    }
    if (showBatteryInfo) {
        ItemRecycle(
            title = "Bateria",
            image = R.drawable.battery,
            imageDescription = "Bateria",
            width = 112.dp,
            height = 107.dp,
            text = "1.  Pilhas alcalinas:\n" +
                    "  •  Reciclável: Pilhas AA, AAA, pilhas de botão.\n" +
                    "  •  Descarte: Leve as pilhas usadas a pontos de coleta específicos em lojas ou centros de reciclagem.\n" +
                    "\n" +
                    "2.  Baterias de chumbo-ácido:\n" +
                    "  •  Reciclável: Baterias de carros, motos.\n" +
                    "  •  Descarte: Devolva baterias usadas ao revendedor no momento da compra de uma nova ou entregue-as em centros de reciclagem autorizados.\n" +
                    "\n" +
                    "3. Baterias recarregáveis:\n" +
                    "  •  Reciclável: Baterias de celular, laptops, câmeras.\n" +
                    "  •  Descarte: Procure pontos de coleta em lojas de eletrônicos ou centros de reciclagem para reciclar baterias recarregáveis.\n" +
                    "\n" +
                    "4. Baterias de íon de lítio:\n" +
                    "  •  Reciclável: Baterias de laptops, dispositivos portáteis.\n" +
                    "  •  Descarte: Utilize programas de reciclagem de eletrônicos ou entregue baterias de íon de lítio em locais de reciclagem específicos.",
            onItemRecycleClicked = {
                showBatteryInfo = it
            }
        )
    }
    if (showPaperInfo) {
        ItemRecycle(
            title = "PAPEL",
            image = R.drawable.paper,
            imageDescription = "Papel",
            width = 112.dp,
            height = 107.dp,
            text = "1.  Papelão:\n" +
                    "  •  Reciclável: Caixas de embalagens, papelão ondulado.\n" +
                    "  •  Descarte: Achate e dobre o papelão para economizar espaço e entregue-o a centros de reciclagem locais.\n" +
                    "\n" +
                    "2.  Papel de escritório:\n" +
                    "  •  Reciclável: Folhas de papel impressas, cadernos.\n" +
                    "  •  Descarte: Rasgue ou pique documentos confidenciais antes de reciclar, e recicle outros tipos de papel em contêineres de reciclagem ou centros locais.\n" +
                    "\n" +
                    "3. Revistas e jornais:\n" +
                    "  •  Reciclável: Revistas, jornais.\n" +
                    "  •  Descarte:  Coloque revistas e jornais usados em caixas de reciclagem ou leve-os a centros de reciclagem designados.\n" +
                    "\n" +
                    "4. Papel de embrulho:\n" +
                    "  •  Reciclável: Papel de presente, sacos de papel.\n" +
                    "  •  Descarte: Evite papel de embrulho laminado ou metalizado, pois pode não ser reciclável; opte por papel simples e recicle-o após o uso.",
            onItemRecycleClicked = {
                showPaperInfo = it
            }
        )
    }
    if (showGlassInfo) {
        ItemRecycle(
            title = "VIDRO",
            image = R.drawable.bottle,
            imageDescription = "Garrafa de vidro",
            width = 112.dp,
            height = 107.dp,
            text = "1.  Garrafas e frascos:\n" +
                    "  •  Reciclável: Garrafas de bebidas, potes de alimentos.\n" +
                    "  •  Descarte: emova tampas e rótulos, lave bem e seque antes de reciclar. Separe por cor (verde, marrom, transparente) se possível.\n" +
                    "\n" +
                    "2.  Vidro quebrado:\n" +
                    "  •  Reciclável: Cacos de vidro.\n" +
                    "  •  Descarte: Evite colocar cacos de vidro soltos no lixo comum para evitar ferimentos; procure por programas de reciclagem locais que aceitem vidro quebrado.\n" +
                    "\n" +
                    "3. Vidro temperado:\n" +
                    "  •  Reciclável: Utensílios de cozinha de vidro temperado.\n" +
                    "  •  Descarte:  Devido à sua resistência, o vidro temperado pode ser mais difícil de reciclar; verifique com instalações de reciclagem locais se aceitam esse tipo de vidro.\n" +
                    "\n",
            onItemRecycleClicked = {
                showGlassInfo = it
            }
        )
    }
    if (showOrganicInfo) {
        ItemRecycle(
            title = "ORGÂNICO",
            image = R.drawable.food,
            imageDescription = "Resto de comidas orgânicas",
            width = 112.dp,
            height = 107.dp,
            text = "1.  Resíduos de alimentos:\n" +
                    "  •  Reciclável: Restos de frutas, legumes, cascas de ovos, borra de café.\n" +
                    "  •  Descarte: Composte os resíduos de alimentos em uma composteira doméstica para produzir adubo orgânico.\n" +
                    "\n" +
                    "2.  Resíduos de jardim:\n" +
                    "  •  Reciclável: Folhas, galhos, gramas cortadas.\n" +
                    "  •  Descarte: Composte os resíduos de jardim junto com os resíduos de alimentos para criar um composto rico em nutrientes.\n" +
                    "\n" +
                    "3. Sobras de comida não cozida:\n" +
                    "  •  Reciclável: Sobras de salada, frutas não utilizadas.\n" +
                    "  •  Descarte:  Utilize resíduos de alimentos não cozidos para compostagem ou alimente animais de estimação, se possível.\n" +
                    "\n" +
                    "4. Materiais compostáveis:\n" +
                    "  •  Reciclável: Sacos compostáveis, utensílios de madeira.\n" +
                    "  •  Descarte: Use sacos compostáveis para coletar resíduos orgânicos e descarte-os em composteiras domésticas ou programas municipais de compostagem.",
            onItemRecycleClicked = {
                showOrganicInfo = it
            }
        )
    }
    if (showEletronicInfo) {
        ItemRecycle(
            title = "ELETRÔNICO",
            image = R.drawable.icon_eletronic,
            imageDescription = "Eletrônicos",
            width = 112.dp,
            height = 107.dp,
            text = "1.  Celulares e smartphones:\n" +
                    "  •  Reciclável: Telefones celulares antigos.\n" +
                    "  •  Descarte: Procure programas de reciclagem eletrônica ou pontos de coleta em lojas de eletrônicos para descartar celulares de forma responsável.\n" +
                    "\n" +
                    "2.  Computadores e laptops:\n" +
                    "  •  Reciclável: Desktops, laptops antigos.\n" +
                    "  •  Descarte: Doação para programas de recondicionamento de eletrônicos ou reciclagem em centros especializados.\n" +
                    "\n" +
                    "3. Baterias e carregadores:\n" +
                    "  •  Reciclável: Baterias de celulares, carregadores.\n" +
                    "  •  Descarte:  Recicle baterias e carregadores em pontos de coleta específicos em lojas ou centros de reciclagem.\n" +
                    "\n" +
                    "4. Cabos e fios:\n" +
                    "  •  Reciclável: Cabos de energia, fios de dados.\n" +
                    "  •  Descarte: Procure programas de reciclagem eletrônica que aceitem cabos e fios ou entregue-os em centros de reciclagem de eletrônicos.",
            onItemRecycleClicked = {
                showEletronicInfo = it
            }
        )
    }
    if (showOilInfo) {
        ItemRecycle(
            title = "ÓLEO",
            image = R.drawable.icon_oil,
            imageDescription = "Óleo de cozinha",
            width = 112.dp,
            height = 107.dp,
            text = "1.  Óleo de cozinha:\n" +
                    "  •  Reciclável: Óleo de fritura usado.\n" +
                    "  •  Descarte: Armazene o óleo em recipientes selados e leve-o a pontos de coleta designados para reciclagem de óleo de cozinha.",
            onItemRecycleClicked = {
                showOilInfo = it
            }
        )
    }
    if (showWoodInfo) {
        ItemRecycle(
            title = "MADEIRA",
            image = R.drawable.icon_wood,
            imageDescription = "Tábuas de madeira",
            width = 112.dp,
            height = 107.dp,
            text = "1.  Móveis de madeira:\n" +
                    "  •  Reciclável: Móveis antigos, paletes de madeira.\n" +
                    "  •  Descarte: Doe móveis em boas condições para organizações de caridade ou entregue-os a centros de reciclagem de madeira.\n" +
                    "\n" +
                    "2.  Sobras de construção:\n" +
                    "  •  Reciclável: Tábuas, vigas.\n" +
                    "  •  Descarte: Separe sobras de madeira de outros materiais de construção e leve-as a instalações de reciclagem de madeira.\n" +
                    "\n" +
                    "3. Papelão revestido de madeira:\n" +
                    "  •  Reciclável: Caixas de papelão laminadas.\n" +
                    "  •  Descarte:  Remova quaisquer materiais não recicláveis anexados ao papelão antes de reciclar em centros de reciclagem de papelão.\n" +
                    "\n" +
                    "4. Madeira tratada:\n" +
                    "  •  Reciclável: Madeira tratada quimicamente.\n" +
                    "  •  Descarte:  Procure empresas especializadas em reciclagem de madeira tratada para descarte adequado.",
            onItemRecycleClicked = {
                showWoodInfo = it
            }
        )
    }
}
