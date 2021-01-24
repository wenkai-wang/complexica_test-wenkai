package com.wenkai.server.complexicatest.mapper;


import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wenkai.server.complexicatest.model.ForecastHistory;

@Mapper
public interface ForecastHistoryMapper {
	
	public void insert(ForecastHistory forcastHistory);
	
	public List<ForecastHistory> findByCityName(String cityName);
	
	public List<ForecastHistory> findByCityNameAndDate(String cityName, String forecastDate);
}
