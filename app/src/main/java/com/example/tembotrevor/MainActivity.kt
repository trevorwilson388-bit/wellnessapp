package com.example.tembotrevor

import android.content.Intent
import android.media.tv.AdRequest
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import java.lang.ref.Reference

class MainActivity : AppCompatActivity() {
    var mInterstitialAd: InterstitialAd?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Banner Ad
        MobileAds.initialize(this)
        val adview=findViewById<AdView>(R.id.adview)
        val adRequest= com.google.android.gms.ads.AdRequest.Builder().build()
        adview.loadAd(adRequest)



        val healthyrecipes=findViewById<Button>(R.id.healthy_recipes)
        val nutrition=findViewById<Button>(R.id.nutrition_advice)
        val meditation=findViewById<Button>(R.id.meditaton)
        val dailyMotivation=findViewById<Button>(R.id.daily_motivation)
        val startExercise=findViewById<Button>(R.id.start_exercise)
        val hydrationAlert=findViewById<Button>(R.id.hydration_alert)
        healthyrecipes.setOnClickListener {


            val intent= Intent(this, HealthyRecipes::class.java)
            startActivity(intent)
        }
        nutrition.setOnClickListener {
            val intent= Intent(this, Nutrition::class.java)
            startActivity(intent)
        }
        meditation.setOnClickListener {
            val intent= Intent(this, Meditation::class.java)
            startActivity(intent)
        }
        dailyMotivation.setOnClickListener {
            val intent= Intent(this, Daily_Motivation::class.java)
            startActivity(intent)
        }
        startExercise.setOnClickListener {
            val intent= Intent(this, Start_exercise::class.java)
            startActivity(intent)
        }
        hydrationAlert.setOnClickListener {
            val intent= Intent(this,hydrationAlert::class.java)
            startActivity(intent)
        }


    }
    fun loadInterstitialAd(){
        val adRequest= com.google.android.gms.ads.AdRequest.Builder().build()

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712",
            adRequest, object :  InterstitialAdLoadCallback())
    }
}