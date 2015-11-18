/*
 * Main.java
 *
 * Main for TMA1, Question 3.
 * M362 Module Team
 */
package event_admissions;

import java.util.Random;

public class Main
{

    /*
     * Creates new instance of Event.
     * Creates new instance of Random.
     * Creates and starts 5 Group threads.
     * Each group has a sequential group number, starting at 0,
     * and a random integer number of hours between 1 and 4,
     * and a random integer number of adults between 1 and the event adult capacity,
     * and a random integer number of children between 1 and the event child capacity.
     */
    public static void main(String[] args)
    {
        Event event = new Event();
        Random randomNumber = new Random();
        Group group0 = new Group(event, 1, randomNumber.nextInt(4), //i changed from 01234 to 12345 23/9/15
                randomNumber.nextInt(event.ADULT_CAPACITY),
                randomNumber.nextInt(event.CHILD_CAPACITY));
        Group group1 = new Group(event, 2, randomNumber.nextInt(4),
                randomNumber.nextInt(event.ADULT_CAPACITY),
                randomNumber.nextInt(event.CHILD_CAPACITY));
        Group group2 = new Group(event, 3, randomNumber.nextInt(4),
                randomNumber.nextInt(event.ADULT_CAPACITY),
                randomNumber.nextInt(event.CHILD_CAPACITY));
        Group group3 = new Group(event, 4, randomNumber.nextInt(4),
                randomNumber.nextInt(event.ADULT_CAPACITY),
                randomNumber.nextInt(event.CHILD_CAPACITY));
        Group group4 = new Group(event, 5, randomNumber.nextInt(4),
                randomNumber.nextInt(event.ADULT_CAPACITY),
                randomNumber.nextInt(event.CHILD_CAPACITY));
        group0.start();
        group1.start();
        group2.start();
        group3.start();
        group4.start();
    }
}
