package com.example.recipexx
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecipeAdapter(private val context: Context, private val recipeList: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_recipe_list, parent, false)
        return RecipeViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recipeNameTextView: TextView = itemView.findViewById(R.id.editTextRecipeName)
        private val ingredientsTextView: TextView = itemView.findViewById(R.id.editTextIngredients)

        fun bind(recipe: Recipe) {
            recipeNameTextView.text = recipe.name
            ingredientsTextView.text = recipe.ingredients.joinToString(separator = "\n")
        }
    }
}

