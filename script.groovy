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
        
        stage('Test') {
            steps {
                sh '/opt/apache-maven-3.6.3/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp-ui -Dsonar.host.url=http://13.127.128.160:9000 -Dsonar.login=e85baf2346bae9a49601f371fb7d8ed2b6537b79'
                echo 'Hello World'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying Stage'
            }
        }
    }
}
