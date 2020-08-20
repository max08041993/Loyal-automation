package ru.invitro.loyalty.steps;

import cucumber.api.java.en.When;
import org.junit.Assert;
import ru.invitro.loyalty.pages.ContactPage;

public class ContactSteps {

    ContactPage contactPage;

    @When("^На странице Контакты ввожу в поле (.*) значение (.*)$")
    public void seachValueInPage (String type, String value){
        contactPage.seachValueInPage(type,value);
    }

    @When("^Проверяю что в таблице поиска в поле (.*) найдено значение (.*)$")
    public void seachValyeInTable(String Type, String value){
        Assert.assertTrue("В столбце " + Type + " не найдено значение " + value, contactPage.seachValyeInTable(Type,value));
    }

    @When("^Нажимаю Поиск$")
    public void sendSeach(){
        contactPage.sendSeach();
    }

    @When("Нажимаю Очистить")
    public void clickbuttonClear(){
        contactPage.clickbuttonClear();
    }

    @When("Проверяю что в таблице поиска отсутствуют данные")
    public void textNullTabl(){
        contactPage.textNullTabl();
    }

    @When("Отмечаю чекбокс Неактивные")
    public void clickcheckBoxNotActiv(){
        contactPage.clickcheckBoxNotActiv();
    }

}
