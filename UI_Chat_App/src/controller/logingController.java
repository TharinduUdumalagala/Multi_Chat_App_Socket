package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class logingController {
    public JFXTextField txtName;
    public JFXPasswordField pwdPassword;
    public AnchorPane root;
    public Label lblstatus;

    public void GetStarted(ActionEvent actionEvent) throws IOException {
        if (txtName.getText().equals("Tharindu") && pwdPassword.getText().equals("1234")){
            lblstatus.setText("Login Success");
            Stage primaryStage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/view/chat.fxml"));
            Scene scene = new Scene(root1,489,640);
            primaryStage.setScene(scene);
            primaryStage.show();
        }else {
            lblstatus.setText("Login Error");
        }
    }

    public void newAccount(ActionEvent actionEvent) {
    }
}

