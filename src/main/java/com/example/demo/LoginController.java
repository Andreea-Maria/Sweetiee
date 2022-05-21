package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;

public class LoginController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView brandingImageView;

    public void validateLogin() throws SQLException, ClassNotFoundException {


        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String verifyLogin = "SELECT count(1) FROM login WHERE username = " + usernameTextField.getText() + "AND password = " + passwordField.getText() + "";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if(queryResult.getInt(1)==1){
                    loginMessageLabel.setText("Congratulations!");
                } else {
                    loginMessageLabel.setText("Invalid login. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void loginButtonOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(usernameTextField.getText().isBlank() == false && passwordField.getText().isBlank() == false){
                validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Sweet App!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("Images/1.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }


}