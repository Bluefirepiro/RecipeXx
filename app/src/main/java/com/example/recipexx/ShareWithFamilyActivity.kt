package com.example.recipexx
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.recipexx.HomeActivity
import com.example.recipexx.R

class ShareWithFamilyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_with_family)

        // Initialize views and set up functionality for sharing with family
        fun backToMainMenu(view: View) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}