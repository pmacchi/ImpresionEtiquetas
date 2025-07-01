@echo off
setlocal

:: Ruta al ejecutable de Java dentro del JRE local
set JAVA_EXE=%~dp0jre\bin\java.exe

:: Verificar que exista java.exe
if not exist "%JAVA_EXE%" (
    echo ERROR: No se encontró el JRE en la carpeta "jre".
    pause
    exit /b
)

:: Ejecutar el JAR
"%JAVA_EXE%" -jar "%~dp0ImpresionEtiquetas.jar"

endlocal
pause
