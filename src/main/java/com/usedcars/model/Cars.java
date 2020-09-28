package com.usedcars.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "location", "vehicles" })

public class Cars {

	@JsonProperty("location")
	@Column(name = "car_location")
	private String location;

	@JsonProperty("vehicles")
	@Embedded
	@ElementCollection  
	@JoinColumn( name = "vehicle_id") 
    private List<Vehicles> vehicles=new ArrayList<Vehicles>();  

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	@JsonProperty("vehicles")
	public List<Vehicles> getVehicles() {
		return vehicles;
	}

	@JsonProperty("vehicles")
	public void setVehicles(List<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}

	public Cars() {
	}
}
