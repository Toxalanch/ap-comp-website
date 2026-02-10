# AP Computer Science A Website
## How to Install
### Installation Dependencies
1. <b>Java:</b><br>
Version 21.0.10 or later within version 21 (Tomcat version 10 is not compatable with anything later than 21)<br><br>
2. <b>Docker Desktop:</b><br>
Version 28.0.1 or later<br><br>
3. <b>Tomcat:</b><br>
Version 10.1.52 or later within version 10 (version 11 is not compatable with JDK 21)

### Installation Procedure<br>
1. Set JAVA_HOME to your java directory
2. Set CATALINA_HOME to your tomcat base directory

## How to Run
1. Build the DockerFile (If not built or updated)<br>
All of this will be run on the system hosting the server. If run locally then do it on the local system.
    * Windows & Mac only:<br>
    Startup docker engine
    * Run Command in the same directory as the dockerfile:<br>
        * Windows:
        `docker build -t java-runner:1.0.0 ./.`
        * Linux & Mac: `docker build -t java-runner:1.0.0 ./.`<br>

2. Get the war file from the cmd
    * Windows:
    `.\gradlew war`
    * Linux/Mac:
    `./gradlew war`
3. Move the [war](app/build/libs/myWebApp-1.0.war) to the tomcat directory: `%CATALINA_HOME%/webapps/`
4. Start the server: `%CATALINA_HOME%/bin/startup`
5. Go to [webpage](http://localhost:8080/myWebApp-1.0)
6. Shutdown the server at any time: `%CATALINA_HOME%/bin/shutdown`