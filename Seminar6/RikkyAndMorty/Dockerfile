# Используем базовый образ с поддержкой Java
FROM openjdk:19-slim

# Копируем JAR-файл приложения в контейнер
COPY  *.jar /app/RikkyAndMorty.jar

WORKDIR /app
 
# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "/app/RikkyAndMorty.jar"]
