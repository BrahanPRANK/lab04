package com.example.laboratorio3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFDDEEE0) // Fondo verde claro como en el ejemplo
            ) {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDDEEE0)) // mismo color de fondo
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagen central (el logo de Android)
        Image(
            painter = painterResource(id = R.drawable.android_logo), // reemplaza con tu logo
            contentDescription = "Android Logo",
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFF073042), shape = CircleShape) // fondo oscuro circular
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Nombre
        Text(
            text = "Brahan Mauricio Quispe",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // Título
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF2E7D32)
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Información de contacto
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            ContactRow(icon = Icons.Default.Phone, text = "+11 (123) 444 555 666")
            ContactRow(icon = Icons.Default.Share, text = "@AndroidDev")
            ContactRow(icon = Icons.Default.Email, text = "Bra.doe@android.com")
        }
    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {
        androidx.compose.material3.Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF2E7D32),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 14.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    BusinessCard()
}
