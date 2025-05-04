pipeline {
  agent any

  tools {
     git 'Git 2.39.5'
    maven 'Maven 3.9.9'
  }

  environment {
    SONAR_TOKEN = credentials('sonar-token')
  }
stages {
        stage('Clone') {
            steps {
                sh '/usr/bin/git --version'
                sh '/usr/bin/git clone https://github.com/moo-tezWayup/Final-repo.git'
            }
        }
    }
  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/moo-tezWayup/Final-repo.git'
      }
    }

    stage('Build') {
      steps {
        dir('back-end-main') {
          sh 'mvn clean install'
        }
      }
    }

    stage('SonarQube Analysis') {
      steps {
        dir('back-end-main') {
          withSonarQubeEnv('SonarQube') {
            sh 'mvn sonar:sonar -Dsonar.projectKey=clinic-backend -Dsonar.login=$SONAR_TOKEN'
          }
        }
      }
    }
  }
}
