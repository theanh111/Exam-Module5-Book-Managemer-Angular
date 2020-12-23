package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameText;

    @FXML
    private TextField passwordText;

    private ObservableList<User> usersList = FXCollections.observableArrayList(
            new User("admin", "admin");
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
