/*
 * Group.java
 *
 * M362 Module Team
 */
package event_admissions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Group extends Thread
{
    // the event being visited by the group
    private Event event;
    // the unique group number of the group
    private int groupNumber;
    // the number of hours of the visit
    private int hours;
    // the number of adults in the group
    private int adults;
    // the number of children in the group
    private int children;

    
    public Group(Event event, int id, int hours, int adults, int children)
    {
        this.event = event;
        this.groupNumber = id;
        this.hours = hours;
        this.adults = adults;
        this.children = children;
    }

   
    /*
     * The group requests admission to the event.
     * If the group is not too large,
     * the group is admitted when seats are available.
     * To simulate the time spent at the event,
     * the thread sleeps for 1 second
     * times the value of instance variable hours.
     * The group departs.
     * If the group is too large, a message is displayed
     */
    @Override
    public void run()
    {
        System.out.println("Group " + groupNumber + " requests admission for " +
                adults + " adults " + " and " +
                children + " children.");
        {
            try 
            {
                if (event.requestAdmission(this))
                {
                    System.out.println("Group " + groupNumber + " starts viewing the event for " + hours + " hours.");
                    try
                    {
                        Thread.sleep(hours*1000);
                    }
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Group " + groupNumber + " departs.");
                    event.depart(this);
                }
                else
                {
                    System.out.println("Group " + groupNumber + " is turned away");
                }
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    public int getGroupNumber()
    {
        return groupNumber;
    }

    public int getAdults()
    {
        return adults;
    }

    public int getChildren()
    {
        return children;
    }



}
