# 🚀 CÁCH CHẠY TRÌNH DUYỆT TRONG ECLIPSE

## ❌ LỖI: "JavaFX runtime components are missing"

Lỗi này xảy ra khi Eclipse chưa được cấu hình VM arguments cho JavaFX.

---

## ✅ GIẢI PHÁP 1: Sử dụng Run Configuration (KHUYẾN NGHỊ)

### Bước 1: Mở Run Configurations
1. Click menu **Run** → **Run Configurations...**
2. Hoặc: **Right-click** vào `WebBrowser.java` → **Run As** → **Run Configurations...**

### Bước 2: Tạo Configuration mới
1. Trong cửa sổ **Run Configurations**:
2. **Right-click** vào **Java Application** → **New Configuration**
3. Đặt tên: `WebBrowser` hoặc `Java Web Browser`

### Bước 3: Cấu hình Main tab
1. Chọn tab **Main**
2. **Project**: `Broswer_Web`
3. **Main class**: `application.WebBrowser` (click **Search** nếu chưa tự động điền)

### Bước 4: Thêm VM Arguments (QUAN TRỌNG)
1. Chọn tab **Arguments**
2. Trong phần **VM arguments**, paste dòng sau:

```
--module-path "d:\eclipse-workspace\Broswer_Web\javafx-sdk\javafx-sdk-21.0.5\lib" --add-modules javafx.controls,javafx.web,javafx.graphics
```

**CHÚ Ý**: Đảm bảo đường dẫn chính xác. Nếu project ở vị trí khác, thay đổi cho phù hợp.

### Bước 5: Apply và Run
1. Click **Apply**
2. Click **Run** ✅

Trình duyệt sẽ mở ngay lập tức!

---

## ✅ GIẢI PHÁP 2: Import Launch Configuration (NHANH NHẤT)

Tôi đã tạo sẵn file cấu hình. Làm theo:

### Bước 1: Import
1. Menu **File** → **Import...**
2. Chọn **Run/Debug** → **Launch Configurations**
3. Click **Next**
4. **Browse** đến: `d:\eclipse-workspace\Broswer_Web\.settings`
5. Chọn file `WebBrowser.launch`
6. Click **Finish**

### Bước 2: Chạy
1. Click menu **Run** → **Run Configurations...**
2. Tìm `WebBrowser` trong **Java Application**
3. Click **Run** ✅

---

## ✅ GIẢI PHÁP 3: Chạy từ Command Line (LUÔN HOẠT ĐỘNG)

Nếu không muốn cấu hình Eclipse, sử dụng cách này:

### Mở Command Prompt hoặc PowerShell:
```cmd
cd d:\eclipse-workspace\Broswer_Web
run.bat
```

Hoặc chạy trực tiếp:
```cmd
cd d:\eclipse-workspace\Broswer_Web

java --module-path "javafx-sdk\javafx-sdk-21.0.5\lib" --add-modules javafx.controls,javafx.web,javafx.graphics -cp "bin;javafx-sdk\javafx-sdk-21.0.5\lib\*" application.WebBrowser
```

---

## 🔍 KIỂM TRA NẾU VẪN LỖI

### 1. Đảm bảo JavaFX SDK đã tồn tại:
```
d:\eclipse-workspace\Broswer_Web\javafx-sdk\javafx-sdk-21.0.5\lib\
```

Trong thư mục này phải có các file:
- javafx.base.jar
- javafx.controls.jar
- javafx.web.jar
- javafx.graphics.jar
- và các file .dll

### 2. Kiểm tra Java version:
```cmd
java -version
```

Phải là Java 11 trở lên (bạn đang dùng Java 21 - OK ✅)

### 3. Clean và Rebuild Project:
1. Menu **Project** → **Clean...**
2. Chọn `Broswer_Web`
3. Click **Clean**

---

## 📝 MẪU VM ARGUMENTS

Nếu project ở vị trí khác, thay đổi đường dẫn:

### Nếu dùng Windows:
```
--module-path "D:\eclipse-workspace\Broswer_Web\javafx-sdk\javafx-sdk-21.0.5\lib" --add-modules javafx.controls,javafx.web,javafx.graphics
```

### Nếu dùng Linux/Mac:
```
--module-path "/home/user/eclipse-workspace/Broswer_Web/javafx-sdk/javafx-sdk-21.0.5/lib" --add-modules javafx.controls,javafx.web,javafx.graphics
```

### Sử dụng biến môi trường (tùy chọn):
```
--module-path "${workspace_loc:Broswer_Web}/javafx-sdk/javafx-sdk-21.0.5/lib" --add-modules javafx.controls,javafx.web,javafx.graphics
```

---

## ✅ SAU KHI CHẠY THÀNH CÔNG

Bạn sẽ thấy cửa sổ trình duyệt với:
- 🔙 Các nút: Back, Forward, Refresh, Home
- 📍 Thanh địa chỉ URL
- 📊 Thanh tiến trình loading
- 🌐 Cửa sổ hiển thị website

### Test với các website:
- `google.com`
- `youtube.com`
- `github.com`
- `facebook.com`
- `stackoverflow.com`

---

## 🎯 LẦN SAU CHẠY

Sau khi cấu hình lần đầu, lần sau chỉ cần:

1. **Right-click** vào `WebBrowser.java`
2. **Run As** → **Java Application**

Hoặc nhấn **Ctrl+F11** (Run)

---

## 🆘 VẪN GẶP VẤN ĐỀ?

Nếu vẫn lỗi, kiểm tra:
1. ✅ VM arguments đã được thêm chưa?
2. ✅ Đường dẫn JavaFX SDK có đúng không?
3. ✅ Project đã được Clean và Build chưa?
4. ✅ Thử chạy bằng `run.bat` xem có hoạt động không?

**Chúc thành công! 🎉**
