package com.example.tugasfrontend

import BottomNavigationBar
import HomeScreen
import MenuScreen
import ProfileScreen
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Daftar Film") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back action */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val menuItems = listOf(
                "Emily in Paris", "Exhuma", "Gran Turismo", "Civil War",
                "The Fall Guy", "The Marvels", "Top Gun: Maverick", "Extraction 2", "Ride On",
                "Aladdin"
            )

            MenuGrid(menuItems)
        }
    }
}

@Composable
fun MenuGrid(menuItems: List<String>) {
    Column {
        for (i in menuItems.indices step 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MenuItemCard(menuItems[i])
                if (i + 1 < menuItems.size) {
                    MenuItemCard(menuItems[i + 1])
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MenuItemCard(title: String) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(80.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF9B0505)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen2preview(){
    TugasFrontEndTheme {
        Screen2()
    }
}

