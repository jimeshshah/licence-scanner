package com.license.scanner.licensescanner.service;

import com.license.scanner.licensescanner.model.Restaurant;
import com.license.scanner.licensescanner.repository.RestaurantRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepo restaurantRepo;

    public RestaurantService(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepo.findAll();
    }
}
