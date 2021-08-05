package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models

data class Commit(
    val version: String,
    val deletions: String,
    val additions: String
)
