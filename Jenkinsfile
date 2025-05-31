pipeline {
  agent any

  tools {
    jdk 'jdk-21'
    maven 'Maven 3.9.9'
  }

  environment {
    SONAR_TOKEN = credentials('sonar-token')
  }

  stages {
    stage('Git Version Check') {
      steps {
        sh '/usr/bin/git --version'
      }
    }

    stage('Clone Repository') {
      steps {
        sh 'rm -rf Final-repo' // Clean any existing repo
        sh '/usr/bin/git clone https://github.com/moo-tezWayup/Final-repo.git'
      }
    }

    stage('Checkout Main Branch') {
      steps {
        dir('Final-repo') {
          git branch: 'main', url: 'https://github.com/moo-tezWayup/Final-repo.git'
        }
      }
    }

    stage('Build Backend') {
      steps {
        dir('Final-repo/back-end-main') {
           sh 'mvn clean install -Dspring.profiles.active=test -DskipTests'
        }
      }
    }

    stage('SonarQube Analysis') {
      steps {
        dir('Final-repo/back-end-main') {
          withSonarQubeEnv('sonar-clinic') {
            withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
              sh 'mvn sonar:sonar -Dsonar.projectKey=clinic-backend -Dsonar.login=$SONAR_TOKEN'
            }
          }
        }
      }
    }
  }
}
