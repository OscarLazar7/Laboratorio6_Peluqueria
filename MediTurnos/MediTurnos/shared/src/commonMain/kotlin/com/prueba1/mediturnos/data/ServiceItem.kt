package com.prueba1.mediturnos.data

import kotlinx.serialization.Serializable

import org.jetbrains.compose.resources.DrawableResource
import mediturnos.shared.generated.resources.Res // Cambia por el paquete autogenerado de tu app
import mediturnos.shared.generated.resources.*


/*Creamos la clase con los atributos que tendra*/
data class ServiceItem(
    val id: String,
    val title: String,
    val description: String,
    val durationMinutes: Int,
    val price: Double,
    val imageResource: DrawableResource // Referencia estática a la imagen
)

// Lista de servicios usando las imágenes estáticas de composeResources
/*Creamos los objetos y lo guardamos en una lista (esta lista
                                            sera usado en la pantalla de servicios)*/
val sampleServices = listOf(
    ServiceItem(
        id = "1",
        title = "Corte & Styling",
        description = "Diseño personalizado, lavado y brushing",
        durationMinutes = 60,
        price = 32000.0,
        imageResource = Res.drawable.imag1
    ),
    ServiceItem(
        id = "2",
        title = "Balayage Signature",
        description = "Color, tonalización y tratamiento protector",
        durationMinutes = 180,
        price = 85000.0,
        imageResource = Res.drawable.imag2
    ),
    ServiceItem(
        id = "3",
        title = "Tratamiento de hidratación",
        description = "Diagnóstico, nutrición profunda y peinado",
        durationMinutes = 75,
        price = 38000.0,
        imageResource = Res.drawable.imag3
    ),
    ServiceItem(
        id = "4",
        title = "Gloss Repair",
        description = "Baño de brillo, reparación de fibra y sellado de p...",
        durationMinutes = 90,
        price = 46000.0,
        imageResource = Res.drawable.imag1
    )
)