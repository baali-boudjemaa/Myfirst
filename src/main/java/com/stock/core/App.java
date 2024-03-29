package com.stock.core;


import io.github.gleidsonmt.decorator.GNDecorator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
public class App extends Application {
    public static final GNDecorator decorator = new GNDecorator();

    public static ObservableList<String> stylesheets;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        System.out.println("/////////////////////////////"+screenBounds);

        stylesheets = decorator.getStylesheets();
        stylesheets.addAll(
                getClass().getResource("/theme/css/fonts.css").toExternalForm(),
                getClass().getResource("/theme/css/material-color.css").toExternalForm(),
                getClass().getResource("/theme/css/skeleton.css").toExternalForm(),
                getClass().getResource("/theme/css/light.css").toExternalForm(),
                getClass().getResource("/theme/css/bootstrap.css").toExternalForm(),
                getClass().getResource("/theme/css/shape.css").toExternalForm(),
                getClass().getResource("/theme/css/typographic.css").toExternalForm(),
                getClass().getResource("/theme/css/helpers.css").toExternalForm(),
                getClass().getResource("/theme/css/master.css").toExternalForm(),
                getClass().getResource("/theme/css/drawer.css").toExternalForm()

        );

        Parent root = FXMLLoader.load(getClass().getResource("/app/views/login.fxml"));
       // primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Hello World");

        primaryStage.setScene(new Scene(root));
        decorator.setMinHeight(768);
        decorator.setMinWidth(1366);
         decorator.setContent(root);
        decorator.show();
    }

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "/META-INF/spring/app-context.xml");
       /* PersonService personService = context.getBean("personServiceImpl", PersonService.class);

        Person person = new Person();
        person.setFirstName("HILLARY");
        person.setLastName("CLINTON");
        personService.insertPerson(person);

        for (Person p : personService.getAllPersons()){
            System.out.println(p);
        }*/

        launch(args);
    }
}