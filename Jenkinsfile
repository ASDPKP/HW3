def usrname = "asdpkp"
def psswrd = "asdpkp+718293"

pipeline {
    agent any
    environment {
        docker_creds = credentials('docker-credentials')
        }

    stages {
        stage('Testing for changes') {
            steps {
                echo 'Testing!!!'
                checkout scm
                }
            }

        stage('Logging into Docker') {
            steps {
                echo "Docker Hub Username: ${usrname}"
                echo "Docker Hub Password: ${psswrd}"
                }
            }
        
        stage('Building and Pushing Docker Image') {
            steps {
                script {
                    sh 'docker login -u asdpkp -p asdpkp+718293'
                    dockerImage = docker.build("asdpkp/final_hw3_swe645")
                    dockerImage.push("latest")
                }
            }
        }

        stage('Checking kube config') {
            step {
                sh 'kubectl config view'
            }
        }
                
        stage('Deploying the the cluster') {
            steps {
                script {
                    sh 'kubectl apply -f mysql-deployment.yaml'
                }
            }
        }

        stage('Starting a service yaml') {
            steps {
                sh 'kubectl apply -f app-deployment.yaml'
            }
        }
    }
}
