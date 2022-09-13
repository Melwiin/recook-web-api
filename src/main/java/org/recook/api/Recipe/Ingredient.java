package org.recook.api.Recipe;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ingredient {
    String ingredientName;
    Units unit;
    Float amount;
}
