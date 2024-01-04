module com.stock.core {

    requires hibernate.core;
    requires java.sql;
    requires GNDecorator;
    requires spring.context;
    requires java.naming;
    requires fontawesomefx;
    requires GNAvatarView;
    requires com.jfoenix;
    requires spring.tx;
    requires spring.beans;
    requires jsr250.api;
    requires animatefx;
    requires controlsfx;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports com.stock.core;
    opens com.stock.core.Controller to javafx.fxml;
}