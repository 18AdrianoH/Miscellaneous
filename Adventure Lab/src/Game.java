/**
 * Class Game - the main class of the "Hark" game.
 * 091608
 * @version 070111
 *          Moved the main method into its own class
 * @version 061412
 *			Cleaned up comments
 *
 *  Michael Kolling's Zork code, modified to resemble MIT's 6.001 Adventure Game.
 *
 *  This class is the main class of the "Hark" application. Hark is a very
 *  simple, text based adventure game.  Users can walk around some scenery.
 *  That's all. It should really be extended to make it more interesting!
 *
 *  To play this game, create an instance of this class and call the "play"
 *  routine.
 *
 *  This main class creates and initializes all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates the
 *  commands that the parser returns.
 */

import java.util.ArrayList;

public class Game
{
    private Parser parser;
    private Person hero;
    private ArrayList<Person> otherPeople;
    private ArrayList<Room> rooms;

    /**
     * Create the game and initialize its internal map.
     */
    public Game()
    {
        setup();
        parser = new Parser();
    }

    /**
     * Create all the rooms, link their exits together, and populate them.
     */
    private void setup()
    {
	    // the Room declarations violate the coding standard.  This is done
	    // to reduce the space required.  Special permission was obtained to
	    // do this!
        Room shah, main, manzanita, edge, bookStore, library, gym, dobbins;
        Room parking, field, nichols, cave, room301;

        // create the rooms
        shah = new Room("Shah Hall");
        main = new Room("The Main Building");
        manzanita = new Room("Manzanita Hall");
        edge = new Room("The Edge");
        bookStore = new Room("the book store");
        library = new Room("the library");
        gym = new Room("the gym");
        dobbins = new Room("Dobbins Hall");
        parking = new Room("the parking lot");
        field = new Room("Rosenthal Field");
        nichols = new Room("Nichols Hall");
        cave = new Room("a dark cave");

        // initialise room exits (north, east, south, west)
        shah.setExits(null, main, null, null);
        main.setExits(null, manzanita, library, shah);
        manzanita.setExits(null, edge, gym, main);
        edge.setExits(null, bookStore, dobbins, manzanita);
        bookStore.setExits(null, null, null, edge);
        library.setExits(main, gym, null, null);
        gym.setExits(manzanita, null, field, library);
        dobbins.setExits(edge, null, nichols, null);
        parking.setExits(null, field, null, null);
        field.setExits(gym, nichols, null, parking);
        nichols.setExits(dobbins, cave, null, field);
        cave.setExits(null, null, null, nichols);
        
        

        // put all the rooms in the array list
        rooms = new ArrayList<Room>();
        rooms.add(shah);
        rooms.add(main);
        rooms.add(manzanita);
        rooms.add(edge);
        rooms.add(bookStore);
        rooms.add(library);
        rooms.add(gym);
        rooms.add(dobbins);
        rooms.add(parking);
        rooms.add(field);
        rooms.add(nichols);
        rooms.add(cave);

        // create the people
        hero = new Person("Your Name Here", Person.HERO);
        hero.changeRoom(getRandomRoom());

        Person mrK = new Person("MrKeller", Person.ROBOT);
        mrK.changeRoom(getRandomRoom());

        Person bamboozler = new Person("Bamboozler", Person.ROBOT);
        bamboozler.changeRoom(getRandomRoom());

        Person javaMan = new Person("JavaMan", Person.ROBOT);
        javaMan.changeRoom(getRandomRoom());

        Person jerryBrown = new Person("GovernorMoonBeam", Person.ROBOT);
        jerryBrown.changeRoom(getRandomRoom());

        Person mrNikoloff = new Person("MrNikoloff", Person.ROBOT);
        mrNikoloff.changeRoom(getRandomRoom());
        
        Person drNelson = new Person("DrNelson", Person.ROBOT);
        drNelson.changeRoom(nichols);

        Person grendel = new Person("Grendel", Person.MONSTER);
        grendel.changeRoom(cave);
        

        // put all the other people in the array list
        otherPeople = new ArrayList<Person>();
        otherPeople.add(mrK);
        otherPeople.add(bamboozler);
        otherPeople.add(javaMan);
        otherPeople.add(jerryBrown);
        otherPeople.add(mrNikoloff);
        otherPeople.add(drNelson);
        otherPeople.add(grendel);
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        printWelcome();
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Hark!");
        System.out.println("Hark is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(hero.getRoom().longDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command)
    {
        if(command.isUnknown())
        {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord(1);
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
        {
            if(command.hasWord(2))
                System.out.println("Quit what?");
            else
                return true;  // signal that we want to quit
        }
        return false;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around The Harker Upper School.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(CommandWords.showAll());
    }

    /**
     * Try to go to one direction. If there is an exit, enter the new
     * room and make all other people act, otherwise print an error message.
     */
    private void goRoom(Command command)
    {
        if(!command.hasWord(2))
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
        }
        else
        {
            String direction = command.getCommandWord(2);
    
            // Try to leave current room.
            Room nextRoom = hero.getRoom().nextRoom(direction);
    
            if (nextRoom == null)
                System.out.println("There is no door!");
            else
            {
                hero.changeRoom(nextRoom);
                moveOtherPeople();
                System.out.println(nextRoom.longDescription());
            }
        }
    }

    //returns a random room in the game
    private Room getRandomRoom()
    {
        int index = Game.random(rooms.size());
        Room room = rooms.get(index);
        return room;
    }

    //cause other people to act (which typically means moving)
    private void moveOtherPeople()
    {
        for (int i = 0; i < otherPeople.size(); i++)
        {
            Person person = otherPeople.get(i);
            person.act();
        }
    }

    //returns a random integer from 0 to n-1
    public static int random(int n)
    {
        return (int)(Math.random() * n);
    }    
}
