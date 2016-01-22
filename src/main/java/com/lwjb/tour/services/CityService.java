package com.lwjb.tour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwjb.tour.mappers.CityMapper;
import com.lwjb.tour.models.City;

@Service  
@Transactional
public class CityService {   

    @Autowired  
    private CityMapper cityMapper;  
      
    public void insertCity() {  
        City city = new City();  
        city.setCityCode("1100");  
        city.setCityJb("1");   
        city.setProvinceCode("1100");  
        city.setCityName("天津市");  
        city.setCity("天津市");  
        city.setProvince("天津市");  
        cityMapper.insertCity(city);
    }
    
    public List<City> getCityList() {
    	return cityMapper.getCityList();
    }
}
