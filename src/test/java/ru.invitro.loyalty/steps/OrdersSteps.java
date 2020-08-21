package ru.invitro.loyalty.steps;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Shared;
import ru.invitro.loyalty.pages.ContactPage;
import ru.invitro.loyalty.pages.OrdersPage;

public class OrdersSteps {

    ContactPage contactPage;
    OrdersPage ordersPage;
    @Shared
    AssertionSteps assertionSteps;

    @When("^На странице Заказы ввожу в поле (.*) значение (.*)$")
    public void seachValueInPage (String type, String value){
        contactPage.seachValueInPage(type,value);
    }

    @When("^Проверяю что вышло передупреждение (.*)$")
    public void textDanger(String value){
        assertionSteps.softAssertIsTrue("Сообщение " + value + " не найдено", ordersPage.textDanger(value));
    }

}
