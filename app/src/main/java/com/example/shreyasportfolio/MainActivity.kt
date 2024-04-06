package com.example.shreyasportfolio

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.Firebase
import java.lang.ref.PhantomReference
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
class MainActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var xlink: String = "https://twitter.com/shkshreyas"
        var linkedinlink: String = "https://www.linkedin.com/in/shkshreyas"
        var gitlink: String = "https://www.github.com/shkshreyas"
        val mainline = findViewById<TextView>(R.id.tvDesignation)
        databaseReference = FirebaseDatabase.getInstance().getReference("portfolio")
        databaseReference.get().addOnSuccessListener { dataSnapshot ->
            mainline.text = dataSnapshot.child("mainline").value?.toString()
            xlink = dataSnapshot.child("x").value?.toString() ?: ""
            linkedinlink = dataSnapshot.child("linkedin").value?.toString() ?: ""
            gitlink = dataSnapshot.child("github").value?.toString() ?: ""
        }
        val twitter = findViewById<ImageView>(R.id.twitter)
        twitter.setOnClickListener {
            gotoUrl(xlink)
        }
        val linkedin=findViewById<ImageView>(R.id.linkedin)
        linkedin.setOnClickListener {
            gotoUrl(linkedinlink)
        }
        val github=findViewById<ImageView>(R.id.github)
        github.setOnClickListener {
            gotoUrl(gitlink)
        }
        val buttonSkills=findViewById<Button>(R.id.btnskills)
        buttonSkills.setOnClickListener {
            intent=Intent(this,SkillsActivity::class.java)
            startActivity(intent)

        }
        val eduActivity=findViewById<Button>(R.id.button2)
        eduActivity.setOnClickListener {
            intent=Intent(this,EduActivity::class.java)
            startActivity(intent)

        }
        val workActivity=findViewById<Button>(R.id.button3)
        workActivity.setOnClickListener {
            intent=Intent(this,WorkActivity::class.java)
            startActivity(intent)

        }
        val achieveActivity=findViewById<Button>(R.id.button4)
        achieveActivity.setOnClickListener {
            intent=Intent(this,AchieveActivity::class.java)
            startActivity(intent)

        }
    }

    private fun gotoUrl(s: String) {
        val uri = Uri.parse(s)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)

    }
}