pipeline {
    agent any

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

        stage('Run Ansible Playbook') {
            steps {
                script {
                    
                    sh 'ansible-playbook playbook.yml'
                }
            }
        }

        stage('Releasing Stage') {
            steps {
                echo 'Releasing the Application...'
            }
        }
    }
}
