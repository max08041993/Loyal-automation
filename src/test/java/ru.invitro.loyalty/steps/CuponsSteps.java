package ru.invitro.loyalty.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import ru.invitro.loyalty.pages.CuponPage;

import java.util.List;

public class CuponsSteps {

    CuponPage cuponPage;

    @When("^Нажимаю кнопку Создать$")
    public void clickCreate(){
        cuponPage.clickCreate();
    }

    @When("^Ввожу в поле (.*) значение (.*) на странице создания тиража Купонов$")
    public void sendValueCupons(String pole, String value){
        cuponPage.sendValueCupons(pole,value);
    }

    @When("^В поле (.*) выбираю значение (.*) на странице создания тиража Купонов$")
    public void selectValueCupons(String pole, String value){
        cuponPage.selectValueCupons(pole,value);
    }

    @When("^В поле поиска блока География применения ввожу (.*) и произвожу поиск и отмечаю найденое значение$")
    public void selectGeografCupons(String value){
        cuponPage.selectGeografCupons(value);
    }

    @When("^В блоке Параметры офисов в строке (.*) выбираю значение (.*)$")
    public void selectValueOffice(String pole, String value){
        cuponPage.selectValueOffice(pole, value);
    }

    @When("^В блоке Список продуктов выбираю тип правила (.*)$")
    public void selectTypeRules(String value){
        cuponPage.selectTypeRules(value);
    }

    @When("^В блоке Список продуктов Добавляю (вхождение|исключение) (.*)$")
    public void clickParamSpis (String type, String value){
        switch (type) {
            case "вхождение":
                cuponPage.clickParamAddEntry(value);
                break;
            case "исключение":
                cuponPage.clickParameNotEception(value);
                break;
        }
    }

    @When("^В блоке добавления вхождения продуктов к (.*) ввожу или выбираю искомый элемент (.*) и Добавляю элемент$")
    public void seachAndAddProductAdd(String type, String value){
        cuponPage.seachAndAddProductAdd(type,value);
    }

    @When("^В блоке добавления исключения продуктов к (.*) ввожу или выбираю искомый элемент (.*) и Добавляю элемент$")
    public void seachAndAddProductNot(String type, String value){
        cuponPage.seachAndAddProductNot(type,value);
    }

    @Then("^Проверяю что блок добавления (Вхождения|Исключения) списка применимости к продукту содержит:$")
    public void checkListsProductAdd(String tupe, List<String> listsNames) {
        switch (tupe) {
            case ("Вхождения"):
                for (String listNames : listsNames) {
                    Assert.assertTrue("Отсутсвует продукт " + listNames + " в списке добавления", cuponPage.checkListsProductAdd(listNames));
                }
                break;
            case ("Исключения"):
                for (String listNames : listsNames) {
                    Assert.assertTrue("Отсутсвует продукт " + listNames + " в списке добавления", cuponPage.checkListsProductNot(listNames));
                }
                break;
        }
    }




}
