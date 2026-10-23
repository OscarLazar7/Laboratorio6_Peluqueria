package com.prueba1.mediturnos.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.prueba1.mediturnos.screens.LoginScreen
import com.prueba1.mediturnos.screens.WelcomeScreen
import kotlinx.serialization.Serializable


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.prueba1.mediturnos.screens.ServicesScreen
import com.prueba1.mediturnos.screens.NextStepScreen

/*
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
}*/


@Serializable
object LoginRoute

@Serializable
data class WelcomeRoute(val nombre: String)


// 1. Declaración de Rutas Tipadas
@Serializable
object ServicesRoute

@Serializable
data class StepTwoRoute(
    val serviceId: String,
    val serviceTitle: String,
    val price: Double
)

// 2. El Grafo o Árbol de Navegación
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ServicesRoute
    ) {
        // Pantalla de lista de servicios
        composable<ServicesRoute> {
            ServicesScreen(
                onServiceSelected = { service ->
                    // Navegamos al siguiente paso transmitiendo el objeto seleccionado
                    navController.navigate(
                        StepTwoRoute(
                            serviceId = service.id,
                            serviceTitle = service.title,
                            price = service.price
                        )
                    )
                }
            )
        }

        // Pantalla del Paso 2 (Elegir fecha/hora, profesional, etc.)
        composable<StepTwoRoute> { backStackEntry ->
            val routeData = backStackEntry.toRoute<StepTwoRoute>()

            NextStepScreen(
                serviceTitle = routeData.serviceTitle,
                price = routeData.price,
                onBack = { navController.popBackStack() }
            )
        }
    }
}