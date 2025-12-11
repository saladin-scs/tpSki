pipeline {
    agent any

    environment {
        // Ton token SonarQube stocké dans Jenkins Credentials
        SONAR_TOKEN = credentials('sonar-token-id')
    }

    stages {

        stage('Checkout') {
            steps {
                // Récupérer ton projet depuis Git
                git branch: 'main', url: 'https://github.com/saladin-scs/tpSki.git'
            }
        }

        stage('Build Maven') {
            steps {
                // Compiler le projet Maven et générer les classes
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Maven SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh """
                        mvn sonar:sonar \
                        -Dsonar.projectKey=TP-SKI_VF \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.token=$SONAR_TOKEN \
                        -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }
    }
}
