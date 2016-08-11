package ru.sbt.hw3;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(true, "Alex");
        Person p2 = new Person(false, "Jane");

        Person p3 = new Person(true, "John");
        Person p4 = new Person(false, "Alice");

        Person p5 = new Person(true, "Mitya");
        Person p6 = new Person(false, "Dasha");

        p1.marry(p2);
        p3.marry(p4);
        p6.divorce();
        p6.marry(p4);
        p6.marry(p1);
        p2.marry(p5);
        p2.divorce();

        System.out.println("Итого: ");

        p1.status();
        p2.status();
        p3.status();
        p4.status();
        p5.status();
        p6.status();


    }
}
