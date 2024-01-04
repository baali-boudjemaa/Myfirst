package com.stock.core;

import io.github.gleidsonmt.decorator.GNDecorator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApp extends Application {
    public static  GNDecorator decorator = null;

    public static ObservableList<String> stylesheets;
    @Override
    public void start(Stage stage) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                decorator = new GNDecorator();
                // do your GUI stuff here

       // Inter n=new Inter();
      //  n.setDecorator(decorator);
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();


        System.out.println("/////////////////////////////"+screenBounds);
        //Scene scene = new Scene(root);
        stylesheets = decorator.getStylesheets();
        stylesheets.addAll(
                getClass().getResource("/com/stock/core/theme/css/fonts.css").toString(),
                getClass().getResource("/com/stock/core/theme/css/material-color.css").toString(),
                getClass().getResource("/com/stock/core/theme/css/skeleton.css").toString(),
                getClass().getResource("/com/stock/core/theme/css/light.css").toString(),
                getClass().getResource("/com/stock/core/theme/css/bootstrap.css").toString(),
                getClass().getResource("/com/stock/core/theme/css/shape.css").toString(),
                getClass().getResource("/com/stock/core/theme/css/typographic.css").toString(),
                getClass().getResource("/com/stock/core/theme/css/helpers.css").toString(),
                getClass().getResource("/com/stock/core/theme/css/master.css").toString(),
                getClass().getResource("/com/stock/core/theme/css/drawer.css").toString()

        );
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/com/stock/core/views/login.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }


                decorator.setContent(root);
        decorator.show();


     /*   // primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Hello World");

        scene.setRoot(root);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();*/
            }
        });
    }

    public static void main(String[] args) {

       /*   ApplicationContext context =
              new ClassPathXmlApplicationContext(
                        "/META-INF/spring/app-context.xml");*/
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