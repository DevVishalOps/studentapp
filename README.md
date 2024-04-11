# Building and Testing StudentApp using Jenkins CI/CD

We will create jenkins pipeline  for this task 

I have used Maven,Sonarqube and Github for CI/CD .
 


## Prequestite

- JAVA version  

- Jenkins

- Maven 

- Sonarqube  
 
## Installation

- Install java with version open-jdk-11 for jenkins and choose instance type as "t2.medium" for better performance

- Install Maven and tomcat on jenkins

- Install sonarqube on seperate server and choose instance type as t2.large for testing perpose


## Steps

1.clone this public get repository in your jenkins server
bash
git clone 
#this is groovy script repository 


2.Create pipline using below steps
    
- Go jenkins dashboard ------> 
- new item --------> 
- select pipline as code--> 
- Select pipeline ------> 
- pipeline script from SCM-->
- select GIT ---> 
- Enter Groovy script url mentioned above --> 
- choose branch according--> 
- Script path Enter name of Groovy script File

3.Our Script for reference 
```bash
pipeline {
    agent any

    stages {

        stage('Pull') {
            steps {
                git 'https://github.com/chetansomkuwar254/studentapp.ui.git' 
                #This is studentapp repository 
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
                sh '/opt/apache-maven-3.6.3/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp-ui -Dsonar.host.url=http://52.66.207.203:9000 -Dsonar.login=75df1c9e34a0449ff40447fe08bd4b8424396605'
                echo 'Testing done'
            }
        } 

        stage('Deploy') {
            steps {
            echo 'Deployed !!!!!!!!'
          }
    }
}
```

4.If your facing error running sonarqube then change java version to jdk11-bellsoft

### Install java-jdk-bellsoft to handle error
```bash
yum install wget epel-release -y
yum install java -y
wget https://download.bell-sw.com/java/11.0.4/bellsoft-jdk11.0.4-linux-amd64.rpm
rpm -ivh bellsoft-jdk11.0.4-linux-amd64.rpm
```

### change java jdk
```bash 
alternatives --config java ----#to change java jdk 
```
