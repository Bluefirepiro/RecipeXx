package com.example.recipexx
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShareWithFamilyActivity : AppCompatActivity() {

    private val familyMembers = listOf(
        FamilyMember(1, "John"),
        FamilyMember(2, "Jane"),
        FamilyMember(3, "Alice"),
        FamilyMember(4, "Bob")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_with_family)

        // Initialize views and set up functionality for sharing with family
        fun backToMainMenu(view: View) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFamilyMembers)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = FamilyMemberAdapter(familyMembers)
        }
    }
}