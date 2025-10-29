# HƯỚNG DẪN CÀI ĐẶT VÀ CHẠY TRÌNH DUYỆT WEB JAVA

## ✅ Tính năng của Trình duyệt

- ✅ **Load được mọi website** (HTTP/HTTPS): Google, Facebook, YouTube, GitHub, v.v.
- ✅ **Thanh địa chỉ URL** với tự động thêm https://
- ✅ **Nút điều hướng**: Back, Forward, Refresh, Home
- ✅ **Thanh tiến trình** khi loading trang
- ✅ **Hiển thị tiêu đề** trang web
- ✅ **Hỗ trợ đầy đủ**: JavaScript, CSS, HTML5
- ✅ **Lịch sử duyệt web** (History)

---

## 📋 BƯỚC 1: Tải JavaFX SDK

1. Truy cập: https://gluonhq.com/products/javafx/
2. Tải **JavaFX SDK** (chọn phiên bản phù hợp với Java của bạn)
   - Nếu dùng **Java 11+**: Tải JavaFX 17 hoặc mới hơn
   - Nếu dùng **Java 8**: Tải JavaFX 8
3. Giải nén file tải về (ví dụ: `javafx-sdk-21.0.1`)

---

## 📋 BƯỚC 2: Cấu hình JavaFX trong Eclipse

### Cách 1: Thêm JavaFX vào User Library (KHUYẾN NGHỊ)

1. **Mở Eclipse** → Menu **Window** → **Preferences**
2. Điều hướng: **Java** → **Build Path** → **User Libraries**
3. Click **New** → Đặt tên: `JavaFX` → Click **OK**
4. Chọn `JavaFX` vừa tạo → Click **Add External JARs**
5. Duyệt đến thư mục `javafx-sdk-xxx/lib` (nơi bạn giải nén)
6. Chọn **TẤT CẢ** các file `.jar`:
   - `javafx.base.jar`
   - `javafx.controls.jar`
   - `javafx.fxml.jar`
   - `javafx.graphics.jar`
   - `javafx.media.jar`
   - `javafx.swing.jar`
   - `javafx.web.jar`
   - `javafx-swt.jar`
7. Click **Apply and Close**

### Cách 2: Thêm trực tiếp vào Project

1. **Right-click** vào project `Broswer_Web`
2. Chọn **Build Path** → **Configure Build Path**
3. Tab **Libraries** → Click **Add External JARs**
4. Chọn tất cả file `.jar` trong `javafx-sdk-xxx/lib`
5. Click **Apply and Close**

---

## 📋 BƯỚC 3: Thêm JavaFX vào Project

1. **Right-click** vào project `Broswer_Web`
2. **Build Path** → **Add Libraries**
3. Chọn **User Library** → **Next**
4. Chọn `JavaFX` → **Finish**

---

## 📋 BƯỚC 4: Cấu hình Run Configuration

1. **Right-click** vào `WebBrowser.java` → **Run As** → **Run Configurations**
2. **Right-click** vào **Java Application** → **New Configuration**
3. Tab **Main**:
   - **Project**: `Broswer_Web`
   - **Main class**: `application.WebBrowser`
4. Tab **Arguments**:
   - Trong **VM arguments**, thêm:

```
--module-path "C:\path\to\javafx-sdk-21.0.1\lib" --add-modules javafx.controls,javafx.web,javafx.graphics
```

**LƯU Ý**: Thay `C:\path\to\javafx-sdk-21.0.1\lib` bằng đường dẫn thực tế đến thư mục `lib` của JavaFX SDK

5. Click **Apply** → **Run**

---

## 📋 BƯỚC 5: Chạy Trình duyệt

Sau khi cấu hình xong:

1. **Right-click** vào `WebBrowser.java`
2. **Run As** → **Java Application**

Hoặc sử dụng cấu hình đã tạo ở Bước 4.

---

## 🎯 CÁCH SỬ DỤNG TRÌNH DUYỆT

### Nhập URL:
- Gõ URL vào thanh địa chỉ (ví dụ: `google.com`, `facebook.com`)
- Nhấn **Enter** hoặc click nút **Go**
- Tự động thêm `https://` nếu bạn không gõ

### Các nút điều khiển:
- **◄ Back**: Quay lại trang trước
- **Forward ►**: Tiến tới trang sau
- **⟳ Refresh**: Làm mới trang hiện tại
- **⌂ Home**: Về trang chủ Google

### Trang web có thể test:
- `https://www.google.com`
- `https://www.facebook.com`
- `https://www.youtube.com`
- `https://github.com`
- `https://stackoverflow.com`
- `https://www.wikipedia.org`

---

## ⚠️ KHẮC PHỤC LỖI THƯỜNG GẶP

### Lỗi 1: "Module javafx.xxx cannot be resolved"
**Giải pháp**: Đảm bảo đã thêm JavaFX vào Build Path (Bước 2 và 3)

### Lỗi 2: "Error: JavaFX runtime components are missing"
**Giải pháp**: Thêm VM arguments trong Run Configuration (Bước 4)

### Lỗi 3: "Graphics Device initialization failed"
**Giải pháp**: Kiểm tra driver card đồ họa, cập nhật Java lên phiên bản mới nhất

### Lỗi 4: Không load được HTTPS
**Giải pháp**: Đảm bảo đã thêm `javafx.web.jar` và dùng Java 11 trở lên

---

## 📦 YÊU CẦU HỆ THỐNG

- **Java**: Java 11 hoặc mới hơn (khuyến nghị Java 17 hoặc 21)
- **JavaFX SDK**: Phiên bản tương ứng với Java
- **Eclipse**: Bất kỳ phiên bản nào (khuyến nghị 2023-03 trở lên)
- **Internet**: Kết nối internet để load websites

---

## 🚀 NÂNG CẤP THÊM (Optional)

Nếu muốn nâng cao trình duyệt, có thể thêm:

1. **Bookmark Manager** (Quản lý trang yêu thích)
2. **Download Manager** (Quản lý tải xuống)
3. **Tabs** (Nhiều tab như Chrome)
4. **Cookie Manager** (Quản lý cookies)
5. **View Source** (Xem mã nguồn trang)

---

## 💡 GHI CHÚ

- Trình duyệt sử dụng **WebKit engine** (giống Safari)
- Hỗ trợ đầy đủ **JavaScript**, **CSS3**, **HTML5**
- **Tự động redirect** HTTP → HTTPS khi cần
- **History navigation** với nút Back/Forward

---

## 📞 HỖ TRỢ

Nếu gặp vấn đề, hãy kiểm tra:
1. Java version: `java -version`
2. JavaFX đã được add vào Build Path chưa
3. VM arguments trong Run Configuration đã đúng chưa

**Chúc bạn sử dụng trình duyệt vui vẻ! 🎉**
