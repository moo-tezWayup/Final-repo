pipeline {
  agent any

  tools {
    maven 'Maven 3.9.9'
  }

  environment {
    SONAR_TOKEN = credentials('sonar-token') // tu dois créer cette "credential"
  }

  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/moo-tezWayup/Final-repo.git'
      }
    }

    stage('Build') {
      steps {
        sh './mvnw clean install'
      }
    }

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('SonarQube') {
            sh './mvnw sonar:sonar -Dsonar.projectKey=clinic-backend -Dsonar.login=$SONAR_TOKEN'
        }
      }
    }
  }
}
