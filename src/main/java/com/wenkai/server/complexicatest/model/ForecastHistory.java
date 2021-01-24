package com.wenkai.server.complexicatest.model;


import java.math.BigInteger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository(value="forecastHistoryModel")
public class ForecastHistory {

	// Mapping table for forecast history
	
	// ud_id
	private BigInteger udId;
	
	// city_name
	private String cityName;
	
	// country_code
	private String country;
	
	// forcast_time_from
	private String forecastDate;
	
	// temperature
	private float temperature;
	
	// clouds
	private String clouds;

	public String getClouds() {
		return clouds;
	}

	public void setClouds(String clouds) {
		this.clouds = clouds;
	}

	public BigInteger getUdId() {
		return udId;
	}

	public void setUdId(BigInteger udId) {
		this.udId = udId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(String forecastDate) {
		this.forecastDate = forecastDate;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	
	
}
