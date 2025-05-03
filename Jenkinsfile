pipeline {
  agent any

  environment {
    SONAR_TOKEN = credentials('sonar-token') // Nom exact de la credential créée dans Jenkins
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/moo-tezWayup/Final-repo.git'
      }
    }

    stage('Build') {
      steps {
        sh './mvnw clean install'
      }
    }

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('SonarQube') { // Le nom doit correspondre à ton serveur configuré dans Jenkins
          sh './mvnw sonar:sonar -Dsonar.projectKey=clinic-backend -Dsonar.login=$SONAR_TOKEN'
        }
      }
    }
  }
}
