pipeline {
    agent any

    environment {
        KUBECONFIG = credentials('kubeconfig') // match the ID of your secret file
    }

    stages {
        stage('Clone Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Kalpeshbonde/DEVOPS-VLE-6.git'
            }
        }

        stage('Build with Maven') {
            steps {
                dir('sample') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Deploy to Minikube') {
            steps {
                sh '''
                  kubectl config get-contexts
                  kubectl apply -f deployment.yaml --validate=false
                  kubectl apply -f service.yaml --validate=false
                '''
            }
        }
    }
}
