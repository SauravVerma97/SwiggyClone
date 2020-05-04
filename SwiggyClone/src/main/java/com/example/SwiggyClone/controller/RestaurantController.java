package com.example.SwiggyClone.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SwiggyClone.model.Restaurant;
import com.example.SwiggyClone.service.RestaurantService;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService service;
	
	@GetMapping(path = "/{id}")
	private ResponseEntity<Optional<Restaurant>> getRestaurant(@PathVariable int id){
		return new ResponseEntity<Optional<Restaurant>>(service.getRestaurant(id), HttpStatus.OK);
	}
	
	@GetMapping(produces = { 
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE 
					})
	private ResponseEntity<List<Restaurant>> getBooks() {
		return new ResponseEntity<List<Restaurant>>(service.getAllRestaurants(), HttpStatus.OK);
	}
	
	@PostMapping(consumes = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE
					}, 
					produces = {
							MediaType.APPLICATION_XML_VALUE, 
							MediaType.APPLICATION_JSON_VALUE
							})
	private ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant){
		return new ResponseEntity<Restaurant>(service.addRestaurant(restaurant), HttpStatus.OK);
	}
	
	@PutMapping(path = "/{RestaurantId}",
			consumes = {
				MediaType.APPLICATION_XML_VALUE, 
				MediaType.APPLICATION_JSON_VALUE
				}, 
			produces = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE
					})
	public ResponseEntity<Optional<Restaurant>> updateRestaurant(@PathVariable int RestaurantId, @Valid @RequestBody Restaurant restaurant) {
		return new ResponseEntity<Optional<Restaurant>>(service.updateRestaurant(RestaurantId, restaurant), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{RestaurantId}")
	public ResponseEntity<Void> deleteRestaurant(@PathVariable int RestaurantId) {
		service.deleteRestaurantById(RestaurantId);
		
		return ResponseEntity.noContent().build();
	}
}
