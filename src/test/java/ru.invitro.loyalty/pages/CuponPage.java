package ru.invitro.loyalty.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CuponPage extends LoyalPage {

    @FindBy(xpath = "//a[.='Создать']")
    WebElementFacade сreate;

    @FindBy(xpath = "//div[@class='geography-fog']")
    WebElementFacade blockGeograf;

    @FindBys({@FindBy(xpath = "//form[@id='CouponForm']/div[not(contains(@class,'hidden'))]//label")})
    List<WebElementFacade> listFullNameInputCupon;

    By inputNameInputCupon = By.xpath("./../descendant::div[contains(@class,'col-md')][1]//*[@name][@id]");

    By oneNamesVerySelectCupon = By.xpath("./following::ul[@aria-expanded='true']//span[1]");
    By oneNameSelectCupon = By.xpath("./following::span[@class='filter-option pull-left']");

    @FindBy(xpath = "//input[@id='TreeSearch']")
    WebElementFacade inputSendRegion;

    @FindBy(xpath = "//button[@id='ExecuteSearch']")
    WebElementFacade buttonSeachRegion;

    @FindBy(xpath = "//span[@class='seekerHighlight active']/../span[@class='icon check-icon glyphicon glyphicon-unchecked']")
    WebElementFacade checkSeachRegion;

    @FindBys({@FindBy(xpath = "//div[@class='form-group col-md-12 pt-sm']/label")})
    List<WebElementFacade> listFullNameSelectParam;

    By buttonSelectNameParam = By.xpath("./following::button[1]");

    @FindBys({@FindBy(xpath = "//ul[@class='dropdown-menu inner'][@aria-expanded='true']/li")}) // меню выбора параметров в полях выбора
    List<WebElementFacade> dropdownSelectMenu;

    @FindBy(xpath = "//select[@id='Mode']")
    WebElementFacade selectTypePravil;

    @FindBys({@FindBy(xpath = "//select[@id='Mode']")})
    List<WebElementFacade> listNamesTypePravilParam;

    @FindBys({@FindBy(xpath = "//div[contains(text(),'Добавить вхождение:')]/button")}) // меню выбора параметров в полях выбора
    List<WebElementFacade> ParamEntry;

    @FindBys({@FindBy(xpath = "//div[contains(text(),'Добавить исключение:')]/button")}) // меню выбора параметров в полях выбора
    List<WebElementFacade> ParameEception;

    @FindBy(xpath = "//textarea[@id='block-reason']")
    WebElementFacade inputPrichina;

    @FindBy(xpath = "//div[@class='modal-footer']/button[.='Заблокировать']")
    WebElementFacade buttonModalBlock;

    @FindBys(@FindBy(xpath = "//div[@id='includedItems']//div[@class='text-muted item-description']/span"))
    List<WebElementFacade> nameLispAddProduct;

    @FindBys(@FindBy(xpath = "//div[@id='excludedItems']//div[@class='text-muted item-description']/span"))
    List<WebElementFacade> nameLispNotProduct;

    By buttonListProduct = By.xpath("./../following-sibling::*//button[@type='button'][@data-toggle]");

    By inputElementProduct = By.xpath("./../following-sibling::*//button[@type='button'][@data-toggle][@aria-expanded='true']/..//input");

    By seachElement = By.xpath("./../following-sibling::*//ul[@aria-expanded='true']//li[not(contains(@class,'hidden'))][@data-original-index='1']");

    @FindBy(xpath = "//div[@id='includedItems']//button[.='Добавить']")
    WebElementFacade buttonAddSpisEnty;

    @FindBy(xpath = "//div[@id='excludedItems']//button[.='Добавить']")
    WebElementFacade buttonAddSpisIskl;

    @FindBys(@FindBy(xpath = "//div[@class='col-sm-6 pl0 pr0']//table[@class='item-contents']//div"))
    List<WebElementFacade> listAddNames;

    @FindBys(@FindBy(xpath = "//div[@class='col-sm-6 bl pl0 pr0']//table[@class='item-contents']//div"))
    List<WebElementFacade> listNotNames;

    @FindBys(@FindBy(xpath = "//div[@class='panel panel-default']//button[@type='button']"))
    List<WebElementFacade> listFullNameButton;

    @FindBys(@FindBy(xpath = "//div[@class='panel panel-default']//label[.='Данные купона']/following::*//table//td"))
    List<WebElementFacade> listFullTdInCupon;


    public void clickCreate() {
        jsClick(сreate);
        blockGeograf.waitUntilNotVisible();
        return;
    }

    //    By listFullNameInputCuponPath = By.xpath("//form[@id='CouponForm']/div[not(contains(@class,'hidden'))]//label");

    public void sendValueCupons(String fieldName, String value) {
//        List<WebElementFacade> listFullNameInputCupon = findAll(listFullNameInputCuponPath);
        for (WebElementFacade fullName : listFullNameInputCupon) {
            if (fullName.getText().equals(fieldName)) {
                WebElementFacade sendCardInInput = fullName.findBy(inputNameInputCupon);
                scrollToElement(sendCardInInput);
                sendCardInInput.clear();
                sendCardInInput.click();
                sendCardInInput.sendKeys(value);
                return;
            }
        }
        Assert.fail("Не найдено поле " + fieldName);
    }

    public void selectValueCupons(String fieldName, String value) {
//        List<WebElementFacade> listFullNameInputCupon = findAll(listFullNameInputCuponPath);
        for (WebElementFacade fullName : listFullNameInputCupon) {
            if (fullName.getText().contains(fieldName)) {
                WebElementFacade clickOneCupon = fullName.findBy(oneNameSelectCupon);
                jsClick(clickOneCupon);
                WebElementFacade selectValue = fullName.find(oneNamesVerySelectCupon);
                if (selectValue.getText().contains(value)) {
                    selectValue.click();
                    waitABit(200);
                    return;
                }
                Assert.fail("Не найдено значение " + value);
            }
        }
        Assert.fail("Не найдено поле " + fieldName);
    }

    public void selectGeografCupons(String value) {
        inputSendRegion.click();
        inputSendRegion.sendKeys(value);
        buttonSeachRegion.click();
        checkSeachRegion.waitUntilVisible().click();
        return;
    }

    public void selectValueOffice(String fieldName, String value) {
        for (WebElementFacade fullName : listFullNameSelectParam) {
            if (fullName.getText().contains(fieldName)) {
                WebElementFacade sendCardInInput = fullName.find(buttonSelectNameParam);
                sendCardInInput.click();
                for (WebElementFacade fullType : dropdownSelectMenu) {
                    if (fullType.getText().replaceAll("[\r\n]", " ").equals(value)) {
                        fullType.click();
                        sendCardInInput.click();
                        return;
                    }
                }
                Assert.fail("Не найдено значение поля " + value);
            }
        }
        Assert.fail("Не найдено поле " + fieldName);
    }

    public void selectTypeRules(String value) {
        selectTypePravil.click();
        for (WebElementFacade fullName : listNamesTypePravilParam) {
            if (fullName.getText().contains(value)) {
                fullName.selectByVisibleText(value);
                return;
            }
        }
        Assert.fail("Не найден тип " + value);
    }

    public void clickParamAddEntry(String value){
        for (WebElementFacade fullName : ParamEntry) {
            System.out.println(fullName.getText());
            if (fullName.getText().contains(value)) {
                fullName.click();
                return;
            }
        }
        Assert.fail("Не найдена кнопка " + value);
    }

    public void clickParameNotEception(String value){
        for (WebElementFacade fullName : ParameEception) {
            System.out.println(fullName.getText());
            if (fullName.getText().contains(value)) {
                fullName.click();
                return;
            }
        }
        Assert.fail("Не найдена кнопка " + value);
    }

    public void seachAndAddProductAdd(String type, String value){
        for (WebElementFacade fullNamePole : nameLispAddProduct) {
            System.out.println(fullNamePole.getText());
            if (fullNamePole.getText().contains(type)) {
                WebElementFacade sendCardInInput = fullNamePole.find(buttonListProduct);
                sendCardInInput.click();
                WebElementFacade inputPoleSeach = fullNamePole.find(inputElementProduct);
                inputPoleSeach.click();
                inputPoleSeach.clear();
                inputPoleSeach.sendKeys(value);
                waitABit(1000);
                WebElementFacade seachAccurate = fullNamePole.find(seachElement);
                seachAccurate.waitUntilVisible().click();
                if (isDisplayed(buttonAddSpisEnty)) {
                    buttonAddSpisEnty.click();
                    }
                return;
            }
        }
        Assert.fail("Не найдено поле " + type);
    }

    public void seachAndAddProductNot(String type, String value){
        for (WebElementFacade fullNamePole : nameLispNotProduct) {
            System.out.println(fullNamePole.getText());
            if (fullNamePole.getText().contains(type)) {
                WebElementFacade sendCardInInput = fullNamePole.find(buttonListProduct);
                sendCardInInput.click();
                WebElementFacade inputPoleSeach = fullNamePole.find(inputElementProduct);
                inputPoleSeach.click();
                inputPoleSeach.clear();
                inputPoleSeach.sendKeys(value);
                waitABit(1000);
                WebElementFacade seachAccurate = fullNamePole.find(seachElement);
                seachAccurate.waitUntilVisible().click();
                if (isDisplayed(buttonAddSpisIskl)) {
                    buttonAddSpisIskl.click();
                }
                return;
            }
        }
        Assert.fail("Не найдено поле " + type);
    }

    public Boolean checkListsProductAdd(String listOjid) {
        waitABit(1000);
        Assert.assertTrue("Кнопки не обнаружены", checkElementList(listAddNames, 3));
        for (WebElementFacade element : listAddNames) {
            if (element.getText().equals(listOjid)) {
                return isDisplayed(element);
            }
        }
        return false;
    }

    public Boolean checkListsProductNot(String listOjid) {
        waitABit(1000);
        Assert.assertTrue("Кнопки не обнаружены", checkElementList(listNotNames, 3));
        for (WebElementFacade element : listNotNames) {
            if (element.getText().equals(listOjid)) {
                return isDisplayed(element);
            }
        }
        return false;
    }

    public Boolean checkCuponDan(String ddButtons) {
        waitABit(350);
        Assert.assertTrue("На странице таблица с данными Купона не обнаружена", checkElementList(listFullTdInCupon, 3));
        for (WebElementFacade element : listFullTdInCupon) {
            if (isDisplayed(element)) {
                if (element.getText().replaceAll("[\r\n]", " ").equals(ddButtons)) {
                    return isDisplayed(element);
                }
            }
        }
        return false;
    }


    public boolean checkButtonsCupon(String ddButtons){
        waitABit(350);
        Assert.assertTrue("На странице кнопок не обнаружено", checkElementList(listFullNameButton, 3));
        for (WebElementFacade element : listFullNameButton) {
            if (isDisplayed(element)) {
                if (element.getText().replaceAll("[\r\n]", " ").equals(ddButtons)) {
                    return isDisplayed(element);
                }
            }
        }
        return false;
    }

    public void clickButtonsCupon(String ddButtons){
        waitABit(350);
        Assert.assertTrue("На странице кнопок не обнаружено", checkElementList(listFullNameButton, 3));
        for (WebElementFacade element : listFullNameButton) {
            if (isDisplayed(element)) {
                if (element.getText().replaceAll("[\r\n]", " ").equals(ddButtons)) {
                    element.click();
                    return;
                }
            }
        }
    }


    public void stndTextAndBlockCupon(String value){
        inputPrichina.click();
        inputPrichina.clear();
        inputPrichina.sendKeys(value);
        buttonModalBlock.click();
        return;
    }



}
