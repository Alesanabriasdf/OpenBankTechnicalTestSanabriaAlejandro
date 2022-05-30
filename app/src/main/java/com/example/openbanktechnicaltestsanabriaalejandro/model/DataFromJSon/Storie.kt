package com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon

data class Storie(
    val available:Int,
    val collectionURI:String,
    val items: List<ItemStorie>,
    val returned:Int
)