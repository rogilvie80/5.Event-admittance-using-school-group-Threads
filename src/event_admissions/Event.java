package event_admissions;
/*
 * Event.java
 *
 * M362 Module Team.
 */

public class Event
{

    // array of adult and child seating capacity
    private int[] seats = new int[2];
    public final static int ADULT_CAPACITY = 25;
    public final static int CHILD_CAPACITY = 250;

    Event()
    {
        seats[0] = ADULT_CAPACITY;
        seats[1] = CHILD_CAPACITY;
    }

    /* Returns false if adults or
    * children value in aGroup is greater
    * than adult or child capacity of the event.
    *
    * Otherwise aGroup is made to wait while there are
    * insufficient free seats, then occupies the seats.
    * The numbers of free adult and child seats are
    * decremented accordingly and true is returned.
    * 
    * @param aGroup a group requesting admission
    * @return true if aGroup adults and children value
    * is less than or equal to adult or child capacity
    * of the event
    */
    public synchronized boolean requestAdmission(Group aGroup) throws InterruptedException
    {
        int adults = aGroup.getAdults();
        int children = aGroup.getChildren();
        if (adults > ADULT_CAPACITY || children > CHILD_CAPACITY)
        {
           return false;
        }
        else
        {
            while(adults > seats[0] || children > seats[1])
            {
                this.wait();
            }
            seats[0] = seats[0] - adults;
            seats[1] = seats[1] - children;
            System.out.println(
                    "Group " + aGroup.getGroupNumber() + " is admitted.");
            System.out.println(
                    "Remaining : " + seats[0] + " adult seats , " + seats[1] + " child seats");
            
            this.notifyAll();
            return true;
        }
    }

    /*
     * aGroup departs and frees its seats
     * The number of free adult and child seats is
     * incremented accordingly.
     * All waiting threads are notified
     * @param aGroup departing the venue
     */
    public synchronized void depart(Group aGroup) throws InterruptedException
    {
        int adults = aGroup.getAdults();
        int children = aGroup.getChildren();
        seats[0] = seats[0] + adults;
        seats[1] = seats[1] + children;

        System.out.println(
                " " + adults + " adults, and  " + children + " children have left the event. ");
        System.out.println(
                "Remaining : " + seats[0] + " adult seats , " + seats[1] + " child seats");
        this.notifyAll();

    }
}
