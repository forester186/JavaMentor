package com.company;
import java.util.Scanner;
import java.lang.Exception;


public class Main {

    public static void main(String[] args)  {
        System.out.print("Это калькулятор для вычисления арабских и римских чисел, введите в формате a ? b, где ? математическая операция:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();    //   Получаем строчку, что ввел пользователь
        String str1 = string.replace(" ", ""); // Удаляем все пробелы в строчке, если они есть
        int[] number = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] strings = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
        char[] symbol = {'+', '-', '*', '/'};
        char[] chars = str1.toCharArray(); // Переводим строку в символы,а точнее в массив символом
        int num = 0;
        for (char aChar : chars) {      // Определяем, есть ли числа в строке используя счетчик
            if (!Character.isDigit(aChar)) {
                continue;
            }
            num++;
        }
        char ch = 0; // Переменная в которую записывается символ (+, -, *, /) для вычисление
        int number1; // Инициализировали переменные которые будет передавать для вычисление
        int number2; // Инициализировали переменные которые будет передавать для вычисление
        try {
            if(num > 1){ // Если в строчке больше 1-ого числа, то есть 2 и более то можно вычислять
                for (char c : symbol) {
                    for (char aChar : chars) {
                        if (c == aChar) {
                            ch = c;
                            break;
                        }
                    }
                }
                int index = str1.indexOf(ch);//
                try {
                    number1 = Integer.parseInt(str1.substring(0, index)); // Сначала определяется 1-ое число в срочке, затем это число переводится в число (int)
                    number2 = Integer.parseInt(str1.substring(index + 1)); // Сначала определяется 2-ое число в срочке, затем это число переводится в число (int)
                    try {
                        if(number1 > 10 || number2 > 10){ // Проверяем числа, больше они 10 или нет, если больше то выдает исключание и вычисление не производится
                            throw new Exception("Вводимые числа больше 10, калькулятор может принимать только от 1 до 10, удачи!");
                        } else {
                            Arabic arabic = new Arabic(number1, number2, ch); // Создали объект и передали переменные
                            arabic.sum(); // Вызвали метод, который производит расчет
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                }catch (Exception e) {
                    System.out.println("Неверный формат строки!");
                }
            } else if(num == 0){ // если в строке нет чисел, значит сожержит римские числа
                for (char c : symbol) { // опеределятеся какой математический знак в строчке, и записывается он в переменную ch
                    for (char aChar : chars) {
                        if (c == aChar) {
                            ch = c;
                            break;
                        }
                    }
                }
                int index = str1.indexOf(ch);
                try {
                    String s1 = str1.substring(0, index); // Определяется 1-ое число в срочке
                    String s2 = str1.substring(index + 1); // Определяется 2-ое число в срочке

                    try {
                        for (int i = 0; i < strings.length; i++){
                            if(s1.equals(strings[i])){ // если 1-ое число удовлетворяет условию (> 10) то можно проверять дальше и 2-ое число
                                int num1 = number[i];
                                for(int j = 0; j < strings.length; j++){//
                                    if(s2.equals(strings[j])){ // оба числа удовлетворяют училовиям, поэтому можно производить расчет
                                        int num2 = number[j];
                                        Roman roman = new Roman(num1,num2, ch); //созадали объект и передали параметры
                                        roman.sum(); // вызвали метод, который производит расчет
                                        break;
                                    }else if(!s2.equals(strings[i]) && j!= strings.length - 1){
                                        continue;
                                    } else throw new Exception("2-ое число больше 10 :(");


                                }
                                break;
                            } else if(!s1.equals(strings[i]) && i!= strings.length - 1){
                                continue;
                            }else throw new Exception("1-ое число больше 10");

                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                }catch (Exception e) {
                    System.out.println("Неверный формат строки!");
                }


            }
            else throw new Exception("Вы ввели числа в арабском и римском формете, а так нельля :( \nКалькулятор может только одновременно вычислять римские или арбские числа" );

        } catch (Exception e){
            System.out.println(e.getMessage());

        }

    }
}
