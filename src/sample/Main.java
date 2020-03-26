package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;

public class Main extends Application {
    @FXML
    private CheckBox fndCheck;
    @FXML
    private TextField fundingField;
    @FXML
    private CheckBox triStateCheck;
    @FXML
    private CheckBox exchCheck;
    @FXML
    private ToggleGroup studentStatus;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Program 3 - Tuition Manager");
        primaryStage.setScene(new Scene(root, 600, 700));
        primaryStage.show();



        //listen for toggle group change
        //studentStatus.getSelectedToggle().addListener();
        //RadioButton selectedRadioButton = (RadioButton) studentStatus.getSelectedToggle();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
