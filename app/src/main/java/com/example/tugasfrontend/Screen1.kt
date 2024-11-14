import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen1()
        }
    }
}

@Composable
fun Screen1() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen() }
            composable("menu") { MenuScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Nonton Film", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listOf("Romance","Action", "Horror", "Sport", "War",
                "Comedy", "Superhero", "Drama", "Thiller", "Musical").forEach {
                Text(it, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val items = listOf(
            "Romance" to "Emily in Paris",
            "Horror" to "Exhuma",
            "Sport" to "Gran Turismo",
            "War" to "Civil War",
            "Comedy" to "The Fall Guy",
            "Superhero" to "The Marvels",
            "Action" to "Top Gun : Maverick",
            "Thiller" to "Extraction 2",
            "Drama" to "Ride On",
            "Musical" to "Aladdin",


        )

        items.forEach { (category, title) ->
            CategoryItem(category, title)
        }
    }
}



@Composable
fun CategoryItem(category: String, title: String) {
    Column {
        Text(category, color = Color.Gray, fontSize = 12.sp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .height(48.dp)
                .background(Color(0xFF9B0505), shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Beranda", "home"),
        BottomNavItem("Menu", "menu"),
        BottomNavItem("Profil", "profile")
    )

    NavigationBar(
        containerColor = Color(0xFFE0E0E0)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Text(
                        text = item.label,
                        color = if (currentRoute == item.route) Color.Red else Color.Gray
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

data class BottomNavItem(val label: String, val route: String)

@Composable
fun MenuScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Daftar Film")
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Profile Screen")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen1preview(){
    TugasFrontEndTheme {
       Screen1()
    }
}

