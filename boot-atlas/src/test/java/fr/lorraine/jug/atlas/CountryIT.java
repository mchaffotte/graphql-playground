package fr.lorraine.jug.atlas;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BootAtlasApplication.class)
public class CountryIT {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void crudCountry() throws JSONException, IOException {
        GraphQLResponse getResponse = graphQLTestTemplate.postForResource("getCountry.graphql");
        Assertions.assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        JSONAssert.assertEquals("{\n" +
                "  \"data\": {\n" +
                "    \"country\": {\n" +
                "      \"code\": \"FR\",\n" +
                "      \"name\": \"France\",\n" +
                "      \"capital\": \"Paris\"\n" +
                "    }\n" +
                "  }\n" +
                "}", getResponse.getRawResponse().getBody(), true);

        GraphQLResponse createResponse = graphQLTestTemplate.postForResource("createCountry.graphql");
        Assertions.assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        JSONAssert.assertEquals("{\n" +
                "  \"data\": {\n" +
                "    \"addCountry\": {\n" +
                "      \"name\": \"Brésil\",\n" +
                "      \"area\": 3300171\n" +
                "    }\n" +
                "  }\n" +
                "}", createResponse.getRawResponse().getBody(), true);

        GraphQLResponse deleteResponse = graphQLTestTemplate.postForResource("deleteCountry.graphql");
        Assertions.assertThat(deleteResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        JSONAssert.assertEquals("{\n" +
                "  \"data\": {\n" +
                "    \"deleteCountry\": true\n" +
                "  }\n" +
                "}", deleteResponse.getRawResponse().getBody(), true);
    }

}
