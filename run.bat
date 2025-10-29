@echo off
REM Script để chạy trình duyệt Web Java

echo ========================================
echo     TRÌNH DUYỆT WEB JAVA
echo ========================================
echo.

set JAVAFX_PATH=javafx-sdk\javafx-sdk-21.0.5\lib
set MAIN_CLASS=application.WebBrowser

echo Đang khởi động trình duyệt...
echo.

java --module-path "%JAVAFX_PATH%" --add-modules javafx.controls,javafx.web,javafx.graphics -cp "bin;%JAVAFX_PATH%\*" %MAIN_CLASS%

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ========================================
    echo LỖI: Không thể khởi động trình duyệt!
    echo ========================================
    echo.
    echo Vui lòng đảm bảo:
    echo 1. Đã compile project trong Eclipse
    echo 2. JavaFX SDK đã được tải về
    echo 3. File .class đã có trong thư mục bin
    echo.
    pause
) else (
    echo.
    echo Trình duyệt đã đóng.
)
