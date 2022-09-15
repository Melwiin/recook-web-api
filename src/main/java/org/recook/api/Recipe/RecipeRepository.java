package org.recook.api.Recipe;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Objects;

public interface RecipeRepository
        extends MongoRepository<Recipe, String> {

    @Query(fields = "{'recipeTitle' :  1, 'id' :  1}")
    List<Recipe> findByRecipeTitleContainingIgnoreCaseOrderByRecipeTitle(String query, Pageable page);
    Recipe findRecipeByIdIs(String id);
}
