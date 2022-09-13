package org.recook.api.Car;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;
    public List<Car> getAllCars(int page, int size) {
        Pageable pageable = PageRequest.of(Math.max(page, 0), Math.max(size, 1));
        Page<Car> cars = carRepository.findAll(pageable);
        return cars.toList();
    }
}
