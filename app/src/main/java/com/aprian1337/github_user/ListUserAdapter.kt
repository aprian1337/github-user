package com.aprian1337.github_user

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aprian1337.github_user.databinding.ItemRowUserBinding
import com.bumptech.glide.Glide

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    inner class ListViewHolder(val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemRowUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        holder.binding.tvCompany.text = user.company
        holder.binding.tvName.text = user.name
        holder.binding.tvUsername.text = user.username
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .into(holder.binding.imgAvatar)
        holder.itemView.setOnClickListener{
            val userParcelable = User(
                user.name,
                user.username,
                user.location,
                user.repository,
                user.company,
                user.followers,
                user.following,
                user.avatar
                )
            val moveWithObjectIntent = Intent(holder.itemView.context, DetailUserActivity::class.java)
            moveWithObjectIntent.putExtra(DetailUserActivity.EXTRA_USER, userParcelable)
            holder.itemView.context.startActivity(moveWithObjectIntent)
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

}