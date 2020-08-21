package ru.invitro.loyalty.steps;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Shared;
import ru.invitro.loyalty.pages.SettingPage;

public class SettingSteps {

    SettingPage settingPage;

    @Shared
    AssertionSteps assertionSteps;

    @When("^Открываю Регион лояльности (.*)$")
    public void openRegionSetting(String value){
        settingPage.openRegionSetting(value);
    }

    @When("^Проверяю если (.*) отмечена чекбоксом на странице изменения региона лояльности, то блок (.*) слева в панеле навигации виден$")
    public void checkCheckBoxSettingRegion(String checkbox,String value){
        assertionSteps.softAssertIsTrue("Значения чакбокса и значения панели меню не совпадает",settingPage.comparisonkCheckBoxSettingRegion(checkbox,value));
    }

    @When("^Проверяю что на странице Настройка накопительных сумм в блоке Разрешенные типы собственности МО у поля (.*) (Отмечен|Не отмечен) чекбокс$")
    public void checkSettingSumm (String type, String value){
        switch (value) {
            case ("Отмечен"):
                assertionSteps.softAssertIsTrue("Чекбокс у поля " + type + " не отмечен", settingPage.checkSettingSumm(type));
                break;
            case ("Не отмечен"):
                assertionSteps.softAssertIsFalse("Чекбокс у поля " + type + " отмечен", settingPage.checkSettingSumm(type));
                break;
        }
    }

    @When("^На странице Настройка накопительных сумм в блоке Разрешенные типы собственности МО у поля (.*) нажимаю на чекбокс$")
    public void clickCheckBoxSettingSumm(String type){
        settingPage.clickCheckBoxSettingSumm(type);
    }

    @When("^На странице Настройка накопительных сумм нажимаю кнопку Сохранить$")
    public void clickSettingSummSaveButton(){
        settingPage.clickSettingSummSaveButton();
    }

}
