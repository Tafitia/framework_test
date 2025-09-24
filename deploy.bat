@echo off
set APP_NAME=test
set SRC_DIR=src
set WEB_DIR=WEB-INF
set BUILD_DIR=build
set LIB_DIR=lib
set TOMCAT_WEBAPPS="C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps"
set SERVLET_API_JAR=%LIB_DIR%\servlet-api.jar
set FRAMEWORK_JAR=%LIB_DIR%\myframework.jar

REM Suppression et recréation du dossier temporaire
if exist "%BUILD_DIR%" rmdir /s /q "%BUILD_DIR%"
mkdir "%BUILD_DIR%\WEB-INF\classes"
mkdir "%BUILD_DIR%\WEB-INF\lib"

REM Compilation des fichiers Java avec le JAR des Servlets et framework
dir /s /b "%SRC_DIR%\*.java" > sources.txt
javac -cp "%SERVLET_API_JAR%;%FRAMEWORK_JAR%" -d "%BUILD_DIR%\WEB-INF\classes" @sources.txt
del sources.txt

REM Copier les JAR de dépendances dans WEB-INF/lib
copy "%FRAMEWORK_JAR%" "%BUILD_DIR%\WEB-INF\lib\"

REM Copier la structure WEB-INF existante (web.xml et classes précompilées)
xcopy %WEB_DIR% %BUILD_DIR%\WEB-INF /E /I /Y

REM Création du fichier .war dans le dossier build
pushd "%BUILD_DIR%"
jar -cvf %APP_NAME%.war *
popd

REM Déploiement vers Tomcat
copy "%BUILD_DIR%\%APP_NAME%.war" %TOMCAT_WEBAPPS%

echo Déploiement terminé. Redémarrez Tomcat si nécessaire.