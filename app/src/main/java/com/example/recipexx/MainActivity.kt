import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.recipexx.R
import com.example.recipexx.R.layout
import com.example.recipexx.RecipeListActivity
import com.example.recipexx.ShareWithFamilyActivity

class HomeActivity : AppCompatActivity() {

    private val recipesList = RecipeDataSource.getAllRecipes()  // Get the list of recipes from RecipeDataSource

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_home)

        // Button click listeners
        findViewById<Button>(R.id.btnRecipeList).setOnClickListener {
            startActivity(Intent(this, RecipeListActivity::class.java))
        }

        findViewById<Button>(R.id.btnShare).setOnClickListener {
            startActivity(Intent(this, ShareWithFamilyActivity::class.java))
            // Implement share functionality here
        }

        findViewById<Button>(R.id.btnAddRecipe).setOnClickListener {
            val intent = Intent(this, AddRecipeActivity::class.java)
            intent.putParcelableArrayListExtra("recipeList", ArrayList(recipesList))
            startActivity(intent)
        }
    }
}





