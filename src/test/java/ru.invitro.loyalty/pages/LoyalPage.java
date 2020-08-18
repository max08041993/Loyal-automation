package ru.invitro.loyalty.pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @FindBy(xpath = "//input[@type='search']")
    WebElementFacade cardQuery;

    @FindBy(xpath = "//input[@id='cardQuery']")
    WebElementFacade seachInInputAndButton;

    @FindBy(xpath = "//button[@type='submit']")
    WebElementFacade buttonSubmit;

    @FindBys({@FindBy(xpath = "//table[@id='DataTables_Table_0']/thead//th")}) //Названия столбцов в таблице Купонов
    List<WebElementFacade> columnsOnProducts;

    By entryTableRowsPath = By.xpath("//table[@id='DataTables_Table_0']/tbody/tr"); //таблицы результатов

    By entryTableCellsPath = By.xpath("./td/*"); // ячейки таблицы результатов

    @FindBy(xpath = "//li[@id='mainDataTable_next']/*")
    WebElementFacade buttonNext;

    By linkSeach = (By.xpath("./..//a"));

    @FindBys({@FindBy(xpath = "//div[@id='main']//thead//th")}) //Названия столбцов в таблице Тиражей
    List<WebElementFacade> columnsTiragOnProducts;

    By entryTiragTableRowsPath = By.xpath("//div[@id='main']//tbody/tr"); //Значение в таблице Тиражей

    By entryTiragTableCellsPath = By.xpath("./td"); // ячейки таблицы результатов


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
        waitABit(500);
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

    public void jsClick(WebElementFacade webElement) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", webElement);
    }

    private boolean elementInViewPort(WebElementFacade element) {
        Dimension screenSize = getDriver().manage().window().getSize();
        try {
            Long y = (Long) ((JavascriptExecutor) getDriver()).executeScript(
                    "var elem = arguments[0],                 " +
                            "  box = elem.getBoundingClientRect();    " +
                            "return box.top;                            "
                    , element);
            return y < screenSize.getHeight() - 200 && y > 200;
        } catch (ClassCastException e) {
            Double y = (Double) ((JavascriptExecutor) getDriver()).executeScript(
                    "var elem = arguments[0],                 " +
                            "  box = elem.getBoundingClientRect();    " +
                            "return box.top;                            "
                    , element);
            return y < screenSize.getHeight() - 200 && y > 200;
        }
    }

    public void scrollToElement(WebElementFacade element) {
        if (!elementInViewPort(element)) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
            scrollToElement(element, 0, -400);
        }
    }

    public void scrollToElement(WebElementFacade element, int x, int y) {
        if (!elementInViewPort(element)) {
            String code = "window.scroll(" + (element.getLocation().x + x) + ","
                    + (element.getLocation().y + y) + ");";
            ((JavascriptExecutor) getDriver()).executeScript(code, element, x, y);
        }
    }

    public boolean checkElementList(List<WebElementFacade> elementList, int checkCount) {
        int count = 0;
        waitABit(2000);
        while (true) {
            if (elementList.size() <= 0) {
                waitABit(1000);
                count++;
            } else {
                return true;
            }
            if (count >= checkCount) {
                return false;
            }
        }
    }

    public Boolean columnsOnTable(String ddButtons) {
        waitABit(350);
        Assert.assertTrue("Столбцы не обнаружены", checkElementList(columnsOnProducts, 3));
        for (WebElementFacade element : columnsOnProducts) {
            if (isDisplayed(element)) {
                if (element.getText().replaceAll("[\r\n]", " ").equals(ddButtons)) {
                    return isDisplayed(element);
                }
            }
        }
        return false;
    }

    public List<Map<String, WebElementFacade>> collectEntryTabe() {
        List<Map<String, WebElementFacade>> table = new ArrayList<>();
        List<String> tableHeaders = new ArrayList<>();
        for (WebElementFacade tableHeaderElement : columnsOnProducts) {
            if (tableHeaderElement.getText().equals(" ")) {
                tableHeaders.add("*");
            } else {
                tableHeaders.add(tableHeaderElement.getText().trim());
            }
        }
        for (WebElementFacade tableRowElement : findAll(entryTableRowsPath)) {
            List<WebElementFacade> cells = tableRowElement.thenFindAll(entryTableCellsPath);
            Map<String, WebElementFacade> row = new HashMap<>();
            for (int i = 0; i < cells.size(); i++) {
                row.put(tableHeaders.get(i), cells.get(i));
            }
            table.add(row);
        }
        return table;
    }

    public void openSend(String header, String value) {
        for (Map<String, WebElementFacade> tableRow : collectEntryTabe()) {
            Assert.assertTrue("Таблица не содержит столбец " + header, tableRow.containsKey(header));
            if (tableRow.get(header).getText().contains(value)) {
                WebElementFacade searchedElement = tableRow.get(header);
                searchedElement.waitUntilClickable().click();
                return;
            }
        }
        Assert.fail("В столбце " + header + " не найдено значение " + value);
    }

    public List<Map<String, WebElementFacade>> collectTiragEntryTabe() {
        List<Map<String, WebElementFacade>> table = new ArrayList<>();
        List<String> tableHeaders = new ArrayList<>();
        for (WebElementFacade tableHeaderElement : columnsTiragOnProducts) {
            if (tableHeaderElement.getText().equals(" ")) {
                tableHeaders.add("*");
            } else {
                tableHeaders.add(tableHeaderElement.getText().trim());
            }
        }
        for (WebElementFacade tableRowElement : findAll(entryTiragTableRowsPath)) {
            List<WebElementFacade> cells = tableRowElement.thenFindAll(entryTiragTableCellsPath);
            Map<String, WebElementFacade> row = new HashMap<>();
            for (int i = 0; i < cells.size(); i++) {
                row.put(tableHeaders.get(i), cells.get(i));
            }
            table.add(row);
        }
        return table;
    }

    public void sendAndOpenCuponStatus(String header, String value) {
        while (true) {
            for (Map<String, WebElementFacade> tableRow : collectTiragEntryTabe()) {
                if (tableRow.get(header).getText().contains(value)) {
                    WebElementFacade searchedElement = tableRow.get(header);
                    WebElementFacade clicSearchedElement = searchedElement.find(linkSeach);
                    clicSearchedElement.waitUntilClickable().click();
                    return;
                }
            }
                if (buttonNext.isClickable()) {
                    buttonNext.waitUntilClickable().click();
                } else {
                    break;
                }
        }
        Assert.fail("В столбце " + header + " не найдено значение " + value);

    }

    public void sendNumberCupon(String value) {
        seachInInputAndButton.click();
        seachInInputAndButton.clear();
        seachInInputAndButton.sendKeys(value);
        buttonSubmit.click();
    }

    public void sendNumberEditionCupon(String value) {
        cardQuery.click();
        cardQuery.clear();
        cardQuery.sendKeys(value);
    }

}
