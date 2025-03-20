pipeline {
    agent any

    tools {
        maven 'maven3'
        jdk 'jdk21'
        // SonarScanner for .NET is already defined in environment
    }

    environment {
        scannerHome = tool 'SonarScanner for .NET'
    }

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

        stage('SonarQube Analysis (.NET)') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat "${env.scannerHome}\\SonarScanner.MSBuild.dll begin /k:\"task1\""
                    bat 'dotnet build'
                    bat "${env.scannerHome}\\SonarScanner.MSBuild.dll end"
                }
            }
        }

        stage('SonarQube Analysis (Maven)') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "${tool 'Default Maven'}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=task1 -Dsonar.projectName='task1'"
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
