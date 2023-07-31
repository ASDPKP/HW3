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
        stage('Building and Pushing Docker Image') {
            steps {
                script {
                    sh 'docker login -u asdpkp -p asdpkp+718293'
                    dockerImage = docker.build("asdpkp/swe645hw3")
                    dockerImage.push("yolo")
                }
            }
        }
        stage('Setting config account') {
            steps {
                script {
                    sh 'kubectl config view'
                    //sh "gcloud config set account '332015331661-compute@developer.gserviceaccount.com'"
                    //sh 'gcloud container clusters get-credentials hw3-microservices --region=us-east4'
                }
            }
        }
        
        /*stage('Deploying the the cluster') {
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

        stage('Seperator') {
            steps {
                echo ""
            }
        }*/
    }
}
