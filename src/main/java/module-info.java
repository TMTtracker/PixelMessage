module com.example.pixelmessage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.pixelmessage to javafx.fxml;
    exports com.example.pixelmessage;
}