package org.recook.api.Recipe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Data
@Document("recipes")
public class Recipe {
    @Id
    String id;

    String recipeTitle;
    String recipeDescription;
    String recipeCreator;
    Integer recipeServings;

    String imageUri;

    List<Ingredient> ingredients;
    List<String> directions;
    List<String> tags;

    Integer calories;
    @Builder.Default Float stars = 0.0F;
}
