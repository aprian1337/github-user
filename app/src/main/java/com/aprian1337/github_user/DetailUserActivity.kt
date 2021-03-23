package com.aprian1337.github_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aprian1337.github_user.databinding.ActivityDetailUserBinding
import com.bumptech.glide.Glide

class DetailUserActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var binding : ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.tvName.text = user.name
        binding.tvUsername.text = user.username
        binding.tvCompany.text = user.company
        binding.tvLocation.text = user.location
        binding.tvRepository.text = user.repository.toString()
        binding.tvFollowers.text = user.followers.toString()
        binding.tvFollowing.text = user.following.toString()
        Glide.with(applicationContext)
            .load(user.avatar)
            .into(binding.imgPhoto)
    }
}