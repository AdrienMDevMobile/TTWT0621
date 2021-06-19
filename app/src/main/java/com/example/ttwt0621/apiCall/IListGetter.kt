package com.example.ttwt0621.apiCall

import com.example.ttwt0621.data.ImagePreview
import com.example.ttwt0621.data.PreviewList

interface IListGetter {
    suspend fun getListPreview(text:String) : PreviewList
}