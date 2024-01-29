package com.pranalaragamkarya.app.features.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val result = mutableStateOf(arrayListOf<Int>())

    fun generatePrime(end:Int){
        for (i in 1..end){
            if(isPrime(i)){
                result.value.add(i)
            }
        }
    }

    fun isPrime(value:Int):Boolean{
        for(i in 2..value){
            if(value % i == 0) {
                return false
            }
        }
        return true
    }
}