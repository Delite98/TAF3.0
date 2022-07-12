package java.api;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import java.helpers.ProjectHelper;
import java.models.Project;
import java.models.ProjectType;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    public Project expectedProject;
    public ProjectHelper projectHelper;

    @BeforeTest
    public void setupEnv() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        expectedProject = Project.builder()
                .name("WP_Test_03")
                .typeOfProject(ProjectType.MULTIPLE_SUITE_MODE)
                .build();

        projectHelper = new ProjectHelper();
    }
}
