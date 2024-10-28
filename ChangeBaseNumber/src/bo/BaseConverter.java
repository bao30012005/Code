/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author Dell
 */

public class BaseConverter {

    public final static String BASE_CHARACTER = "0123456789ABCDEF";

    public enum Base {
        BINARY,
        DECIMAL,
        HEXADECIMAL;

        public int getBaseValue() throws Exception {
            switch (this) {
                case BINARY:
                    return 2;
                case DECIMAL:
                    return 10;
                case HEXADECIMAL:
                    return 16;
                default:
                    throw new Exception("Invalid value !");
            }
        }
    }

    private int charToInt(char c) {
        return BASE_CHARACTER.indexOf(c);
    }

    private char intToChar(int n) {
        return BASE_CHARACTER.charAt(n);
    }

    private String convertToDecimal(String input, int baseInput) {
        int decimal = 0;
        int pow = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            int number = charToInt(input.charAt(i));
            decimal += number * Math.pow(baseInput, pow);
            pow++;
        }
        return decimal + "";
    }

    private String convertFromDecimal(String input, int baseOutput) {
        String result = "";
        int number = Integer.parseInt(input);
        while (number > 0) {
            result += intToChar(number % baseOutput);
            number /= baseOutput;
        }
        StringBuilder s = new StringBuilder();
        s.append(result);
        return new String(s.reverse());
    }

    private String createRegex(int base) {
        return BASE_CHARACTER.substring(0, base);
    }

    public String convert(String input, Base baseInt, Base baseOut) throws Exception {
        input = input.toUpperCase();
        String regex = "[" + createRegex(baseInt.getBaseValue()) + "]+";
        if (!input.matches(regex)) {
            throw new Exception("Number input not match with base input");
        }
        int index = - 1;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != '0'){
                index = i;
                break;
            }
        }
        if(index == -1){
            input = "0";
        }else{
            input = input.substring(index);
        }
        if(baseInt == baseOut) return input;
        if(baseInt == Base.DECIMAL) return convertFromDecimal(input, baseOut.getBaseValue());
        if(baseOut == Base.DECIMAL) return convertToDecimal(input, baseInt.getBaseValue());
        return convertFromDecimal(convertToDecimal(input, baseInt.getBaseValue()), baseOut.getBaseValue());
    }
}
