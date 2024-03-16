pipeline {
    agent any

    stages {

        stage('Pull') {
            steps {
                git 'https://github.com/chetansomkuwar254/studentapp.ui.git'
                echo 'Hello World'
            }
        }

        stage('Build') {
            steps {
                sh '/opt/apache-maven-3.6.3/bin/mvn clean package'
                echo 'Hello World'
            }
        }

    }
}
