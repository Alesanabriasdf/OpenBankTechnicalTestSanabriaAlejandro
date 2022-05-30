package com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon

data class Comic(
    val available:Int,
    val collectionURI: String,
    val items: List<ItemComic>,
    val returned: Int
)