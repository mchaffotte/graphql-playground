package fr.lorraine.jug.atlas;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CountryIT {

    @Test
    public void crudCountry() {
        given()
            .contentType("application/json")
            .body("{\"query\":\"{\\n    country(code: \\\"FR\\\") {\\n        code\\n        name\\n        capital\\n    }\\n}\\n\",\"variables\":null}")
        .when()
            .post("/graphql")
        .then()
            .statusCode(200)
            .body("data.country.code", Matchers.equalTo("FR"))
            .body("data.country.capital", Matchers.equalTo("Paris"));

        given()
            .contentType("application/json")
            .body("{\"query\":\"mutation {\\n    addCountry(country: {code: \\\"BR\\\", name: \\\"Brésil\\\", capital:\\\"Brasilia\\\", area: 8547404}) {\\n        name\\n        area(unit: SQUARE_MILE)\\n    }\\n}\",\"variables\":null}")
        .when()
            .post("/graphql")
        .then()
            .statusCode(200)
            .body("data.addCountry.name", Matchers.equalTo("Brésil"))
            .body("data.addCountry.area", Matchers.equalTo(3300171));

        given()
            .contentType("application/json")
            .body("{\"query\":\"mutation {\\n    deleteCountry(code: \\\"BR\\\")\\n}\",\"variables\":null}")
        .when()
            .post("/graphql")
        .then()
            .statusCode(200)
            .body("data.deleteCountry", Matchers.equalTo(true));
    }

}
