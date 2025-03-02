pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'SonarQube'  
    }

    stages {
        stage('Building Stage') {
            steps {
                echo 'Building the project...'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run SonarQube scanner for analysis
                    withSonarQubeEnv(SONARQUBE_SERVER) {
                      bat 'mvn clean verify sonar:sonar -Dsonar.projectKey=task1 -Dsonar.host.url=http://your-sonarqube-url -Dsonar.login=your-sonar-token'

                    }
                }
            }
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
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run SonarQube scanner for analysis
                    withSonarQubeEnv(SONARQUBE_SERVER) {
                      bat 'mvn clean verify sonar:sonar -Dsonar.projectKey=task1 -Dsonar.host.url=http://your-sonarqube-url -Dsonar.login=your-sonar-token'

                    }
                }
            }
        }
    stage('SonarQube Analysis') {
            steps {
                script {
                    // Run SonarQube scanner for analysis
                    withSonarQubeEnv(SONARQUBE_SERVER) {
                      bat 'mvn clean verify sonar:sonar -Dsonar.projectKey=task1 -Dsonar.host.url=http://your-sonarqube-url -Dsonar.login=your-sonar-token'

                    }
                }
            }
        }
    }
}
