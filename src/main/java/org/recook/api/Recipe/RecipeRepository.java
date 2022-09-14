package org.recook.api.Recipe;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository
        extends MongoRepository<Recipe, String> {
    List<Recipe> findByRecipeTitleContainingIgnoreCaseOrderByRecipeTitle(String query);
}
