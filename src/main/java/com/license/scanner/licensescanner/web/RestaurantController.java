package com.license.scanner.licensescanner.web;

import com.license.scanner.licensescanner.model.Restaurant;
import com.license.scanner.licensescanner.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.POST)
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(restaurantService.save(restaurant), HttpStatus.OK);
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET)
    public ResponseEntity<List<Restaurant>> findAllRestaurant() {
        return new ResponseEntity<>(restaurantService.getRestaurants(), HttpStatus.OK);
    }
}
