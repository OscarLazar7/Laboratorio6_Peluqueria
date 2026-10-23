package com.prueba1.mediturnos.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prueba1.mediturnos.CreamBackground

@Composable
fun NextStepScreen(
    serviceTitle: String,
    price: Double,
    onBack: () -> Unit
) {
    Scaffold(containerColor = CreamBackground) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Paso 2: Selección de fecha y profesional", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Servicio seleccionado: $serviceTitle")
            Text("Precio: $$price")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onBack) {
                Text("Volver")
            }
        }
    }
}