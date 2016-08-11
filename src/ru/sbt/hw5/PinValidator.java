package ru.sbt.hw5;


import ru.sbt.hw5.Exceptions.AccountIsLockedException;

public class PinValidator {

    private final int pin = 0000;
    private int timeToTry = 0;
    boolean isPinCorrect = false;

    void checkPin(int pin) throws AccountIsLockedException {
        if (this.pin == pin) {
            isPinCorrect = true;
        } else {
            isPinCorrect = false;
            timeToTry++;
            if (timeToTry == 3) {
                throw new AccountIsLockedException("Превышен лимит попыток");
            }
        }
    }
}
