package com.example.shreyasportfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EduActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var eduArrayList:ArrayList<edu>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edu2)
        val toolbar: Toolbar=findViewById(R.id.toolbar)
        toolbar.title="Shreyas Kumar"
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        toolbar.subtitle = "Educational Details"
        myRecyclerView=findViewById(R.id.recyclerView)
        val ImgArray= arrayOf(
            R.drawable.vit,
            R.drawable.logo
        )
        val eduArray= arrayOf(
            "Vellore Institute Of Technology, Chennai",
            "Bridgewell Global School"
        )
        myRecyclerView.layoutManager=LinearLayoutManager(this)
        eduArrayList= arrayListOf<edu>()
        for (index in ImgArray.indices){
            val edu=edu(eduArray[index], ImgArray[index])
            eduArrayList.add(edu)

        }
        myRecyclerView.adapter=MyAdapter(eduArrayList,this)
    }
}