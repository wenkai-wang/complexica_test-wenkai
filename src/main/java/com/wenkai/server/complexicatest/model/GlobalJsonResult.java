package com.wenkai.server.complexicatest.model;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;

@Data
public class GlobalJsonResult {
	private int code; // if the return code is not 0, then that means it fails
	private String msg; // return message
	private Map<String, Object> data; // the return data

	public GlobalJsonResult() {
	};

	public GlobalJsonResult(int code, String msg, Map<String, Object> data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static String success() {
		return success(10000, "Handle Successful!", new HashMap<>(0));
	}

	public static String success(int code, String msg, Map<String, Object> data) {

		JSONObject result = new JSONObject();
		result.put("msg", msg);
		result.put("code", code);
		result.put("data", data);

		// resultMap.put("jsonResult", new GlobalJsonResult(code, msg, data));
		return JSONObject.toJSONString(result);
	}

	public static String failed() {
		return failed("Handle failed!");
	}

	public static String failed(String msg) {
		return failed(-1, msg);
	}

	public static String failed(int code, String msg) {
		Map<String, Object> resultMap;
		resultMap = new HashMap<String, Object>();
		resultMap.put("jsonResult", new GlobalJsonResult(code, msg, new HashMap<>(0)));

		JSONObject result = new JSONObject();
		result.put("msg", msg);
		result.put("code", code);
		result.put("data", new HashMap<String, Object>());

		// return JSON.toJSONString(new JsonResult(code, msg, new HashMap<>(0)));
//    	return JSONObject.toJSONString(resultMap);
		return JSONObject.toJSONString(result);
	}
}
