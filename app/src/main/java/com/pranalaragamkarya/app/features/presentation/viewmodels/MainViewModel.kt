package com.pranalaragamkarya.app.features.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _result = MutableStateFlow(arrayListOf<Int>())
    val result:StateFlow<ArrayList<Int>> = _result
     fun generatePrime(end:Int){
         val temp = arrayListOf<Int>()
        viewModelScope.launch(Dispatchers.IO) {
            for(i in 2 until end){
                var counter = 0
                for(x in 1..i){
                    if(i%x==0){
                        counter++
                    }
                }
                if(counter==2) {
                   async {
                      // _result.value.add(i)
                       temp.add(i)
                   }
                }
            }
            _result.value = temp
        }


    }

}