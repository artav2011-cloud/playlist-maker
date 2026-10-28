package com.example.playlist_maker_android_voroninartem

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current // Получаем контекст для Intent и Toast
    val backgroundColor = Color(0xFF3772E7)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Playlist maker",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(8.dp)
        ) {
            // Переход на экран поиска
            MenuButton(text = "Поиск", icon = "🔍") {
                context.startActivity(Intent(context, SearchActivity::class.java))
            }
            // Toast для Плейлистов (пока нет экрана)
            MenuButton(text = "Плейлисты", icon = "📁") {
                Toast.makeText(context, "Нажата кнопка \"Плейлисты\"", Toast.LENGTH_SHORT).show()
            }
            // Toast для Избранного (пока нет экрана)
            MenuButton(text = "Избранное", icon = "❤️") {
                Toast.makeText(context, "Нажата кнопка \"Избранное\"", Toast.LENGTH_SHORT).show()
            }
            // Переход на экран настроек
            MenuButton(text = "Настройки", icon = "⚙️") {
                context.startActivity(Intent(context, SettingsActivity::class.java))
            }
        }
    }
}

@Composable
fun MenuButton(text: String, icon: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = icon, fontSize = 20.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = text, fontSize = 18.sp, color = Color.Black)
        }
        Text(text = ">", fontSize = 20.sp, color = Color.Gray)
    }
}