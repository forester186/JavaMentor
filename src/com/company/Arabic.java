package com.company;

public class Arabic extends Calc {
    public Arabic (int number1, int number2, char symbol) {
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
        System.out.println(result);



    }
}
