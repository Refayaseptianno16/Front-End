package com.example.tugasfrontend

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontend.R
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

@Composable
fun Screen3() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProfileHeader()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Riwayat Tontonan",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        MenuItem("Exhuma", "9JTx ditonton ", "Disukai oleh 8JT Orang")
        MenuItem("Top Gun: Maverick", "7JTx ditonton", "Disukai oleh 6JT Orang")
        MenuItem("Aladdin", "13JTx ditonton", "Disukai oleh 10JT orang")
        MenuItem("Gran Turismo", "5JTx ditonton", "Disukai oleh 4JT Orang")
        MenuItem("The Marvels", "8JTx ditonton", "Disukai oleh 7JT Orang ")
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Replace with your profile image
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24), // replace with actual profile image resource
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text("Refaya Septianno", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("refayaseptiano@gmail.com")
            Text("Universitas Krisnadwipayana")
            Text("Teknik Informatika")
        }
    }
}

@Composable
fun MenuItem(title: String, sales: String, likedBy: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Replace with actual food image resource
            Image(
                painter = painterResource(id = android.R.drawable.checkbox_on_background),
                contentDescription = title,
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(sales, color = Color.Gray, fontSize = 14.sp)
                Text(likedBy, color = Color.Gray, fontSize = 14.sp)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen3preview(){
    TugasFrontEndTheme {
        Screen3()
    }
}