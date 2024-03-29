package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {

    @FXML
    private ImageView regImageView;
    @FXML
    private Button closeButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File regFile = new File("Images/2.png");
        Image regImage = new Image(regFile.toURI().toString());
        regImageView.setImage(regImage);
    }

    public void registerButtonOnAction(ActionEvent event){
        //registrationMessageLabel.setText("User has been registered succesfully!");
        if(setPasswordField.getText().equals(confirmPasswordField.getText())){
            //confirmPasswordLabel.setText("You are set.");
            registrationMessageLabel.setText("User has been registered succesfully!");
        }else {
            confirmPasswordLabel.setText("Password does not match.");

        }
    }

    public void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = setPasswordField.getText();

        String insertFields = "INSERT INTO user_account(lastname, firstname, username, password) VALUES";
        String insertValues = " ('" + firstname + "','" +  lastname + "','" + username + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertToRegister);

            registrationMessageLabel.setText("User has been registered successfully.");
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
}
