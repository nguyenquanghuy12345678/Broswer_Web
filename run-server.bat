@echo off
REM Script để chạy Web Server độc lập

echo ========================================
echo     JAVA WEB SERVER
echo ========================================
echo.

echo Đang khởi động Web Server...
echo.

java -cp "bin" application.SimpleWebServer

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ========================================
    echo LỖI: Không thể khởi động server!
    echo ========================================
    echo.
    pause
)
