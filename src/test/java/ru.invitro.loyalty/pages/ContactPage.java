package ru.invitro.loyalty.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactPage extends LoyalPage {

    @FindBys(@FindBy(xpath = "//div[@id='requestBox']//label"))
    List<WebElementFacade> listLabelSeach;

    By inputSeach = By.xpath("./following::input");

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElementFacade checkBoxNotActiv;

    @FindBy(xpath = "//td[.='В таблице отсутствуют данные']")
    WebElementFacade textNullTabl;

    public void sendSeach(){
        buttonSubmit.click();
    }

    @FindBy(xpath = "//a[@role='button']")
    WebElementFacade buttonClear;

    public void seachValueInPage(String type, String value){
        for (WebElementFacade fullName : listLabelSeach) {
            if (fullName.getText().replaceAll("[\r\n]", " ").equals(type)) {
                WebElementFacade sendCardInInput = fullName.findBy(inputSeach);
                scrollToElement(sendCardInInput);
                sendCardInInput.clear();
                sendCardInInput.click();
                sendCardInInput.sendKeys(value);
                return;
            }
        }
        Assert.fail("Не найдено поле " + type);
    }

    public List<Map<String, WebElementFacade>> collectContactTabe() {
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
            List<WebElementFacade> cells = tableRowElement.thenFindAll(entryTiragTableCellsPath);
            Map<String, WebElementFacade> row = new HashMap<>();
            for (int i = 0; i < cells.size(); i++) {
                row.put(tableHeaders.get(i), cells.get(i));
            }
            table.add(row);
        }
        return table;
    }

    public boolean seachValyeInTable(String header, String value) {
        for (Map<String, WebElementFacade> tableRow : collectContactTabe()) {
            Assert.assertTrue("Таблица не содержит столбец " + header, tableRow.containsKey(header));
            if (tableRow.get(header).getText().replaceAll("[\r\n]", " ").equals(value)) {
                return true;
            }
        }
        Assert.fail("В столбце " + header + " не найдено значение " + value);
        return false;
    }

    public void clickbuttonClear(){
        buttonClear.click();
    }

    public void textNullTabl(){
        isDisplayed(textNullTabl);
    }


    public void clickcheckBoxNotActiv(){
        checkBoxNotActiv.click();
    }

}
