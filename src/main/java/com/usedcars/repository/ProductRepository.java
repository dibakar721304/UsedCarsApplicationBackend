package com.usedcars.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.usedcars.model.WareHouse;

@Repository
public interface ProductRepository extends CrudRepository<WareHouse, Long> {

	void save(List<WareHouse> wareHouse);
}
