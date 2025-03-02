pipeline {
    agent any

    stages {
        stage ('Clone Sources')
            steps {
                git URL: 'https://github.com/Talim1738/WK-5-Assignment.git'
            }
    }

    environment {
        SONARQUBE_SERVER = 'SonarQube'
    }

    stages {
        stage('Building Stage') {
            steps {
                echo 'Building the project...'
            }
        }
    }

      node {
  stage('SCM') {
    checkout scm
  }
      }
  stage('SonarQube Analysis') {
    def mvn = tool 'Default Maven';
    withSonarQubeEnv() {
      bat "${mvn}/bin/mvn clean verify sonar: sonar -Dsonar.projectKey=task1 -Dsonar.projectName='task1'"
    }
  }

        stage('Quality Gate') {
            steps {
                waitForQualityGate abortPipeline: true
        }
        stage('Testing Stage') {
            steps {
                echo 'Running tests...'
            }
        }
        }
        stage('Deploy Stage') {
            steps {
                echo 'Deploying application...'
            }
        }
        stage('Releasing Stage') {
            steps {
                echo 'Releasing the Application...'
            }
        }
    
