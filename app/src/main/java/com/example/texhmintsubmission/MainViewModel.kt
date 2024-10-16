package com.example.texhmintsubmission



import androidx.lifecycle.*
import com.example.texhmintsubmission.Repository
import com.example.texhmintsubmission.GitHubRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: GitHubRepository) : ViewModel() {
    private val _repos = MutableLiveData<List<Repository>>()
    val repos: LiveData<List<Repository>> = _repos

    fun searchRepositories(query: String) {
        viewModelScope.launch {
            val result = repository.searchRepositories(query, 10, 1) // 10 per page
            _repos.postValue(result)
        }
    }
}

class MainViewModelFactory(private val repository: GitHubRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
