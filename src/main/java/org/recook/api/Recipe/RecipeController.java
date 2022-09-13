package org.recook.api.Recipe;

import lombok.AllArgsConstructor;
import org.recook.api.File.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final FileService fileService;

    @GetMapping
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:6006"})
    public List<Recipe> fetchAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getRecipeImage(@RequestParam("imageUri") String imageUri) throws IOException {
        final ByteArrayResource inputStream = new ByteArrayResource(
                Files.readAllBytes(Paths.get(fileService.resPath + imageUri)));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public String saveRecipe(@RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return "Recipe has been inserted successfully";
    }

    @PostMapping("/saveimg")
    @CrossOrigin(origins = "http://localhost:3000")
    public String saveRecipeImage(@RequestParam("file") MultipartFile file) throws IOException {
        return fileService.saveFile(file);
    }
}
