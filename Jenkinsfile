//def usrname = "asdpkp"
//def psswrd = "asdpkp+718293"

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
                echo "Docker Hub Username: ${docker_creds_USR}"
                echo "Docker Hub Password: ${docker_creds_PSW}"
                }
            }
        
        stage('Building and Pushing Docker Image') {
            steps {
                script {
                    sh 'docker login -u asdpkp -p asdpkp+718293'
                    dockerImage = docker.build("asdpkp/latest_hw3:latest")
                    dockerImage.push("latest")
                }
            }
        }

    }
}
