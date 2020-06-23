package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button buttonDivide;


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

    private boolean operandPresent = false;

    @FXML
    public void inputEventHandler(ActionEvent event){
        if (event.getSource().equals(allClear)){
            calculationField.setText("");
            return;
        }

        try{
            Button pressedButton = (Button) event.getSource();
            Integer.parseInt(pressedButton.getText());
        }catch (Exception e){
            if (operandPresent){
                performCalculation();
            }else{
                operandPresent = true;
            }
        }

        if (event.getSource().equals(buttonSquare)){
            calculationField.setText(String.valueOf(squareRoot(calculationField.getText())));
            operandPresent = false;
            return;
        }


        if (event.getSource().equals(buttonEquals)){
            performCalculation();
            operandPresent = false;
            return;
        }
        //calculationField.setText(calculationField.getText()+((Button)event.getSource()).getText());
        calculationField.appendText(((Button)(event.getSource())).getText());

    }

    @FXML
    public void backSpaceHandler(){
        calculationField.setText(calculationField.getText(0, calculationField.getLength()-1));
    }

    public void performCalculation(){
        String input = calculationField.getText();
        char operator = 'X';
        for (int i = 0; i < input.length(); i++){
            char character = input.charAt(i);
            if (character<'0' || character>'9'){
                operator = character;
                break;
            }
        }
        String spiltter = String.valueOf(operator);
        String[] operands = input.split("[-+*/]");

        switch (operator){
            case '+':
                calculationField.setText(String.valueOf(addition(operands[0], operands[1])));
                break;
            case '-':
                calculationField.setText(String.valueOf(subtract(operands[0], operands[1])));
                break;
            case '*':
                calculationField.setText(String.valueOf(multiply(operands[0], operands[1])));
                break;
            case '/':
                calculationField.setText(String.valueOf(divide(operands[0], operands[1])));
                break;
            default:
        }
    }

    private double squareRoot(String s){
        return Math.sqrt(Double.parseDouble(s));
    }


    private long addition(String a, String b){
        return Long.parseLong(a) + Long.parseLong(b);
    }

    private long subtract(String a, String b){
        return Long.parseLong(a) - Long.parseLong(b);
    }

    private long multiply(String a, String b){
        return Long.parseLong(a) * Long.parseLong(b);
    }

    private double divide(String a, String b){
        return Double.parseDouble(a) / Double.parseDouble(b);
    }


}
