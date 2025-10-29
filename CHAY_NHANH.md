# 🚀 HƯỚNG DẪN CHẠY NHANH - TRÌNH DUYỆT WEB JAVA

## ✅ ĐÃ CÀI ĐẶT XONG!

JavaFX SDK đã được tải và cấu hình tự động trong project của bạn.

---

## 🎯 CÁCH CHẠY TRONG ECLIPSE

### Bước 1: Refresh Project
1. **Right-click** vào project `Broswer_Web` trong Eclipse
2. Chọn **Refresh** (hoặc nhấn F5)

### Bước 2: Clean và Build
1. Menu **Project** → **Clean**
2. Chọn project `Broswer_Web` → Click **Clean**

### Bước 3: Tạo Run Configuration
1. **Right-click** vào file `WebBrowser.java`
2. Chọn **Run As** → **Run Configurations...**
3. **Right-click** vào **Java Application** → **New Configuration**
4. Đặt tên: `Web Browser`
5. Tab **Main**:
   - Project: `Broswer_Web`
   - Main class: `application.WebBrowser`
6. Tab **Arguments** → Trong **VM arguments**, dán:

```
--module-path "d:\eclipse-workspace\Broswer_Web\javafx-sdk\javafx-sdk-21.0.5\lib" --add-modules javafx.controls,javafx.web,javafx.graphics
```

7. Click **Apply** → Click **Run**

### Bước 4: Chạy (lần sau)
- **Right-click** vào `WebBrowser.java`
- **Run As** → **Java Application**

---

## 🎯 CÁCH CHẠY TỪ COMMAND LINE

### Cách 1: Dùng file run.bat (ĐƠN GIẢN NHẤT)

1. Mở **Eclipse** → Build project (Ctrl+B)
2. Mở **Command Prompt** hoặc **PowerShell**
3. Chạy lệnh:

```cmd
cd d:\eclipse-workspace\Broswer_Web
run.bat
```

### Cách 2: Chạy trực tiếp bằng lệnh Java

```cmd
cd d:\eclipse-workspace\Broswer_Web

java --module-path "javafx-sdk\javafx-sdk-21.0.5\lib" --add-modules javafx.controls,javafx.web,javafx.graphics -cp "bin;javafx-sdk\javafx-sdk-21.0.5\lib\*" application.WebBrowser
```

---

## 🔧 NẾU GẶP LỖI

### Lỗi: "Error: Could not find or load main class"
**Giải pháp**: 
1. Mở Eclipse
2. **Project** → **Clean** → Chọn `Broswer_Web` → **Clean**
3. Đợi Eclipse build lại project
4. Thử chạy lại

### Lỗi: "javafx.xxx cannot be resolved"
**Giải pháp**:
1. Right-click project → **Refresh** (F5)
2. **Project** → **Clean**
3. Đợi Eclipse re-index

### Lỗi: "Graphics Device initialization failed"
**Giải pháp**:
- Cập nhật driver card đồ họa
- Thử chạy với Java mode khác

---

## 📝 TEST TRÌNH DUYỆT

Sau khi chạy thành công, thử các website sau:

1. **Google**: `google.com` hoặc `https://www.google.com`
2. **YouTube**: `youtube.com`
3. **GitHub**: `github.com`
4. **Wikipedia**: `wikipedia.org`
5. **Facebook**: `facebook.com`
6. **StackOverflow**: `stackoverflow.com`

---

## 🎨 TÍNH NĂNG

- ✅ **Back/Forward**: Điều hướng lịch sử
- ✅ **Refresh**: Tải lại trang
- ✅ **Home**: Về trang chủ Google
- ✅ **URL Bar**: Nhập địa chỉ website
- ✅ **Progress Bar**: Hiển thị tiến trình tải
- ✅ **Status Bar**: Hiển thị trạng thái

---

## 💡 MẸO SỬ DỤNG

1. Không cần gõ `https://` - trình duyệt tự thêm
2. Nhấn **Enter** trong URL bar để load trang
3. Sử dụng nút **Back/Forward** để điều hướng
4. Click **Home** để về Google

---

**Chúc bạn sử dụng vui vẻ! 🎉**

Nếu có lỗi, hãy đảm bảo:
- ✅ JavaFX SDK đã được tải (thư mục `javafx-sdk` tồn tại)
- ✅ Project đã được build trong Eclipse
- ✅ VM arguments đã được thêm đúng
