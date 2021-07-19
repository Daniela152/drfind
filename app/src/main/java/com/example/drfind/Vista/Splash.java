package com.example.drfind.Vista;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.drfind.R;

public class Splash extends AppCompatActivity {
ImageView arriba,corazon,linea,abajo;
TextView nombreapp;
CharSequence charSequence;
int index;
long delay=200;
Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        arriba=findViewById(R.id.iv_top);
        corazon=findViewById(R.id.iv_corazon);
        abajo=findViewById(R.id.iv_bot);
        nombreapp=findViewById(R.id.nombre_logo);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
         Animation animation= AnimationUtils.loadAnimation(this,R.anim.top_wave);
         arriba.setAnimation(animation);
        ObjectAnimator objectAnimator= ObjectAnimator.ofPropertyValuesHolder(corazon,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f));
objectAnimator.setDuration(500);
objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
objectAnimator.start();
animatText("Find Dr");
        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.bot_wave);
        abajo.setAnimation(animation1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                Animatoo.animateDiagonal(Splash.this);
                finish();
            }
        },4000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateDiagonal(Splash.this);
    }

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            nombreapp.setText(charSequence.subSequence(0,index++));
            if(index<=charSequence.length()){
                handler.postDelayed(runnable,delay);
            }
        }
    };
    public void animatText(CharSequence cs){
        charSequence=cs;
        index=0;
        nombreapp.setText("");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable,delay);
    }
}
