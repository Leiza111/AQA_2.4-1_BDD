package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement cardFirst = $$(".list__item").first();
    private SelenideElement cardSecond = $$(".list__item").last();;
    private SelenideElement reload = $("[data-test-id=action-reload]");
    private final SelenideElement cardFirstButton = $$("[data-test-id=action-deposit]").first();
    private final SelenideElement cardSecondButton = $$("[data-test-id=action-deposit]").last();

    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public CardReplenishmentWidget firstCardButton() {
        cardFirstButton.click();
        return new CardReplenishmentWidget();
    }

    public CardReplenishmentWidget secondCardButton() {
        cardSecondButton.click();
        return new CardReplenishmentWidget();
    }

    public int getFirstCardBalance() {
        val text = cardFirst.text();
        return extractBalanceCard(text);
    }
    public int getSecondCardBalance() {
        val text = cardSecond.text();
        return extractBalanceCard(text);
    }
    private int extractBalanceCard(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
   }
}


