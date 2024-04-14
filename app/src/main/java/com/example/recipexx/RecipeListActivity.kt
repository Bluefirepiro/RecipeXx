package com.example.recipexx

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecipeListActivity : AppCompatActivity() {

    private lateinit var recipeListView: RecyclerView
    private lateinit var adapter: RecipeAdapter
    private var recipeList: MutableList<Recipe> = mutableListOf() // Initialize with an empty list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        // Initialize RecyclerView
        recipeListView = findViewById(R.id.recyclerViewRecipes)
        recipeListView.layoutManager = LinearLayoutManager(this)

        // Initialize adapter with recipe list
        adapter = RecipeAdapter(recipeList)
        recipeListView.adapter = adapter
    }

    // Method to handle button click event
    fun backToMainMenu(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}