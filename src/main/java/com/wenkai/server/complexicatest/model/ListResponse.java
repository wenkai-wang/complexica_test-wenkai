package com.wenkai.server.complexicatest.model;

public class ListResponse {
    
	private Long timeStamp;
	private MainResponse mainResponse;
	private WeatherResponse weatherResponse;
	private CouldsResponse cloudsResponse;
	private WindResponse wind;
	private int visibility;
	private float pop;
	private SysResponse sysResponse;
	private String dateString;
	
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public MainResponse getMainResponse() {
		return mainResponse;
	}
	public void setMainResponse(MainResponse mainResponse) {
		this.mainResponse = mainResponse;
	}
	public WeatherResponse getWeatherResponse() {
		return weatherResponse;
	}
	public void setWeatherResponse(WeatherResponse weatherResponse) {
		this.weatherResponse = weatherResponse;
	}
	public CouldsResponse getCloudsResponse() {
		return cloudsResponse;
	}
	public void setCloudsResponse(CouldsResponse cloudsResponse) {
		this.cloudsResponse = cloudsResponse;
	}
	public WindResponse getWind() {
		return wind;
	}
	public void setWind(WindResponse wind) {
		this.wind = wind;
	}
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	public float getPop() {
		return pop;
	}
	public void setPop(float pop) {
		this.pop = pop;
	}
	public SysResponse getSysResponse() {
		return sysResponse;
	}
	public void setSysResponse(SysResponse sysResponse) {
		this.sysResponse = sysResponse;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	
	
	
}
