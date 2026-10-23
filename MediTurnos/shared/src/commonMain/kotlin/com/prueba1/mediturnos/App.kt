
package com.prueba1.mediturnos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.prueba1.mediturnos.navigation.AppNavigation
import mediturnos.shared.generated.resources.Res


@Composable
@Preview
fun App() {
    MaterialTheme {
        AppNavigation()
    }
}

/*

@Composable
@Preview
fun App() {
    var nombre by remember { mutableStateOf("") }
    var mostrarSaludo by remember { mutableStateOf(false) }


    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!mostrarSaludo) {
                Text("Bienvenido a MediTurnos")

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Ingresá tu nombre") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { mostrarSaludo = true },
                    enabled = nombre.isNotBlank()
                ) {
                    Text("Continuar")
                }

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { mostrarSaludo = true },
                    colors = buttonColors(
                        containerColor = PinkPastel,
                        contentColor = Color.Black,
                    )
                ) {
                    Text(
                        text = "Iniciar Seccion",
                        fontWeight = FontWeight.Bold)
                }


            } else {
                Text("¡Hola, $nombre!")

                Spacer(modifier = Modifier.height(16.dp))

                Text("Bienvenido a MediTurnos.")

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { mostrarSaludo = false }) {
                    Text("Volver")
                }
            }
        }
    }
}
*/