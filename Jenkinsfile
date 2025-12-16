pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('Sonar_Token') // use straight single quotes
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/saladin-scs/tpSki.git'
            }
        }

        stage('Maven SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('sonar-server') {
                        sh """
                            mvn sonar:sonar \
                            -Dsonar.projectKey=TP-SKI_VF \
                            -Dsonar.login=${SONAR_TOKEN}
                        """
                    }
                }
            }
        }
    }
}
