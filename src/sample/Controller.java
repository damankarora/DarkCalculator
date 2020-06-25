package sample;

import javafx.beans.binding.DoubleExpression;
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
    private boolean useDoubles = false;
    private boolean decimalNumber = false;

    @FXML
    public void inputEventHandler(ActionEvent event){
        if (event.getSource().equals(allClear)){
            calculationField.setText("");
            useDoubles = false;
            decimalNumber = false;
            operandPresent = false;
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

        if (event.getSource().equals(buttonDec)){
            if (!decimalNumber){
                decimalNumber = true;
            }else {
                return;
            }
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
            if(character=='.'){
                useDoubles = true;
                continue;
            }
            if (character<'0' || character>'9'){
                operator = character;
                break;
            }
        }

        String[] operands = input.split("[-+*/]");
        if(!useDoubles){
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
        }else{
            switch (operator){
                case '+':
                    calculationField.setText(String.valueOf(doubleAddition(operands[0], operands[1])));
                    break;
                case '-':
                    calculationField.setText(String.valueOf(doubleSubtract(operands[0], operands[1])));
                    break;
                case '*':
                    calculationField.setText(String.valueOf(doubleMultiply(operands[0], operands[1])));
                    break;
                case '/':
                    calculationField.setText(String.valueOf(doubleDivide(operands[0], operands[1])));
                    break;
                default:
            }
        }


    }

    private double squareRoot(String s){
        return Math.sqrt(Double.parseDouble(s));
    }


    private long addition(String a, String b){
        return Long.parseLong(a) + Long.parseLong(b);
    }

    private double doubleAddition(String a, String b){
        return Double.parseDouble(a)+Double.parseDouble(b);
    }

    private long subtract(String a, String b){
        return Long.parseLong(a) - Long.parseLong(b);
    }

    private double doubleSubtract(String a, String b){
        return Double.parseDouble(a) - Double.parseDouble(b);
    }

    private long multiply(String a, String b){
        return Long.parseLong(a) * Long.parseLong(b);
    }

    private double doubleMultiply(String a, String b){
        return Double.parseDouble(a) * Double.parseDouble(b);
    }

    private double divide(String a, String b){
        return Double.parseDouble(a) / Double.parseDouble(b);
    }

    private double doubleDivide(String a, String b){
        return Double.parseDouble(a) / Double.parseDouble(b);
    }


}
