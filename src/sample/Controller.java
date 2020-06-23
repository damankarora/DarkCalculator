package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonDivide;

    @FXML
    private Button buttonMod;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button buttonMult;

    @FXML
    private Button buttonPow;

    @FXML
    private Button allClear;

    @FXML
    private Button button0;

    @FXML
    private Button buttonDec;

    @FXML
    private Button buttonEquals;

    @FXML
    private Button buttonSquare;

    @FXML
    private TextField calculationField;

    @FXML
    public void inputEventHandler(ActionEvent event){
        if (event.getSource().equals(allClear)){
            calculationField.setText("");
            return;
        }
        calculationField.setText(calculationField.getText()+((Button)event.getSource()).getText());
    }

    public void performCalculation(){
        String input = calculationField.getText();
        for (int i = 0; i < input.length(); i++){
            char character = input.charAt(i);

        }
    }


}
