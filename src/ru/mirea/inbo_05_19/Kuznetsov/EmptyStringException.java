package ru.mirea.inbo_05_19.Kuznetsov;

public class EmptyStringException extends RuntimeException {
    public EmptyStringException(String s) {
        super(s);
    }
}