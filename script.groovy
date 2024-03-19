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
        
        stage('Deploy to EC2') {
            steps {
                script {
                    // Copy built artifacts to EC2 instance
                    sshagent(['ubuntuid']) {
                        sh 'scp -v /var/lib/jenkins/workspace/student-app/target/studentapp-2.2-SNAPSHOT.war root@ip-172-31-43-117:/opt/apache-tomcat-9.0.87/webapps'
                    }
                }
            }
        }
    }
}

