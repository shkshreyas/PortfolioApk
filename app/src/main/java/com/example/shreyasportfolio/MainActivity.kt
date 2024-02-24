package com.example.shreyasportfolio

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
        val linkedin=findViewById<Button>(R.id.linkedin)
        linkedin.setOnClickListener {
            gotoUrl("https://www.linkedin.com/in/shkshreyas")
        }
        val twitter=findViewById<Button>(R.id.twitter)
        twitter.setOnClickListener {
            gotoUrl("https://www.twitter.com/shkshreyas")
        }
        val mainline = findViewById<TextView>(R.id.tvDesignation)
        databaseReference = FirebaseDatabase.getInstance().getReference("portfolio")
        databaseReference.get().addOnSuccessListener {
            mainline.text = (it.child("mainline").value).toString()
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