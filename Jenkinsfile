pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'SonarQube'  
    }

    stages {
        stage('Building Stage') {
            steps {
               bat echo 'Building the project...'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run SonarQube scanner for analysis
                    withSonarQubeEnv(SONARQUBE_SERVER) {
                        sonar-scanner.bat -D"sonar.projectKey=task1" -D"sonar.sources=." -D"sonar.host.url=http://localhost:9000" -D"sonar.token=sqp_956251bbf18789772ace164c164fbf64a10b6b21"
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
