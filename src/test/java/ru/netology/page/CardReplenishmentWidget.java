package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class CardReplenishmentWidget {

    private SelenideElement heading = $(withText("Пополнение карты"));
    private SelenideElement sumAmount = $("[data-test-id='amount'] input");
    private SelenideElement sumFrom = $("[data-test-id='from'] input");
    private SelenideElement buttonFrom = $("[data-test-id='action-transfer']");
    private SelenideElement cancelButton = $("[data-test-id=action-cancel]");
    private SelenideElement errorAmount = $("[data-test-id='error-notification']");

    public CardReplenishmentWidget() {
        heading.shouldBe(Condition.visible);
    }

    public DashboardPage transferForm(String sum, DataHelper.CardInfo CardInfo) {
        sumAmount.setValue(sum);
        sumFrom.setValue(String.valueOf(CardInfo));
        buttonFrom.click();
        return new DashboardPage();
    }

    public void getError() {
        errorAmount.shouldBe(Condition.visible);
    }

    public DashboardPage cancelButton() {
        cancelButton.click();
        return new DashboardPage();
    }
}

