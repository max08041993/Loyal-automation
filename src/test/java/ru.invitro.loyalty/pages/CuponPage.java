package ru.invitro.loyalty.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CuponPage extends LoyalPage {

    @FindBy(xpath = "//a[.='Создать']")
    WebElementFacade сreate;

    @FindBy(xpath = "//div[@class='geography-fog']")
    WebElementFacade blockGeograf;

    @FindBys({@FindBy(xpath = "//form[@class='form-horizontal']/div[not(contains(@class,'hidden'))]//label")})
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

    @FindBys(@FindBy(xpath = "//form[@class='form-horizontal']/div[not(contains(@class,'hidden'))]//label/following::ul[@aria-expanded='true']//span[1]"))
    List<WebElementFacade> listSelectAaa;

    public void selectValueCupons(String fieldName,String value) {
//        List<WebElementFacade> listFullNameInputCupon = findAll(listFullNameInputCuponPath);
        for (WebElementFacade fullName : listFullNameInputCupon) {
            if (fullName.getText().contains(fieldName)) {
                WebElementFacade clickOneCupon = fullName.findBy(oneNameSelectCupon);
                jsClick(clickOneCupon);
                for (WebElementFacade listSelect : listSelectAaa) {
                    if (listSelect.getText().contains(value)) {
                        listSelect.click();
                        waitABit(200);
                        return;
                    }
                }
            }
        }
        Assert.fail("Не найдено поле " + fieldName);
    }

    @FindBys(@FindBy(xpath = "//label[.='Шаблон тиража']/..//option"))
    List<WebElementFacade> blockPatternEdition;

    @FindBy(xpath = "//label[.='Шаблон тиража']/following::select[@id='PrintingTemplateId']")
    WebElementFacade buttonPatternEdition;

    public void selectPatternEdition(String type){
        buttonPatternEdition.click();
        for (WebElementFacade fullType : blockPatternEdition) {
            if (fullType.getText().equals(type)) {
                fullType.click();
                return;
            }
        }
        Assert.fail("Не найден шаблон тиража " + type);
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
            if (fullName.getText().contains(value)) {
                fullName.click();
                return;
            }
        }
        Assert.fail("Не найдена кнопка " + value);
    }

    public void clickParameNotEception(String value){
        for (WebElementFacade fullName : ParameEception) {
            if (fullName.getText().contains(value)) {
                fullName.click();
                return;
            }
        }
        Assert.fail("Не найдена кнопка " + value);
    }

    public void seachAndAddProductAdd(String type, String value){
        for (WebElementFacade fullNamePole : nameLispAddProduct) {
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
                if (element.getText().equals(ddButtons)) {
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

    @FindBy(xpath = "//input[@id='Serie']")
    WebElementFacade Serie;

    public void sendValueRandom(){
        Serie.click();
        Serie.clear();
        Serie.sendKeys(generationRandomMumber9());
    }

    @FindBy(xpath = "//input[@id='AvailableFrom']")
    WebElementFacade AvailableFrom;

    public void sendValueDate(String tupe) {
        AvailableFrom.click();
        AvailableFrom.clear();
        AvailableFrom.sendKeys(tupe);
    }

    By errorText = By.xpath("./..//span[@id]");

    public boolean errorTirag(String type,String value) {
        waitABit(500);
        for (WebElementFacade medInfoRow : listFullNameInputCupon) {
            if (medInfoRow.getText().equals(type)) {
                WebElementFacade directoryMenu = medInfoRow.find(errorText);
                if(directoryMenu.getText().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @FindBy(xpath = "//*[@value='Сохранить']")
    WebElementFacade buttonSave;

    public void clickbuttonSave(){
        buttonSave.waitUntilClickable().click();
    }

    @FindBy(xpath = "//label[.='Номер серии']/..//span[@class='field-validation-error'][@data-valmsg-replace='true']")
            WebElementFacade errorMessageDublication;

    public void fixErrorDuplication() {
        boolean aaa = true;
        while (aaa) {
            waitABit(1000);
            if(errorMessageDublication.isVisible()) {
                System.out.println(errorMessageDublication.getText());
                if (errorMessageDublication.getText().contains("Серия пересекается с номерами")) {
                    sendValueRandom();
                    Serie.sendKeys(Keys.ENTER);
                    waitABit(1000);
                    aaa = true;
                } else aaa = false;
            }else aaa = false;
        }
    }

//    public void fixErrorDuplication() {
//        boolean aaa = true;
//        while (aaa) {
//            waitABit(2000);
//            if (!listFullNameInputCupon.isEmpty()) {
//                for (WebElementFacade medInfoRow : listFullNameInputCupon) {
//                    if (medInfoRow.getText().equals("Номер серии")) {
//                        WebElementFacade directoryMenu = medInfoRow.find(textSeriaDublicat);
//                        System.out.println(directoryMenu.getText());
//                        if (directoryMenu.getText().contains("Серия пересекается с номерами")) {
//                            sendValueRandom();
//                            Serie.sendKeys(Keys.ENTER);
//                            waitABit(1000);
//                            aaa = true;
//                        } else aaa = false;
//                    } else aaa = false;
//                }
//            } else aaa = false;
//        }
//    }

    @FindBys(@FindBy(xpath = "//div[@class='panel panel-default']//label/following::dl/*"))
    List<WebElementFacade> listFullInfoEdition;

    public Boolean checkInfoIsEdition(String ddListInfo) {
        waitABit(350);
        Assert.assertTrue("На странице таблица с данными по тиражу не найдена", checkElementList(listFullInfoEdition, 3));
        for (WebElementFacade element : listFullInfoEdition) {
            if (isDisplayed(element)) {
                if (element.getText().replaceAll("[\r\n]", " ").equals(ddListInfo)) {
                    return isDisplayed(element);
                }
            }
        }
        return false;
    }

    @FindBy(xpath = "//input[@placeholder='Комментарий']")
    WebElementFacade inputComment;

    @FindBy(xpath = "//button[.='Продолжить']")
    WebElementFacade buttonNextComment;

    @FindBy(xpath = "//div[@class='fog modal-fog fog-top0 fog-fixed'][@style='display: block;']")
    WebElementFacade blockModalFog;

    public void sendCommentarAndSendNext(String value){
        inputComment.waitUntilVisible();
        waitABit(1000);
        inputComment.click();
        inputComment.sendKeys(value);
        buttonNextComment.click();
        blockModalFog.waitUntilNotVisible();
    }

    public void sendNotCommentarAndSendNextFail(){
        inputComment.waitUntilVisible();
        waitABit(1000);
        inputComment.click();
        buttonNextComment.click();
    }

    @FindBys(@FindBy(xpath = "//div[@class='jconfirm-content-pane']"))
    List<WebElementFacade> textFailWindow;

    public boolean checkFailWindowText(String ddButtons){
        waitABit(350);
        Assert.assertTrue("На странице кнопок не обнаружено", checkElementList(textFailWindow, 3));
        for (WebElementFacade element : textFailWindow) {
            if (isDisplayed(element)) {
                if (element.getText().replaceAll("[\r\n]", " ").equals(ddButtons)) {
                    return isDisplayed(element);
                }
            }
        }
        return false;
    }

    @FindBy(xpath = "//button[@type='button'][.='ok']")
    WebElementFacade buttonOk;

    public void clicButtonOk(){
        buttonOk.waitUntilClickable().click();
    }

}
