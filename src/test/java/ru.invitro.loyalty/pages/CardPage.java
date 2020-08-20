package ru.invitro.loyalty.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CardPage extends LoyalPage{

    @FindBys(@FindBy(xpath = "//div[@id='ClonedTree']//li"))
    List<WebElementFacade> ListRegionSend;

    @FindBys(@FindBy(xpath = "//div[@id='ClonedTree']//li//span[@class='icon expand-icon glyphicon glyphicon-plus']"))
    List<WebElementFacade> ListIconPlus;

    public boolean checkListRegionSend (String listOjid){
    waitABit(700);
        for (WebElementFacade element : ListIconPlus) {
            if (element.isVisible()) {
                element.click();
            }
        }
        Assert.assertTrue("Блок Проверки правила не видим", checkElementList(ListRegionSend, 3));
        for (WebElementFacade element : ListRegionSend) {
        if (element.getText().contains(listOjid)) {
            return true;
        }
    }
        return false;
}




}
