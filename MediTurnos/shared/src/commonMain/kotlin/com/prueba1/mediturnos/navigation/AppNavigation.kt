package com.prueba1.mediturnos.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.prueba1.mediturnos.screens.LoginScreen
import com.prueba1.mediturnos.screens.WelcomeScreen
import kotlinx.serialization.Serializable

// 1. Definimos las rutas de forma tipada (Navigation Tree destinations)
@Serializable
object LoginRoute

@Serializable
data class WelcomeRoute(val nombre: String)

@Composable
fun AppNavigation() {
    // 2. Creamos el controlador del árbol de navegación
    val navController = rememberNavController()

    // 3. Declaramos el mapa / árbol de navegación (NavHost)
    NavHost(
        navController = navController,
        startDestination = LoginRoute
    ) {
        // Ruta 1: Login
        composable<LoginRoute> {
            LoginScreen(
                onLoginClick = { nombreIngresado ->
                    // Navegamos hacia la siguiente pantalla pasando el parámetro de forma segura
                    navController.navigate(WelcomeRoute(nombre = nombreIngresado))
                }
            )
        }

        // Ruta 2: Welcome
        composable<WelcomeRoute> { backStackEntry ->
            // Extraemos los argumentos de la ruta de manera automática
            val welcomeRoute = backStackEntry.toRoute<WelcomeRoute>()

            WelcomeScreen(
                nombre = welcomeRoute.nombre,
                onBackClick = {
                    // Volvemos atrás limpiando la pila si es necesario
                    navController.popBackStack()
                }
            )
        }
    }
}