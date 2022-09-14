package org.recook.api.Recipe;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository repository;
    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }
    public List<String> getSuggestions(String query) {
        List<Recipe> result = repository.findByRecipeTitleContainingIgnoreCaseOrderByRecipeTitle(query);
        List<String> res = new ArrayList<>();
        result.forEach(recipe -> res.add(recipe.recipeTitle));
        return res;
    }
    public void saveRecipe(Recipe recipe){
        repository.insert(recipe);
    }
}
