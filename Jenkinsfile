pipeline {
    agent any
    environment {
        docker_creds = credentials('docker-credentials')
        }
    stages {
        stage('Checking for updates to the GitHub master repo') {
            steps {
                checkout scm
                }
            }

        stage('Logging into Docker') {
            steps {
                sh "docker login -u ${docker_creds_USR} -p ${docker_creds_PSW}"
                }
            }
        
        stage('Building and Pushing Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("asdpkp/latest_hw3:latest")
                    dockerImage.push("latest")
                }
            }
        }
        
        stage('Cleaning the cluster') {
            steps {
                //sh 'kubectl delete pvc mysql-pvc -n myapp-namespace'
                sh 'kubectl delete deployments myapp -n nginx-app-namespace'
                sh 'kubectl delete deployments mysqldbi -n nginx-app-namespace'
                sh 'kubectl delete svc mysqldb-svc -n nginx-app-namespace'
                sh 'kubectl delete svc myapp-svc -n nginx-app-namespace'
                //sh 'kubectl delete namespace myapp-namespace'
                //sh 'kubectl create namespace myapp-namespace'
                }
            }

        stage('Deploying the MySQL container') {
            steps {
                sh 'kubectl apply -f mysql-deployment.yaml -n nginx-app-namespace'
                }
            }

        stage('Deploying the Web Application container') {
            steps {
                sh 'kubectl apply -f app-deployment.yaml -n nginx-app-namespace'
                }
            }

    }
}
