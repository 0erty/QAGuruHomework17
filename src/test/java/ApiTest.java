import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;

public class ApiTest {
    @Test
    public void getListUser() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("total", is(12));
    }

    @Test
    public void postCreateUser() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"morpheus\", \"job\": \"leader\" }")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .body("name", is("morpheus"));
    }

    @Test
    public void putUpdateUser() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"morpheus\", \"job\": \"zion resident\" }")
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("job", is("zion resident"));
    }

    @Test
    public void patchUpdateUser() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"morpheus\", \"job\": \"zion resident\" }")
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("job", is("zion resident"));
    }

    @Test
    public void deleteUser() {
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);
    }
}
