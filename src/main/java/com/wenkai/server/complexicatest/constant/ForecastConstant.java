package com.wenkai.server.complexicatest.constant;

public class ForecastConstant {

	// Log Type (system_log_info)
	// Define for log type - Successful log
	public static final int LOG_TYPE_SUCCESS = 0;
	// Define for log type - File writing error
	public static final int LOG_TYPE_WRITING_ERROR = -1;
	// Define for log type - File reading error
	public static final int LOG_TYPE_READING_ERROR = -2;
	// Define for log type - DB insert error
	public static final int LOG_TYPE_DB_INSERT_ERROR = -3;
	// Define for log type - DB update error
	public static final int LOG_TYPE_DB_UPDATE_ERROR = -4;
	// Define for log type - Cannot find the username in DB (this username does not
	// exist). Login failed.
	public static final int LOG_TYPE_USERNAME_ERROR = -5;
	// Define for log type - Password incorrect. Login failed.
	public static final int LOG_TYPE_PASSWORD_ERROR = -6;
	// Define for log type - This user/admin is deleted from system.
	public static final int LOG_TYPE_USER_DELETE = -7;

	// Log Level (system_log_info)
	// Define for log level - All levels including custom levels.
	public static final String LOG_LEVEL_ALL = "ALL";
	// Define for log level - Designates fine-grained informational events that are
	// most useful to debug an application.
	public static final String LOG_LEVEL_DEBUG = "DEBUG";
	// Define for log level - Designates informational messages that highlight the
	// progress of the application at coarse-grained level.
	public static final String LOG_LEVEL_INFO = "INFO";
	// Define for log level - Designates potentially harmful situations.
	public static final String LOG_LEVEL_WARN = "WARN";
	// Define for log level - Designates error events that might still allow the
	// application to continue running.
	public static final String LOG_LEVEL_ERROR = "ERROR";
	// Define for log level - Designates very severe error events that will
	// presumably lead the application to abort.
	public static final String LOG_LEVEL_FATAL = "FATAL";
	// Define for log level - The highest possible rank and is intended to turn off
	// logging.
	public static final String LOG_LEVEL_OFF = "OFF";
	// Define for log level - Designates very severe error events that will
	// presumably lead the application to abort.
	public static final String LOG_LEVEL_TRACE = "TRACE";

	// Global Exception Message
	// Got exception
	public static final String CATCH_EXCEPTION_MSG = "Catch exception!";
	
	// Date check success message
	public static final int CHECK_WEATHER_SUCCESS = 10000;
	
	public static final int DATE_PARSE_EXCEPTION = 20001;
	public static final int DATE_NOT_AVAILABLE = 20002;
	public static final int OPEN_API_FAILED = 20003;
	
	
	// Date check failed message
	public static final String CHECKWEATHER_FAILED_MSG = "Weather check failed!";
	// Weather check success message
	public static final String CHECK_WEATHER_MSG = "Check weather successful!";

	// Global Exception Code
	// Runtime exception
	public static final int RUNTIME_EXCEPTION = 30001;
	// Null Pointer Exception
	public static final int NULL_POINTER_EXCEPTION = 30002;
	// Class Cast Exception
	public static final int CLASS_CAST_EXCEPTION = 30003;
	// IO Exception
	public static final int IO_EXCEPTION = 30004;
	// No Such Method Exception
	public static final int NO_SUCH_METHOD_EXCEPTION = 30005;
	// Index Out Of Bounds Exception
	public static final int INDEX_OUT_OF_BOUNDS_EXCEPTION = 30006;
	// Parse Exception
	public static final int PARSE_EXCEPTION = 30007;
	// Http Message Not Readable Exception
	public static final int HTTP_MESSAGE_NOT_READABLE_EXCEPTION = 30008;
	// Type Mismatch Exception
	public static final int TYPE_MISMATCH_EXCEPTION = 30009;
	// Missing Servlet Request Parameter Exception
	public static final int MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION = 30010;
	// Http Request Method Not Supported Exception
	public static final int HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION = 30011;
	// Http Media Type Not Acceptable Exception
	public static final int HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION = 30012;
	// Conversion Not Supported Exception
	public static final int CONVERSION_NOT_SUPPORTED_EXCEPTION = 30013;
	// Stack Overflow Error
	public static final int STACK_OVERFLOW_ERROR = 30014;
	// Exception
	public static final int EXCEPTION = 30015;
	// My Exception
	public static final int MY_EXCEPTION = 30016;
}
