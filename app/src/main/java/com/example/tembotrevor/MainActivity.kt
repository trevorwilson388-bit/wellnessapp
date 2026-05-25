package com.example.tembotrevor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

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

        // Initialize AdMob Banner Ad
        MobileAds.initialize(this)
        val adView = findViewById<AdView>(R.id.adview)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        // Navigation buttons - each opens its respective activity
        findViewById<Button>(R.id.healthy_recipes).setOnClickListener {
            startActivity(Intent(this, HealthyRecipes::class.java))
        }
        findViewById<Button>(R.id.nutrition_advice).setOnClickListener {
            startActivity(Intent(this, Nutrition::class.java))
        }
        findViewById<Button>(R.id.mediton).setOnClickListener {
            startActivity(Intent(this, Meditation::class.java))
        }
        findViewById<Button>(R.id.daily_motivation).setOnClickListener {
            startActivity(Intent(this, Daily_Motivation::class.java))
        }
        findViewById<Button>(R.id.start_exercise).setOnClickListener {
            startActivity(Intent(this, Start_exercise::class.java))
        }
        findViewById<Button>(R.id.hydration_alert).setOnClickListener {
            startActivity(Intent(this, Hydration_alert::class.java))
        }
        findViewById<Button>(R.id.shop_button).setOnClickListener {
            startActivity(Intent(this, ProductsActivity::class.java))
        }
    }
}
