package com.wenkai.server.complexicatest.service;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.wenkai.server.complexicatest.model.ForecastHistory;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;


public interface OpenWeatherIService {

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, rollbackFor = Exception.class)
	public JSONObject getOpenWeatherData(String apiUrl, String cityName, String appidValue, String unitsValue);
}
