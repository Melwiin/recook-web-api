package org.recook.api.Car;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarService carService;
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Car> fetchAllCars(@RequestParam(name = "page") int page,
                                  @RequestParam(name = "size") int size) {
        return carService.getAllCars(page, size);
    }
}
