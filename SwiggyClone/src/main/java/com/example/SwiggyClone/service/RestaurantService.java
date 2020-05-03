package com.example.SwiggyClone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SwiggyClone.model.Restaurant;
import com.example.SwiggyClone.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository repository;
	
	public Restaurant addRestaurant(Restaurant restaurant) {
		int count = (int) repository.count();
		
		restaurant.setId(count + 1);
		repository.save(restaurant);
		
		return restaurant;
	}
	
	public Optional<Restaurant> updateRestaurant(int id, Restaurant restaurant) {
		if( repository.findById(id) == null )
			return null;
		
		Restaurant r = repository.findById(id).get();
		r.setName(restaurant.getName());
		r.setLocation(restaurant.getLocation());
		
		repository.save(r);
		return Optional.of(r);
	}
	
	public Optional<Restaurant> getRestaurant(int id){
		return repository.findById(id);
	}
	
	public List<Restaurant> getAllRestaurants(){
		return repository.findAll();
	}
	
	public List<Restaurant> getRestaurantByName(String name){
		return repository.findByName(name);
	}
	
	public void deleteRestaurantById(int id) {
		repository.deleteById(id);
	}
	
	public void deleteRestaurant(Restaurant restaurant) {
		repository.delete(restaurant);
	}
}
