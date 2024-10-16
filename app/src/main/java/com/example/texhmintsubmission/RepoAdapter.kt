package com.example.texhmintsubmission



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.texhmintsubmission.databinding.ItemRepoBinding
import com.example.texhmintsubmission.Repository

class RepoAdapter(private val repoList: List<Repository>) :
    RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    class RepoViewHolder(val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repoList[position]
        holder.binding.repoName.text = repo.name
        holder.binding.repoDescription.text = repo.description
        Glide.with(holder.itemView.context).load(repo.owner.avatar_url).into(holder.binding.ownerAvatar)
    }

    override fun getItemCount() = repoList.size
}
