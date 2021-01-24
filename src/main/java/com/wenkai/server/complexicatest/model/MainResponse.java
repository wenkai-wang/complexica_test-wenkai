package com.wenkai.server.complexicatest.model;

public class MainResponse {

	private float temperature;
	private float feelsLike;
	private float tempMin;
	private float tempMax;
	private int presure;
	private int seaLevel;
	private int grndLevel;
	private int humidity;
	private float tempKf;
	
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(float feelsLike) {
		this.feelsLike = feelsLike;
	}
	public float getTempMin() {
		return tempMin;
	}
	public void setTempMin(float tempMin) {
		this.tempMin = tempMin;
	}
	public float getTempMax() {
		return tempMax;
	}
	public void setTempMax(float tempMax) {
		this.tempMax = tempMax;
	}
	public int getPresure() {
		return presure;
	}
	public void setPresure(int presure) {
		this.presure = presure;
	}
	public int getSeaLevel() {
		return seaLevel;
	}
	public void setSeaLevel(int seaLevel) {
		this.seaLevel = seaLevel;
	}
	public int getGrndLevel() {
		return grndLevel;
	}
	public void setGrndLevel(int grndLevel) {
		this.grndLevel = grndLevel;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public float getTempKf() {
		return tempKf;
	}
	public void setTempKf(float tempKf) {
		this.tempKf = tempKf;
	}
}
