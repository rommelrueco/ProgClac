package Factory;

import javafx.event.Event;

public class KeyValue {
    private String keyValue;

    public void setKeyValue(Event event){
        keyValue = event.getSource().toString().charAt(event.getSource().toString().length()-2) + "";
    }

    public String       getKeyValue(){
        return keyValue;
    }
}
