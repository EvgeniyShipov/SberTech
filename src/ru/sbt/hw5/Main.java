package ru.sbt.hw5;


import ru.sbt.hw5.TerminalImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TerminalImpl terminal = new TerminalImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Проверить баланс, нажмите 1");
        System.out.println("Пополнить баланс, нажмите 2");
        System.out.println("Снять средства, нажмите 3");
        System.out.println("Выйти, нажмите 9");
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number == 1) {
                terminal.checkAccount();
            } else if (number == 2) {
                terminal.putMoney();
            } else if (number == 3) {
                terminal.getMoney();
            } else if (number == 9) {
                System.out.println("Хорошего дня!");
                break;
            } else {
                System.out.println("Вы ввели не верное значение. Попробуйте ещё раз");
            }
        }
        scanner.close();
    }
}
