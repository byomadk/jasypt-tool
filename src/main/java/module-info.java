module com.jasypt.jasypt {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jasypt;

    opens com.jasypt.jasypt to javafx.fxml;
    exports com.jasypt.jasypt;
}