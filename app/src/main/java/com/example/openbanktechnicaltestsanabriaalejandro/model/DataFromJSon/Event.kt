package com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon

data class Event(
    val available: String,
    val collectionURI: String,
    val items: List<ItemEvent>,
    val returned: String,
)