package com.sultan.cleanrickandmorty.domain.model

data class Character(
    val results: List<Result>
) {
    data class Result(
        val image: String,
        val name: String,
    )
}