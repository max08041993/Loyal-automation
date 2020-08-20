@test @cupons

#  https://invitro.atlassian.net/browse/LOY-179

Feature: 179 Проверка отображения срока действия купона

  Scenario: 179 Проверка отображения срока действия купона
    Given Открываю страницу Loyal
    When Выбираю регион Россия
    When Открываю в блоке Купоны страницу Шаблоны тиражей
    When Нажимаю Создать
    When Ввожу в поле Название рандомное значение на странице создания тиража Купонов
    When В поле Тип купона выбираю значение Купон на фиксированную скидку на странице создания тиража Купонов
    When Ввожу в поле Длина серии значение 9 на странице создания тиража Купонов
    When Ввожу в поле Действует с значение 1200 на странице создания тиража Купонов
    When Ввожу в поле Скидка, руб. значение 500 на странице создания тиража Купонов
    When Ввожу в поле Примечание значение Тест на странице создания тиража Купонов
    When Ввожу в поле Количество транзакций гашения значение 1 на странице создания тиража Купонов
    When Ввожу в поле Срок действия значение 10 на странице создания тиража Купонов
    When Ввожу в поле Длина номера значение 9 на странице создания тиража Купонов
    When Ввожу в поле Действует по значение 1300 на странице создания тиража Купонов
    When Ввожу в поле Верхнее ограничение, % значение 50 на странице создания тиража Купонов

    When В поле поиска блока География применения ввожу Нагатинская и произвожу поиск и отмечаю найденое значение
    When Жду 2 секунды
    When Нажимаю Сохранить

    When Открываю в блоке Купоны страницу Тиражи

    When Нажимаю Создать
    When Выбираю Шаблон тиража значение Сохраненное значение на странице создания тиража Купонов
    When Ввожу в поле Номер серии рандомное число из 9 знаков
    When Ввожу в поле Количество значение 100 на странице создания тиража Купонов
    When Ввожу в поле Комментарий значение Автотест 178 на странице создания тиража Купонов
    When Ввожу в поле Количество резервных купонов значение 0 на странице создания тиража Купонов
    When Ввожу в поле Дата-время активации Текущую дату и время
    When В поле Признак возмещения выбираю значение Локальные на странице создания тиража Купонов
    When Нажимаю Сохранить
    When Проверяю наличие ошибки пересечения серии с номерами и исправляю её
    When Проверяю что информация по Тиражу купонов содержит следующие строки:
      |Статус|
      |Создан|
    When Нажимаю кнопку Выпустить
    When Ввожу комментарий Выпуск Автотест 179 в блоке операция над тиражом и нажимаю Продолжить
    When Проверяю что информация по Тиражу купонов содержит следующие строки:
      |Статус|
      |Сформирован|
    When Нажимаю кнопку Передать в производство
    When Ввожу комментарий Передача в производство Автотест 179 в блоке операция над тиражом и нажимаю Продолжить
    When Проверяю что информация по Тиражу купонов содержит следующие строки:
      |Статус|
      |Передан в производство|
    When Нажимаю кнопку Получить из производства
    When Ввожу комментарий Получение из производства Автотест 179 в блоке операция над тиражом и нажимаю Продолжить
    When Проверяю что информация по Тиражу купонов содержит следующие строки:
      |Статус|
      |Выпущен|
    When Нажимаю кнопку Активировать
    When Ввожу комментарий Активация Автотест 179 в блоке операция над тиражом и нажимаю Продолжить
    When Проверяю что информация по Тиражу купонов содержит следующие строки:
      |Статус|
      |Активен|
    When В таблице Тиража в поле Статус нахожу элемент со значением Активен и открываю его
    When Проверяю что Дата активации купона равен текущей дате
    When Проверяю что Срок действия купона равен сроку действия в шаблоне
