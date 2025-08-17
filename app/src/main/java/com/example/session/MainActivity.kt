package com.example.session

import android.animation.Animator
import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView

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
        val anime1 : LottieAnimationView =findViewById(R.id.anim1)
        val anime2 : LottieAnimationView =findViewById(R.id.anim2)
        val num1:TextView=findViewById(R.id.num1)
        val num2:TextView=findViewById(R.id.num2)
        val message:ConstraintLayout=findViewById(R.id.pop_message)
        val sum:TextView=findViewById(R.id.popupText)
        val react:ImageView=findViewById(R.id.popupImage)
        val reactText:TextView=findViewById(R.id.text_react)
        luckBtn.setOnClickListener {
            num1.visibility=View.GONE
            num2.visibility=View.GONE
            val randomNo1 =(0..5).random()
            val randomNo2 =(0..5).random()
            val images = arrayOf(
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6
            )
            image1.animate().alpha(0f).setDuration(300).withEndAction {
                image1.visibility=View.GONE
                anime1.visibility=View.VISIBLE
                anime1.playAnimation()
                anime1.addAnimatorListener(object : Animator.AnimatorListener {


                    override fun onAnimationEnd(animation: Animator) {
                        anime1.visibility=View.GONE
                        image1.setImageResource(images[randomNo1])
                        image1.alpha = 0f
                        image1.visibility=View.VISIBLE
                        image1.animate().alpha(1f).setDuration(300).start()
                        num1.text= (randomNo1+1).toString()
                        num1.visibility=View.VISIBLE

                    }
                    override fun onAnimationStart(animation: Animator) {
                    }
                    override fun onAnimationCancel(animation: Animator) {
                        TODO("Not yet implemented")
                    }
                    override fun onAnimationRepeat(animation: Animator) {
                        TODO("Not yet implemented")
                    }
                })
            }
            image2.animate().alpha(0f).setDuration(300).withEndAction {
                image2.visibility=View.GONE
                anime2.visibility=View.VISIBLE
                anime2.playAnimation()
                anime2.addAnimatorListener(object : Animator.AnimatorListener {


                    override fun onAnimationEnd(animation: Animator) {
                        anime2.visibility=View.GONE
                        image2.setImageResource(images[randomNo2])
                        image2.alpha = 0f
                        image2.visibility=View.VISIBLE
                        image2.animate().alpha(1f).setDuration(300).start()
                        num2.text= (randomNo2+1).toString()
                        num2.visibility=View.VISIBLE

                    }
                    override fun onAnimationStart(animation: Animator) {
                    }
                    override fun onAnimationCancel(animation: Animator) {
                        TODO("Not yet implemented")
                    }
                    override fun onAnimationRepeat(animation: Animator) {
                        TODO("Not yet implemented")
                    }
                })
            }
            message.postDelayed({
                message.visibility = View.VISIBLE
                var sumNo=randomNo1+randomNo2+2
                sum.text="You Rolled a $sumNo"
                if(sumNo>6)
                {
                    react.setImageResource(R.drawable.good)
                    reactText.text="That's Good !"
                }
                else if(sumNo<6)
                {
                    react.setImageResource(R.drawable.bad)
                    reactText.text="That's Bad !"
                }
                else{
                    react.setImageResource(R.drawable.middle)
                    reactText.text="Is This Good?"
                }

            }, 4500)
        }
        val again:Button=findViewById(R.id.closePopupBtn)
        again.setOnClickListener {
            message.visibility=View.GONE
        }
        val resultText: TextView = findViewById(R.id.feeling)
        val animator = ValueAnimator.ofArgb(Color.RED, Color.BLUE, Color.GREEN)
        animator.duration = 5000
        animator.repeatCount = ValueAnimator.INFINITE
        animator.addUpdateListener { animation ->
            resultText.setTextColor(animation.animatedValue as Int)
        }
        animator.start()



    }


}