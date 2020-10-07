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
	"id",
	"created_at",
	"updated_at",
	"external_id",
	"name",
	"longitude",
	"latitude",
	"altitude",
	"rank",
	"source_type"
	})
	public class Station {

	@JsonProperty("id")
	private String id;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("external_id")
	private String externalId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("altitude")
	private Integer altitude;
	@JsonProperty("rank")
	private Integer rank;
	@JsonProperty("source_type")
	private Integer sourceType;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
	return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
	this.id = id;
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
	return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
	return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
	}

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

	@JsonProperty("longitude")
	public Double getLongitude() {
	return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
	this.longitude = longitude;
	}

	@JsonProperty("latitude")
	public Double getLatitude() {
	return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
	this.latitude = latitude;
	}

	@JsonProperty("altitude")
	public Integer getAltitude() {
	return altitude;
	}

	@JsonProperty("altitude")
	public void setAltitude(Integer altitude) {
	this.altitude = altitude;
	}

	@JsonProperty("rank")
	public Integer getRank() {
	return rank;
	}

	@JsonProperty("rank")
	public void setRank(Integer rank) {
	this.rank = rank;
	}
	@JsonProperty("source_type")
	public Integer getSourceType() {
	return sourceType;
	}

	@JsonProperty("source_type")
	public void setSourceType(Integer sourceType) {
	this.sourceType = sourceType;
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


