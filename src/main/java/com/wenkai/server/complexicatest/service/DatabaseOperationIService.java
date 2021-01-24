package com.wenkai.server.complexicatest.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.wenkai.server.complexicatest.model.ForecastHistory;

public interface DatabaseOperationIService {
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, rollbackFor = Exception.class)
	public void insertDB(ForecastHistory forecastHistory);
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, rollbackFor = Exception.class)
	public List<ForecastHistory> findForecastByCityNameFromDB(String cityName);
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, rollbackFor = Exception.class)
	public List<ForecastHistory> findForecastByCityNameAndDateFromDB(String cityName, String forecastDate);
}
