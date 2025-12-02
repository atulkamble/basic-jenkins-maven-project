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

- **Java 21** compatibility
- **JUnit 5** for testing
- **JaCoCo** for code coverage
- **Jenkins Pipeline** configuration
- **Maven** build automation

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Jenkins with required plugins

## Local Development

### Essential Maven Commands

#### Build & Compile
```bash
# Clean the project (removes target directory)
mvn clean

# Compile source code only
mvn compile

# Compile source + test code
mvn test-compile

# Clean and compile (recommended for fresh builds)
mvn clean compile
```

#### Testing
```bash
# Run all tests with code coverage report
mvn test

# Skip tests during other phases
mvn package -DskipTests
```

#### Packaging & Installation
```bash
# Create JAR file (includes compile + test + package)
mvn package

# Install to local Maven repository
mvn install

# Verify project integrity
mvn verify
```

#### Running the Application
```bash
# Method 1: Direct Java execution
java -cp target/classes com.example.app.App

# Method 2: Using Maven exec plugin
mvn exec:java -Dexec.mainClass="com.example.app.App"

# Method 3: Run JAR file (requires main class configuration in pom.xml)
# Currently not configured - use Method 1 or 2 instead
```

#### Project Information & Reports
```bash
# View dependency tree
mvn dependency:tree

# Generate project site with reports
mvn site

# View all available plugins and goals
mvn help:describe -Dplugin=help
```

#### Complete Lifecycle Commands
```bash
# Full build lifecycle (clean → compile → test → package)
mvn clean package

# Full build with installation to local repository
mvn clean install

# Full verification including integration tests
mvn clean verify
```

#### Code Coverage & Quality
```bash
# Run tests with JaCoCo coverage report
mvn test

# View coverage report at: target/site/jacoco/index.html
open target/site/jacoco/index.html

# Generate comprehensive project documentation
mvn site
open target/site/index.html
```

#### Development Troubleshooting
```bash
# Debug Maven execution with verbose output
mvn clean compile -X

# Show effective POM (resolved properties and inheritance)
mvn help:effective-pom

# Display project dependencies
mvn dependency:list

# Check for dependency conflicts
mvn dependency:analyze

# Update snapshots and releases
mvn clean install -U

# Offline mode (use only local repository)
mvn clean compile -o
```

#### Performance & Optimization
```bash
# Parallel builds (use multiple CPU cores)
mvn clean install -T 4

# Skip documentation generation for faster builds
mvn clean install -Dmaven.javadoc.skip=true

# Memory optimization for large projects
export MAVEN_OPTS="-Xmx2048m -XX:MaxPermSize=256m"
mvn clean install
```

#### Useful Maven Properties
```bash
# Skip tests entirely
mvn clean install -DskipTests=true

# Skip compilation of test sources
mvn clean install -Dmaven.test.skip=true

# Force update of snapshots and releases
mvn clean install -Dfork=true -U

# Run specific test class
mvn test -Dtest=AppTest

# Run specific test method
mvn test -Dtest=AppTest#testGetMessage
```

### Project Output Files
After running Maven commands, you'll find generated files in:
- `target/classes/` - Compiled main source code
- `target/test-classes/` - Compiled test source code  
- `target/surefire-reports/` - Test execution reports
- `target/site/jacoco/` - Code coverage reports
- `target/site/` - Project documentation (after `mvn site`)
- `target/*.jar` - Packaged JAR files (after `mvn package`)

### Java 21 Features
This project is configured to use Java 21 LTS, which includes:
- Virtual Threads (Project Loom)
- Pattern Matching for switch expressions
- Record patterns
- String templates (preview)
- Foreign Function & Memory API improvements

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