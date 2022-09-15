package org.recook.api.Recipe;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<Recipe> getSuggestions(String query) {
        Pageable page = PageRequest.of(0, 10);
        return repository.findByRecipeTitleContainingIgnoreCaseOrderByRecipeTitle(query, page);
    }
    public Recipe getRecipeById(String id) {
        return repository.findRecipeByIdIs(id);
    }
    public void saveRecipe(Recipe recipe){
        repository.insert(recipe);
    }
}
