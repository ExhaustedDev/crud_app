@echo off

set "TOMCAT_HOME=C:\Tomcat\apache-tomcat-9.0.118"
set "CATALINA_HOME=%TOMCAT_HOME%"
set "CATALINA_BASE=%TOMCAT_HOME%"

if not exist "%TOMCAT_HOME%\bin\startup.bat" (
    echo Tomcat startup.bat not found: "%TOMCAT_HOME%\bin\startup.bat"
    pause
    exit /b 1
)

if not exist "target\crud_app.war" (
    echo WAR file not found: target\spring_mvc.war
    echo First build the project with: mvn clean package
    pause
    exit /b 1
)

if exist "%TOMCAT_HOME%\webapps\crud_app.war" del "%TOMCAT_HOME%\webapps\crud_app.war"
if exist "%TOMCAT_HOME%\webapps\crud_app" rmdir /s /q "%TOMCAT_HOME%\webapps\crud_app"

copy "target\crud_app.war" "%TOMCAT_HOME%\webapps\crud_app.war"

pushd "%TOMCAT_HOME%\bin"
call startup.bat
popd

pause