# План

## Перечень автоматизируемых сценариев ##

 ### Успешная оплата по карте используя валидные данные:
- вводимые значения : **карта 4276 4276 4276 4276 , срок 02/23 , владедец Ivan Ivanov, CVV 147**
1. Оплата тура через кнопку "Купить". Итог - покупка одобрена. (Успешно! Операция одобрена банком)
2. Оплата тура через кнопку "Купить в кредит". Итог - покупка в кредит одобрена.(Успешно! Операция одобрена банком)
 ### Успешная оплата по карте используя валидные данные:
- вводимые значения: **карта 4276 4276 4276 4276 , срок 02/23 , владедец Ivan Ivanov, CVV 147**
4. Оплата тура через кнопку "Купить". Итог - покупка отклонена. (Ошибка! Банк отказал в проведении операции)  
5. Оплата тура через кнопку "Купить в кредит". Итог - покупка в кредит отклонена. (Ошибка! Банк отказал в проведении операции) 

 ### Неуспешная оплата по дебетовой карте используя не валидные данные:
 
1. Оплата тура через кнопку "Купить" по карте "4276 4276 4276 4276" с использованием невалидных данных (Месяц/Год/Владелец/CVC/CVV)  Итог - покупка отклонена. (Ошибка! Банк отказал в проведении операции)
1. Оплата тура через кнопку "Купить в кредит" по карте "4276 4276 4276 4276" с использованием невалидных данных (Месяц/Год/Владелец/CVC/CVV)  Итог - покупка отклонена. (Ошибка! Банк отказал в проведении операции) 
1. Оплата тура через кнопку "Купить" по карте 4276 4276 4276 4276" с отправкой пустых значений (Месяц/Год/Владелец/CVC/CVV)  Итог - сообщение "Поле обязательно для заполнения"
1.  Оплата тура через кнопку "Купить в кредит" по карте "4276 4276 4276 4276" с отправкой пустых значений (Месяц/Год/Владелец/CVC/CVV)  Итог - сообщение "Поле обязательно для заполнения"
---
### Перечень используемых инструментов

* IntelliJIDEA - Интегрированная среда разработки программного обеспечения на Java;
* Java - Язык программирования;
* Gradle - система автоматической сборки для тестов;
* JunitJupiter – платформа для запуска тестов;
* Selenide - фреймворк для автоматизированного тестирования веб-приложений на основе SeleniumWebDriver;
* Git - Система контроля версийй;
* GitHub Action - CI/CD;

### Перечень и описание возможных рисков при автоматизации

* Трудности с нахождением необходимых для тестирования CSS - селекторов;
* Трудно воспроизводимые кейсы, которые не могут быть обнаружены при тестировании;
* Потеря интернет соединения
### Интервальная оценка с учётом рисков (в часах)

* 20 часов на проектирование с Selenide;
* 20 часов на проектирование и разработку, запуск тестовых классов.
* 5 часов на составление отчета
---
### План сдачи работ

* Ожидаемая дата завершения проекта 1 июня 2021г.
