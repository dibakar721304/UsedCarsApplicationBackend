package com.usedcars.model;

import java.util.Date;

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
@JsonPropertyOrder({ "_id", "make", "model", "year_model", "price", "licensed", "date_added","warehouse_name","warehouse_longitude","warehouse_latitude"})
public class Vehicles {
	
	@JsonProperty("warehouse_latitude")
	private String WarehouseLatitude;
	@JsonProperty("warehouse_longitude")
	private String WarehouseLongitude;
	@JsonProperty("warehouse_name")
	private String wareHouseName;

	@JsonProperty("warehouse_latitude")

	public String getWarehouseLatitude() {
		return WarehouseLatitude;
	}

	@JsonProperty("warehouse_latitude")

	public void setWarehouseLatitude(String warehouseLatitude) {
		WarehouseLatitude = warehouseLatitude;
	}

	@JsonProperty("warehouse_longitude")

	public String getWarehouseLongitude() {
		return WarehouseLongitude;
	}

	@JsonProperty("warehouse_longitude")

	public void setWarehouseLongitude(String warehouseLongitude) {
		WarehouseLongitude = warehouseLongitude;
	}

	@JsonProperty("warehouse_name")

	public String getWareHouseName() {
		return wareHouseName;
	}

	@JsonProperty("warehouse_name")

	public void setWareHouseName(String wareHouseName) {
		this.wareHouseName = wareHouseName;
	}
	@JsonProperty("_id")
	@Column(name = "vehicle_id")
	private Integer id;
	@JsonProperty("make")
	private String make;
	@JsonProperty("model")
	private String model;
	@JsonProperty("year_model")
	private Integer yearModel;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("licensed")
	private Boolean licensed;
	@JsonProperty("date_added")
	private Date dateAdded;

	@JsonProperty("_id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("_id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("make")
	public String getMake() {
		return make;
	}

	@JsonProperty("make")
	public void setMake(String make) {
		this.make = make;
	}

	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	@JsonProperty("model")
	public void setModel(String model) {
		this.model = model;
	}

	@JsonProperty("year_model")
	public Integer getYearModel() {
		return yearModel;
	}

	@JsonProperty("year_model")
	public void setYearModel(Integer yearModel) {
		this.yearModel = yearModel;
	}

	@JsonProperty("price")
	public Double getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonProperty("licensed")
	public Boolean getLicensed() {
		return licensed;
	}

	@JsonProperty("licensed")
	public void setLicensed(Boolean licensed) {
		this.licensed = licensed;
	}

	@JsonProperty("date_added")
	public Date getDateAdded() {
		return dateAdded;
	}

	@JsonProperty("date_added")
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Vehicles() {
	}
}