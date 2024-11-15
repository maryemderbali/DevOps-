pipeline {
    agent any

    stages {
        stage('Clone ') {
            steps {
                script {
                    echo 'Step 1: Cloning the repository from GitHub...'
                }
                git credentialsId: 'maryemderbali', branch: 'Maryem', url: 'https://github.com/Yassynmss/DevOps5.git'
            }
        }
         stage('Build Image') {
            steps {
                script {
                    echo 'Step 2: Building the backend Docker image...'
                }
                sh 'docker build -t maryem1708/5se2 .'
            }
        }
        
        stage('Push Image to Docker Hub') {
            steps {
                script {
                    echo 'Step 3: Pushing the Docker image to Docker Hub...'
                }
                sh 'docker login -u maryem1708 -p Maryem27*'
                sh 'docker push maryem1708/5se2'
            }
        }
        
       
        
        stage('Check Docker Compose') {
            steps {
                 
                script {
                    echo 'Step 4: Checking the status of running Docker containers...'
                }
                sh 'docker ps'
                sh 'docker-compose logs'}
            
        } 
     stage('Deploy') {
            steps {
                script {
                    echo 'Step 5: Starting application services using Docker Compose...'
                }
                sh 'docker-compose up -d'
            }
        }   
    
         stage('Start Database') {
            steps {
                script {
                    echo 'Step 6: Starting the test database container...'
                }
                sh 'docker-compose -f docker-compose.yml up -d mysql'
            }
        }

  stage('Build') {
            steps {
                 script {
                    echo 'Step 7: Building the project with Maven...'
                }
                 sh 'mvn clean package'
            }
        }

  stage('Verify Target ') {
    steps {
        script {
            sh 'ls -la target/'
        }
    }
}


      stage('JaCoCo ') {
            steps {
                echo 'Generating JaCoCo report...'
                sh "mvn jacoco:report"
            }
        }

        

        stage('SonarQube ') {
            steps {
                script {
                    sh '''
                    mvn sonar:sonar \
                        -Dsonar.projectKey=Maryemdev  \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.login=sqp_809b72d1c12e57291884c6dff3077f41af9cdf94 \
                        -Dsonar.jacoco.reportPaths=target/site/jacoco/jacoco.xml
                    '''
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo 'Step 11: Running unit tests and collecting results...'
                }
                sh 'mvn test'
                junit 'target/surefire-reports/*.xml'

            }
           
        }

        
        stage('Docker Build') {
            steps {
                script {
                    echo 'Step 12: Building the Docker image for the application...'
                }
                sh 'docker build -t devopsprojectspring:latest .'


            }
        }

        stage('Docker Run') {
            steps {
                  script {
                    echo 'Step 13: Running the Docker container for the application...'
                }
                 sh 'docker run -d -p 8083:8080 --name devops-project-spring devopsprojectspring:latest'
            }
        }

      stage( 'Nexus') {
    steps {
        script {
            script {
                    echo 'Step 14: Uploading the artifact to Nexus repository...'
                }
            def nexusUrl = "http://localhost:8081/repository/"
            def artifactId = "firstProject"
            def version = "0.0.1"  // Assurez-vous que cette version est sans -SNAPSHOT
            def packaging = "jar"
            def nexusUser = "admin"
            def nexusPassword = "nexus"
            def repository = "maven-releases"   

             sh """
            mvn deploy:deploy-file \
                -DgroupId=tn.esprit \
                -DartifactId=${artifactId} \
                -Dversion=${version} \
                -Dpackaging=${packaging} \
                -Dfile=target/${artifactId}-${version}.${packaging} \
                -DrepositoryId=deploymentRepo \
                -Durl=${nexusUrl}${repository}/ \
                -DpomFile=pom.xml \
                -Dusername=${nexusUser} \
                -Dpassword=${nexusPassword}
            """
        }
    }
}

    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Le pipeline a réussi !'
        }
        failure {
            echo 'Le pipeline a échoué.'
        }
    }
}
 
