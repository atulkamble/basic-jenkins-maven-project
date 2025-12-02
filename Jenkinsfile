pipeline {
    agent any
    
    tools {
        maven 'Maven-3.8.1' // Configure this in Jenkins Global Tool Configuration
        jdk 'JDK-21'        // Configure this in Jenkins Global Tool Configuration
        // Note: Tool names must match exactly what's configured in Jenkins
        // Go to: Manage Jenkins > Global Tool Configuration to set up tools
    }
    
    environment {
        // Define environment variables
        MAVEN_OPTS = '-Xmx1024m'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                // Source code is automatically checked out by Jenkins
                // This stage is mainly for logging purposes
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
            post {
                always {
                    // Publish test results
                    publishTestResults testResultsPattern: 'target/surefire-reports/*.xml'
                    // Publish JaCoCo code coverage reports
                    publishCoverage adapters: [jacocoAdapter('target/site/jacoco/jacoco.xml')], sourceFileResolver: sourceFiles('STORE_LAST_BUILD')
                }
            }
        }
        
        stage('Package') {
            steps {
                echo 'Packaging the application...'
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    // Archive the built artifacts
                    archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: false
                }
            }
        }
        
        stage('Deploy') {
            when {
                anyOf {
                    branch 'main'
                    branch 'appmod/java-upgrade-*'
                }
            }
            steps {
                echo 'Deploying application...'
                // Add your deployment steps here
                // Example: sh 'scp target/*.jar user@server:/path/to/deploy/'
                echo 'Deployment completed successfully!'
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline execution completed.'
            // Clean up workspace if needed
            // cleanWs()
        }
        success {
            echo 'Pipeline executed successfully!'
            // Add notification steps for success
        }
        failure {
            echo 'Pipeline execution failed!'
            // Add notification steps for failure
            // emailext subject: "Pipeline Failed: ${env.JOB_NAME} - ${env.BUILD_NUMBER}",
            //          body: "Build failed. Check Jenkins for details.",
            //          to: "team@company.com"
        }
    }
}
