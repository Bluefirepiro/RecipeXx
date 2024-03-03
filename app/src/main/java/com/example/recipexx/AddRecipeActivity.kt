package com.example.recipexx

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class AddRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

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

        // Create a new com.example.recipexx.Recipe object
        val recipe = Recipe(recipeName, ingredients, instructions)

        // Add the recipe to the recipe list
        recipeList.add(recipe)

        // Notify the adapter that the dataset has changed
        // This will refresh the recipe list view to display the newly added recipe



        (recipeList.adapter as RecipeAdapter).notifyDataSetChanged()
    }

}

private fun <E> List<E>.add(recipe: E) {

}

private val <E> List<E>.adapter: Any
    get() {(recipeList)
    TODO()
    }
val recipeList: List<Recipe> = listOf(/* initialize list of recipes */)

private lateinit var editTextRecipeName: EditText
private lateinit var editTextIngredients: EditText
private lateinit var  editTextInstructions: EditText