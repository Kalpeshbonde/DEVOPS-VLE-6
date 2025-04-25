pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "sample-java-app:${BUILD_NUMBER}"
    }

    stages {
        stage('Clone Code') {
            steps {
                git 'https://github.com/Kalpeshbonde/DEVOPS-VLE-6.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Deploy to Minikube') {
            steps {
                sh '''
                  kubectl set image deployment/sample-app-deployment sample-container=$DOCKER_IMAGE || \
                  kubectl apply -f deployment.yaml && kubectl apply -f service.yaml
                '''
            }
        }
    }
}
