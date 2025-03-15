pipeline {
    agent any

    stages {
        stage('Clone Sources') {
            steps {
                git branch: 'main', url: 'https://github.com/Talim1738/WK-5-Assignment.git'
            }
        }

        stage('Verify Ansible is Installed') {
            steps {
                script {
                    // Check if ansible and ansible-playbook are installed using WSL
                    bat '''
                        wsl if ! command -v ansible &> /dev/null || ! command -v ansible-playbook &> /dev/null; then
                            echo "Ansible is not installed. Failing the build."
                            exit 1
                        fi
                    '''
                }
            }
        }

        stage('Verify Playbook Exists') {
            steps {
                script {
                    // Check if playbook.yml exists using WSL
                    def playbookExists = bat(script: 'wsl test -f playbook.yml', returnStatus: true)
                    if (playbookExists != 0) {
                        error 'playbook.yml not found. Failing the build.'
                    }
                }
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

        stage('Run Ansible Playbook') {
            steps {
                script {
                    // Run ansible-playbook within WSL
                    bat 'wsl ansible-playbook playbook.yml'
                }
            }
        }

        stage('Release') {
            steps {
                echo 'Releasing the application...'
            }
        }
    }
}
