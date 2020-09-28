package com.usedcars.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "_id", "name", "location", "cars" })
public class WareHouse { 

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    
	@JsonProperty("_id")
    @Column( name = "warehouse_id")
	private Long _id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("_id")
	public Long getId() {
		return _id;
	}
	@JsonProperty("_id")
	public void setId(Long id) {
		this._id = id;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}
	@JsonProperty("location")
	public void setLocation(Location location) {
		this.location = location;
	}
	@JsonProperty("cars")
	public Cars getCars() {
		return cars;
	}
	@JsonProperty("cars")
	public void setCars(Cars cars) {
		this.cars = cars;
	}

	@JsonProperty("location")
	@Embedded
   

	private Location location;
	@JsonProperty("cars")
	@Embedded
	private Cars cars;

    public WareHouse() {}
}