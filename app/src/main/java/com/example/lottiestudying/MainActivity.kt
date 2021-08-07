package com.example.lottiestudying

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pauseButton = findViewById<FloatingActionButton>(R.id.button_pause)
        val stopButton = findViewById<FloatingActionButton>(R.id.button_stop)

        val animationView = findViewById<View>(R.id.animation_view) as LottieAnimationView

        pauseButton.setOnClickListener{
            if (animationView.isAnimating) {
                animationView.pauseAnimation()
                pauseButton.setImageResource(R.drawable.play)
            }else {
                animationView.resumeAnimation()
                pauseButton.setImageResource(R.drawable.pause)
            }
        }

        stopButton.setOnClickListener{
            animationView.cancelAnimation()
            animationView.progress = 0F
            pauseButton.setImageResource(R.drawable.play)
        }
    }
}