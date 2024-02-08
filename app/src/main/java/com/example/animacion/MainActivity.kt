package com.example.animacion

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animacion.ui.theme.AnimacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimacionTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var text by remember { mutableStateOf("Hello, World!") }


    // Definimos un estado para controlar la animación de color
    var colorAnimationState by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (colorAnimationState) androidx.compose.ui.graphics.Color.Red else androidx.compose.ui.graphics.Color.Green
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Cuadro de texto
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                // Cambiamos el estado de la animación al escribir en el cuadro de texto
                colorAnimationState = !colorAnimationState
            },
            label = { Text("Type something") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = color)  // Usa color = para especificar el color de fondo
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de envío
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            // Icono en el botón
            Icon(imageVector = Icons.Default.Send, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Send")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    AnimacionTheme {
        Greeting()
    }
}
