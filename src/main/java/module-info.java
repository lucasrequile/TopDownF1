module be.lucasrequile.topdownf1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires vecmath;

    opens be.lucasrequile.topdownf1 to javafx.fxml;
    exports be.lucasrequile.topdownf1;
}
