package com.example.recipexx

import HomeActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFamilyMembers)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = FamilyMemberAdapter(familyMembers)
        recyclerView.adapter = adapter

        // Set click listener for each family member item
        adapter.setOnItemClickListener { familyMember: FamilyMember ->
            // Handle click event here, e.g., show details or initiate sharing
            Toast.makeText(this, "Clicked on ${familyMember.name}", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to go back to the main menu
    fun backToMainMenu(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
