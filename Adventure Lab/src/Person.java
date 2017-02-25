/**
 * A person or character in our game.  There will be at least three kinds of people:
 * a hero (you), monsters (who eat other people), and robots (who walk around and do their own thing).
 *
 *
 */
//


public class Person
{
    //types of people
    public static final int HERO    = 0;
    public static final int MONSTER = 1;
    public static final int ROBOT   = 2;

    private static final int MAXHEALTH = 4;
    //instance variables
    private String name;
    private int type;
    private Room room;
    private int health;

    //creates a new person with given name and of given type
    public Person(String aName, int aType)
    {
        name = aName;
        type = aType;
        health = MAXHEALTH;
    }

    //returns this person's name
    public String getName()
    {
        return name;
    }

    //returns the type of this person
    public int getType()
    {
        return type;
    }

    //returns the room the person is in
    public Room getRoom()
    {
        return room;
    }

    //moves the person to the given room
    // why can't I just write room = nextRoom; ???
    public void changeRoom(Room nextRoom)
    {
        //remove the person from the old room (if already in one)
        if (room != null)
            room.remove(this);

        //change my room to be the next one
        room = nextRoom;

        //add myself to the new room
        room.add(this);
    }

    //precondition:  person is not the hero
    //postcondition: person has acted, by moving, eating people, etc.
    public void act()
    {   
        // dead people can't act
        if (room != null)
        {
            move();
            if (type == MONSTER)
                eatSomeone();
        }
    }

    //causes the person to move to a random neighbor (or stay still)
    private void move()
    {
        int num = Game.random(4);
        String direction;
        if (num == 0)
            direction = "north";
        else if (num == 1)
            direction = "east";
        else if (num == 2)
            direction = "south";
        else //num == 3
            direction = "west";
        Room nextRoom = room.nextRoom(direction);
        if (nextRoom != null)
        {
            changeRoom(nextRoom);
            
        }
    }

    //sometimes causes this person to eat a random person in the room
    private void eatSomeone()
    {
        Person victim = room.getRandomPerson();
        if (victim != this) //don't eat yourself
        {
            say("Grrr!  I eat tasty " + victim.getName() + "!");
            victim.suffer(Game.random(3) + 2);
        }
    }

    //causes the person to say the given message
    public void say(String message)
    {
        System.out.println("At " + room.getName() + " " + name + " says -- " + message);
    }

    //causes this person to suffer the given amount of damage
    public void suffer(int hits)
    {
        say("Ouch!  " + hits + " hits is more than I want!");
        health = health - hits;
        if (health <= 0)
            die();
    }

    //causes this person to die
    public void die()
    {
        say("SHREEEEK!  I, uh, suddenly feel very faint...");

        System.out.println("An earth-shattering, soul-piercing scream is heard...");

        room.remove(this);

        room = null;

        if (type == HERO)
        {
            // say goodbye and die
            System.out.println("Thank you for playing.  Good bye.");
            System.exit(0);
        }
    }
}