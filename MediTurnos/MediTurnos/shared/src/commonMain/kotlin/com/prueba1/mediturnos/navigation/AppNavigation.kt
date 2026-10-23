package com.prueba1.mediturnos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.prueba1.mediturnos.screens.NextStepScreen
import com.prueba1.mediturnos.screens.ServicesScreen
import kotlinx.serialization.Serializable

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