package com.company.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Apartment extends Space{

	private Set<Person> occupiedBy;
	private Map<String, ParkingSpace> parkingSpaces;
	private LocalDate startDate;
	private LocalDate endDate;
	public static int count = 0;

	public Apartment(double length, double breadth, double height){
		this.ID = "APT-" + ++count;
		this.volume = length*breadth*height;
		this.occupiedBy = new HashSet<>();
		this.parkingSpaces = new HashMap<>();
	}

	public Apartment(double volume){
		this.ID = "APT-" + ++count;
		this.volume = volume;
		this.occupiedBy = new HashSet<>();
		this.parkingSpaces = new HashMap<>();
	}

	public void addParkingSpace(ParkingSpace parkingSpace){
		parkingSpaces.put(parkingSpace.getID(), parkingSpace);
	}

	public ParkingSpace getParkingSpace(String id){
		return parkingSpaces.get(id);
	}

	public void checkIn(Person person) {
		occupiedBy.add(person);
	}

	public void checkOut(Person person){
		occupiedBy.remove(person);
	}

	public Map<String, ParkingSpace> getParkingSpaces() {
		return parkingSpaces;
	}

	public Set<Person> getOccupiedBy() {
		return occupiedBy;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	@Override
	public void setPrimaryOwner(Person primaryOwner) {
		this.primaryOwner = primaryOwner;
		this.startDate = LocalDate.now();
		this.endDate = LocalDate.now().plusDays(30);
	}
}
