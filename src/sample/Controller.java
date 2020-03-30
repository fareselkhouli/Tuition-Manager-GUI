package sample;

/**
 * This controller handles the input/output processes for the Tuition Manager GUI
 * @FaresElkhouli
 * @ZhiyuFeng
 */

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

    /**
     * Disables wrong fields and enables right fields for the radio toggle group
     */
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

    /**
     * Adds a student to the Student list. Handles several error cases.
     * @throws IllegalArgumentException
     */
    @FXML
    public void addBtnClicked() throws IllegalArgumentException{

        if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || creditsField.getText() == null){
            outputArea.appendText("Incomplete Input." + "\n");
            return;
        }

        String fname = firstNameField.getText();
        String lname = lastNameField.getText();
        int credits;
        int partTimeCredits = 12;
        int internationalRequirement = 9;
        String successMessage = "Student successfully added! \n";

        try {
           credits = Integer.parseInt(creditsField.getText());
        }
        catch(IllegalArgumentException ex){
            outputArea.appendText("Credits must be a number" + "\n");
            return;
        }

        if(credits <= 0){
            outputArea.appendText("Credits must be more than zero." + "\n");
            return;
        }

            if (insRdio.isSelected()) {
                if (fndCheck.isSelected()) {
                    int funding;
                    try {
                        funding = Integer.parseInt(fundingField.getText());
                    }
                    catch(IllegalArgumentException ex){
                        outputArea.appendText("Funding must be a number" + "\n");
                        return;
                    }
                    if(funding < 0){
                        outputArea.appendText("Funding must be positive." + "\n");
                        return;
                    }
                    if(credits < partTimeCredits){
                        outputArea.appendText("Part-time students are not elgible for funding. Try again." + "\n");
                        return;
                    }
                    Instate st = new Instate(fname, lname, credits, funding);
                    if(cs213.contains(st)){
                        outputArea.appendText("Student is already in the list" + "\n");
                        return;
                    }
                    cs213.add(st);
                } else {
                    Instate st = new Instate(fname, lname, credits, 0);
                    if(cs213.contains(st)){
                        outputArea.appendText("Student is already in the list" + "\n");
                        return;
                    }
                    cs213.add(st);
                }
                outputArea.appendText(successMessage);
                return;
            }

            if (outRdio.isSelected()) {
                if (triStateCheck.isSelected()) {
                    Outstate st = new Outstate(fname, lname, credits, true);
                    if(cs213.contains(st)){
                        outputArea.appendText("Student is already in the list" + "\n");
                        return;
                    }
                    cs213.add(st);
                } else {
                    Outstate st = new Outstate(fname, lname, credits, false);
                    if(cs213.contains(st)){
                        outputArea.appendText("Student is already in the list" + "\n");
                        return;
                    }
                    cs213.add(st);
                }
                outputArea.appendText(successMessage);
                return;
            }

            if (intRdio.isSelected()) {
                if (credits < internationalRequirement){
                    outputArea.appendText("International Students must have 9 credits or more." + "\n");
                    return;
                }
                if (exchCheck.isSelected()) {
                    International st = new International(fname, lname, credits, true);
                    if(cs213.contains(st)){
                        outputArea.appendText("Student is already in the list" + "\n");
                        return;
                    }
                    cs213.add(st);
                } else {
                    International st = new International(fname, lname, credits, false);
                    if(cs213.contains(st)){
                        outputArea.appendText("Student is already in the list" + "\n");
                        return;
                    }
                    cs213.add(st);
                }
                outputArea.appendText(successMessage);
                return;
            }
            outputArea.appendText("Please choose a radio button and try again." + "\n");
    }
    /**
     * This class Remove a student from the student list.
     */
    @FXML
    public void removeBtnClicked() {
        if (firstNameField.getText().isEmpty()
                || lastNameField.getText().isEmpty()
        ) {
            outputArea.appendText("Incomplete Input" + "\n");
            ;
            return;
        }
        String fname = firstNameField.getText();
        String lname = lastNameField.getText();
        String successMessage = "Student successfully removed!\n";
        Student st = new Instate(fname,lname,1,1); //temporary student to pass to remove method
        boolean successfullyremoved = cs213.remove(st);
        if (!successfullyremoved){
            outputArea.appendText("The student is not in the list."+"\n");
        } else{
            outputArea.appendText(successMessage);
        }

    }
    /**
     * This class print out the student list according to what button people choose.
     */
    @FXML
    public void printBtnClicked(){
        boolean emptylist = cs213.isEmpty();
        if (emptylist == true){
            outputArea.appendText("The list is empty!"+"\n");
            return;
        }
        outputArea.appendText(cs213.toString());
    }

}
