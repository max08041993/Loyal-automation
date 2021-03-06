@test @cupons

#  https://invitro.atlassian.net/browse/LOY-180

Feature: 180 Проверка вхождения заданного продукта в список продуктов

  Scenario: 180 Проверка вхождения заданного продукта в список продуктов
    Given Открываю страницу Loyal
    When Выбираю регион Россия
    When Открываю в блоке Купоны страницу Шаблоны тиражей
    When В поле поиска Тиражей купонов ввожу -10% Автотесты и произвожу поиск
    Then В таблице поиска в поле Название нажимаю на значение -10% Автотесты
    When В блоке Список продуктов выбираю тип правила Белый
    When В блоке Список продуктов Добавляю вхождение Список
    When В блоке добавления вхождения продуктов к Список ввожу или выбираю искомый элемент 6844Е102 и Добавляю элемент
    When В блоке добавления вхождения продуктов к Список ввожу или выбираю искомый элемент 6842Е220 и Добавляю элемент
    When Проверяю что блок добавления Вхождения списка применимости к продукту содержит:
      |6844Е102 Собака, rCan f 2 (e102) IgE, ImmunoCAP|
      |6842Е220 Кошка, сывороточный альбумин, rFel d2 (e220) IgE, ImmunoCAP|
    When В поле Применимость к продукту ввожу 6844Е102 и нажимаю Проверить
    Then Проверяю что блок Проверка правила содержит текст:
      |сработает|

    When В блоке Список продуктов Добавляю исключение Список
    When В блоке добавления исключения продуктов к Список ввожу или выбираю искомый элемент 3251 и Добавляю элемент
    When В блоке добавления исключения продуктов к Список ввожу или выбираю искомый элемент 5733200 и Добавляю элемент
    When Проверяю что блок добавления Исключения списка применимости к продукту содержит:
      |3251 Андр-лор Скрин(моча)|
      |5733200 Семья куклы Штеффи 6/12|

    When В поле Применимость к продукту ввожу 6844Е102 и нажимаю Проверить
    Then Проверяю что блок Проверка правила содержит текст:
      |сработает|

    When В поле Применимость к продукту ввожу 6842Е220 и нажимаю Проверить
    Then Проверяю что блок Проверка правила содержит текст:
      |сработает|

    When В поле Применимость к продукту ввожу 3251 и нажимаю Проверить
    Then Проверяю что блок Проверка правила содержит текст:
      |не сработает|

    When В поле Применимость к продукту ввожу 5733200 и нажимаю Проверить
    Then Проверяю что блок Проверка правила содержит текст:
      |не сработает|

    When В поле Применимость к продукту ввожу 1515 и нажимаю Проверить
    Then Проверяю что блок Проверка правила содержит текст:
      |не сработает|