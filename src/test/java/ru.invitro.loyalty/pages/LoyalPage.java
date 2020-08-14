package ru.invitro.loyalty.pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class LoyalPage extends PageObject {

    @FindBy(xpath = "//h2")
    WebElementFacade headerPage;

    @FindBy(xpath = "//button[@data-id='CountryNavigation']")
    WebElementFacade CountryNavigation;

    @FindBys({@FindBy(xpath = "//ul[@class='nav navbar-nav']//div[@class='dropdown-menu open']//li")})
    List<WebElementFacade> listFullNameRegions;

    By region = By.xpath(".//a");

    @FindBys({@FindBy(xpath = "//div[@class='left-menu']/h4")})
    List<WebElementFacade> listFullNameDerictores;

    @FindBy(xpath = "//div[@style='display: block;']")
    WebElementFacade blockDisplay;

    By directoryMenuPath = By.xpath("./following::ul[1]/li/a");


    public void waitSomeTime(long time) {
        waitABit(time);

    }

    public void openMainPage() {
        WebDriver driver = this.getDriver();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
        setDriver(driver);
        openUrl("https://manage-loyalty.invitro.ru/");
    }

    public void openDirectoriesName(String name, String value) {
        for (WebElementFacade medInfoRow : listFullNameDerictores) {
            if (medInfoRow.getText().replaceAll("[\r\n]", " ").equals(name)) {
                List<WebElementFacade> directoryMenu = medInfoRow.thenFindAll(directoryMenuPath);
                for (WebElementFacade menuItem : directoryMenu) {
                    if (menuItem.getText().replaceAll("[\r\n]", " ").equals(value)) {
                        menuItem.waitUntilClickable().click();
                        blockDisplay.waitUntilNotVisible();
                        waitABit(500);
                        return;
                    }
                }
                Assert.fail("На странице нет подраздела " + value);
            }
        }
        Assert.fail("На странице нет раздела " + name);
    }

    public void ScriptRegionChange(String nameRegion) {
        CountryNavigation.click();
        waitABit(1000);
        for (WebElementFacade fullRerion : listFullNameRegions) {
            if (fullRerion.getText().replaceAll("[\r\n]", " ").equals(nameRegion)) {
                WebElementFacade oneRegion = fullRerion.find(region);
                oneRegion.click();
                return;
            }
        }
            Assert.fail("Региона " + nameRegion + " не существует");
        }

    public void scrollToUp() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0)");
    }

    public void scrollToDown() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isDisplayed(WebElementFacade element) {
        try {
            return element.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public String headerPage() {
        isDisplayed(headerPage);
        return headerPage.getText();
    }



}
