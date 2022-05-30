package com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon

data class Serie (
    val available: Int,
    val collectionURI:String,
    val items: List<ItemSerie>,
    val returned:Int
)