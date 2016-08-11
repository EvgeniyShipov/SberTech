package ru.sbt.hw5;


import ru.sbt.hw5.Exceptions.NotEnoughMoneyException;
import ru.sbt.hw5.Exceptions.SumException;

public class TerminalServer {
    int money = 0;

    boolean checkSum(int sum) throws SumException {
        if (sum % 100 == 0) {
            return true;
        } else {
            throw new SumException("Сумма должна быть кратна 100 рублям");
        }
    }

    void putMoney(int sum) {
        money += sum;
    }

    void getMoney(int sum) throws NotEnoughMoneyException {
        if (sum <= money) {
            money -= sum;
        } else {
            throw new NotEnoughMoneyException("Недостаточно средств.");
        }
    }

}
