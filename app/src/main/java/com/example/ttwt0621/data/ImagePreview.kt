package com.example.ttwt0621.data

data class ImagePreview (
    val id:Int,
    val tags : String,
    val previewURL : String,
    var isChecked : Boolean = false
)