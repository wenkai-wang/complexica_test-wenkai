package com.wenkai.server.complexicatest.model;

import java.math.BigInteger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository(value = "forecastInstantModel")
public class ForecastInstant {

	// Mapping for forecast instant value from OpenWeather

	// city_name
	private String cityName;

	// country_code
	private int countryCode;

	// forcast_time_from
	private String forcastTimeFrom;

	// forcast_time_to
	private String forcastTimeTo;

	// temperature
	private float temperature;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getForcastTimeFrom() {
		return forcastTimeFrom;
	}

	public void setForcastTimeFrom(String forcastTimeFrom) {
		this.forcastTimeFrom = forcastTimeFrom;
	}

	public String getForcastTimeTo() {
		return forcastTimeTo;
	}

	public void setForcastTimeTo(String forcastTimeTo) {
		this.forcastTimeTo = forcastTimeTo;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
}
