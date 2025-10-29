# ⚡ FIX LỖI NGAY - THỰC HIỆN TRONG ECLIPSE

## 🔴 QUAN TRỌNG: Làm theo thứ tự sau trong Eclipse

### Bước 1️⃣: REFRESH PROJECT
1. Mở **Eclipse**
2. Trong **Package Explorer**, tìm project `Broswer_Web`
3. **Right-click** vào project `Broswer_Web`
4. Chọn **Refresh** (hoặc nhấn phím **F5**)
5. Đợi Eclipse refresh xong

### Bước 2️⃣: CLEAN PROJECT
1. Menu **Project** → **Clean...**
2. Chọn **Clean projects selected below**
3. Check vào `Broswer_Web`
4. Click **Clean**
5. Đợi Eclipse build lại project (xem Progress ở góc dưới bên phải)

### Bước 3️⃣: KIỂM TRA LỖI
1. Mở file `WebBrowser.java`
2. Kiểm tra xem còn lỗi đỏ không
3. Nếu KHÔNG còn lỗi → Chuyển sang Bước 4
4. Nếu VẪN còn lỗi → Làm Bước Fix Thêm bên dưới

### Bước 4️⃣: CHẠY TRÌNH DUYỆT

#### Cách A: Tạo Run Configuration (KHUYẾN NGHỊ)
1. **Right-click** vào `WebBrowser.java`
2. **Run As** → **Run Configurations...**
3. **Right-click** vào **Java Application** → **New Configuration**
4. Đặt tên: `Web Browser`
5. Tab **Main**:
   - Project: `Broswer_Web`
   - Main class: `application.WebBrowser`
6. Tab **Arguments**:
   - Trong ô **VM arguments**, paste dòng sau:
   
```
--module-path "d:\eclipse-workspace\Broswer_Web\javafx-sdk\javafx-sdk-21.0.5\lib" --add-modules javafx.controls,javafx.web,javafx.graphics
```

7. Click **Apply**
8. Click **Run** ✅

#### Cách B: Chạy từ Command Line
```cmd
cd d:\eclipse-workspace\Broswer_Web
run.bat
```

---

## 🛠️ FIX THÊM NẾU VẪN CÒN LỖI

### Fix 1: Xóa module-info.java
Nếu vẫn thấy lỗi "module cannot be resolved":

1. Trong Eclipse, xóa file `module-info.java` (hoặc đã được comment)
2. **Project** → **Clean**
3. Rebuild lại

### Fix 2: Kiểm tra .classpath
1. Đảm bảo file `.classpath` có các dòng sau:

```xml
<classpathentry kind="lib" path="javafx-sdk/javafx-sdk-21.0.5/lib/javafx.base.jar"/>
<classpathentry kind="lib" path="javafx-sdk/javafx-sdk-21.0.5/lib/javafx.controls.jar"/>
<classpathentry kind="lib" path="javafx-sdk/javafx-sdk-21.0.5/lib/javafx.fxml.jar"/>
<classpathentry kind="lib" path="javafx-sdk/javafx-sdk-21.0.5/lib/javafx.graphics.jar"/>
<classpathentry kind="lib" path="javafx-sdk/javafx-sdk-21.0.5/lib/javafx.media.jar"/>
<classpathentry kind="lib" path="javafx-sdk/javafx-sdk-21.0.5/lib/javafx.swing.jar"/>
<classpathentry kind="lib" path="javafx-sdk/javafx-sdk-21.0.5/lib/javafx.web.jar"/>
<classpathentry kind="lib" path="javafx-sdk/javafx-sdk-21.0.5/lib/javafx-swt.jar"/>
```

2. Nếu chưa có → Copy từ file `.classpath` mẫu
3. **Right-click** project → **Refresh** (F5)

### Fix 3: Build Path
1. **Right-click** vào project `Broswer_Web`
2. **Build Path** → **Configure Build Path...**
3. Tab **Libraries**
4. Kiểm tra có các JAR sau không:
   - javafx.base.jar
   - javafx.controls.jar
   - javafx.web.jar
   - javafx.graphics.jar
   - (và các jar khác)
5. Nếu **KHÔNG có** → Click **Add External JARs**
6. Browse đến: `d:\eclipse-workspace\Broswer_Web\javafx-sdk\javafx-sdk-21.0.5\lib`
7. Chọn **TẤT CẢ** file `.jar`
8. Click **Open** → **Apply and Close**

### Fix 4: Restart Eclipse
Đôi khi Eclipse cần restart:
1. **File** → **Restart**
2. Sau khi restart → **Project** → **Clean**

---

## ✅ SAU KHI FIX XONG

Trình duyệt sẽ mở với giao diện:
- 📍 **Thanh địa chỉ URL** phía trên
- 🔙 **Nút Back, Forward, Refresh, Home**
- 📊 **Thanh tiến trình** khi load trang
- 🌐 **Cửa sổ hiển thị** website

### Test với các website:
- `google.com`
- `youtube.com`
- `github.com`
- `facebook.com`

---

## 🆘 VẪN GẶP VẤN ĐỀ?

Gửi cho tôi:
1. Screenshot lỗi trong Eclipse
2. Nội dung file `.classpath`
3. Java version (`java -version`)

**Chúc thành công! 🎉**
