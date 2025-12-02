# Basic Jenkins Maven Project

A simple Java Maven project configured for Jenkins CI/CD pipeline.

## Project Structure

```
basic-jenkins-maven-project/
├── pom.xml                 # Maven project configuration
├── Jenkinsfile            # Jenkins pipeline configuration
├── README.md              # This file
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               └── app/
    │                   └── App.java      # Main application class
    └── test/
        └── java/
            └── com/
                └── example/
                    └── app/
                        └── AppTest.java  # Unit tests
```

## Features

- **Java 11** compatibility
- **JUnit 5** for testing
- **JaCoCo** for code coverage
- **Jenkins Pipeline** configuration
- **Maven** build automation

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Jenkins with required plugins

## Local Development

### Build the project
```bash
mvn clean compile
```

### Run tests
```bash
mvn test
```

### Package the application
```bash
mvn package
```

### Run the application
```bash
java -cp target/classes com.example.app.App
```

## Jenkins Setup

### Required Jenkins Plugins
- Pipeline Plugin
- Maven Integration Plugin
- JUnit Plugin
- JaCoCo Plugin

### Jenkins Configuration
1. Install Maven and JDK in Jenkins Global Tool Configuration:
   - Maven: Name it "Maven-3.8.1" (or update Jenkinsfile accordingly)
   - JDK: Name it "JDK-11" (or update Jenkinsfile accordingly)

2. Create a new Pipeline job in Jenkins
3. Configure the job to use this repository
4. Set the pipeline script path to `Jenkinsfile`

### Pipeline Stages
1. **Checkout**: Source code checkout
2. **Build**: Compile the Java sources
3. **Test**: Run unit tests with coverage
4. **Package**: Create JAR artifacts
5. **Deploy**: Deploy to target environment (main branch only)

## Customization

- Update the `groupId`, `artifactId`, and `version` in `pom.xml`
- Modify the Jenkins tool names in `Jenkinsfile` to match your Jenkins configuration
- Add deployment steps in the Deploy stage of `Jenkinsfile`
- Configure email notifications in the post-failure section

## Output

The build produces:
- Compiled classes in `target/classes/`
- Test reports in `target/surefire-reports/`
- Code coverage reports in `target/site/jacoco/`
- JAR file in `target/`