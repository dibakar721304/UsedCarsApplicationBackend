package com.usedcars.ucars;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.usedcars.controller.ProductController;
import com.usedcars.model.Vehicles;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UcarsApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UcarsApplicationIntegrationTest {

    @Autowired private TestRestTemplate restTemplate;

    @LocalServerPort private int port;

    @Autowired private ProductController productController;


    @Test
    public void contextLoads() {
        Assertions
          .assertThat(productController)
          .isNotNull();

    }

    @Test
    public void givenGetProductsApiCall_whenProductListRetrieved_thenSizeMatchAndListContainsProductNames() {
        ResponseEntity<List<Vehicles>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/vehicles", HttpMethod.GET, null, new ParameterizedTypeReference<List<Vehicles>>() {
        });
        List<Vehicles> vehicles = responseEntity.getBody();
        Assertions
          .assertThat(vehicles)
          .hasSize(80);

    }

}
