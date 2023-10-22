package com.example.shreyasportfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }
}