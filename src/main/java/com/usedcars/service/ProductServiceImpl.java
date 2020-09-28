package com.usedcars.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usedcars.exceptions.ApiExceptionHandler;
import com.usedcars.exceptions.ResourceNotFoundException;
import com.usedcars.model.Location;
import com.usedcars.model.Vehicles;
import com.usedcars.model.WareHouse;
import com.usedcars.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	@Autowired
	private ApiExceptionHandler apiExceptionHandler;
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Vehicles> getAllProducts() {
		String url = "https://api.jsonbin.io/b/5ebe673947a2266b1478d892";
		List<WareHouse> warehouseList = new ArrayList<>();
		List<Vehicles> vehicleList = new ArrayList<Vehicles>();
		try {
			ResponseEntity<List<WareHouse>> result = restTemplateBuilder.build().exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<WareHouse>>() {
					});

			warehouseList.addAll(result.getBody());
			save(warehouseList);

			warehouseList.stream().forEach(w -> w.getCars().getVehicles().stream()
					.forEach(v -> setVehicleWareHouseInfo(v, w.getName(), w.getLocation())));
			warehouseList.stream().forEach(w -> vehicleList.addAll(w.getCars().getVehicles()));
			vehicleList.sort((d1, d2) -> d2.getDateAdded().compareTo(d1.getDateAdded()));
		} catch (ConstraintViolationException constraintViolationException) {
			apiExceptionHandler.handle(constraintViolationException);
		} catch (ResourceNotFoundException resourceNotFoundException) {
			apiExceptionHandler.handle(resourceNotFoundException);

		}
		return vehicleList;
	}

	public void setVehicleWareHouseInfo(Vehicles vehicles, String wareHouseName, Location location) {
		vehicles.setWareHouseName(wareHouseName);
		vehicles.setWarehouseLatitude(location.getLat());
		vehicles.setWarehouseLongitude(location.get_long());

	}

	@Override
	public Iterable<WareHouse> save(List<WareHouse> wareHouse) {
		return productRepository.saveAll(wareHouse);
	}

}