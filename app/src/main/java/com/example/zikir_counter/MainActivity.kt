// Package utama aplikasi
package com.example.zikir_counter

// Import Android dan Jetpack Compose tools yang dibutuhkan
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.zikir_counter.ui.theme.ZikircounterTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape

// Activity utama aplikasi
class MainActivity : ComponentActivity() {
    // Fungsi yang dijalankan pertama kali saat activity dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Mengaktifkan tampilan penuh tanpa batas ke tepi layar

        setContent {
            // Mengatur tema aplikasi agar sesuai dengan desain yang ditentukan
            ZikircounterTheme {
                // Menampilkan layar utama ZikirCounterScreen
                ZikirCounterScreen()
            }
        }
    }
}

// Fungsi composable untuk menampilkan teks sapaan
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", // Menampilkan teks hello
        modifier = modifier // Modifier digunakan untuk styling atau layout
    )
}

// Fungsi untuk preview tampilan Greeting di Android Studio Preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ZikircounterTheme {
        Greeting("Zikir Counter") // Preview dengan teks "Zikir Counter"
    }
}

// Fungsi composable utama untuk tampilan penghitung zikir
@Composable
fun ZikirCounterScreen() {
    var count by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()

    Scaffold(
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF1F8E9)) // latar belakang hijau muda
                    .verticalScroll(scrollState)
                    .padding(padding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(74.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "اللهم صل على سيدنا محمد",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF8f1b13),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 34.dp) // 👈 menambahkan jarak dari atas layar
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Hitungan: $count",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    Button(
                        onClick = { count++ },
                        colors = ButtonDefaults.buttonColors(Color(0xFF8f1b13)),
                        modifier = Modifier
                            .size(280.dp)

                    ) {
                        Text("DZIKIR", fontSize = 40.sp, color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {  count = 0 },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Red
                        ),
                        border = BorderStroke(2.dp, Color.Red),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .width(100.dp) // 👈 Lebar tombol lebih kecil
                            .height(40.dp) // 👈 Tinggi tombol lebih kecil
                    ) {
                        Text(
                            text = "Ulangi",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }
        }
    )
}