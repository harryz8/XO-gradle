module com.zs1.oxgradle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zs1.oxgradle to javafx.fxml;
    exports com.zs1.oxgradle;
}