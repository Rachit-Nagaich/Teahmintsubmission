package com.example.texhmintsubmission


import com.example.texhmintsubmission.GitHubApiService
import com.example.texhmintsubmission.Repository

class GitHubRepository(private val apiService: GitHubApiService) {
    suspend fun searchRepositories(query: String, perPage: Int, page: Int): List<Repository> {
        return apiService.searchRepositories(query, perPage, page).items
    }
}