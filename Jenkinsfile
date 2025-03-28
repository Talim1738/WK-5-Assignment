pipeline {
    agent any

    environment {
        SONARQUBE_URL = 'http://localhost:9000'
        SONARQUBE_TOKEN = credentials('sonarway') // Store the token in Jenkins Credentials
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Talim1738/WK-5-Assignment.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh """
                        mvn clean verify sonar:sonar \
                        -Dsonar.projectKey=Sonar \
                        -Dsonar.projectName='Sonar' \
                        -Dsonar.host.url=$SONARQUBE_URL \
                        -Dsonar.token=$SONARQUBE_TOKEN
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    def qg = waitForQualityGate()
                    if (qg.status != 'OK') {
                        error "Pipeline failed due to quality gate failure: ${qg.status}"
                    }
                }
            }
        }
    }
}
