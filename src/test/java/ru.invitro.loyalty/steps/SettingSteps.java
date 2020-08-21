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
        //assertionSteps.softAssertIsTrue
        assertionSteps.softAssertIsTrue("Значения чакбокса и значения панели меню не совпадает",settingPage.comparisonkCheckBoxSettingRegion(checkbox,value));
    }

}
