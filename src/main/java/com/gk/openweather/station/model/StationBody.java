package com.gk.openweather.station.model;


	import java.util.HashMap;
	import java.util.Map;
	import com.fasterxml.jackson.annotation.JsonAnyGetter;
	import com.fasterxml.jackson.annotation.JsonAnySetter;
	import com.fasterxml.jackson.annotation.JsonIgnore;
	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"external_id",
	"name",
	"latitude",
	"longitude",
	"altitude"
	})
	public class StationBody {

	@JsonProperty("external_id")
	private String externalId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("altitude")
	private Integer altitude;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("external_id")
	public String getExternalId() {
	return externalId;
	}

	@JsonProperty("external_id")
	public void setExternalId(String externalId) {
	this.externalId = externalId;
	}

	@JsonProperty("name")
	public String getName() {
	return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
	this.name = name;
	}

	@JsonProperty("latitude")
	public Double getLatitude() {
	return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
	this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public Double getLongitude() {
	return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
	this.longitude = longitude;
	}

	@JsonProperty("altitude")
	public Integer getAltitude() {
	return altitude;
	}

	@JsonProperty("altitude")
	public void setAltitude(Integer altitude) {
	this.altitude = altitude;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	}


