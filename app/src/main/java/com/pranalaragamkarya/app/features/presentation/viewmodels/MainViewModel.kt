package com.pranalaragamkarya.app.features.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val result = mutableStateOf(arrayListOf<Int>())

    fun generatePrime(end:Int){

        for(i in 2 until end){
            var counter = 0
            for(x in 1..i){
                if(i%x==0){
                    counter++
                }
            }
            if(counter==2) {
                result.value.add(i)
            }
        }

    }

}