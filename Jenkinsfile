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
        stage('Login Successful') {
            steps {
                echo "Success!!!"
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'sudo docker login -u asdpkp -p asdpkp+718293'
                    def newImage = docker.build("swe645hw3")
                    sh 'sudo docker push asdpkp/swe645hw3'
                }
            }
        }
    }
}
