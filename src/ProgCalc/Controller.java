package ProgCalc;

import ArithemeticExpressions.CheckInteger;
import ArithemeticExpressions.Operations;
import Factory.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller implements EventHandler {

    //Declaration of Buttons
    public Button btn_num0,btn_num1,btn_num2,btn_num3,btn_num4,btn_num5,btn_num6,btn_num7,btn_num8,btn_num9,
            btn_decimal,btn_percent,btn_division,btn_multiply,btn_subtract,btn_addition;

    //Declaration of IO
    public TextArea txt_Display;

    //Declaration of Factory
    KeyValue keyValue = new KeyValue();
    Operator operator = new Operator();
    Input input = new Input();

    //Declaration of Arithmetic Expressions
    Operations operations = new Operations();

    @Override
    public void handle(Event event) {
        //Set Value From Event
        keyValue.setKeyValue(event);

        //Retrieve Value From Event
        String val = keyValue.getKeyValue();

        //Check Value if number
        if(CheckInteger.checkNum(val)) {
            txt_Display.setText(txt_Display.getText() + val);
        }
        //Check Decimal
        else if(val.equals(".")) {
            txt_Display.setText(txt_Display.getText() + val);
        }

        // Check Operator
        else if(val.equals("+")  || val.equals("-") || val.equals("x")
                || val.equals("/")){

            if(input.getInput() == "" || input.getInput() == null) {
                //Set Temporary Input
                input.setInput(txt_Display.getText());
                //Set Operator
                operator.setOperator(val);
                //Clear Text
                txt_Display.setText("");
            }else{
                //Set Computed Output
                input.setInput(operations.Operations(val,input.getInput(),txt_Display.getText()));
                txt_Display.setText(input.getInput());
            }
        }
        else if(val.equals("R")){
            txt_Display.setText("");
            operator.setOperator("");
        }

    }



}

