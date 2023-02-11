package com.denal.helpers;

import com.denal.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.denal.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserstackVideo {
    public static String getVideoUrl(String sessionId) {
        BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(config.login(), config.password())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
