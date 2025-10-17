package com.example.layoutsjetpackcompose

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutsjetpackcompose.ui.theme.LayoutsJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutsJetpackComposeTheme {
                Imagen(
                )
            }
        }
    }
}
@Composable
fun Imagen() {
    Box(modifier = Modifier){

        val fotoPerfil = painterResource(R.drawable.fotovini)
        Image(
            painter = fotoPerfil,
            contentDescription = null
        )

        Text(
            text = "Vinishus",
            color = Color.Cyan

            )
    }

}
@Composable
fun MyColumn() {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(50.dp)

    ) {
        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(100.dp)) {
            Text(
                text = "Nofitifaciones", Modifier.background(Color.LightGray)
                    .align(Alignment.Center)
            )
        }
        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(100.dp)) {
            Text(
                text = "Tema Oscuro", Modifier.background(Color.LightGray)
                    .align(Alignment.Center)
            )
        }
        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(100.dp)) {
            Text(
                text = "Idioma", Modifier.background(Color.LightGray)
                    .align(Alignment.Center)
            )
        }
        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(100.dp)) {
            Text(
                text = "Ajustes", Modifier.background(Color.LightGray)
                    .align(Alignment.Center)
            )
        }

    }
}
@Preview
@Composable
fun RowEjemplo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        tarjetasProducto("Lusi Milla","4M", R.drawable.milla)
        tarjetasProducto("Pedri", "140M", R.drawable.pedri)
        tarjetasProducto("Santi Cazorla","200Mil", R.drawable.cazorla)
    }
}

@Composable
fun tarjetasProducto(nombreProducto: String, precioProducto: String, imagen: Int){
    Card(modifier = Modifier.height(50.dp)
        .width(50.dp)
        ,elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(){
            Image(painter = painterResource(imagen),
                contentDescription = "Producto",
                modifier = Modifier.size(100.dp))
            Text(nombreProducto)
            Text("€${String.format("%.2f", precioProducto)}")
        }
    }
}
