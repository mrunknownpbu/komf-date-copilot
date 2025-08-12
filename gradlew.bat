@echo off
rem Gradle wrapper script for Windows

set DIR=%~dp0
if "%DIR%"=="" set DIR=.

set GRADLE_HOME=%DIR%gradle\wrapper
set GRADLE_VERSION=7.4.2

if not exist "%GRADLE_HOME%\gradle-%GRADLE_VERSION%\bin\gradle.bat" (
    echo Downloading Gradle %GRADLE_VERSION%...
    curl -L https://services.gradle.org/distributions/gradle-%GRADLE_VERSION%-bin.zip -o gradle.zip
    mkdir "%GRADLE_HOME%"
    powershell -Command "Expand-Archive -Path gradle.zip -DestinationPath %GRADLE_HOME% -Force"
    del gradle.zip
)

"%GRADLE_HOME%\gradle-%GRADLE_VERSION%\bin\gradle.bat" %*