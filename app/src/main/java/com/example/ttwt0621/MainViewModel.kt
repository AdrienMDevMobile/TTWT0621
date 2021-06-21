package com.example.ttwt0621

import androidx.lifecycle.ViewModel
import com.example.ttwt0621.apiCall.IListGetter
import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.*
import com.example.ttwt0621.data.ImagePreview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel(){

    private val listPreview = MutableLiveData<ArrayList<ImagePreview>>()

    fun getListPreview(): LiveData<ArrayList<ImagePreview>> {
        return listPreview
    }

    fun startSearch(searchText : String, listGetter : IListGetter){

        viewModelScope.launch(Dispatchers.IO){
            val listImagePreview = listGetter.getListPreview(searchText)

            listPreview.postValue(listImagePreview.hits)
        }
    }

    fun getCheckedURLList() : ArrayList<String>{
        val toSend = ArrayList<String>()
        for(a in getListPreview().value!!){

            if(a.isChecked)
                toSend.add(a.largeImageURL)
        }
        return toSend
    }




}