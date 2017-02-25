/*
 * Class Room - a room in an adventure game.
 *
 * Michael Kolling's Zork code, modified to resemble MIT's 6.001 Adventure Game.
 *
 * This class is part of Hark. Hark is a simple, text based adventure game.
 *
 * "Room" represents one location in the scenery of the game.  It is
 * connected to at most four other rooms via exits.  The exits are labeled
 * north, east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * @version 0614012
 *			Fixed generics and eliminated unnecessary typecasts
 */

import java.util.ArrayList;

public class Room
{
    private String name;
    private Room northExit;
    private Room eastExit;
    private Room southExit;
    private Room westExit;
    private ArrayList<Person> people;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     */
    public Room(String description)
    {
        name = description;
        people = new ArrayList<Person>();
    }

    /**
     * Define the exits of this room.  Every direction either leads to
     * another room or is null (no exit there).
     */
    public void setExits(Room north, Room east, Room south, Room west)
    {
        northExit = north;
        eastExit = east;
        southExit = south;
        westExit = west;
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the kitchen.
     *     Exits: north west
     */
    public String longDescription()
    {
        return "You are in " + name + ".\n" + exitString() + "\n" + otherPeopleString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west ".
     */
    private String exitString()
    {
        String returnString = "Exits:";

        if (northExit != null)
            returnString = returnString + " north";
        if (eastExit != null)
            returnString = returnString + " east";
        if (southExit != null)
            returnString = returnString + " south";
        if (westExit != null)
            returnString = returnString + " west";

        return returnString;
    }

    private String otherPeopleString()
    {
        if (people.size() == 1)
            return "No one is here.";

        String returnString = "People here:";

        for (int i = 0; i < people.size(); i++)
        {
            Person person = people.get(i);
            if (person.getType() != Person.HERO)
                returnString = returnString + " " + person.getName();
        }

        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room nextRoom(String direction)
    {
        if (direction.equals("north"))
            return northExit;
        else if (direction.equals("east"))
            return eastExit;
        else if (direction.equals("south"))
            return southExit;
        else if (direction.equals("west"))
            return westExit;
        else
            return null;
    }

    //adds the given person to the room
    public void add(Person person)
    {
        people.add(person);
    }

    //precondition:  person must be in the room
    //postcondition: person has been removed from the room
    public void remove(Person person)
    {
        boolean found = false;
        for (int i = 0; i < people.size() && !found; i++)
        {
            if (people.get(i) == person)
            {
                people.remove(i);
                found = true;
            }
        }

        if(!found) throw new IllegalArgumentException("Person not found:  " + person);
    }

    //precondition:  room contains at least one person
    //postcondition: returns a random person in the room
    public Person getRandomPerson()
    {
        int index = Game.random(people.size());
        return (Person)people.get(index);
    }
}