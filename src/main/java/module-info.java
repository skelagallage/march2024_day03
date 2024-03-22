module com.ucsc.automation.march2024_day03 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ucsc.automation.march2024_day03 to javafx.fxml;
    exports com.ucsc.automation.march2024_day03;
}