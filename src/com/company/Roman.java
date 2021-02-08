package com.company;

public class Roman extends Calc {
    public Roman(int number1, int number2, char symbol) {
        super(number1, number2, symbol);
    }
    public void sum(){
        switch(symbol){
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                System.out.println("Невозможно произвести вычисления, проверьте запись!");
        }
        System.out.println(intToRoman(result));
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        String[] romans = { "I", "IV", "V", "IX", "X", "XL", "L",
                "XC", "C", "CD", "D", "CM", "M" };
        int[] ints = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
                900, 1000 };
        for (int i = ints.length - 1; i >= 0; i--) {
            times = num / ints[i];
            num %= ints[i];
            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        return sb.toString();
    }

}
