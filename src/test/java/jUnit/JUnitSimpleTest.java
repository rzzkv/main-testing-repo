package jUnit;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class JUnitSimpleTest {


    @BeforeEach
    void setUp() {
        open("https://google.com");
    }

//  2 options  Parameterized Test, when you have several different parameters (array of arrays in this case)
// Option 1:
    @CsvSource({
            "Allure testops, https://qameta.io",
            "Selenide, https://selenide.org"
    })
// Option 2: Would be better to use when we have BigData
//    @CsvFileSource(resources = "/testData.csv")

    @ParameterizedTest(name = "Адрес {1} должен быть в выдаче гугла по запросу {0}")
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void productSiteUrlShouldBePresentInResultsOfSearchInGoggleByProductNameQuery(
            String productName,
            String productUrl
    ) {
        $("[name=q]").setValue(productName).pressEnter();
        $("[id=search]").shouldHave(text(productUrl));
    }

//  Parameterized Test, with one para meter
    @ValueSource(
            strings = {"Allure testops", "Selenide"}
    )
    @ParameterizedTest(name = "Адрес {1} должен быть в выдаче гугла по запросу {0}")
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void searchResultsCountTest(String productName) {
        $("[name=q]").setValue(productName).pressEnter();
        $$("div[class='g']").shouldHave(CollectionCondition.sizeGreaterThan(5));
    }
}