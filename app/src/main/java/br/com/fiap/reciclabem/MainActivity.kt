package br.com.fiap.reciclabem


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.reciclabem.components.Menu
import br.com.fiap.reciclabem.screens.DiscardScreen
import br.com.fiap.reciclabem.screens.FaqScreen
import br.com.fiap.reciclabem.screens.RecycleScreen
import br.com.fiap.reciclabem.ui.theme.ReciclaBemTheme
import br.com.fiap.reciclabem.ui.theme.backgroundApplicationColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReciclaBemTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = backgroundApplicationColor
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "recycle",
                        exitTransition = {
                            slideOutOfContainer(towards =
                           AnimatedContentTransitionScope.SlideDirection.End,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(towards =
                            AnimatedContentTransitionScope.SlideDirection.Start,
                                animationSpec = tween(1000)
                            )
                        }
                    ){
                        composable(route = "recycle"){ RecycleScreen() }
                        composable(route = "discard"){ DiscardScreen() }
                        composable(route = "faq"){ FaqScreen() }
                    }
                    Menu(navController)
                }
            }
        }
    }

}

