package com.example.SwiggyClone.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.SwiggyClone.model.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> {
	
	List<Restaurant> findByName(String name);

}
