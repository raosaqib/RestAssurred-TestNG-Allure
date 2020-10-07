package com.gk.openweather.station.service;

import static org.testng.Assert.assertEquals;
import org.apache.http.HttpStatus;

import com.gk.openweather.station.constatnts.Endpoints;
import com.gk.openweather.station.model.StationBody;
import com.gk.openweather.station.model.Station;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OpenMapsStationAPIHelper {
	/**
	 * Method is used for providing base url & relax for https.
	 */
	public OpenMapsStationAPIHelper() {
		RestAssured.baseURI = "http://api.openweathermap.org/data/3.0/stations";
		RestAssured.useRelaxedHTTPSValidation();
	}

	/**
	 * 
	 * @param appId
	 * @return RequestSpecification
	 * @step will help allure reporting purpose
	 */
	@Step()

	public RequestSpecification getRequest(String appId) {
		RequestSpecification response = RestAssured.given().contentType(ContentType.JSON).queryParams("APPID", appId)
				.log().all().when();
		return response;
	}

	/**
	 * 
	 * @param appId
	 * @return this metod returns response this will be used when user wants to get all the stations created APPID
	 */
	@Step()
	public Station getStations(String appId) {
		return getRequest(appId).get(Endpoints.GET_ALL_STATION).as(Station.class);

	}
/**
 * 
 * @param appId
 * @return Response- if user wants to extract response
 */
	@Step()
	public Response getStationsResponse(String appId) {
		return getRequest(appId).get(Endpoints.GET_ALL_STATION);
	}
	/**
	 * 
	 * @param appId
	 * @return status code of the request
	 */

	@Step()
	public int getStationsStatusCode(String appId) {
		return getStationsResponse(appId).statusCode();
	}
/**
 * 
 * @param appId
 * @param stationId
 * @return response of a specifc station
 */
	@Step()
	public int getSpecificStationStationResponse(String appId, String stationId) {
		return getRequest(appId).pathParams("ID", stationId).get(Endpoints.GET_SINGLE_STATION).statusCode();
	}
/**
 * 
 * @param appId
 * @return  response will be returned
 *  user need to create a station
 */
	@Step()
	public Response createStation(String appId) {
		StationBody opMapReqAddstation = createTestStation();
		Response resp = getRequest(appId).body(opMapReqAddstation).post(Endpoints.CREATE_STATION).andReturn();
		assertEquals(resp.getStatusCode(), HttpStatus.SC_CREATED, "created");
		return resp;
	}
/**
 * 
 * @param appId
 * @param stationId
 * @return 
 * delete operation for station API
 */
	@Step()
	public int deleteStation(String appId, String stationId) {
		return getRequest(appId).pathParams("ID", stationId).delete(Endpoints.DELETE_STATION).statusCode();
	}
	/**
	 * Pojo for passing the request body
	 * @return
	 */
	@Step()
	private StationBody createTestStation() {
		StationBody opMapReqAddstation = new StationBody();
		opMapReqAddstation.setExternalId("Testing from pojo");
		opMapReqAddstation.setName("global kin");
		opMapReqAddstation.setLatitude(37.76);
		opMapReqAddstation.setLongitude(32.1);
		opMapReqAddstation.setAltitude(122);
		return opMapReqAddstation;
	}

}
