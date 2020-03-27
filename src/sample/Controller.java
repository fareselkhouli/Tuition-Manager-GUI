package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import sample.project2.*;


public class Controller {

    //inject FXML objects
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField creditsField;
    @FXML
    private CheckBox fndCheck;
    @FXML
    private TextField fundingField;
    @FXML
    private CheckBox triStateCheck;
    @FXML
    private CheckBox exchCheck;
    @FXML
    private TextArea outputArea;
    @FXML
    private RadioButton insRdio;
    @FXML
    private RadioButton outRdio;
    @FXML
    private RadioButton intRdio;

    public StudentList cs213 = new StudentList();

    @FXML
    public void radioGroupPress(){
        if(insRdio.isSelected()){
            fndCheck.setDisable(false);
            fundingField.setDisable(false);
            triStateCheck.setDisable(true);
            exchCheck.setDisable(true);
        }
        if(outRdio.isSelected()){
            fndCheck.setDisable(true);
            fundingField.setDisable(true);
            triStateCheck.setDisable(false);
            exchCheck.setDisable(true);
        }
        if(intRdio.isSelected()){
            fndCheck.setDisable(true);
            fundingField.setDisable(true);
            triStateCheck.setDisable(true);
            exchCheck.setDisable(false);
        }
    }

    @FXML
    public void addBtnClicked(){
        String fname = firstNameField.getText();
        String lname = lastNameField.getText();
        int credits = Integer.parseInt(creditsField.getText());

        if(insRdio.isSelected()){
            if(fndCheck.isSelected()){
                int funding = Integer.parseInt(fundingField.getText());
                cs213.add(new Instate(fname,lname,credits,funding));
            }
            else{
                cs213.add(new Instate(fname,lname,credits,0));
            }
        }

        if(outRdio.isSelected()){
            if(triStateCheck.isSelected()){
                cs213.add(new Outstate(fname,lname,credits,true));
            }
            else{
                cs213.add(new Outstate(fname,lname,credits,false));
            }
        }

        if(intRdio.isSelected()){
            if(exchCheck.isSelected()) {
                cs213.add(new International(fname, lname, credits, true));
            }
            else{
                cs213.add(new International(fname, lname, credits, false));
            }
        }

    }

    @FXML
    public void removeBtnClicked(){

    }

    @FXML
    public void printBtnClicked(){

    }

}
