package ru.sbt.hw5;


import ru.sbt.hw5.Exceptions.AccountIsLockedException;
import ru.sbt.hw5.Exceptions.NotEnoughMoneyException;
import ru.sbt.hw5.Exceptions.PinValidatorException;
import ru.sbt.hw5.Exceptions.SumException;

import java.util.Scanner;

public class TerminalImpl implements Terminal {

    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void checkAccount() throws InterruptedException {
        try {
            System.out.println("Введите пин-код");
            pinValidator.checkPin(scanner.nextInt());
            if (pinValidator.isPinCorrect) {
                System.out.println("Ваш баланс: " + server.money + " рублей");
            } else {
                throw new PinValidatorException("Не верный пин-код");
            }
        } catch (PinValidatorException e) {
            System.out.println("Не верный пин-код");
        } catch (AccountIsLockedException e) {
            System.out.println("Превышен лимит попыток. Попробуйте позже");
            Thread.sleep(5000);
        }
    }

    @Override
    public void putMoney() throws InterruptedException {
        if (!(pinValidator.isPinCorrect)) {
            checkAccount();
        }
        System.out.println("На какую сумму пополнить?");
        int sum = scanner.nextInt();
        try {
            if (server.checkSum(sum)) {
                server.putMoney(sum);
                System.out.println("Итого у Вас на балансе: " + server.money + " рублей");
            }
        } catch (SumException e) {
            System.out.println("Сумма должна быть кратна 100 рублям");
        }
    }

    @Override
    public void getMoney() throws InterruptedException {
        if (!(pinValidator.isPinCorrect)) {
            checkAccount();
        }
        System.out.println("Какую сумму Вы хотите снять?");
        int sum = scanner.nextInt();
        try {
            if (server.checkSum(sum)) {
                server.getMoney(sum);
                System.out.println("Оставшаяся сумма: " + server.money + " рублей");
            }
        } catch (NotEnoughMoneyException e) {
            System.out.println("Недостаточно средств.");
        } catch (SumException e) {
            System.out.println("Сумма должна быть кратна 100 рублям");
        }
    }
}
