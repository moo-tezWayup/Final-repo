pipeline {
  agent any

  tools {
    jdk 'jdk-21'
    maven 'Maven 3.9.9'
    nodejs 'NodeJS 20' // Assure-toi que "NodeJS 20" est bien défini dans Jenkins (Global Tools)
  }

  environment {
    SONAR_TOKEN = credentials('sonar-token')
    SONAR_HOST_URL = 'http://sonarqube:9000'
  }

  stages {

    stage('Git Version Check') {
      steps {
        sh '/usr/bin/git --version'
      }
    }

    stage('Clone Repository') {
      steps {
        sh 'rm -rf Final-repo' // Nettoyer
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

    // ------------------ BACKEND ------------------
    stage('Build Backend') {
      steps {
        dir('Final-repo/back-end-main') {
          sh 'mvn clean install -Dspring.profiles.active=test -DskipTests'
        }
      }
    }

    stage('SonarQube Backend') {
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

    // ------------------ FRONTEND ------------------
    stage('Install Frontend Dependencies') {
      steps {
        dir('Final-repo/front-end') {
          sh 'npm install'
        }
      }
    }

    stage('Build Frontend') {
      steps {
        dir('Final-repo/front-end') {
          sh 'npm run build'
        }
      }
    }

    stage('SonarQube Frontend') {
      steps {
        dir('Final-repo/front-end') {
          withSonarQubeEnv('sonar-clinic') {
            withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
              sh '''
                docker run --rm \
                  ${tool 'sonar'}/bin/sonar-scanner \
                  -e SONAR_TOKEN=$SONAR_TOKEN \
                  -e SONAR_HOST_URL=$SONAR_HOST_URL \
                  -v $(pwd):/usr/src \
                  sonarsource/sonar-scanner-cli \
                  -Dsonar.projectKey=clinic-frontend \
                  -Dsonar.sources=src \
                  -Dsonar.exclusions=**/*.spec.ts \
                  -Dsonar.projectName=clinic-frontend \
                  -Dsonar.projectVersion=1.0 \
                  -Dsonar.login=$SONAR_TOKEN
              '''
            }
          }
        }
      }
    }
  }
}
