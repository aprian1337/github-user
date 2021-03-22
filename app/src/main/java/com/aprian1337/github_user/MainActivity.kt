package com.aprian1337.github_user

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aprian1337.github_user.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser:RecyclerView
    private var list: ArrayList<User> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvUser = findViewById(R.id.rv_user)
        list.addAll(getListHeroes())
        showRecyclerList()
    }

    fun getListHeroes(): ArrayList<User> {
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataAvatar = resources.getIntArray(R.array.avatar)

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
                dataAvatar[position],
            )
            listHero.add(user)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter
    }
}