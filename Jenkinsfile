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
                        bat 'mvn clean verify sonar:sonar -Dsonar.projectKey=task1 -Dsonar.host.url=http://localhost:9000 -Dsonar.login=task1'
                    }
                }
            }
        }
        stage('Quality Gate') {
            steps {
                script {
                    // Check quality gate status
                    timeout(time: 1, unit: 'HOURS') {
                        def qualityGate = waitForQualityGate()
                        if (qualityGate.status != 'OK') {
                            error "Pipeline failed due to quality gate failure: ${qualityGate.status}"
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
    }
}
