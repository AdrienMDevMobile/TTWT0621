package com.example.ttwt0621

import androidx.lifecycle.ViewModel
import com.example.ttwt0621.apiCall.IListGetter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.*
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(private val listGetter : IListGetter) : ViewModel(){

    private var coroutineScope = this.viewModelScope

    public fun launch(){
        //Pour aller plus vide. Global scope
        //TODO a remplacer
        //https://medium.com/l-r-engineering/launching-kotlin-coroutines-in-android-coroutine-scope-context-800d280ebd80
        coroutineScope.launch(Dispatchers.IO){
            val toTest = listGetter.getListPreview()
        }
    }
}