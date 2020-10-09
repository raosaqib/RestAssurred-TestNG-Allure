package com.gk.openweather.station.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gk.openweather.station.service.OpenMapsStationAPIHelper;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class OpenweatherTestRunnerE2E{
	private OpenMapsStationAPIHelper openWeatherMapsAPI;

	JSONObject stationWeatherMapApiParams;

	static String latestCreatedStation;

	@BeforeClass
	public void init() throws IOException {
		openWeatherMapsAPI = new OpenMapsStationAPIHelper();
		InputStream details = null;

		try {
			String dataFileName = "configFile/WeatherMapStationsData.json";
			details = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(details);
			stationWeatherMapApiParams = new JSONObject(tokener);
		}

		catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (details != null) {
				details.close();
			}
		}
	}

	@Test(description = "Validate user is able to create station", priority = 10)
	@Severity(SeverityLevel.BLOCKER)
	public void validateUserShouldableToCreatStation() {
		String appId = stationWeatherMapApiParams.getJSONObject("validAppId").getString("appid");

		latestCreatedStation = openWeatherMapsAPI.createStation(appId).jsonPath().getString("ID");
		int statuscode = openWeatherMapsAPI.createStation(appId).getStatusCode();
		Assert.assertEquals(statuscode, HttpStatus.SC_CREATED, "user is able to create station successfully");
		System.out.println("stattion got created with the number =>>" + latestCreatedStation);

	}

	@Test(description = "validate user is able to delete the latest station id created", dependsOnMethods = "validateUserShouldableToCreatStation", priority = 20)
	@Severity(SeverityLevel.CRITICAL)
	public void validateUserIsAbleToDeleteStation() {
		String appid = stationWeatherMapApiParams.getJSONObject("validAppId").getString("appid");
		int statusCode = openWeatherMapsAPI.deleteStation(appid, latestCreatedStation);
		Assert.assertEquals(statusCode, 204, "user should get statuc code as 204");
		Assert.assertEquals(statusCode, HttpStatus.SC_NO_CONTENT, "user should get statuc code as 204");

		System.out.println("print status code for delete" + statusCode);
	}

	@Test(description = "Validate user is able to run request upon providing a specific station id as a path param user should get status code 200", priority = 30)
	@Severity(SeverityLevel.CRITICAL)
	public void ValidateUserIsAbleToRunTherequestandGetsSuccessStatusCode() {

		String appid = stationWeatherMapApiParams.getJSONObject("validAppId").getString("appid");
		String mapstation = stationWeatherMapApiParams.getJSONObject("stationId").getString("mapStationId");
		int stauscode = openWeatherMapsAPI.getSpecificStationStationResponse(appid, mapstation);

		Assert.assertEquals(stauscode, HttpStatus.SC_OK, "status should display ok 200");

	}

	@Test(description = "Validate get station request is returning correct status code", priority = 40)
	@Severity(SeverityLevel.NORMAL)
	public void validateStatusCode() {
		String appId = stationWeatherMapApiParams.getJSONObject("validAppId").getString("appid");
		int statusCode = openWeatherMapsAPI.getStationsStatusCode(appId);
		Assert.assertEquals(statusCode, HttpStatus.SC_OK, "Request executed successfully");
	}

	@Test(description = "Validate user is able to run request upon providing a specific station id", priority = 50)
	@Severity(SeverityLevel.TRIVIAL)
	public void validateSpecificStationByStationIdSuccess() {
		String appid = stationWeatherMapApiParams.getJSONObject("validAppId").getString("appid");
		String validStationId = stationWeatherMapApiParams.getJSONObject("stationId").getString("mapStationId");
		int stauscode = openWeatherMapsAPI.getSpecificStationStationResponse(appid, validStationId);
		Assert.assertEquals(stauscode, HttpStatus.SC_OK, "User should get message for not found");
	}

	@Test(description = "Validate user gets BAD Request response code upon providing wrong stationId", priority = 50)
	@Severity(SeverityLevel.MINOR)
	public void validateSpecificStationByStationIdWrongStatId() {
		String appid = stationWeatherMapApiParams.getJSONObject("validAppId").getString("appid");
		int stauscode = openWeatherMapsAPI.getSpecificStationStationResponse(appid, "5f78971bcca8ce0001ef6131x");

		Assert.assertEquals(stauscode, HttpStatus.SC_BAD_REQUEST, "User gets Bad Request status code-400");

	}

	@Test(description = "Negative test--Validate upon passing a null value user shouldn't get success code", dependsOnMethods = "validateUserIsAbleToDeleteStation", priority = 50)
	@Severity(SeverityLevel.MINOR)
	public void validateSpecificStationByStationIdWrongStatIdRespValid() {
		String appid = stationWeatherMapApiParams.getJSONObject("validAppId").getString("appid");
		int stauscode = openWeatherMapsAPI.getSpecificStationStationResponse(appid, latestCreatedStation);

		Assert.assertEquals(stauscode, HttpStatus.SC_OK, "User gets Bad Request status code-404");

	}
}
