package ru.invitro.loyalty.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import ru.invitro.loyalty.pages.LoyalPage;

public class MainPageSteps {

    LoyalPage loyalPage;

    @Given("^Открываю страницу Loyal$")
    public void openMainPage() {
        loyalPage.open();
        loyalPage.openMainPage();
                try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^Жду (\\d+) (минут|секунд|милисекунд)[уы]*$")
    public void Wait(long time, String timeUnitName) {
        switch (timeUnitName) {
            case "минут":
                time = time * 60000;
                break;
            case "секунд":
                time = time * 1000;
                break;
            case "милисекунд":
                break;
        }
        loyalPage.waitSomeTime(time);
    }

    @Then("^Открываю в блоке (.*) страницу (.*)$")
    public void openDirectoriesName(String name, String value) {
        loyalPage.openDirectoriesName(name, value);
    }

    @When("^Выбираю регион (.*)$")
    public void ScriptRegionChange(String nameRegion){
        loyalPage.ScriptRegionChange(nameRegion);
    }

    @Then("^Проверяю что на странице отображается заголовок (.*)$")
    public void headerPage(String value) {
        Assert.assertEquals("Неверный заголовок. Ожидается: " + value + ". Отображается " + loyalPage.headerPage(), loyalPage.headerPage(), value);
    }

    @Then("^В таблице поиска в поле (.*) нажимаю на значение (.*)$")
    public void openSend(String type, String value){
        loyalPage.openSend(type,value);
    }


    @When("^Произвожу поиск по номеру Купона или Дисконтной карты (.*)$")
    public void sendNumberCupon(String value){
        loyalPage.sendNumberCupon(value);
    }





}