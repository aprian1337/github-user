package com.aprian1337.github_user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aprian1337.github_user.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var binding: ActivityMainBinding
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        var tvCompany: TextView = itemView.findViewById(R.id.tv_company)
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        holder.tvCompany.text = user.company
        holder.tvName.text = user.name
        holder.tvUsername.text = user.username
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgAvatar)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

}