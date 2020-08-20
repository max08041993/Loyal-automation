@test @cupons

#  https://invitro.atlassian.net/browse/LOY-176

Feature: 176 Блокировка тиража Купонов

  Scenario: 176 Блокировка тиража Купонов
    Given Открываю страницу Loyal
    When Выбираю регион Россия
    When Открываю в блоке Купоны страницу Тиражи
    When Нажимаю Создать
    When Выбираю Шаблон тиража значение -10% Автотесты на странице создания тиража Купонов
    When Ввожу в поле Номер серии рандомное число из 9 знаков
    When Ввожу в поле Количество значение 10000 на странице создания тиража Купонов
    When Ввожу в поле Комментарий значение Автотест 178 на странице создания тиража Купонов
    When Ввожу в поле Количество резервных купонов значение 10000 на странице создания тиража Купонов
    When Ввожу в поле Дата-время активации Текущую дату и время
    When В поле Признак возмещения выбираю значение Локальные на странице создания тиража Купонов
    When Нажимаю Сохранить
    When Проверяю наличие ошибки пересечения серии с номерами и исправляю её
    When Проверяю что информация по Тиражу купонов содержит следующие строки:
      |Статус|
      |Создан|
    When Проверяю что на странице присутствует кнопка
      |Заблокировать|
      |Выпустить|
    When Нажимаю кнопку Заблокировать
    When Не Ввожу комментарий в блоке операция над тиражом и нажимаю Продолжить
    Then Проверяю что вышла окно Внимание с текстом:
      |При выполнении действия необходимо указать комментарий!|
    When Нажимаю кнопку Заблокировать
    When Ввожу комментарий Блокировка Автотест 178 в блоке операция над тиражом и нажимаю Продолжить
    When Проверяю что информация по Тиражу купонов содержит следующие строки:
      |Статус|
      |Закрыт|