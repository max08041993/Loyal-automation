package ru.invitro.loyalty.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends LoyalPage{

    @FindBy(xpath = "//span[@class='text-danger']")
    WebElementFacade messageTextDanger;

    public boolean textDanger(String value){
        Assert.assertTrue("Предупреждение " + value + " не найдено", isDisplayed(messageTextDanger));
        if(messageTextDanger.getText().equals(value)){
            return true;
        }
        return false;
    }

}
