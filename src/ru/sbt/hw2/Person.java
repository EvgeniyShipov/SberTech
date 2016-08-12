package ru.sbt.hw2;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     * param person - new husband/wife for this person.
     * return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */

    public boolean marry(Person person) {
        if (this.man != person.man) {
            if (this.spouse != null) {
                this.divorce();
            }
            if (person.spouse != null) {
                person.divorce();
            }
            this.spouse = person;
            person.spouse = this;
            System.out.println(this.name + " и " + person.name + " сыграли свадьбу!");
            return true;
        } else {
            System.out.println(this.name + " и " + person.name + " не могут сыграть свадьбу, т.к. однополые браки запрещены в нашей стране.");
            return false;
        }
    }

    /**
     * Sets spouse = null if spouse is not null
     * return true - if person status has been changed
     */

    public boolean divorce() {
        if (this.spouse != null) {
            System.out.println(this.name + " и " + this.spouse.name + " развелись.");
            this.spouse.spouse = null;
            this.spouse = null;
            return true;
        } else {
            if (this.man == true) {
                System.out.println(this.name + " не может развестись, т.к. не женат.");
            } else {
                System.out.println(this.name + " не сможет развестись, т.к. не замужем.");
            }
            return false;
        }
    }

    public void status() {
        if (this.spouse == null) {
            if (this.man == true) {
                System.out.println(this.name + " не женат, и чувствует себя хорошо.");
            } else {
                System.out.println(this.name + " не замужем, но очень хочет.");
            }
        } else {
            if (this.man == true) {
                System.out.println(this.name + " женат на " + this.spouse.name + ", и счастлив!");
            } else {
                System.out.println(this.name + " замужем за " + this.spouse.name + ", и счастлива!");
            }
        }
    }
}
