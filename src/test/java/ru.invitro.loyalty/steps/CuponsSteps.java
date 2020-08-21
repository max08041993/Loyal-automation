package ru.invitro.loyalty.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Shared;
import org.junit.Assert;
import ru.invitro.loyalty.driver.SaveData;
import ru.invitro.loyalty.pages.CuponPage;

import java.util.List;

public class CuponsSteps {

    CuponPage cuponPage;

    @Shared
    SaveData saveData;

    @Shared
    AssertionSteps assertionSteps;

    @When("^Нажимаю Создать$")
    public void clickCreate(){
        cuponPage.clickCreate();
    }

    @When("^Ввожу в поле (.*) значение (.*) на странице создания тиража Купонов$")
    public void sendValueCupons(String pole, String value){
        if (pole.equals("Срок действия")){
            int number = Integer.parseInt (value);
            saveData.setNumderDeyActions(number);
            System.out.println(saveData.getNumderDeyActions());
        }
        cuponPage.sendValueCupons(pole,value);
    }

    @When("^В поле (.*) выбираю значение (.*) на странице создания тиража Купонов$")
    public void selectValueCupons(String pole, String value){
        cuponPage.selectValueCupons(pole,value);
    }

    @When("^Выбираю Шаблон тиража значение (.*) на странице создания тиража Купонов$")
    public void selectPatternEdition(String value){
        if (value.equals("Сохраненное значение")){
            value = saveData.getNameRandom();
        }
        cuponPage.selectPatternEdition(value);
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
        cuponPage.searchAndAddProductAdd(type,value);
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

    @When("^Проверяю что отображается таблица со следующими полями:$")
    public void checkThatTableIsVisible(List<String> columns) {
        for (String ddButtons : columns) {
            assertionSteps.softAssertIsTrue("Отсутсвует столбец " + ddButtons, cuponPage.columnsOnTable(ddButtons));
        }
    }

    @When("^Проверяю что Данные купона и События лояльности содержат следующие строки:$")
    public void checkCuponDan(List<String> listsNames) {
        for (String listNames : listsNames) {
            assertionSteps.softAssertIsTrue("Данные купона не содержат строчки " + listNames, cuponPage.checkCouponDan(listNames));
        }
    }

    @When("^Проверяю что Данные карты и События лояльности содержат следующие строки:$")
    public void checkCardDan(List<String> listsNames) {
        for (String listNames : listsNames) {
            assertionSteps.softAssertIsTrue("Данные купона не содержат строчки " + listNames, cuponPage.checkCardDan(listNames));
        }
    }

    @When("^Проверяю что на странице присутствует кнопка$")
    public void checkButtonsCupon(List<String> listsNames) {
        for (String listNames : listsNames) {
            assertionSteps.softAssertIsTrue("Кнопка(и) " + listNames + " не обнаружены на странице", cuponPage.checkButtonsCupon(listNames));
        }
    }

    @When("^В поле поиска Тиражей купонов ввожу (.*) и произвожу поиск$")
    public void sendNumberEditionCupon(String value){
        cuponPage.sendNumberEditionCupon(value);
    }

    @When("^В таблице Тиража в поле (.*) нахожу элемент со значением (.*) и открываю его$")
    public void sendAndOpenCuponStatus(String type,String value){
        cuponPage.sendAndOpenCuponStatus(type,value);
    }

    @When("^Нажимаю кнопку (.*)$")
    public void clickBlock(String value){
        cuponPage.clickButtonsCupon(value);
    }

    @When("^Ввожу причину блокировки (.*) и Блокирую купон$")
    public void stndTextAndBlockCupon(String value){
        cuponPage.stndTextAndBlockCupon(value);
    }

    @When("^Ввожу в поле Номер серии рандомное число из 9 знаков$")
    public void sendValueRandom(){
        cuponPage.sendValueRandom();
    }

    @When("^Ввожу в поле Дата-время активации (Текущую|Вчерашнюю|Завтрашнюю) дату и время$")
    public void sendDateAndTime(String value){
        switch (value){
            case ("Текущую"):
                String tupe = cuponPage.currentDateAndHour();
                System.out.println(true);
                cuponPage.sendValueDate(tupe);
                break;
            case ("Вчерашнюю"):
                String yesterday = cuponPage.yesterdayDateAndHour();
                cuponPage.sendValueDate(yesterday);
                break;
            case ("Завтрашнюю"):
                String tomorrow = cuponPage.tomorrowDateAndHour();
                cuponPage.sendValueDate(tomorrow);
                break;
        }
    }

    @When("^Проверяю что в поле (.*) отображается ошибка (.*)$")
    public void errorTirag(String type, String value){
        assertionSteps.softAssertIsTrue("Ошибка " + value + " не обнаружена",cuponPage.errorTirag(type,value));
    }

    @When("Нажимаю Сохранить")
    public void clickbuttonSave(){
        cuponPage.clickbuttonSave();
    }

    @When("Проверяю наличие ошибки пересечения серии с номерами и исправляю её")
    public void fixErrorDuplication(){
//        cuponPage.fixErrorDuplication();
        saveData.setRandomNumber9(cuponPage.fixErrorDuplication());
    }

    @When("^Проверяю что информация по Тиражу купонов содержит следующие строки:$")
    public void checkInfoIsEdition(List<String> listsNames){
        for (String listNames : listsNames) {
            assertionSteps.softAssertIsTrue("В информации по тиражу купонов не обнаружено " + listNames, cuponPage.checkInfoIsEdition(listNames));
        }
    }

    @When("^Ввожу комментарий (.*) в блоке операция над тиражом и нажимаю Продолжить$")
    public void sendCommentarAndSendNext(String value){
        cuponPage.sendCommentarAndSendNext(value);
    }

    @When("^Не Ввожу комментарий в блоке операция над тиражом и нажимаю Продолжить$")
    public void sendNotCommentarAndSendNextFail(){
        cuponPage.sendNotCommentarAndSendNextFail();
    }

    @When("^Проверяю что вышла окно Внимание с текстом:$")
    public void checkFailWindowText(List<String> listsNames) {
        for (String listNames : listsNames) {
            assertionSteps.softAssertIsTrue("Текст: " + listNames + " в окне не обнаружен", cuponPage.checkFailWindowText(listNames));
        }
        cuponPage.clicButtonOk();
    }

    @When("^Ввожу в поле (.*) рандомное значение на странице создания тиража Купонов$")
    public void sendRandomNameTirag(String type){
        saveData.setNameRandom(cuponPage.sendRandomNameTirag(type));
        System.out.println(saveData.getNameRandom());
    }

    @When("^Проверяю что Дата активации купона равен текущей дате$")
    public void checkDataCuponValueNow(){
        String dataNow = cuponPage.currentDateNow();
            assertionSteps.softAssertIsTrue("Дата активации купона не равна текущей", cuponPage.checkDataCuponValueNow(dataNow));
    }

    @When("^Проверяю что Срок действия купона равен сроку действия в шаблоне$")
    public void checkValidCupon(){
        String dataNow = cuponPage.exactDate(saveData.getNumderDeyActions());
        assertionSteps.softAssertIsTrue("Срок действия купона не равен значению в шаблоне тиража", cuponPage.checkValidCupon(dataNow));
    }

    @When("^В поле Применимость к продукту ввожу (.*) и нажимаю Проверить$")
    public void sendValuePrimenimost(String value){
        cuponPage.sendValuePrimenimost(value);
    }

    @When("^Проверяю что блок Проверка правила содержит текст:$")
    public void checkRulesProduct(List<String> listsNames){
        for (String listNames : listsNames) {
            assertionSteps.softAssertIsTrue("Отсутсвует строка " + listNames + " в блоке проверки применимости продукта", cuponPage.checkRulesProduct(listNames));
        }
    }




}
