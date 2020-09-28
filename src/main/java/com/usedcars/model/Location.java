package com.usedcars.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "lat", "long" })
public class Location {
	@Column(name = "warehouse_location_latitude")
	@JsonProperty("lat")
	private String lat;

	@JsonProperty("lat")
	public String getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(String lat) {
		this.lat = lat;
	}

	@JsonProperty("long")
	public String get_long() {
		return _long;
	}

	@JsonProperty("long")
	public void set_long(String _long) {
		this._long = _long;
	}

	@Column(name = "warehouse_location_longitude")

	@JsonProperty("long")
	private String _long;

	public Location() {
	}
}
