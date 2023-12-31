package com.example.shreyasportfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        analytics = Firebase.analytics
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
}