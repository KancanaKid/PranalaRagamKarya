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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
        mutableStateOf("")
    }

    var currentInput = 0
    val result by viewModel.result.collectAsState()

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
                OutlinedTextField(value = textState.value,
                    onValueChange = { textState.value = it},
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    ),
                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp))
                Button(onClick = {
                    currentInput = textState.value.toInt()
                    viewModel.generatePrime(currentInput)
                },
                    enabled = textState.value.isNotEmpty(),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()) {
                    Text("GENERATE BILANGAN PRIMA")
                }
                listOfResult(result = result)

            }
        }    
    )
}

@Composable
fun listOfResult(result:ArrayList<Int>){
    result.forEach {
        Text(text = "${it}", fontWeight = FontWeight.Normal,
            fontSize = TextUnit(12f, type = TextUnitType.Sp)
        )
    }
}

@Preview
@Composable
fun PreviewHome(){
    PranalaRagamKaryaTheme {
        HomeScreen(navController = rememberNavController())
    }
}