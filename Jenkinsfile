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
