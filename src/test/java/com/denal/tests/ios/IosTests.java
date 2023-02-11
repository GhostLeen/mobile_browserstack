package com.denal.tests.ios;


import com.denal.tests.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;

@Tag("ios")
public class IosTests extends TestBase {

    @Test
    void checkEqualsInputAndOutputTextTest() {

        String inputText = "IOS test";

        step("Click 'Text' Button", () ->
            $(id("Text Button")).click()
        );

        step("Check output text", () ->
            assertEquals("Waiting for text input.", $(id("Text Output")).getText())
        );

        step(format("Enter value %s in the input field and press enter", inputText), () -> {
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys(inputText);
            $(id("Text Input")).pressEnter();
        });

        step("Check if output text equals to text from previous step", () ->
            assertEquals(inputText, $(id("Text Output")).getText())
        );
    }
}
