package ru.sbt.hw5.Exceptions;


public class AccountIsLockedException extends Exception {

    public AccountIsLockedException(String message) {
        super(message);
    }
}
