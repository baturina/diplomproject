Дипломный проект по курсу "Тестировщик ПО"
### Инструкция по запуску проекта
## ПРОЦЕДУРА ЗАПУСКА АВТОТЕСТОВ
Т.к. заявлена одновременная поддержка двух БД, созданы 2 файла docker-compose - отдельно для mysql, отдельно для postgres.
### При использовании MySQL

1. Запуск контейнеров
```
docker-compose -f docker-compose-mysql.yml up -d 
```

2. Запуск SUT с указанием подключения к БД
```
java -Dspring.datasource.url=jdbc:mysql://localhost:3306/db -jar artifacts/aqa-shop.jar
```
3. Запуск тестов с расширенной информацией о выполнении
```
gradlew test -Dtest.db.url=jdbc:mysql://localhost:3306/db  --info
```
4. Остановка контейнеров
```
docker-compose -f docker-compose-mysql.yml down
```


### При использовании PostgreSQL
1. Запуск контейнеров
```
docker-compose -f docker-compose-postgres.yml up -d
```

2. Запуск SUT с указанием подключения к БД
```
java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/db -jar artifacts/aqa-shop.jar
```
3. Запуск тестов с расширенной информацией о выполнении
```
gradlew test -Dtest.db.url=jdbc:postgresql://localhost:5432/db  --info
```
4. Остановка контейнеров
```
docker-compose -f docker-compose-postgres.yml down
```

### Для запуска отчетов Allure
```
gradlew allureReport
gradlew allureServe
``
### Необходимое окружение
- Docker Desktop
- AdoptOpenJDK
- IIDEA