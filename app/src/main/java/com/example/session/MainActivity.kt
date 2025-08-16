package com.example.session

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val image1:ImageView=findViewById(R.id.dice1)
        val image2:ImageView=findViewById(R.id.dice2)
        val luckBtn:Button=findViewById(R.id.roll_btn)
        luckBtn.setOnClickListener {
            val randomNo1 =(1..6).random()
            val randomNo2 =(1..6).random()
            val images = arrayOf(
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6
            )
            image1.setImageResource(images[randomNo1-1])
            image2.setImageResource(images[randomNo2-1])

        }
        val resultText: TextView = findViewById(R.id.feeling)
        val animator = ValueAnimator.ofArgb(Color.RED, Color.BLUE, Color.GREEN)
        animator.duration = 4000
        animator.repeatCount = ValueAnimator.INFINITE
        animator.addUpdateListener { animation ->
            resultText.setTextColor(animation.animatedValue as Int)
        }
        animator.start()


    }


}