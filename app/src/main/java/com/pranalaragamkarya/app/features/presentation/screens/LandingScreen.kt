package com.pranalaragamkarya.app.features.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pranalaragamkarya.app.R
import com.pranalaragamkarya.app.features.presentation.utils.ScreenRoute
import com.pranalaragamkarya.app.ui.theme.PranalaRagamKaryaTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LandingScreen(navController: NavController){
    Scaffold(
        content = {  paddingValues ->
            Column( modifier = Modifier
                .fillMaxSize()
                .padding(32.dp), verticalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp))
                Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))
                Text("Let's meet our summer\n coffee drinks", modifier = Modifier.fillMaxWidth(), style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(24f, type = TextUnitType.Sp)
                ),)
                Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))
                Text("Lorem Ipsum dolor Lorem Ipsum dolor Lorem Ipsum dolor Lorem Ipsum dolor")
                Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))
                Button(onClick = { navController.navigate(ScreenRoute.Home.route) },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)) {
                    Text("GET STARTED", )
                }
            }
        }
    )
}

@Preview
@Composable
fun Preview(){
    PranalaRagamKaryaTheme {
        LandingScreen(navController = rememberNavController())
    }
}