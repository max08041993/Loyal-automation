@test @Orders

#  https://invitro.atlassian.net/browse/LOY-186

Feature: 186 Проверка поиска на странице Заказы

  Scenario: 186 Проверка поиска на странице Заказы
    Given Открываю страницу Loyal
    When Выбираю регион Россия
    When Открываю в блоке Управление данными страницу Заказы

    When На странице Заказы ввожу в поле Номер заказа значение 1621361424742
    When Нажимаю Поиск
    When Проверяю что в таблице поиска в поле Номер заказа найдено значение 1621361424742
    When Проверяю что в таблице поиска в поле ФИО пациента найдено значение Тест08 Иностранец2 Тест08
    When Нажимаю Очистить

    When На странице Заказы ввожу в поле Поисковой запрос значение Тест08
    When Нажимаю Поиск
    When Проверяю что вышло передупреждение Слишком много совпадений в контактах, уточните критерий
    When На странице Заказы ввожу в поле Дата оформления с значение 110419
    When На странице Заказы ввожу в поле Дата оформления по значение 140419
    When Нажимаю Поиск
    When Проверяю что в таблице поиска в поле EsbId найдено значение 91f08ac6-5c5e-11e9-fc9a-005056c00008
    When Проверяю что в таблице поиска в поле ФИО пациента найдено значение Тест08 Младше 18 Лет
    When Проверяю что в таблице поиска в поле Дата оформления найдено значение 11.04.19 16:37
    When Нажимаю Очистить

    When На странице Заказы ввожу в поле Номер заказа значение 4961271171768
    When Нажимаю Поиск
    When Проверяю что в таблице поиска отсутствуют данные
    When Отмечаю чекбокс Неактивные
    When Нажимаю Поиск
    When Проверяю что в таблице поиска в поле EsbId найдено значение 07711184-daba-11ea-35f5-00155d0ac924
    When Проверяю что в таблице поиска в поле Номер заказа найдено значение 4961271171768
    When Проверяю что в таблице поиска в поле Дата оформления найдено значение 10.08.20 06:34
    When Нажимаю Очистить

    When На странице Заказы ввожу в поле ИНЗ значение 240335870
    When Нажимаю Поиск
    When Проверяю что в таблице поиска в поле Номер заказа найдено значение 8393714858961
    When Проверяю что в таблице поиска в поле ФИО пациента найдено значение Петровская Ксения Сергеевна
    When Нажимаю Очистить

    When На странице Заказы ввожу в поле EsbId Заказа значение cbc05c61-daba-11ea-8a1e-00155d0ac924
    When Нажимаю Поиск
    When Проверяю что в таблице поиска в поле EsbId найдено значение cbc05c61-daba-11ea-8a1e-00155d0ac924
    When Проверяю что в таблице поиска в поле ФИО пациента найдено значение Автотестнов Без Программынов Без Документовнов
    When Нажимаю Очистить

    When На странице Заказы ввожу в поле Номер визита значение 6913665171717
    When Нажимаю Поиск
    When Проверяю что в таблице поиска в поле EsbId найдено значение 00bf1d0a-de19-11e6-0268-000000000000
    When Проверяю что в таблице поиска в поле ФИО пациента найдено значение Авдеева Елена Владимировна
    When Нажимаю Очистить
