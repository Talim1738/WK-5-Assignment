pipeline {
    agent any

    stages {
        stage('Clone Sources') {
            steps {
                git branch: 'main', url: 'https://github.com/Talim1738/WK-5-Assignment.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
            }
        }

        node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def scannerHome = tool 'SonarScanner for .NET'
    withSonarQubeEnv() {
      bat "dotnet ${scannerHome}\\SonarScanner.MSBuild.dll begin /k:\"task1\""
      bat "dotnet build"
      bat "dotnet ${scannerHome}\\SonarScanner.MSBuild.dll end"
    }
  }
}
plugins {
  id "org.sonarqube" version "6.0.1.5171"
}

sonar {
  properties {
    property "sonar.projectKey", "task1"
    property "sonar.projectName", "task1"
  }
}

        node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Default Maven';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=task1 -Dsonar.projectName='task1'"
    }
  }
}

        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
        }

        stage('Release') {
            steps {
                echo 'Releasing the application...'
            }
        }
    }
}
