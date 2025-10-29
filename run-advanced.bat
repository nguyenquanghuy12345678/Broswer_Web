@echo off
title Advanced Web Browser v2.0
echo ===================================
echo  ADVANCED WEB BROWSER v2.0
echo  Multi-Tab Edition
echo ===================================
echo.
echo Starting browser...
echo.

cd /d "%~dp0"

java --module-path "javafx-sdk\javafx-sdk-21.0.5\lib" --add-modules javafx.controls,javafx.web,javafx.graphics -cp "bin;javafx-sdk\javafx-sdk-21.0.5\lib\*" application.WebBrowserAdvanced

if errorlevel 1 (
    echo.
    echo ERROR: Failed to start browser!
    echo.
    pause
)
