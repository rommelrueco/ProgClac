package ArithemeticExpressions;

public class Operations {

    private int output;


    public String Operations(String operator, String firstInput, String secondInput ){
        switch (operator)
        {
            case "+":
                output = Integer.parseInt(firstInput) + Integer.parseInt(secondInput);
                return output + "";

            case "-":
                output = Integer.parseInt(firstInput) - Integer.parseInt(secondInput);
                return output + "";

            case "x":
                output = Integer.parseInt(firstInput) * Integer.parseInt(secondInput);
                return output + "";

            case "/":
                output = Integer.parseInt(firstInput) / Integer.parseInt(secondInput);
                return output + "";

            default:
                return output + "";
        }
    }
}
