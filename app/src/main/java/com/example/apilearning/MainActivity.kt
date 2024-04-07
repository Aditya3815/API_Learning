package com.example.apilearning

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var recycler:RecyclerView
    //Intialisation of Api and data class.

    var apiUrl = "https://api.github.com/users" // Intialize Url
    var userInfoItem = arrayOf<userinfoItem>() //
    var userInfo = userinfo()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.rView)
        val stringRequest = StringRequest(apiUrl,
            {
                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()
                userInfoItem = gson.fromJson(it, Array<userinfoItem>::class.java)

                userInfoItem.forEach {
                    userInfo.add(it)
                }

                val adapter  = rvAdapter(this, userInfo)
                recycler.layoutManager = LinearLayoutManager(this)
                recycler.adapter = adapter
            },

            {
                Toast.makeText(this, "Something went wrong" + it.toString(), Toast.LENGTH_SHORT)
                    .show()
            })
        val volleQueue = Volley.newRequestQueue(this)
        volleQueue.add(stringRequest)
    }
}