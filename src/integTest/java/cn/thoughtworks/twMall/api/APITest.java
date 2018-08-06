package cn.thoughtworks.twMall.api;

import cn.thoughtworks.twMall.TWMallApplication;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@DBRider
@DBUnit(caseSensitiveTableNames = true, escapePattern = "`")
public class APITest {

    @LocalServerPort
    private int port;

    @Test
    @DataSet("orders.yml")
    public void should_return_order() {
        RestAssured
            .given()
                .port(port)
            .when()
                .get("/orders")
            .then()
                .statusCode(200)
                .body("size()", is(3));
    }
}
