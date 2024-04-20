
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recipexx.R
import com.example.recipexx.RecipeAdapter

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

        // Retrieve the recipeList extra from the intent
        recipeList = intent.getParcelableArrayListExtra<Recipe>("recipeList") ?: mutableListOf()
        adapter = RecipeAdapter(this, recipeList)  // Pass 'this' as the context
    }

    fun backToMainMenu(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun addRecipe(view: View) {
        val recipeName = editTextRecipeName.text.toString()
        val ingredients = editTextIngredients.text.toString().split("\n")
        val instructions = editTextInstructions.text.toString()

        val recipe = Recipe(recipeName, ingredients, instructions)
        recipeList.add(recipe)
        adapter.notifyDataSetChanged()

        Toast.makeText(this, "Recipe added successfully", Toast.LENGTH_SHORT).show()
    }
}
