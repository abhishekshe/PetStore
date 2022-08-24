package com.bridgelabz.petstoreassuretesting;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestingRestAssuredUser {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void acreateUser() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"abhishek\",\n" +
                        "  \"firstName\": \"Abhishek\",\n" +
                        "  \"lastName\": \"Narwariya\",\n" +
                        "  \"email\": \"abhishek123@gmail.com\",\n" +
                        "  \"password\": \"abhishek@123\",\n" +
                        "  \"phone\": \"7876798765\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        Assertions.assertEquals(200,response.statusCode());

    }
    @Test
    public void bgetUserByUserName() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/abhishek\n");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void cupdatedUser() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"krishna\",\n" +
                        "  \"firstName\": \"Krishna\",\n" +
                        "  \"lastName\": \"Ldohi\",\n" +
                        "  \"email\": \"krishna123@gmail.com\",\n" +
                        "  \"password\": \"Krishna@123\",\n" +
                        "  \"phone\": \"7689879608\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/abhishek");
        response.prettyPrint();
        Assertions.assertEquals(200,response.statusCode());
    }

    @Test
    public void deleteUser() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete("https://petstore.swagger.io/v2/user/abhishek");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void ecreateWithList() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 0,\n" +
                        "    \"username\": \"anup\",\n" +
                        "    \"firstName\": \"Anup\",\n" +
                        "    \"lastName\": \"Sharma\",\n" +
                        "    \"email\": \"anup123@gmail.com\",\n" +
                        "    \"password\": \"Anup@123\",\n" +
                        "    \"phone\": \"8756779456\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithList");
        response.prettyPrint();
        Assertions.assertEquals(200,response.statusCode());
    }

}
