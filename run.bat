@echo off
REM Script để chạy trình duyệt Web Java

echo ========================================
echo     TRÌNH DUYỆT WEB JAVA
echo ========================================
echo.

set JAVAFX_PATH=javafx-sdk\javafx-sdk-21.0.5\lib

echo Đang khởi động trình duyệt...
echo.

java --module-path "%JAVAFX_PATH%" --add-modules javafx.controls,javafx.web,javafx.graphics -cp "bin;%JAVAFX_PATH%\*" application.WebBrowser

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ========================================
    echo LỖI: Không thể khởi động trình duyệt!
    echo ========================================
    echo.
    pause
)
