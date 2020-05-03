package com.example.SwiggyClone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Restaurants")
public class Restaurant {
	@Id
	private int id;
	private String name;
	private String location; 
	
	// To store co-ordinates
	private GeoJsonPoint position;
	private double x;
	private double y;
	
	// Time is stored in minutes format; for example 5:30 will be
	// stored as 5 * 60 + 30 -> 330 
	private int startTime;
	private int endTime;
	
	private int startHours, startMins;
	private int endHours, endMins;
	
	public Restaurant(String name, String location, double x, double y, int startHours, int startMins, int endHours, int endMins) {
		this.name = name;
		this.location = location;
		
		this.x = x;
		this.y = y;
		
		this.startHours = startHours;
		this.startMins = startMins;
		
		this.endHours = endHours;
		this.endMins = endMins;
		
		this.position = new GeoJsonPoint(x, y);
		this.startTime = startHours * 60 + startMins;
		this.endTime = endHours * 60 + endMins;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public GeoJsonPoint getPosition() {
		return position;
	}

	public void setPosition(GeoJsonPoint position) {
		this.position = position;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getStartHours() {
		return startHours;
	}

	public void setStartHours(int startHours) {
		this.startHours = startHours;
	}

	public int getStartMins() {
		return startMins;
	}

	public void setStartMins(int startMins) {
		this.startMins = startMins;
	}

	public int getEndHours() {
		return endHours;
	}

	public void setEndHours(int endHours) {
		this.endHours = endHours;
	}

	public int getEndMins() {
		return endMins;
	}

	public void setEndMins(int endMins) {
		this.endMins = endMins;
	}
}
