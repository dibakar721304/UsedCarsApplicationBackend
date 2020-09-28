package com.usedcars.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.usedcars.model.Vehicles;
import com.usedcars.model.WareHouse;

@Validated
public interface ProductService {

	@NotNull
	List<Vehicles> getAllProducts();


	Iterable<WareHouse> save(List<WareHouse> wareHouse);
}