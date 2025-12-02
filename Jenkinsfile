pipeline {
    agent any
    tools {
        maven 'myMaven'
        jdk 'myJDK'
    }
    environment {
        MAVEN_OPTS = '-Xmx1024m'
    }
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/site/jacoco',
                        reportFiles: 'index.html',
                        reportName: 'Coverage Report'
                    ])
                }
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar'
                }
            }
        }
        stage('Deploy') {
            when {
                anyOf {
                    branch 'main'
                    branch 'release'
                }
            }
            steps {
                echo 'Deployment placeholder'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
