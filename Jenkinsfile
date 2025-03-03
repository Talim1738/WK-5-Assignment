pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'SonarQube'
    }

    stages {
        stage('Clone Sources') {
            steps {
                
                git branch: 'main', url: 'https://github.com/Talim1738/WK-5-Assignment.git'
            }
        }

        stage('Building Stage') {
            steps {
                echo 'Building the project...'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def mvn = tool 'maven3'
                    withSonarQubeEnv('SonarQube') {
                        
                        if (isUnix()) {
                            sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=task1 -Dsonar.projectName='task1'"
                        } else {
                            bat "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=task1 -Dsonar.projectName='task1'"
                        }
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }

        stage('Testing Stage') {
            steps {
                echo 'Running tests...'
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
    }
}
