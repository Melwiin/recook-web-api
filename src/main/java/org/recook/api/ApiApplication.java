package org.recook.api;

import org.recook.api.Recipe.Ingredient;
import org.recook.api.Recipe.Recipe;
import org.recook.api.Recipe.Units;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

/*	@GetMapping
	private Recipe checkStatus() {
		return new Recipe(
				"knjdfs8u9324njfsdu",
				"Zwiebel Salat",
				"Kleiner vegetatische Zwiebelsalat",
				"Melwin",
				2,
				List.of(new Ingredient(
						"Zwiebel",
						Units.KG,
						2F
				)),
				List.of("Erst das", "Dann das"),
				List.of("Vegetarisch", "Vegan", "Deutsch"),
				20,
				3.56F
		);
	}*/
}
