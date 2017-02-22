package ArithemeticExpressions;


import java.util.ArrayList;

public class Operations {

    private char[] input;
    private Float output;
    private int pointer;
    public static ArrayList<String> listNum = new ArrayList<>();

    public String Operations(String input) {
        try {
            this.input = input.toCharArray();

            int tempIndex = 0;
            for (int ctr = 0; ctr < this.input.length; ctr++) {
                if (this.input[ctr] == '+' || this.input[ctr] == '-' ||
                        this.input[ctr] == 'x' || this.input[ctr] == '/' || this.input[ctr] == '=') {
                    listNum.add(input.substring(tempIndex, ctr));
                    listNum.add(this.input[ctr] + "");
                    tempIndex = ctr + 1;
                }
            }

            while (listNum.contains("=")) {
                //Check amount of values in array list if 0 break loop
                if (listNum.size() > 2) {
                    //Check array if has both X and /
                    if (listNum.contains("x") && listNum.contains("/")) {
                        //Check Index of X and / for left to right order
                        //
                        //If X comes first
                        if (listNum.indexOf("x") < listNum.indexOf("/")) {
                            pointer = listNum.indexOf("x");
                            output = Float.parseFloat(listNum.get(pointer - 1)) * Float.parseFloat(listNum.get(pointer + 1));
                            ListFixer.fixArray(listNum,pointer,output);
                        }
                        //if / Comes first
                        else {
                            pointer = listNum.indexOf("/");
                            output = Float.parseFloat(listNum.get(pointer - 1)) / Float.parseFloat(listNum.get(pointer + 1));
                            ListFixer.fixArray(listNum,pointer,output);
                        }
                    }
                    //Check array if it only has x
                    else if (listNum.contains("x") && !listNum.contains("/")) {
                        pointer = listNum.indexOf("x");
                        output = Float.parseFloat(listNum.get(pointer - 1)) * Float.parseFloat(listNum.get(pointer + 1));
                        ListFixer.fixArray(listNum,pointer,output);
                    }
                    //Check array if it only has /
                    else if (!listNum.contains("x") && listNum.contains("/")) {
                        pointer = listNum.indexOf("/");
                        output = Float.parseFloat(listNum.get(pointer - 1)) / Float.parseFloat(listNum.get(pointer + 1));
                        ListFixer.fixArray(listNum,pointer,output);
                    }
                    // Check if array has both + and -
                    else if (listNum.contains("+") && listNum.contains("-")) {
                        //Check Index of + and - for left to right order
                        //
                        //If + comes first
                        if (listNum.indexOf("+") < listNum.indexOf("-")) {
                            pointer = listNum.indexOf("+");
                            output = Float.parseFloat(listNum.get(pointer - 1)) + Float.parseFloat(listNum.get(pointer + 1));
                            ListFixer.fixArray(listNum,pointer,output);
                        }
                        //if - Comes first
                        else {
                            output = Float.parseFloat(listNum.get(pointer - 1)) - Float.parseFloat(listNum.get(pointer + 1));
                            ListFixer.fixArray(listNum,pointer,output);
                        }
                    }
                    //Check array if it only has +
                    else if (listNum.contains("+") && !listNum.contains("-")) {
                        pointer = listNum.indexOf("+");
                        output = Float.parseFloat(listNum.get(pointer - 1)) + Float.parseFloat(listNum.get(pointer + 1));
                        ListFixer.fixArray(listNum,pointer,output);
                    }
                    //Check array if it only has -
                    else if (!listNum.contains("+") && listNum.contains("-")) {
                        pointer = listNum.indexOf("-");
                        output = Float.parseFloat(listNum.get(pointer - 1)) - Float.parseFloat(listNum.get(pointer + 1));
                        ListFixer.fixArray(listNum,pointer,output);
                    }
                } else {
                    listNum.remove(1);
                }
            }

            //Pass Value
            output = Float.parseFloat(listNum.get(0));

            //Clear List For nxt algorithm
            listNum.removeAll(listNum);

            //Return Value
            return output + "";

        }catch (Exception e){
            return  "Syntax Error";
        }
    }
}

