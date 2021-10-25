pipeline {
    agent any
    stages {
        stage ('Compile Stage') {
            steps {
                withMaven(maven : 'maven3') {
                    bat 'mvn clean compile'
                }
            }
        }
        stage ('Testing Stage') {
            steps {
                withMaven(maven : 'maven3') {
                    bat 'mvn test'
                }
            }
        }
        stage ('Code Coverage Stage') {
            steps {
                withMaven(maven : 'maven3') {
                    bat 'mvn jacoco:report'
                }
            }
        }
        stage ('Sonar Analysis Stage') {
            steps {
                withMaven(maven : 'maven3'){
                withCredentials([string(credentialsId: 'sonartoken25', variable: 'SECRET')]){
                    bat 'mvn sonar:sonar -Dsonar.login="${SECRET}"'
                }
                }
            }
        }
    }
}
