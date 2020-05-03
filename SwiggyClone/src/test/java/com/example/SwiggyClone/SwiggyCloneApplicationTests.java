package com.example.SwiggyClone;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.SwiggyClone.model.Restaurant;
import com.example.SwiggyClone.repository.RestaurantRepository;
import com.example.SwiggyClone.service.RestaurantService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SwiggyCloneApplicationTests {

	@Autowired
	private RestaurantService service;
	
	@MockBean
	private RestaurantRepository repository;
	
	@Test
	public void addRestaurant() {
		when(repository.findAll()).thenReturn(Stream.of
				(new Restaurant("A", "B", 1, 2, 5, 5, 10, 10), new Restaurant("C", "D", 1, 2, 5, 5, 10, 10)).collect(Collectors.toList()));
		
		assertEquals(2, service.getAllRestaurants().size());
	}
	
	@Test	
	public void getRestaurantByName() {
		String name = "A";
		when(repository.findByName(name))
						.thenReturn(Stream.of(new Restaurant("A", "B", 1, 2, 5, 5, 10, 10)).collect(Collectors.toList()));
		
		assertEquals(1, service.getRestaurantByName(name).size());
	}
	
	@Test
	public void saveRestaurantTest() {
		Restaurant restaurant = new Restaurant("A", "B", 1, 2, 5, 5, 10, 10);
		when(repository.save(restaurant)).thenReturn(restaurant);
		
		assertEquals(restaurant, service.addRestaurant(restaurant));
	}

	@Test
	public void deleteRestaurant() {
		Restaurant restaurant = new Restaurant("A", "B", 1, 2, 5, 5, 10, 10);
		service.deleteRestaurant(restaurant);
		
		verify(repository, times(1)).delete(restaurant);
	}

}
