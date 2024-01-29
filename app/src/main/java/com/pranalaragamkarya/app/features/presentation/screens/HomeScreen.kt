package com.pranalaragamkarya.app.features.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pranalaragamkarya.app.features.presentation.utils.ScreenRoute
import com.pranalaragamkarya.app.features.presentation.viewmodels.MainViewModel
import com.pranalaragamkarya.app.ui.theme.PranalaRagamKaryaTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()){
    val textState = remember {
        mutableStateOf(TextFieldValue())
    }
    val result = viewModel.result.value
    Scaffold (
        content = {  paddingValues ->  
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                
                Text(text = "Bilangan Prima", fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(16f, type = TextUnitType.Sp)
                )
                Text(text = "Masukan bilangan untuk menghasilan bilangan prima", fontWeight = FontWeight.Normal,
                    fontSize = TextUnit(12f, type = TextUnitType.Sp)
                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))
                TextField(value = textState.value, onValueChange = {
                    textState.value = it
                    viewModel.result.value.clear()
                                                                   }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp))
                Button(onClick = {
                    viewModel.generatePrime(textState.value.text.toInt())
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()) {
                    Text("GENERATE BILANGAN PRIMA")
                }
                Text(text = "${result}", fontWeight = FontWeight.Normal,
                    fontSize = TextUnit(12f, type = TextUnitType.Sp)
                )
            }
        }    
    )
}

@Preview
@Composable
fun PreviewHome(){
    PranalaRagamKaryaTheme {
        HomeScreen(navController = rememberNavController())
    }
}