FROM openjdk:19
EXPOSE  8082
ADD springProject-0.0.1-SNAPSHOT.jar springProject-docker.jar
ENTRYPOINT ["java", "-jar" , "springProject-docker.jar"]

 stage('Create Project Artifact') {
                    steps {
                        script {
                            echo 'Running Docker Compose to create project artifact...'
                           dir('Mini-Projet-main/Mini-Projet-main') {

                                sh 'docker-compose up -d'
                            }
                        }
                    }
                }