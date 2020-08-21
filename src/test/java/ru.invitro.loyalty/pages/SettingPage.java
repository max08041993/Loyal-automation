package ru.invitro.loyalty.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Shared;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.invitro.loyalty.steps.AssertionSteps;

import java.util.List;

public class SettingPage extends LoyalPage{

    @Shared
    AssertionSteps assertionSteps;

    @FindBys(@FindBy(xpath = "//table[@id='DataTables_Table_0']//td[@class='sorting_1']/a"))
    List<WebElementFacade> listRegionSetting;

    public void openRegionSetting(String value){
        for (WebElementFacade fullRerion : listRegionSetting) {
            if (fullRerion.getText().equals(value)) {
                fullRerion.click();
                return;
            }
        }
        Assert.fail("Региона " + value + " не существует");
    }

    @FindBys(@FindBy(xpath = "//div[@class='panel-heading']"))
    List<WebElementFacade> listNameSetting;

    By dostupInRegion = By.xpath("./..//label[.='Тип собственности']/..//button");

    private boolean checkCheckBoxSettingRegion(String checkbox) {
        for (WebElementFacade element : listNameSetting) {
            if (element.getText().replaceAll("[\r\n]", " ").contains(checkbox)) {
                if (element.findBy(dostupInRegion).getAttribute("class").equals("btn dropdown-toggle btn-default")) {
                    boolean valueChekBox = true;
                    return valueChekBox;
                }
            }
        }
        return false;
    }

     private boolean checkIsDisplayNameH4(String value) {
        for (WebElementFacade element : listFullNameDerictores) {
            if (element.getText().replaceAll("[\r\n]", " ").equals(value)) {
                boolean valueValue = true;
                    return valueValue;
            }
        }
        return false;
    }

    public boolean comparisonkCheckBoxSettingRegion(String checkbox, String value){
        boolean aaa = checkCheckBoxSettingRegion(checkbox);
        boolean bbb = checkIsDisplayNameH4(value);
        if(aaa==bbb){
            return true;
        }else
            return false;
    }

    @FindBys(@FindBy(xpath = "//div[@class='panel-body']//label"))
    List<WebElementFacade> listNameTypeSobstv;

    By inputCheckBox1NameSobstv = By.xpath("./following::input[1]");

    public boolean checkSettingSumm (String type){
        for (WebElementFacade element : listNameTypeSobstv) {
            if (element.getText().replaceAll("[\r\n]", " ").equals(type)) {
                WebElementFacade input = element.find(inputCheckBox1NameSobstv);
                boolean result = false;
                try {
                    if (input.getAttribute("checked").equals("true")){
                        result = true;
                    }
                } catch (Exception e) {}
                return result;
                }
            }
        return false;
    }

    By inputCheckBox2NameSobstv = By.xpath("./following::input[2]");

    public void clickCheckBoxSettingSumm (String type){
        for (WebElementFacade element : listNameTypeSobstv) {
            if (element.getText().replaceAll("[\r\n]", " ").equals(type)) {
                WebElementFacade input = element.find(inputCheckBox2NameSobstv);
                input.click();
                return;
            }
        }
        Assert.fail("Не найдено поле " + type);
    }

    @FindBy(xpath = "//button[@id='saveButton']")
    WebElementFacade buttonSave;

    public void clickSettingSummSaveButton(){
        waitABit(300);
        buttonSave.click();
        waitABit(300);
    }

}
