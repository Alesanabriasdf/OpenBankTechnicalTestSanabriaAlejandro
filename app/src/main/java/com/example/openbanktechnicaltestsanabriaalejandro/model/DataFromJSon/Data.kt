package com.example.openbanktechnicaltestsanabriaalejandro.model.DataFromJSon

data class Data (
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Result>
)