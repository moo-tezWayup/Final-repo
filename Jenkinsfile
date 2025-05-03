pipeline {
  agent any

  tools {
    maven 'Maven 3.9.9'
  }

  environment {
    SONAR_TOKEN = credentials('sonar-token')
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/moo-tezWayup/Final-repo.git'
      }
    }

    stage('Build') {
      steps {
        dir('backend/clinic') {
          sh 'mvn clean install'
        }
      }
    }

    stage('SonarQube Analysis') {
      steps {
        dir('backend/clinic') {
          withSonarQubeEnv('SonarQube') {
            sh 'mvn sonar:sonar -Dsonar.projectKey=clinic-backend -Dsonar.login=$SONAR_TOKEN'
          }
        }
      }
    }
  }
}
