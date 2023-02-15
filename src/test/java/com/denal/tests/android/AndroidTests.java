package com.denal.tests.android;

import com.denal.tests.TestBase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

@Tag("android")
public class AndroidTests extends TestBase {

    @Test
    void onboardingTest() {
        step("Open Wiki getting started page", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });
        step("Go to the next onboarding page - New ways to explore", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });
        step("Go to the next onboarding page - Reading lists with sync", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });
        step("Go to the next onboarding page - Send anonymous data", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
        step("Finish Wiki getting started", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
            $(id("org.wikipedia.alpha:id/main_toolbar_wordmark"))
                    .shouldBe(visible);
        });
    }

    @Test
        //Пример с урока
    void searchBrowserstackTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Disabled
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
