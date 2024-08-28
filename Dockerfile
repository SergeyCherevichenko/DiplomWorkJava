# Используем базовый образ JDK
FROM openjdk:17

# Установка рабочей директории
WORKDIR /app

# Копируем файлы проекта в контейнер
COPY . /app

# Установка прав на выполнение для mvnw
RUN chmod +x mvnw

# Выполняем сборку проекта
RUN ./mvnw clean package

# Установка команды для запуска приложения
CMD ["java", "-jar", "target/my-app.jar"]

