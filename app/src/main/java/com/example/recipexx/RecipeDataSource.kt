object RecipeDataSource {
    private val recipesList = mutableListOf<Recipe>()

    // Add a recipe to the list
    fun addRecipe(recipe: Recipe) {
        recipesList.add(recipe)
    }

    // Get all recipes from the list
    fun getAllRecipes(): List<Recipe> {
        return recipesList.toList()
    }

    // Get a recipe by its index in the list
    fun getRecipeByIndex(index: Int): Recipe? {
        return if (index in 0 until recipesList.size) {
            recipesList[index]
        } else {
            null
        }
    }

    // Get the number of recipes in the list
    fun getRecipesCount(): Int {
        return recipesList.size
    }

    // Initialize the recipes list with some default recipes
    init {
        recipesList.apply {
            add(Recipe("Spaghetti Carbonara", listOf("Spaghetti", "Eggs", "Bacon", "Parmesan Cheese"), "Cook spaghetti, fry bacon, mix eggs and cheese, combine all ingredients."))
            add(Recipe("Chicken Alfredo", listOf("Chicken Breast", "Fettuccine Pasta", "Heavy Cream", "Parmesan Cheese"), "Cook chicken, boil pasta, heat cream, mix cheese and ingredients."))
            add(Recipe("Vegetable Stir-Fry", listOf("Broccoli", "Carrots", "Bell Peppers", "Soy Sauce"), "Stir-fry vegetables, add soy sauce, cook until tender, serve hot."))
            // Add more default recipes here
        }
    }
}
