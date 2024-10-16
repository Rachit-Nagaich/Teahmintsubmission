package com.example.texhmintsubmission

data class RepoSearchResponse(
    val items: List<Repository>
)

data class Repository(
    val name: String,
    val owner: Owner,
    val description: String,
    val html_url: String,
    val contributors_url: String
)

data class Owner(
    val avatar_url: String,
    val login: String
)