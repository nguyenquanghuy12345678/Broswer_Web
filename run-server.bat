@echo off
REM Script để chạy Web Server độc lập

echo ========================================
echo     JAVA WEB SERVER
echo ========================================
echo.

cd /d "%~dp0"

echo Đang khởi động Web Server...
echo.

java -cp "bin" application.SimpleWebServer

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ========================================
    echo LỖI: Không thể khởi động server!
    echo ========================================
    echo.
    echo Vui lòng đảm bảo:
    echo 1. Đã compile project trong Eclipse
    echo 2. File .class đã có trong thư mục bin
    echo.
    pause
)
