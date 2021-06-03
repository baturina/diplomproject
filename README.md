Дипломный проект по курсу "Тестировщик ПО"
### Инструкция по запуску проекта
1. Скачать проект с https://github.com/baturina/diplomproject.git
2. Выполнить в терминале команду `docker-compose up -d`.
3. Включить `SUT` командой java -jar aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app
4. Запустить автотесты.

### Необходимое окружение
- Docker Desktop
- AdoptOpenJDK
- IIDEA