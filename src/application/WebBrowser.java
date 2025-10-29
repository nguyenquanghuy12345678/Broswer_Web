package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Trình duyệt Web đầy đủ tính năng - Hỗ trợ HTTP/HTTPS
 * Có thể load bất kỳ website nào giống như Chrome
 * 
 * @author Your Name
 * @version 1.0
 */
public class WebBrowser extends Application {
    
    private WebView webView;
    private WebEngine webEngine;
    private TextField urlField;
    private ProgressBar progressBar;
    private Label statusLabel;
    private Button backButton;
    private Button forwardButton;
    
    // Trang chủ mặc định
    private static final String HOME_PAGE = "https://www.google.com";
    
    @Override
    public void start(Stage primaryStage) {
        try {
            // Tạo WebView và WebEngine
            webView = new WebView();
            webEngine = webView.getEngine();
            
            // Bật JavaScript (cần thiết cho hầu hết websites)
            webEngine.setJavaScriptEnabled(true);
            
            // Tạo giao diện
            BorderPane root = new BorderPane();
            
            // Thanh công cụ phía trên
            VBox topContainer = new VBox(5);
            topContainer.setPadding(new Insets(10));
            
            // Hàng 1: Các nút điều hướng và thanh địa chỉ
            HBox navigationBar = createNavigationBar();
            
            // Hàng 2: Thanh tiến trình
            progressBar = new ProgressBar(0);
            progressBar.setPrefWidth(Double.MAX_VALUE);
            progressBar.setVisible(false);
            
            topContainer.getChildren().addAll(navigationBar, progressBar);
            
            // Thanh trạng thái phía dưới
            HBox statusBar = new HBox(10);
            statusBar.setPadding(new Insets(5, 10, 5, 10));
            statusBar.setAlignment(Pos.CENTER_LEFT);
            statusBar.setStyle("-fx-background-color: #f0f0f0;");
            
            statusLabel = new Label("Sẵn sàng");
            statusBar.getChildren().add(statusLabel);
            
            // Đặt các thành phần vào BorderPane
            root.setTop(topContainer);
            root.setCenter(webView);
            root.setBottom(statusBar);
            
            // Thiết lập các listener
            setupListeners();
            
            // Tạo Scene và hiển thị
            Scene scene = new Scene(root, 1200, 800);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            
            primaryStage.setTitle("Trình duyệt Web - Java Browser");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            // Load trang chủ
            loadURL(HOME_PAGE);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tạo thanh điều hướng với các nút và thanh địa chỉ
     */
    private HBox createNavigationBar() {
        HBox navBar = new HBox(10);
        navBar.setAlignment(Pos.CENTER_LEFT);
        
        // Nút Back
        backButton = new Button("◄ Back");
        backButton.setStyle("-fx-font-size: 12px; -fx-padding: 5 15 5 15;");
        backButton.setOnAction(e -> goBack());
        backButton.setDisable(true);
        
        // Nút Forward
        forwardButton = new Button("Forward ►");
        forwardButton.setStyle("-fx-font-size: 12px; -fx-padding: 5 15 5 15;");
        forwardButton.setOnAction(e -> goForward());
        forwardButton.setDisable(true);
        
        // Nút Refresh
        Button refreshButton = new Button("⟳ Refresh");
        refreshButton.setStyle("-fx-font-size: 12px; -fx-padding: 5 15 5 15;");
        refreshButton.setOnAction(e -> refresh());
        
        // Nút Home
        Button homeButton = new Button("⌂ Home");
        homeButton.setStyle("-fx-font-size: 12px; -fx-padding: 5 15 5 15;");
        homeButton.setOnAction(e -> loadURL(HOME_PAGE));
        
        // Thanh địa chỉ URL
        urlField = new TextField();
        urlField.setPromptText("Nhập URL (ví dụ: https://www.google.com)");
        urlField.setStyle("-fx-font-size: 13px;");
        HBox.setHgrow(urlField, Priority.ALWAYS);
        
        // Nút Go
        Button goButton = new Button("Go");
        goButton.setStyle("-fx-font-size: 12px; -fx-padding: 5 20 5 20; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        goButton.setOnAction(e -> loadURL(urlField.getText()));
        
        // Enter trong URL field cũng load trang
        urlField.setOnAction(e -> loadURL(urlField.getText()));
        
        navBar.getChildren().addAll(
            backButton, 
            forwardButton, 
            refreshButton, 
            homeButton, 
            urlField, 
            goButton
        );
        
        return navBar;
    }
    
    /**
     * Thiết lập các listener cho WebEngine
     */
    private void setupListeners() {
        // Lắng nghe thay đổi URL
        webEngine.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                              String oldValue, String newValue) {
                urlField.setText(newValue);
            }
        });
        
        // Lắng nghe thay đổi tiêu đề
        webEngine.titleProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                              String oldValue, String newValue) {
                Stage stage = (Stage) webView.getScene().getWindow();
                if (newValue != null && !newValue.isEmpty()) {
                    stage.setTitle(newValue + " - Java Browser");
                }
            }
        });
        
        // Lắng nghe trạng thái loading
        webEngine.getLoadWorker().stateProperty().addListener(
            new ChangeListener<State>() {
                @Override
                public void changed(ObservableValue<? extends State> observable, 
                                  State oldValue, State newValue) {
                    if (newValue == State.RUNNING) {
                        progressBar.setVisible(true);
                        statusLabel.setText("Đang tải...");
                    } else if (newValue == State.SUCCEEDED) {
                        progressBar.setVisible(false);
                        statusLabel.setText("Tải thành công - " + webEngine.getLocation());
                        updateNavigationButtons();
                    } else if (newValue == State.FAILED) {
                        progressBar.setVisible(false);
                        statusLabel.setText("Tải thất bại!");
                        updateNavigationButtons();
                    }
                }
            }
        );
        
        // Lắng nghe tiến trình loading
        webEngine.getLoadWorker().progressProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, 
                                  Number oldValue, Number newValue) {
                    progressBar.setProgress(newValue.doubleValue());
                }
            }
        );
        
        // Lắng nghe lỗi
        webEngine.getLoadWorker().exceptionProperty().addListener(
            new ChangeListener<Throwable>() {
                @Override
                public void changed(ObservableValue<? extends Throwable> observable, 
                                  Throwable oldValue, Throwable newValue) {
                    if (newValue != null) {
                        statusLabel.setText("Lỗi: " + newValue.getMessage());
                    }
                }
            }
        );
    }
    
    /**
     * Load URL
     */
    private void loadURL(String url) {
        if (url == null || url.trim().isEmpty()) {
            statusLabel.setText("Vui lòng nhập URL!");
            return;
        }
        
        // Tự động thêm https:// nếu không có protocol
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        
        webEngine.load(url);
    }
    
    /**
     * Quay lại trang trước
     */
    private void goBack() {
        webEngine.getHistory().go(-1);
        updateNavigationButtons();
    }
    
    /**
     * Tiến tới trang sau
     */
    private void goForward() {
        webEngine.getHistory().go(1);
        updateNavigationButtons();
    }
    
    /**
     * Làm mới trang
     */
    private void refresh() {
        webEngine.reload();
    }
    
    /**
     * Cập nhật trạng thái các nút Back/Forward
     */
    private void updateNavigationButtons() {
        int currentIndex = webEngine.getHistory().getCurrentIndex();
        backButton.setDisable(currentIndex <= 0);
        forwardButton.setDisable(currentIndex >= webEngine.getHistory().getEntries().size() - 1);
    }
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        launch(args);
    }
}
