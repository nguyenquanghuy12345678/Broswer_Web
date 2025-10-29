package application;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Web Server độc lập - Chạy riêng trên port 8080
 * Không phụ thuộc vào JavaFX, có thể chạy như một service
 * 
 * @author Your Name
 * @version 1.0
 */
public class SimpleWebServer {
    
    private static final int PORT = 8080;
    private HttpServer server;
    
    /**
     * Khởi động Web Server
     */
    public void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(PORT), 0);
        
        // Trang chủ
        server.createContext("/", new HomeHandler());
        
        // API endpoint
        server.createContext("/api/info", new InfoHandler());
        server.createContext("/api/time", new TimeHandler());
        
        // Static pages
        server.createContext("/about", new AboutHandler());
        server.createContext("/contact", new ContactHandler());
        
        // Executor để xử lý requests
        server.setExecutor(null); // Sử dụng default executor
        
        server.start();
        
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   WEB SERVER ĐÃ KHỞI ĐỘNG THÀNH CÔNG!   ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();
        System.out.println("🌐 Server đang chạy tại:");
        System.out.println("   http://localhost:" + PORT);
        System.out.println();
        System.out.println("📋 Các endpoint có sẵn:");
        System.out.println("   • http://localhost:" + PORT + "/");
        System.out.println("   • http://localhost:" + PORT + "/about");
        System.out.println("   • http://localhost:" + PORT + "/contact");
        System.out.println("   • http://localhost:" + PORT + "/api/info");
        System.out.println("   • http://localhost:" + PORT + "/api/time");
        System.out.println();
        System.out.println("⏹  Nhấn Ctrl+C để dừng server");
        System.out.println("════════════════════════════════════════════");
    }
    
    /**
     * Dừng Web Server
     */
    public void stop() {
        if (server != null) {
            server.stop(0);
            System.out.println("Server đã dừng!");
        }
    }
    
    /**
     * Handler cho trang chủ
     */
    static class HomeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = buildHtmlPage(
                "Trang Chủ - Web Server",
                "<h1>🌐 Chào mừng đến với Web Server!</h1>" +
                "<div class='card'>" +
                "   <h2>Server Information</h2>" +
                "   <p><strong>Port:</strong> 8080</p>" +
                "   <p><strong>Status:</strong> <span style='color: green;'>Running</span></p>" +
                "   <p><strong>Java Version:</strong> " + System.getProperty("java.version") + "</p>" +
                "</div>" +
                "<div class='card'>" +
                "   <h2>Quick Links</h2>" +
                "   <ul>" +
                "       <li><a href='/about'>About Page</a></li>" +
                "       <li><a href='/contact'>Contact Page</a></li>" +
                "       <li><a href='/api/info'>API Info (JSON)</a></li>" +
                "       <li><a href='/api/time'>Current Time (JSON)</a></li>" +
                "   </ul>" +
                "</div>" +
                "<div class='card'>" +
                "   <h2>Test Form</h2>" +
                "   <form id='testForm'>" +
                "       <input type='text' id='name' placeholder='Nhập tên của bạn' style='width: 300px; padding: 10px; margin: 10px 0;'><br>" +
                "       <button type='button' onclick='showGreeting()' style='padding: 10px 30px; background: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer;'>Gửi</button>" +
                "   </form>" +
                "   <div id='result' style='margin-top: 20px; font-size: 18px; color: #4CAF50;'></div>" +
                "</div>" +
                "<script>" +
                "   function showGreeting() {" +
                "       var name = document.getElementById('name').value;" +
                "       if (name) {" +
                "           document.getElementById('result').innerHTML = '👋 Xin chào, ' + name + '!';" +
                "       } else {" +
                "           alert('Vui lòng nhập tên!');" +
                "       }" +
                "   }" +
                "</script>"
            );
            
            sendResponse(exchange, 200, response);
        }
    }
    
    /**
     * Handler cho trang About
     */
    static class AboutHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = buildHtmlPage(
                "About - Web Server",
                "<h1>📖 About This Server</h1>" +
                "<div class='card'>" +
                "   <h2>Web Server Information</h2>" +
                "   <p>Đây là một Web Server độc lập được viết bằng Java, sử dụng HttpServer API có sẵn trong JDK.</p>" +
                "   <p><strong>Tính năng:</strong></p>" +
                "   <ul>" +
                "       <li>✅ Chạy độc lập, không cần thư viện bên ngoài</li>" +
                "       <li>✅ Hỗ trợ HTML, CSS, JavaScript</li>" +
                "       <li>✅ RESTful API endpoints</li>" +
                "       <li>✅ Responsive design</li>" +
                "       <li>✅ Lightweight và nhanh chóng</li>" +
                "   </ul>" +
                "</div>" +
                "<div class='card'>" +
                "   <p><a href='/'>← Quay lại trang chủ</a></p>" +
                "</div>"
            );
            
            sendResponse(exchange, 200, response);
        }
    }
    
    /**
     * Handler cho trang Contact
     */
    static class ContactHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = buildHtmlPage(
                "Contact - Web Server",
                "<h1>📧 Contact Information</h1>" +
                "<div class='card'>" +
                "   <h2>Liên hệ với chúng tôi</h2>" +
                "   <p><strong>Email:</strong> admin@webserver.local</p>" +
                "   <p><strong>Phone:</strong> +84 123 456 789</p>" +
                "   <p><strong>Address:</strong> Hanoi, Vietnam</p>" +
                "</div>" +
                "<div class='card'>" +
                "   <h2>Send Message</h2>" +
                "   <form id='contactForm'>" +
                "       <input type='text' placeholder='Your Name' style='width: 100%; padding: 10px; margin: 5px 0; box-sizing: border-box;'><br>" +
                "       <input type='email' placeholder='Your Email' style='width: 100%; padding: 10px; margin: 5px 0; box-sizing: border-box;'><br>" +
                "       <textarea placeholder='Your Message' rows='5' style='width: 100%; padding: 10px; margin: 5px 0; box-sizing: border-box;'></textarea><br>" +
                "       <button type='button' onclick='alert(\"Cảm ơn! Tin nhắn của bạn đã được gửi.\")' style='padding: 10px 30px; background: #2196F3; color: white; border: none; border-radius: 5px; cursor: pointer;'>Gửi tin nhắn</button>" +
                "   </form>" +
                "</div>" +
                "<div class='card'>" +
                "   <p><a href='/'>← Quay lại trang chủ</a></p>" +
                "</div>"
            );
            
            sendResponse(exchange, 200, response);
        }
    }
    
    /**
     * Handler cho API Info (JSON)
     */
    static class InfoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String json = "{\n" +
                "  \"server\": \"Simple Java Web Server\",\n" +
                "  \"version\": \"1.0\",\n" +
                "  \"port\": 8080,\n" +
                "  \"status\": \"running\",\n" +
                "  \"java_version\": \"" + System.getProperty("java.version") + "\",\n" +
                "  \"os\": \"" + System.getProperty("os.name") + "\",\n" +
                "  \"endpoints\": [\"/\", \"/about\", \"/contact\", \"/api/info\", \"/api/time\"]\n" +
                "}";
            
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            sendResponse(exchange, 200, json);
        }
    }
    
    /**
     * Handler cho API Time (JSON)
     */
    static class TimeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            
            String json = "{\n" +
                "  \"timestamp\": \"" + now.format(formatter) + "\",\n" +
                "  \"timezone\": \"" + java.time.ZoneId.systemDefault() + "\",\n" +
                "  \"epoch\": " + System.currentTimeMillis() + "\n" +
                "}";
            
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            sendResponse(exchange, 200, json);
        }
    }
    
    /**
     * Tạo HTML page với styling
     */
    private static String buildHtmlPage(String title, String content) {
        return "<!DOCTYPE html>\n" +
            "<html lang='vi'>\n" +
            "<head>\n" +
            "   <meta charset='UTF-8'>\n" +
            "   <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
            "   <title>" + title + "</title>\n" +
            "   <style>\n" +
            "       * { margin: 0; padding: 0; box-sizing: border-box; }\n" +
            "       body {\n" +
            "           font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
            "           background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
            "           min-height: 100vh;\n" +
            "           padding: 20px;\n" +
            "       }\n" +
            "       .container {\n" +
            "           max-width: 900px;\n" +
            "           margin: 0 auto;\n" +
            "           background: white;\n" +
            "           border-radius: 15px;\n" +
            "           padding: 40px;\n" +
            "           box-shadow: 0 10px 40px rgba(0,0,0,0.2);\n" +
            "       }\n" +
            "       h1 {\n" +
            "           color: #333;\n" +
            "           margin-bottom: 30px;\n" +
            "           text-align: center;\n" +
            "           font-size: 32px;\n" +
            "       }\n" +
            "       h2 {\n" +
            "           color: #555;\n" +
            "           margin-bottom: 15px;\n" +
            "           font-size: 24px;\n" +
            "       }\n" +
            "       .card {\n" +
            "           background: #f8f9fa;\n" +
            "           border-left: 4px solid #667eea;\n" +
            "           padding: 20px;\n" +
            "           margin: 20px 0;\n" +
            "           border-radius: 8px;\n" +
            "       }\n" +
            "       p { margin: 10px 0; line-height: 1.6; color: #666; }\n" +
            "       ul { margin-left: 20px; }\n" +
            "       li { margin: 10px 0; color: #666; }\n" +
            "       a {\n" +
            "           color: #667eea;\n" +
            "           text-decoration: none;\n" +
            "           font-weight: 600;\n" +
            "       }\n" +
            "       a:hover { text-decoration: underline; }\n" +
            "       .footer {\n" +
            "           text-align: center;\n" +
            "           margin-top: 40px;\n" +
            "           color: #999;\n" +
            "           font-size: 14px;\n" +
            "       }\n" +
            "   </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "   <div class='container'>\n" +
            content +
            "       <div class='footer'>\n" +
            "           <p>© 2025 Simple Java Web Server | Powered by Java " + System.getProperty("java.version") + "</p>\n" +
            "       </div>\n" +
            "   </div>\n" +
            "</body>\n" +
            "</html>";
    }
    
    /**
     * Gửi response
     */
    private static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(statusCode, bytes.length);
        
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
    
    /**
     * Main method - Chạy server độc lập
     */
    public static void main(String[] args) {
        SimpleWebServer webServer = new SimpleWebServer();
        
        try {
            webServer.start();
            
            // Thêm shutdown hook
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("\n⏹  Đang dừng server...");
                webServer.stop();
            }));
            
            // Giữ server chạy
            Thread.currentThread().join();
            
        } catch (IOException e) {
            System.err.println("❌ Lỗi khởi động server: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Server bị gián đoạn!");
            Thread.currentThread().interrupt();
        }
    }
}
