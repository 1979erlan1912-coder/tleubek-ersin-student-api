pipeline {
    agent any
    tools {
        jdk 'JDK17'
        gradle 'Gradle8.5'
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub...'
                checkout scm
            }
        }
    }
}
