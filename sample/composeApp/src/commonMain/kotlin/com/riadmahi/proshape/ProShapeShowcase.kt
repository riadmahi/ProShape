package com.riadmahi.proshape

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import proshape.sample.composeapp.generated.resources.*

@Composable
fun BrSonomaFontFamily() = FontFamily(
    org.jetbrains.compose.resources.Font(Res.font.brsonoma_regular, FontWeight.Normal),
    org.jetbrains.compose.resources.Font(Res.font.brsonoma_medium, FontWeight.Medium),
    org.jetbrains.compose.resources.Font(Res.font.brsonoma_semibold, FontWeight.SemiBold),
    org.jetbrains.compose.resources.Font(Res.font.brsonoma_bold, FontWeight.Bold),
)

@Composable
fun ProShapeShowcase() {
    val fontFamily = BrSonomaFontFamily()

    val sections = listOf(
        ShapeDemo("Rounded", ProShape.rounded(), 24),
        ShapeDemo("Top Rounded", ProShape.topRounded(), 24),
        ShapeDemo("Bottom Rounded", ProShape.bottomRounded(), 24),
        ShapeDemo("Start Rounded", ProShape.startRounded(), 24),
        ShapeDemo("End Rounded", ProShape.endRounded(), 24),
        ShapeDemo("Modifier.proShape()", null, 18, useModifier = true)
    )

    Surface(color = Color(0xFFF9F7F9)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            item {
                ShowcaseTitle("ProShape UI Library Showcase", fontFamily)
            }

            items(sections) { demo ->
                ShapeSection(demo, fontFamily)
            }

            item {
                InputAndButtonSection(fontFamily)
            }
        }
    }
}

data class ShapeDemo(
    val title: String,
    val shape: Shape? = null,
    val radius: Int,
    val useModifier: Boolean = false
)

@Composable
fun ShapeSection(demo: ShapeDemo, fontFamily: FontFamily) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "🔷 ${demo.title}",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = fontFamily,
            color = Color(0xFF333333)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ShapeBox("Rectangle", Modifier.size(140.dp, 70.dp), demo, fontFamily)
            ShapeBox("Square", Modifier.size(70.dp), demo, fontFamily)
        }
    }
}

@Composable
fun ShapeBox(label: String, size: Modifier, demo: ShapeDemo, fontFamily: FontFamily) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = size
                .then(
                    if (demo.useModifier) Modifier.proShape(demo.radius.dp)
                    else Modifier.clip(demo.shape ?: ProShape.rounded(demo.radius.dp))
                )
                .background(Color(0xFF7F75D8)),
            contentAlignment = Alignment.Center
        ) {
            Text("Hello", color = Color.White, fontSize = 14.sp, fontFamily = fontFamily)
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(label, fontSize = 12.sp, color = Color.Gray, fontFamily = fontFamily)
        Text("radius = ${demo.radius}dp", fontSize = 11.sp, color = Color.LightGray, fontFamily = fontFamily)
    }
}

@Composable
fun InputAndButtonSection(fontFamily: FontFamily) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "🧪 Inputs & Buttons",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = fontFamily,
            color = Color(0xFF333333)
        )

        var text by remember { mutableStateOf("") }
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 15.sp, fontFamily = fontFamily),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(ProShape.rounded(16.dp))
                        .background(Color(0xFFEFEAFE))
                        .padding(horizontal = 16.dp, vertical = 24.dp)
                ) {
                    if (text.isEmpty()) {
                        Text("Type something...", color = Color(0xFFAAAAAA), fontFamily = fontFamily)
                    }
                    innerTextField()
                }
            }
        )

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .clip(ProShape.rounded(12.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFF67280),
                contentColor = Color.White
            ),
            elevation = null,
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            Text("Awesome Button", fontSize = 16.sp, fontWeight = FontWeight.Medium, fontFamily = fontFamily)
        }
    }
}

@Composable
fun ShowcaseTitle(text: String, fontFamily: FontFamily) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = fontFamily,
        color = Color(0xFF1C1C1C)
    )
}

@Preview
@Composable
fun PreviewProShapeShowcase() {
    MaterialTheme {
        ProShapeShowcase()
    }
}