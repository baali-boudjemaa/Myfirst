/*
 * Copyright (C) Gleidson Neves da Silveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.stock.core.Controller;

import animatefx.animation.Flash;
import animatefx.animation.Pulse;
import animatefx.animation.SlideInLeft;
import com.stock.core.Inter;
import com.stock.core.MyApp;
import com.stock.core.global.plugin.ViewManager;
import io.github.gleidson28.GNAvatarView;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  22/11/2018
 * Version 1.0.2
 */
public class login implements Initializable {
    @FXML
    StackPane dsh;
    @FXML private GNAvatarView avatar;
    @FXML private HBox box_username;
    @FXML private HBox box_password;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Button login;

    @FXML private Label lbl_password;
    @FXML private Label lbl_username;
    @FXML private Label lbl_error;

    private RotateTransition rotateTransition = new RotateTransition();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rotateTransition.setNode(avatar);
        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setAutoReverse(true);

       // addEffect(password);
      //  addEffect(username);

        //setupListeners();

    }

    private void addEffect(Node node){
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            rotateTransition.play();
            Pulse pulse = new Pulse(node.getParent());
            pulse.setDelay(Duration.millis(100));
            pulse.setSpeed(5);
            pulse.play();
            node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });

        node.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!node.isFocused())
                node.getParent().setStyle("-icon-color : -dark-gray; -fx-border-color : transparent");
            else node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });
    }

    private void setupListeners(){
        password.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validPassword()){
                if(!newValue){
                    Flash swing = new Flash(box_password);
                    lbl_password.setVisible(true);
                    new SlideInLeft(lbl_password).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_password.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_password.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });

        username.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validUsername()){
                if(!newValue){
                    Flash swing = new Flash(box_username);
                    lbl_username.setVisible(true);
                    new SlideInLeft(lbl_username).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_username.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_username.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });
    }

    private boolean validPassword(){
        return !password.getText().isEmpty() && password.getLength() > 3;
    }

    private boolean validUsername(){
        return !username.getText().isEmpty() && username.getLength() > 3;
    }

    @FXML
    private void loginAction(){

        try {
            Pulse pulse = new Pulse(login);
            pulse.setDelay(Duration.millis(20));
            pulse.play();
            ViewManager.getInstance().put(
                    "login",
                    FXMLLoader.load(getClass().getResource("/com/stock/core/views/dashboard.fxml"))
            );
            MyApp.decorator.setContent((Parent) ViewManager.getInstance().get("login"));
          //  dsh.getChildren().add(FXMLLoader.load(getClass().getResource("/app/views/dashboard.fxml")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(validPassword() && validUsername()){}
            //enter();


        else {
            lbl_password.setVisible(true);
            lbl_username.setVisible(true);
        }
    }

    /*private void enter() {

        User user = UserManager.get(username.getText());

        if(user.getUserName().equals(this.username.getText()) && user.getPassword().equals(this.password.getText())){
            Section section = new Section();
            section.setLogged(true);
            section.setUserLogged(this.username.getText());
            SectionManager.save(section);

            com.stock.App.decorator.setContent(ViewManager.getInstance().get("main"));

         *//*   UserDetail detail = com.stock.App.getUserDetail();
            detail.setText(user.getFullName());
            detail.setHeader(user.getUserName());*//*

         //   com.stock.App.decorator.addCustom(com.stock.App.getUserDetail());

         *//*   com.stock.App.getUserDetail().setProfileAction(event -> {
                com.stock.App.getUserDetail().getPopOver().hide();
                Main.ctrl.title.setText("Profile");
                Main.ctrl.body.setContent(ViewManager.getInstance().get("profile"));
            });
*//*
          *//*  com.stock.App.getUserDetail().setSignAction(event -> {
                com.stock.App.getUserDetail().getPopOver().hide();
                com.stock.App.decorator.setContent(ViewManager.getInstance().get("login"));
                this.username.setText("");
                this.password.setText("");
                if(Main.popConfig.isShowing()) Main.popConfig.hide();
                if(Main.popup.isShowing()) Main.popup.hide();
                com.stock.App.decorator.removeCustom(com.stock.App.getUserDetail());
            });*//*

            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(()-> {
                        // add notification in later
    //                                    TrayNotification tray = new TrayNotification();
    //                                    tray.setNotificationType(NotificationType.NOTICE);
    //                                    tray.setRectangleFill(Color.web(""));
    //                                    tray.setTitle("Welcome!");
    //                                    tray.setMessage("Welcome back " + username);
    //                                    tray.showAndDismiss(Duration.millis(10000));
                        }
                    );
                }
            };

            Timer timer = new Timer();
            timer.schedule(timerTask, 300);

        } else {
            lbl_error.setVisible(true);
        }
    }*/

   /* @FXML
  //  private void switchCreate(){
        com.stock.App.decorator.setContent(ViewManager.getInstance().get("account"));
    }*/
}
