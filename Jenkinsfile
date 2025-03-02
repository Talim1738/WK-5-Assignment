pipeline {
    agent any

    stages {
        stage('Building Stage') {
            steps {
                echo 'Building the project...'
            }
        }
        stage('Testing Stage') {
            steps {
                echo 'Running tests...'
            }

          stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube Scanner') { 
                    sh 'mvn sonar:sonar -Dsonar.projectKey=Task1 -Dsonar.host.url=http://localhost:9000'
                }
            }
        }
        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    def qg = waitForQualityGate()
                    if (qg.status != 'OK') {
                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    }
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
    }
}
