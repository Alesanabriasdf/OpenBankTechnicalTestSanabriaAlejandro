package com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon

data class Result(
    val id:String,
    val name: String,
    val description:String,
    val modified:String,
    val thumbnail: Thumbnail,
    val resourceUri:String,
    val comics: Comic,
    val series: Serie,
    val stories: Storie,
    val events: Event,
    val urls: List<Urls>
)