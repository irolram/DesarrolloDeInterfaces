package com.example.layoutcomposeproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutcomposeproyecto.ui.theme.LayoutComposeProyectoTheme
import java.text.NumberFormat
import java.util.Locale
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutComposeProyectoTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Imagen()
                    MiColumn()
                    ProductosDestacados()
                }
            }
        }
    }
}

@Composable
fun Imagen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        val fotoPerfil = painterResource(R.drawable.fotovini)
        Image(
            painter = fotoPerfil,
            contentDescription = "Foto de perfil de Vinishus",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Vinishus",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .background(Color(0x80000000))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        )
    }
}
@Composable
fun MiColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AjusteItem("Notificaciones")
        AjusteItem("Tema Oscuro")
        AjusteItem("Idioma")
        AjusteItem("Ajustes")
    }
}

@Composable
fun AjusteItem(titulo: String) {
    Box(
        modifier = Modifier
            .background(Color.LightGray, RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Text(
            text = titulo,
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
@Composable
fun ProductosDestacados() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.Magenta)
    ) {
        Text(
            text = "Productos destacados",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ProductoItemPequenio(
                nombre = "Pedri",
                precio = 140_000_000.0,
                imagenRes = R.drawable.pedri,
                modifier = Modifier.weight(1f)
            )
            ProductoItemPequenio(
                nombre = "Santi Cazorla",
                precio = 200_000.0,
                imagenRes = R.drawable.cazorla,
                modifier = Modifier.weight(1f)
            )
            ProductoItemPequenio(
                nombre = "Lusi Milla",
                precio = 4_000_000.0,
                imagenRes = R.drawable.milla,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ProductoItemPequenio(nombre: String, precio: Double, imagenRes: Int,
                                 modifier: Modifier = Modifier) {

    val formatoEuro = NumberFormat.getCurrencyInstance(Locale("es", "ES"))
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(imagenRes),
                contentDescription = "Imagen de $nombre",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = nombre,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = formatoEuro.format(precio),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
            )
        }
    }
}
@Composable
fun ProductosDestacadosPreview() {
    MaterialTheme {
        ProductosDestacados()
    }
}


@Composable
fun PantallaInicio() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Bienvenido a FutbolShop",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )


        Text(
            text = "Encuentra tus jugadores favoritos y más",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )


        Spacer(modifier = Modifier.weight(1f))


        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continuar")
        }
    }
}

@Composable
fun CajasAlineadasArriba() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top){

                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.Red)
                )
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.Green)
                )
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.Cyan)
                )
            }
        }
    }
}

@Composable
fun CajasCentradasHorizontal() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Cyan)
        )
    }
}

@Composable
fun CajasEnEsquinas() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF))
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
                .align(Alignment.TopStart)
        )

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Green)
                .align(Alignment.TopEnd)
        )

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Blue)
                .align(Alignment.BottomStart)
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Cyan)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun RelacionCajas() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxC, boxR, boxB, boxG) = createRefs()

        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxR) {
                    centerTo(parent)
                })
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(boxB) {
                    top.linkTo(boxR.bottom, margin = 16.dp)
                    centerHorizontallyTo(boxR)
                })
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxG) {
                    start.linkTo(boxR.end, margin = 16.dp)
                    centerVerticallyTo(boxR)
                })
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Cyan)
                .constrainAs(boxC) {
                    bottom.linkTo(boxR.top, margin = 16.dp)
                    centerHorizontallyTo(boxR)
                })
    }
}

@Composable
fun AlineacionMultiple() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (left, center, right, off) = createRefs()

        Box(
            Modifier
                .constrainAs(center) {
                    centerVerticallyTo(parent)
                    centerHorizontallyTo(parent)
                    width = Dimension.percent(0.30f)
                    height = Dimension.value(100.dp)
                }
                .background(Color.Red))
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Green)
                .constrainAs(left) {
                    centerVerticallyTo(center)
                    end.linkTo(center.start, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                })
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Blue)
                .constrainAs(right) {
                    centerVerticallyTo(center)
                    start.linkTo(center.end, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                })
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Cyan)
                .constrainAs(off) {
                    centerVerticallyTo(center)
                    start.linkTo(left.end, 16.dp)
                    end.linkTo(center.start, 32.dp)
                })
    }
}

@Composable
fun CajasAlineadasDis() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)

    ) {
        val (cajaIzq, cajaCentro, cajaDer, cajaFuera) = createRefs()
        Box(
            modifier = Modifier
                .background(Color.Red)
                .constrainAs(cajaCentro) {
                    width = Dimension.percent(0.3f)
                    height = Dimension.value(100.dp)
                    centerTo(parent)
                }
        )
        Box(
            modifier = Modifier
                .background(Color.Green)
                .constrainAs(cajaIzq) {
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                    centerVerticallyTo(cajaCentro)
                    end.linkTo(cajaCentro.start, 32.dp)
                    start.linkTo(parent.start, 16.dp)
                }
        )
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .constrainAs(cajaDer) {
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                    centerVerticallyTo(cajaCentro)
                    start.linkTo(cajaCentro.end, 16.dp)
                    end.linkTo(parent.end, 40.dp)
                }
        )
        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .constrainAs(cajaFuera) {
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                    centerVerticallyTo(cajaCentro)
                    start.linkTo(parent.start, 100.dp)
                    horizontalBias = 0.2f
                }
        )
    }
}

@Composable
fun FiguraCruz() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (c, up, down, left, right) = createRefs()

        Box(
            Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(c) { centerTo(parent) }
        )
        Box(
            Modifier
                .size(80.dp)
                .background(Color.Green)
                .constrainAs(up) {
                    bottom.linkTo(c.top, 16.dp)
                    centerHorizontallyTo(c)
                }
        )
        Box(
            Modifier
                .size(80.dp)
                .background(Color.Blue)
                .constrainAs(down) {
                    top.linkTo(c.bottom, 16.dp)
                    centerHorizontallyTo(c)
                }
        )
        Box(
            Modifier
                .size(80.dp)
                .background(Color.Cyan)
                .constrainAs(left) {
                    end.linkTo(c.start, 16.dp)
                    centerVerticallyTo(c)
                }
        )
        Box(
            Modifier
                .size(80.dp)
                .background(Color.Yellow)
                .constrainAs(right) {
                    start.linkTo(c.end, 16.dp)
                    centerVerticallyTo(c)
                }
        )
    }
}

@Composable
fun TarjetaPresentacion(
    onContactoClick: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        val (foto, nombre, bio, boton) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.milla),
            contentDescription = "Foto de perfil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(60.dp))
                .constrainAs(foto) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                }
        )
        Text(
            text = "Luis Milla",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.constrainAs(nombre) {
                top.linkTo(foto.top)
                start.linkTo(foto.end, 16.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            }
        )
        Text(
            text = "Mediocentro creativo. Amante del control del juego y el fútbol champage del Getafe."
                    ,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF4A4A4A),
            modifier = Modifier
                .constrainAs(bio) {
                    top.linkTo(nombre.bottom, 100.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.percent(0.80f)
                }
        )
        Button(
            onClick = onContactoClick,
            modifier = Modifier
                .constrainAs(boton) {
                    bottom.linkTo(parent.bottom, 24.dp)
                    end.linkTo(parent.end, 24.dp)
                }
        ) {
            Text("Contactar")
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun TarjetaPresentacionPreview() {
    MaterialTheme {
        TarjetaPresentacion()
    }
}







