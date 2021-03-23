package com.aprian1337.github_user

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aprian1337.github_user.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var list: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvUser.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    fun getListHeroes(): ArrayList<User> {
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getIntArray(R.array.repository)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataFollowers = resources.getIntArray(R.array.followers)
        val dataFollowing = resources.getIntArray(R.array.following)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val listHero = ArrayList<User>()
        for (position in dataName.indices) {
            val user = User(
                dataName[position],
                dataUsername[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position],
                dataAvatar.getResourceId(position, -1),
            )
            listHero.add(user)
        }
        return listHero
    }

    private fun showRecyclerList() {
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        binding.rvUser.adapter = listUserAdapter
    }
}