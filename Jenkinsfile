pipeline {
    agent any

    stages {

        stage(‘Checkout’) {
            steps {
                git branch: ‘main’, url: ‘https://github.com/saladin-scs/tpSki.git’
            }
        }

        stage(‘Build Maven’) {
            steps {
                sh ‘mvn clean install -DskipTests’
            }
        }

        stage(‘Maven SonarQube Analysis’) {
            steps {
                script {
                    withSonarQubeEnv(‘sonar-server’) {
                        sh ‘’’
                            mvn sonar:sonar \
                            -Dsonar.projectKey=TP-SKI_VF \
                            -Dsonar.java.binaries=target/classes
                        ‘’’
                    }
                }
            }
        }
    }
}
