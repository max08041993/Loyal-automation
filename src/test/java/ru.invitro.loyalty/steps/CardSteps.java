package ru.invitro.loyalty.steps;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Shared;
import ru.invitro.loyalty.pages.CardPage;

import java.util.List;

public class CardSteps {

    CardPage cardPage;

    @Shared
    AssertionSteps assertionSteps;

    @When("^Проверяю что в блоке Выбранные регионы, города и офисы присутствуют строки:$")
    public void checkListRegionSend(List<String> listsNames){
        for (String listNames : listsNames) {
            assertionSteps.softAssertIsTrue("Отсутсвует строка " + listNames + " в блоке проверки Выбранных регионов", cardPage.checkListRegionSend(listNames));
        }
    }

}
