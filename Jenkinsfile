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
                    // Check if ansible is installed
                    sh '''
                        if ! command -v ansible-playbook &> /dev/null; then
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
                    // Search for playbook.yml in the workspace and fail if not found
                    def playbookExists = sh(script: 'test -f playbook.yml', returnStatus: true)
                    if (playbookExists != 0) {
                        error 'playbook.yml not found. Failing the build.'
                    }
                }
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
                    // Run the ansible-playbook command
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
