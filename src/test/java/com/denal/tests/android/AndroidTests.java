package com.denal.tests.android;

import com.codeborne.selenide.Condition;
import com.denal.tests.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

@Tag("android")
public class AndroidTests extends TestBase {

    @Test
    //Пример с урока
    void searchBrowserstackTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void checkOpenSettingsByNavigationTest() {
        step("Click on sidebar menu button", () -> {
            $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Click on Settings button", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });
        step("Check presence of Settings page", () -> {
            $(className("android.widget.TextView")).shouldHave(text("Settings"));
        });
    }
}
