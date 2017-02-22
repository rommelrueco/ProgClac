package ArithemeticExpressions;

public class CheckInteger {

    //Value Check if Integer
    public static boolean checkNum(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
