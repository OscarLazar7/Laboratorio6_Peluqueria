package com.prueba1.mediturnos.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba1.mediturnos.data.ServiceItem
import com.prueba1.mediturnos.data.sampleServices
import com.prueba1.mediturnos.*
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesScreen(
    onServiceSelected: (ServiceItem) -> Unit
) {
    var selectedServiceId by remember { mutableStateOf<String?>("1") } // Por defecto se selecciona el primer servicio

    Scaffold( //es un layout/div
        containerColor = CreamBackground,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = CreamBackground),
                title = { //HEADER con el logo y el Nombre de MUSA
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface( //logo de la ( M )
                            shape = CircleShape,
                            color = Color.White,
                            modifier = Modifier.size(36.dp).border(1.dp, TextDark, CircleShape)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("M", fontWeight = FontWeight.Bold, color = TextDark)
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text("M U S A", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TextDark)
                            Text("HAIR STUDIO", fontSize = 9.sp, color = TextSubtitle)
                        }
                    }
                },
                actions = { //BOTON DE NOTIFICACIONES con el LOGO
                    IconButton(onClick = {}) {
                        Icon(Icons.Outlined.Notifications, contentDescription = "Notificaciones", tint = TextDark)
                    }
                }
            )
        },
        bottomBar = { //Barra de navegacion inferior
            NavigationBar(containerColor = CardBackground) {
                NavigationBarItem(
                    selected = false, //no esta activo
                    onClick = { },
                    icon = { Icon(Icons.Outlined.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio", fontSize = 10.sp) }
                )
                NavigationBarItem(
                    selected = true, //esta activo (cambia el diseño)
                    onClick = { },
                    icon = { Icon(Icons.Default.ContentCut, contentDescription = "Reservar") },
                    label = { Text("Reservar", fontSize = 10.sp) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = TerracottaPrimary,
                        selectedTextColor = TerracottaPrimary
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Outlined.DateRange, contentDescription = "Turnos") },
                    label = { Text("Turnos", fontSize = 10.sp) }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Outlined.Notifications, contentDescription = "Notificaciones") },
                    label = { Text("Notificaciones", fontSize = 10.sp) }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Outlined.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil", fontSize = 10.sp) }
                )
            }
        }
    ) { paddingValues ->
            //CONTEDOR PRINCIPAL DESDE RESERVAR TURNO HASTA EL FINAL DEL LISTADO DE SERVICIOS
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {  //Boton volver
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver",
                        tint = TextSubtitle,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "RESERVAR TURNO",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TerracottaPrimary,
                        letterSpacing = 1.sp
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Elegí tu servicio",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
                Text(
                    text = "Servicios diseñados para cuidar y realzar tu pelo.",
                    fontSize = 14.sp,
                    color = TextSubtitle
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Indicador de Pasos (1 -> 2 -> 3 -> 4)
                StepsIndicator(currentStep = 1)

                Spacer(modifier = Modifier.height(16.dp))
            }

            // =====================Lista de servicios=======================
            /*agreamos la lista de los servicios del archivo ServiceItem*/
            items(sampleServices) { service ->
                ServiceCard(
                    service = service,
                    isSelected = service.id == selectedServiceId,
                    onClick = { selectedServiceId = service.id }
                )
            }

            // Botón de Continuar
            item {
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        val selectedService = sampleServices.find { it.id == selectedServiceId }
                        selectedService?.let { onServiceSelected(it) }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = TerracottaPrimary),
                    shape = RoundedCornerShape(12.dp),
                    enabled = selectedServiceId != null
                ) {
                    Text("Continuar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}


/*Diseño de los componentes*/
@Composable
fun ServiceCard(
    service: ServiceItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card( /*tarjetas de los servicios*/
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() } //permitirle clickearlo
            .then(
                if (isSelected) Modifier.border(1.5.dp, TerracottaPrimary, RoundedCornerShape(16.dp))
                else Modifier
            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image( //imagen del servicio
                painter = painterResource(service.imageResource),
                contentDescription = service.title,
                contentScale = ContentScale.Crop, // Recorta la imagen para llenar el contenedor sin deformarse
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(16.dp)) //un espaciado

            Column(modifier = Modifier.weight(1f)) { //columna de datos generales del servicio
                Text(
                    text = service.id,  //id
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = PinkPastel
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = service.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = TextDark
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = service.description,
                    fontSize = 12.sp,
                    color = TextSubtitle,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Schedule, //icono del reloj
                        contentDescription = "Duración",
                        tint = TextSubtitle,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${service.durationMinutes} min", //duracion estimada del servicio
                        fontSize = 12.sp,
                        color = TextSubtitle
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$${service.price.toInt()}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = TextDark
                )
            }
        }
    }
}

@Composable
fun StepsIndicator(currentStep: Int) { //progreso de pasos. (paso 1: elegir servicio...)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 1..4) {
            val isActive = step <= currentStep
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(if (isActive) TerracottaPrimary else StepInactive),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$step",
                    color = if (isActive) Color.White else TextSubtitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
            if (step < 4) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp)
                        .background(if (step < currentStep) TerracottaPrimary else StepInactive)
                )
            }
        }
    }
}