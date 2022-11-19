package com.example.p8

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity(){
    lateinit var logo_img: ImageView
    lateinit var logoframbyframanimation: AnimationDrawable
    lateinit var twinanimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        logo_img=findViewById(R.id.img)
        logo_img.setBackgroundResource(R.drawable.i1)
        logoframbyframanimation=logo_img.background as AnimationDrawable
        twinanimation= AnimationUtils.loadAnimation(this,R.anim.twin_animation)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            logoframbyframanimation.start()
            logo_img.startAnimation(twinanimation)
            twinanimation.setAnimationListener(object :Animation.AnimationListener{
                override fun onAnimationEnd(p0: Animation?) {
                    var intent = Intent(applicationContext,MainActivity::class.java)

                    startActivity(intent)
                    overridePendingTransition(R.anim.scale_in,R.anim.scale_out)
                    finish()
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationStart(p0: Animation?) {

                }
            })
        }
        else{
            logoframbyframanimation.stop()
        }
    }
}