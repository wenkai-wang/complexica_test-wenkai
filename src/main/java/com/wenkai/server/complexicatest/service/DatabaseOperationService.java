package com.wenkai.server.complexicatest.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.wenkai.server.complexicatest.mapper.ForecastHistoryMapper;
import com.wenkai.server.complexicatest.model.ForecastHistory;


@ComponentScan({"com.wenkai.server.complexicatest.model"})
@Service("databaseOperationService")
public class DatabaseOperationService implements DatabaseOperationIService{
	@Resource
    private ForecastHistoryMapper forecastHistoryMapper;
	
	//insertDB method
	public void insertDB(ForecastHistory forecastHistory)
	{
		System.out.println("!!!!!!!!! Method start to forecastHistoryMapper.insert(forecastHistory); !!!!!!!!!");
		System.out.println("!!!!!!!!! ForecastHistory.CityName is: !!!!!!!!!" + forecastHistory.getCityName());
		System.out.println("!!!!!!!!! ForecastHistory.CountryCode is: !!!!!!!!!" + forecastHistory.getCountry());
		System.out.println("!!!!!!!!! ForecastHistory.ForcastDate is: !!!!!!!!!" + forecastHistory.getForecastDate());
		System.out.println("!!!!!!!!! ForecastHistory.Temperature is: !!!!!!!!!" + forecastHistory.getTemperature());
		System.out.println("!!!!!!!!! ForecastHistory.Clouds is: !!!!!!!!!" + forecastHistory.getClouds());
		
		forecastHistoryMapper.insert(forecastHistory);
	}
	
	public List<ForecastHistory> findForecastByCityNameFromDB(String cityName)
	{
		return forecastHistoryMapper.findByCityName(cityName);
	}
	
	public List<ForecastHistory> findForecastByCityNameAndDateFromDB(String cityName, String forecastDate)
	{
		return forecastHistoryMapper.findByCityNameAndDate(cityName, forecastDate);
	}
	
	
}
