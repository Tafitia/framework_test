@echo off
set APP_NAME=framework_test
set SRC_DIR=src\main\java
set WEB_DIR=src\main\webapp
set BUILD_DIR=build
set LIB_DIR=lib
set TOMCAT_WEBAPPS="C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps"
set SERVLET_API_JAR=%LIB_DIR%\servlet-api.jar

REM Suppression et recréation du dossier temporaire
if exist "%BUILD_DIR%" rmdir /s /q "%BUILD_DIR%"
mkdir "%BUILD_DIR%\WEB-INF\classes"
mkdir "%BUILD_DIR%\WEB-INF\lib"

REM Compilation du Framework (FrontServlet)
echo Compilation du Framework...
cd ..\Framework
call build_framework.bat
if %ERRORLEVEL% NEQ 0 (
    echo Erreur lors de la compilation du framework!
    cd ..\framework_test
    exit /b 1
)
cd ..\framework_test

REM Compilation des fichiers Java de test
echo Compilation des classes de test...
dir /s /b "%SRC_DIR%\*.java" > sources.txt
javac -cp "%SERVLET_API_JAR%;%BUILD_DIR%\WEB-INF\classes" -d "%BUILD_DIR%\WEB-INF\classes" @sources.txt
del sources.txt

REM Copier les fichiers webapp (HTML, JSP, etc.)
if exist "%WEB_DIR%\*.html" copy "%WEB_DIR%\*.html" "%BUILD_DIR%\"
if exist "%WEB_DIR%\*.jsp" copy "%WEB_DIR%\*.jsp" "%BUILD_DIR%\"

REM Copier le web.xml
copy "%WEB_DIR%\WEB-INF\web.xml" "%BUILD_DIR%\WEB-INF\"

REM Création du fichier .war dans le dossier build
pushd "%BUILD_DIR%"
jar -cvf %APP_NAME%.war *
popd

REM Déploiement vers Tomcat
copy "%BUILD_DIR%\%APP_NAME%.war" %TOMCAT_WEBAPPS%

echo Déploiement terminé. Redémarrez Tomcat si nécessaire.