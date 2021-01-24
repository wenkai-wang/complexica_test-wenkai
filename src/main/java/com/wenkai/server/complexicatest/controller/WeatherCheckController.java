package com.wenkai.server.complexicatest.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.wenkai.server.complexicatest.util.OpenWeatherApiUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.wenkai.server.complexicatest.constant.ForecastConstant;
import com.wenkai.server.complexicatest.model.ApiResultGeneral;
import com.wenkai.server.complexicatest.model.ForecastHistory;
import com.wenkai.server.complexicatest.model.GlobalJsonResult;
import com.wenkai.server.complexicatest.model.ListResponse;
import com.wenkai.server.complexicatest.service.DatabaseOperationIService;
import com.wenkai.server.complexicatest.service.DatabaseOperationService;
import com.wenkai.server.complexicatest.service.OpenWeatherIService;
import com.wenkai.server.complexicatest.service.OpenWeatherService;
import com.wenkai.server.complexicatest.util.AvailableDateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


@Controller
@MapperScan({"com.wenkai.server.complexicatest.mapper"})
@Api(value = "TravelWeatherCheck")
public class WeatherCheckController {
	
	//private final ResourceLoader resourceLoader;
	
	@Autowired
	@Qualifier("databaseOperationService")
    private DatabaseOperationIService dbOperationService;
	
	@Autowired
	@Qualifier("getOpenWeatherDataService")
    private OpenWeatherService openWeatherService;
	
	@Resource(name = "forecastHistoryModel")
	private ForecastHistory forecastHistory;
	
	@Resource(name = "apiResultGenModel")
	private ApiResultGeneral<ListResponse> apiResultGen;
	
	@Value("${web.openweather.api.url-origin}")
    private String apiUrlOrigin;
	
	@Value("${web.openweather.api.appid-value}")
    private String appIdValue;
	
	@Value("${web.openweather.api.units-value}")
    private String unitsValue;
	
	
	/**
    *
    * Check weather for the specific date
    * @param String city_name
    * @param String check_date
    * @return
    */
    @RequestMapping(value = "checkWeather", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation("CheckFutureWeather")
    public String checkWeather(HttpServletResponse response, @RequestParam("city_name") String cityName, 
    		@RequestParam("check_date") String checkDate) {
    	
    	// Return message based on the result
        String msg = "";
        
        // Initialize Result Status Code
    	int checkWeatherStatusCode = 0;
    	
    	int apiResultCount = 0;
    	
    	List<ForecastHistory> listForecastHistoryForNew = new ArrayList<ForecastHistory>();
    	List<ForecastHistory> listForecastHistoryForExisted = new ArrayList<ForecastHistory>();
    	
    	// Check date available result
    	boolean dataIsAvailable = false;
    	
    	JSONObject obj;
    	
    	// new map for response
        Map<String, Object> dataMap = new HashMap<String, Object>();
    	
        //Check input date is available or not
        try {
        	dataIsAvailable = AvailableDateUtil.checkDateAvailable(checkDate);
        	
        }catch(ParseException pe)
        {
        	pe.printStackTrace();
        	checkWeatherStatusCode = ForecastConstant.DATE_PARSE_EXCEPTION;
    		msg = ForecastConstant.CHECKWEATHER_FAILED_MSG;
    		return GlobalJsonResult.failed(checkWeatherStatusCode, msg);
        }
        
        if(!dataIsAvailable)
        {
        	checkWeatherStatusCode = ForecastConstant.DATE_NOT_AVAILABLE;
    		msg = ForecastConstant.CHECKWEATHER_FAILED_MSG;
    		return GlobalJsonResult.failed(checkWeatherStatusCode, msg);
        }
        
        listForecastHistoryForExisted = dbOperationService.findForecastByCityNameAndDateFromDB(cityName, checkDate);
        
        //Check the user input data with the record in In-Memory DB
        if(listForecastHistoryForExisted != null)
        {
        	checkWeatherStatusCode = ForecastConstant.CHECK_WEATHER_SUCCESS;
    		msg = ForecastConstant.CHECK_WEATHER_MSG;
    		dataMap.put("weather_data", JSONObject.toJSONString(listForecastHistoryForExisted));
    		
    		return GlobalJsonResult.success(checkWeatherStatusCode, msg, dataMap);
    		
        }else {
        	obj = openWeatherService.getOpenWeatherData(apiUrlOrigin, cityName, appIdValue, unitsValue);
        	
        	apiResultGen = JSONObject.toJavaObject(obj, ApiResultGeneral.class);
        	
        	if(apiResultGen != null)
        	{
        		for(int i = 0; i < apiResultGen.getListCount(); i++)
        		{
        			forecastHistory.setCityName(cityName);
        			forecastHistory.setCountry(apiResultGen.getCountry());
        			forecastHistory.setForecastDate(checkDate);
        			forecastHistory.setTemperature(apiResultGen.getListGeneral().get(i).getMainResponse().getTemperature());
        			forecastHistory.setClouds(apiResultGen.getListGeneral().get(i).getWeatherResponse().getWeatherDescription());
        			//Insert into DB to store data
        			dbOperationService.insertDB(forecastHistory);
        			listForecastHistoryForNew.add(forecastHistory);
        		}
        		
        		checkWeatherStatusCode = ForecastConstant.CHECK_WEATHER_SUCCESS;
        		msg = ForecastConstant.CHECK_WEATHER_MSG;
        		dataMap.put("weather_data", JSONObject.toJSONString(listForecastHistoryForNew));
        		
        		return GlobalJsonResult.success(checkWeatherStatusCode, msg, dataMap);
        	}else {
        		checkWeatherStatusCode = ForecastConstant.OPEN_API_FAILED;
        		msg = ForecastConstant.CHECKWEATHER_FAILED_MSG;
        		return GlobalJsonResult.failed(checkWeatherStatusCode, msg);
        	}
        	
        }
        
    }
    	
}
