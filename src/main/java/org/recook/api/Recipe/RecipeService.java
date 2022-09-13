package org.recook.api.Recipe;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository repository;
    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }
    public void saveRecipe(Recipe recipe){
        repository.insert(recipe);
    }
}
