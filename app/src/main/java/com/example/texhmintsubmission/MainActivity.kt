package com.example.texhmintsubmission


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.texhmintsubmission.databinding.ActivityMainBinding


import com.example.texhmintsubmission.RetrofitClient
import com.example.texhmintsubmission.GitHubRepository
import com.example.texhmintsubmission.RepoAdapter
import com.example.texhmintsubmission.MainViewModel
import com.example.texhmintsubmission.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(GitHubRepository(RetrofitClient.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.repoRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.repos.observe(this) { repos ->
            val adapter = RepoAdapter(repos)
            binding.repoRecyclerView.adapter = adapter
        }

        binding.searchButton.setOnClickListener {
            val query = binding.searchInput.text.toString()
            if (query.isNotEmpty()) {
                viewModel.searchRepositories(query)
            }
        }
    }
}
