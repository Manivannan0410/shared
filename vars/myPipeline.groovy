// Jenkins Pipeline script for building and managing a shared library
def call(){
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the shared library code from the Git repository
                 git branch: 'node-dev', url: 'https://github.com/Manivannan0410/shared.git'
            }
        }

        stage('Build') {
            steps {
                // Perform any build steps for your shared library
                script {
                    sh 'echo "Building the shared library..."'
                    // Add any build commands here
                      sh 'npm install'
                }
            }
        }

        stage('Docker image') {
            steps {
                // Publish the shared library to a repository or a shared location
                script {
                    sh 'echo "Publishing the shared library..."'
                    // Add commands to publish the library, e.g., pushing to a Nexus repository
                    sh 'docker build -t mani:v3'
                    sh 'docker images'
                }
            }
        }

        stage('Cleanup') {
            steps {
                // Clean up any temporary files or resources
                script {
                    sh 'echo "Cleaning up..."'
                    // Add cleanup commands if needed
                }
            }
        }
    }

    post {
        success {
            // Perform actions when the pipeline succeeds
            echo "Shared library pipeline succeeded!"
        }
        failure {
            // Perform actions when the pipeline fails
            echo "Shared library pipeline failed!"
        }
    }
}
}
