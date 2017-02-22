package ArithemeticExpressions;


import java.util.ArrayList;

public class ListFixer {
    public static ArrayList<String> fixArray(ArrayList<String> listNum, int pointer, float output){

        //Change Current Value at pointer
        listNum.set(pointer,"" + output);

        //Remove right value from pointer
        listNum.remove(pointer + 1);

        //Remove left value from pointer
        listNum.remove(pointer - 1);

        //Returned Fixed List
        return listNum;
    }
}
