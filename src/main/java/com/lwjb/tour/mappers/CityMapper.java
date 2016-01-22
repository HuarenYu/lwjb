package com.lwjb.tour.mappers;

import java.util.List;

import com.lwjb.tour.models.City;

public interface CityMapper {
	public void insertCity(City city);
	public List<City> getCityList(); 
}
