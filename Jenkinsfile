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

        /*stage('Checking kube config') {
            steps {
                sh 'kubectl delete --all deployments'
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
        }*/

        stage("Get pods status") {
            steps {
                //sh 'kubectl get deployments'
                //sh 'kubectl logs myapp-6b8bbf978-l2b44'
                echo '++++++++++++++++++++++++++++++++++++++++++++++++'
                //sh 'kubectl logs mysqldbi-679bc5fc85-ntjll'
                sh 'kubectl get pods'
                sh 'kubectl logs myapp-8fbf6868f-zk8cv'
            }
        }
    }
}
