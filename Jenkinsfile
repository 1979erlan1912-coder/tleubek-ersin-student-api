pipeline {
    agent any
    environment {
        IMAGE_NAME = 'tleubek-ersin-student-api:v1.0-tleubek-ersin'
        STUDENT_NAME = 'Yersin Tleubek'
    }
    stages {
        stage('Checkout') {
            steps {
                echo "=========================================="
                echo "Pipeline execution for: \"
                echo "Checking out source code from GitHub..."
                echo "=========================================="
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo "Building Spring Boot application for \..."
                bat 'gradle bootJar --no-daemon'
            }
        }
        stage('Test') {
            steps {
                echo "Running automated tests for \..."
                bat 'gradle test --no-daemon'
            }
        }
        stage('Docker Build') {
            steps {
                echo "Building Docker image: \..."
                bat "docker build -t \ ."
            }
        }
        stage('Verify') {
            steps {
                echo "Verifying Docker image existence for \..."
                bat "docker images \"
            }
        }
    }
    post {
        always {
            echo "Pipeline finished for student: \"
        }
        success {
            echo "CI/CD Pipeline successfully executed all 5 stages!"
        }
        failure {
            echo "Pipeline failed. Stopping execution as required."
        }
    }
}
