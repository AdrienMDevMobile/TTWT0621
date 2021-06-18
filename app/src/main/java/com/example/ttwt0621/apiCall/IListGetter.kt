package com.example.ttwt0621.apiCall

import com.example.ttwt0621.data.ImagePreview

interface IListGetter {
    suspend fun getListPreview() : ArrayList<ImagePreview>
}