# Étape 1 : Build du projet avec Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Créer un répertoire de travail
WORKDIR /app

# Copier les fichiers de configuration Maven
COPY pom.xml .

# Télécharger les dépendances pour accélérer les builds suivants
RUN mvn dependency:go-offline

# Copier le reste du code source
COPY src ./src

# Construire l'application Spring Boot (le .jar)
RUN mvn clean package -DskipTests

# Étape 2 : Image d'exécution plus légère
FROM eclipse-temurin:21-jdk

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copier le jar depuis le build précédent
COPY --from=build /app/target/*.jar app.jar

# Exposer le port 8080 (celui du backend Spring Boot)
EXPOSE 8081

# Démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
