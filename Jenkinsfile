pipeline {
    agent any
    environment {
        IMAGE_NAME = "tleubek-ersin-student-api:v1.0-tleubek-ersin"
        STUDENT_NAME = "Yersin Tleubek"
    }
    stages {
        stage("Checkout") {
            steps {
                echo "=========================================="
                echo "Pipeline execution for: ${env.STUDENT_NAME}"
                echo "Checking out source code from GitHub..."
                echo "=========================================="
                checkout scm
            }
        }
        stage("Build & Test") {
            steps {
                echo "Building application and running tests via Docker..."
                bat "docker build -t ${env.IMAGE_NAME} ."
            }
        }
        stage("Docker Build") {
            steps {
                echo "Personalized Docker image built successfully: ${env.IMAGE_NAME}"
            }
        }
        stage("Verify") {
            steps {
                echo "Verifying Docker image existence for ${env.STUDENT_NAME}..."
                bat "docker images ${env.IMAGE_NAME}"
            }
        }
    }
    post {
        always {
            echo "Pipeline finished for student: ${env.STUDENT_NAME}"
        }
        success {
            echo "CI/CD Pipeline successfully executed all 5 stages!"
        }
        failure {
            echo "Pipeline failed. Stopping execution as required."
        }
    }
}
