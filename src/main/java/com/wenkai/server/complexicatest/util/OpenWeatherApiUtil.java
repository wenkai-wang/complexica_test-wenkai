package com.wenkai.server.complexicatest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OpenWeatherApiUtil {

	public static String createOpenWeatherApiUrl(String urlPrefix, String cityPara, String cityValue, String appIdPara, String appIdValue, String unitsPara, String unitsValue)
	{
		String finalApiUrl = "";
		finalApiUrl = urlPrefix + cityPara + "=" + cityValue + appIdPara + "=" + appIdValue + unitsPara + "=" + unitsValue;
		return finalApiUrl;
	}
}
