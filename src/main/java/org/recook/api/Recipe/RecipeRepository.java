package org.recook.api.Recipe;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository
        extends MongoRepository<Recipe, String> {
}
