package com.example.recipexx

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddRecipeActivity : AppCompatActivity() {

    private lateinit var editTextRecipeName: EditText
    private lateinit var editTextIngredients: EditText
    private lateinit var editTextInstructions: EditText
    private lateinit var recipeList: MutableList<Recipe>
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        editTextRecipeName = findViewById(R.id.editTextRecipeName)
        editTextIngredients = findViewById(R.id.editTextIngredients)
        editTextInstructions = findViewById(R.id.editTextInstructions)

        // Initialize recipeList and adapter (assuming they are passed from the previous activity)
        recipeList = intent.getParcelableArrayListExtra("recipeList") ?: mutableListOf()
        adapter = RecipeAdapter(recipeList)
    }

    // Method to handle button click event
    fun backToMainMenu(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRecipe(view: View) {
        val recipeName = editTextRecipeName.text.toString()
        val ingredients = editTextIngredients.text.toString().split("\n")
        val instructions = editTextInstructions.text.toString()

        // Create a new Recipe object
        val recipe = Recipe(recipeName, ingredients, instructions)

        // Add the recipe to the recipe list
        recipeList.add(recipe)

        // Notify the adapter that the dataset has changed
        adapter.notifyDataSetChanged()
    }
}