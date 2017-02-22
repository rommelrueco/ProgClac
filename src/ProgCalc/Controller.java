package ProgCalc;

import ArithemeticExpressions.Operations;
import Factory.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements EventHandler {

    //Declaration of Buttons
    public Button btn_num0,btn_num1,btn_num2,btn_num3,btn_num4,btn_num5,btn_num6,btn_num7,btn_num8,btn_num9,
            btn_decimal,btn_percent,btn_division,btn_multiply,btn_subtract,btn_addition;

    //Declaration of IO
    public TextArea txt_Display;
    public TextField txt_DisplayOutput;

    //Declaration of Factory
    KeyValue keyValue = new KeyValue();
    Input input = new Input();

    //Declaration of Arithmetic Expressions
    Operations operations = new Operations();

    @Override
    public void handle(Event event) {
        try {

            //Set Value From Event
            keyValue.setKeyValue(event);

            //Retrieve Value From Event
            String val = keyValue.getKeyValue();

            //Check Key Pressed
            if(val.equals("R")) {

                //Clear Values
                input.setInput("");
                txt_Display.setText("");
                txt_DisplayOutput.setText("");

            }else if(val.equals("=")){
                //Clear Container
                operations.listNum.removeAll(operations.listNum);

                //Set Equation
                input.setInput(txt_Display.getText());

                //Process Algorithm
                txt_DisplayOutput.setText(operations.Operations(input.getInput() + "="));

                //Clear Text box
                txt_Display.setText("");

            }else if(val.equals("L")){

                //Delete Last Inputted Value
                txt_Display.setText(txt_Display.getText().substring(0,txt_Display.getText().length() - 1));
            }
            else{
                //Get pressed key Value
                txt_Display.setText(txt_Display.getText() + val);
            }
        }catch (Exception e)
        {
            txt_DisplayOutput.setText("Syntax Error");
            throw e;
        }
    }
}

