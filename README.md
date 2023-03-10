# Тестовое задание
_____

## Описание задачи:

Необходимо реализовать микросервис, который позволяет пользователю получить информацию о выбраннном (по ID) автомобилю из базы данных в формате JSON

Для реализации задания используются:
* Язык программирования: Kotlin
* Фреймворк: Spring
* Бибилиотека для работы с базой данных: JOOQ
* СУБД: PostgreSQL
* Брокер сообщений: Apache Kafka
* Docker

Подзадачи:
* Необходимо реализовать базу данных, для хранения информации об автомобилях
* Развернуть Apache Kafka и направить туда информацию о выбранном автомобиле

_____

## Схема базы данных:
![image](https://user-images.githubusercontent.com/76054847/218891694-36fbe693-d2af-47de-978d-a7b83217e6c8.png)

_____

## Запуск проекта

* Запустить сервис на порту 8090
* Развернуть apache kafka на порту 29092
* Для обращения к сервису необходимо отправить GET-запрос в формате: http://localhost:8090/cars/8

## Результат работы сервиса

_____
Ответ в формате json

![image](https://user-images.githubusercontent.com/76054847/219058834-d0d38905-b6dd-4153-ad24-18134ba3994d.png)
___
kafka

![image](https://user-images.githubusercontent.com/76054847/219058973-cc7e0503-fe49-41be-b6a6-e99f4d5a751b.png)

