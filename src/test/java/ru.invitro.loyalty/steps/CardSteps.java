package ru.invitro.loyalty.steps;

import cucumber.api.java.en.When;
import org.junit.Assert;
import ru.invitro.loyalty.pages.CardPage;

import java.util.List;

public class CardSteps {

    CardPage cardPage;

    @When("^Проверяю что в блоке Выбранные регионы, города и офисы присутствуют строки:$")
    public void checkListRegionSend(List<String> listsNames){
        for (String listNames : listsNames) {
            Assert.assertTrue("Отсутсвует строка " + listNames + " в блоке проверки Выбранных регионов", cardPage.checkListRegionSend(listNames));
        }
    }

}
