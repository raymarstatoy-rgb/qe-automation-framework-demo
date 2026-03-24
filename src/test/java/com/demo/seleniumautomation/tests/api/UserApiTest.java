package com.demo.seleniumautomation.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {

    @Test
    public void getUsers_shouldReturn200 (){

        RestAssured.baseURI = "https://pokeapi.co";

        Response response = RestAssured
                .given()
                .when()
                .get("/api/v2/pokemon/gengar");

        Assert.assertEquals(
                response.getStatusCode(),200,"Expected HTTP Status Code is 200"
        );
    }
}
