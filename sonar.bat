SET JAVA_HOME=C:\Program Files\Java\jre1.8.0_131
SET SONAR_RUNNER_HOME=D:\SONARQUBE\sonar-runner-2.4
SET SONAR_RUNNER_OPTS=-Xmx512m -XX:MaxPermSize=128m

set path=%path%;D:\SONARQUBE\sonar-runner-2.4\bin
pause
sonar-runner.bat -X
pause