package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class PostsAssertionTest extends TestBase {
    static ValidatableResponse response;

    public PostsAssertionTest() {
        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 25)
                .when()
                .get("/posts")
                .then().statusCode(200);

    }

    @Test
    public void test001() {
        response.body("size", equalTo(25));
    }

    @Test
    public void test002() {
        response.body("find{it.id = 2322259}.title", equalTo("Astrum consequuntur voluptas carcer versus optio."));
    }

    @Test
    public void test003() {
        response.body("[8].user_id", equalTo(2322233));
    }

    @Test
    public void test004() {
        response.body("id", hasItems(39948, 39945, 39943));
    }

    public void test005() {
        response.body("find{it.user_id == 2322256}.body", equalTo("Termes trado et. Sulum coniuratio approbo. Caterva unde vinculum. Tabella aufero caecus. Ab deduco circumvenio. Carmen cubo thymbra. Eos ad quidem. Auctor facilis voluptatem. Comprehendo tenus utilis. Nemo artificiose quod. Cena sequi avoco. Supellex clamo angustus. Architecto arx bibo. Volo armo aut. Mollitia tamen stipes. Versus suppono absconditus."));
    }


}
