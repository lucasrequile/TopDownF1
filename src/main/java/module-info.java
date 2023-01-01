module be.lucasrequile.topdownf1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.lang3;

    opens be.lucasrequile.topdownf1 to javafx.fxml;
    exports be.lucasrequile.topdownf1;
}
