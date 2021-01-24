package com.wenkai.server.complexicatest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.wenkai.server.complexicatest.model.ForecastInstant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;


@Service("getOpenWeatherDataService")
public class OpenWeatherService implements OpenWeatherIService{

	public JSONObject getOpenWeatherData(String apiUrl, String cityName, String appidValue, String unitsValue)
	{
		RestTemplate restTemplate=new RestTemplate();
		Map<String,String> apiParams=new HashMap();
		
		apiParams.put("cityName", cityName);
		apiParams.put("appidValue", cityName);
		apiParams.put("unitsValue", unitsValue);
		
		//ResponseEntity<Object> responseEntity=restTemplate.getForObject(apiUrl,Object.class, apiParams);
		String responseString = restTemplate.getForObject(apiUrl, String.class, apiParams);
		System.out.println("!!!!!!!!! Calling OpenWeather API started !!!!!!!!!");
		System.out.println(responseString);
		
		JSONObject obj=JSON.parseObject(responseString);
		
		return obj;
	}
}
