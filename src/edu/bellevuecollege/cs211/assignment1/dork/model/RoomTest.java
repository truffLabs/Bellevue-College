package edu.bellevuecollege.cs211.assignment1.dork.model;
import edu.bellevuecollege.cs211.assignment1.dork.items.*;
import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class RoomTest {

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {

    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testRoom() throws Exception
    {
        //check default values
        Room r1 = new Room("test");
        assertEquals(r1.getNorth(), null);
        assertEquals(r1.getSouth(), null);
        assertEquals(r1.getEast(), null);
        assertEquals(r1.getWest(), null);


        //check if array list is empty
        assertTrue(r1.getItemsInRoom().isEmpty());
    }

    @Test
    public void testsetLocation() throws Exception
    {
        //create room in shape of '+' with five total
        //rooms ; one in center and one at each extremity
        Room base = new Room("test");
        Room up = new Room("test1");
        Room down = new Room("test2");
        Room left = new Room("test3");
        Room right = new Room("test4");

        //call method to set north = up, etc
        base.setLocation(Direction.NORTH, up);
        base.setLocation(Direction.SOUTH, down);
        base.setLocation(Direction.EAST, left);
        base.setLocation(Direction.WEST, right);

        //test if objects reference same memory location
        assertEquals(base.getNorth(), up);
        assertEquals(base.getSouth(), down);
        assertEquals(base.getEast(), left);
        assertEquals(base.getWest(), right);
    }

    @Test
    public void testSetLocation2() throws Exception
    {
        //create room in shape of '+' with five total
        //rooms ; one in center and one at each extremity
        Room base = new Room("test");
        Room up = new Room("test1");
        Room down = new Room("test2");
        Room left = new Room("test3");
        Room right = new Room("test4");

        //call method to set north = up, etc
        base.setLocation(up, down, left, right);

        //test if objects reference same memory location
        assertEquals(base.getNorth(), up);
        assertEquals(base.getSouth(), down);
        assertEquals(base.getEast(), left);
        assertEquals(base.getWest(), right);
    }

    @Test
    public void testGetAdjacent() throws Exception
    {
        //create room in shape of '+' with five total
        //rooms ; one in center and one at each extremity
        Room base = new Room("test");
        Room up = new Room("test1");
        Room down = new Room("test2");
        Room left = new Room("test3");
        Room right = new Room("test4");

        //call method to set north = up, etc
        base.setLocation(up, down, left, right);

        //test if objects reference same memory location
        assertEquals(base.getAdjacent(Direction.NORTH), up);
        assertEquals(base.getAdjacent(Direction.SOUTH), down);
        assertEquals(base.getAdjacent(Direction.EAST), left);
        assertEquals(base.getAdjacent(Direction.WEST), right);
    }

    @Test
    public void getItemsInRoom() throws Exception
    {
        //setup
        Room getItemsInRoom = new Room("test");
        DirtyDiaper diaperInRoom = new DirtyDiaper("somekid");
        DirtyDiaper diaperInRoom2 = new DirtyDiaper("somekid2");
        getItemsInRoom.addItem(diaperInRoom);
        getItemsInRoom.addItem(diaperInRoom2);
        ArrayList listOfItemsInRoom = getItemsInRoom.getItemsInRoom();

        //does the diaper exist in the room?
        assertTrue(listOfItemsInRoom.contains(diaperInRoom));
        assertTrue(listOfItemsInRoom.contains(diaperInRoom2));
    }

    @Test
    public void getPeopleInRoom() throws Exception
    {
        //setup
        Room anyRoom = new Room("test");
        Person somebody = new Person("somebody");
        Person somebodyElse = new Person("somebodyElse");
        anyRoom.addPerson(somebody);
        anyRoom.addPerson(somebodyElse);
        ArrayList listOfPeopleInRoom = anyRoom.getPeopleInRoom();

        //does the people exist in the room?
        assertTrue(anyRoom.getPeopleInRoom().contains(somebody));
        assertTrue(anyRoom.getPeopleInRoom().contains(somebodyElse));
    }

    @Test
    public void testAddItem() throws Exception
    {
        //setup
        Room testAddItem = new Room("test");
        DirtyDiaper diaperInRoom = new DirtyDiaper("somekid");
        DirtyDiaper diaperInRoom2 = new DirtyDiaper("somekid2");
        testAddItem.addItem(diaperInRoom);
        ArrayList listOfItemsInRoom = testAddItem.getItemsInRoom();

        //does the diaper exist in the room?
        assertTrue(listOfItemsInRoom.contains(diaperInRoom));
    }

    @Test
    public void addPerson() throws Exception
    {
        //setup
        Room anyRoom = new Room("test");
        Person somebody = new Person("somebody");
        Person somebodyElse = new Person("somebodyElse");
        anyRoom.addPerson(somebody);
        anyRoom.addPerson(somebodyElse);
        ArrayList listOfPeopleInRoom = anyRoom.getPeopleInRoom();

        //does the people exist in the room?
        assertTrue(anyRoom.getPeopleInRoom().contains(somebody));
        assertTrue(anyRoom.getPeopleInRoom().contains(somebodyElse));
    }

    @Test
    public void testRemoveItem() throws Exception
    {
        //setup
        Room testRemoveItem = new Room("test");
        DirtyDiaper diaperInRoom = new DirtyDiaper("somekid");
        DirtyDiaper diaperInRoom2 = new DirtyDiaper("somekid2");
        testRemoveItem.addItem(diaperInRoom);
        testRemoveItem.addItem(diaperInRoom2);

        ArrayList listOfItemsInRoom = testRemoveItem.getItemsInRoom();

        //does the diaper exist in the room right now?
        assertTrue(listOfItemsInRoom.contains(diaperInRoom));
        assertTrue(listOfItemsInRoom.contains(diaperInRoom2));

        //remove items from the room
        testRemoveItem.removeItem(diaperInRoom2);

        //does diaperInRoom2 exist in the room now?
        assertFalse(listOfItemsInRoom.contains(diaperInRoom2));

    }

    @Test
    public void removePerson() throws Exception
    {
        //setup
        Room anyRoom = new Room("test");
        Person somebody = new Person("somebody");
        Person somebodyElse = new Person("somebodyElse");
        anyRoom.addPerson(somebody);
        anyRoom.addPerson(somebodyElse);
        ArrayList listOfPeopleInRoom = anyRoom.getPeopleInRoom();

        //does the people exist in the room before?
        assertTrue(anyRoom.getPeopleInRoom().contains(somebody));
        assertTrue(anyRoom.getPeopleInRoom().contains(somebodyElse));

        //remove people from room
        anyRoom.removePerson(somebodyElse);

        //is somebodyElse still in the room?
        assertFalse(anyRoom.getPeopleInRoom().contains(somebodyElse));
    }

    @Test
    public void testClearItems()
    {
        //setup
        Room testRemoveItem = new Room("test");
        DirtyDiaper diaperInRoom = new DirtyDiaper("somekid");
        DirtyDiaper diaperInRoom2 = new DirtyDiaper("somekid2");
        testRemoveItem.addItem(diaperInRoom);
        testRemoveItem.addItem(diaperInRoom2);

        ArrayList listOfItemsInRoom = testRemoveItem.getItemsInRoom();

        //does the diaper exist in the room right now?
        assertTrue(listOfItemsInRoom.contains(diaperInRoom));
        assertTrue(listOfItemsInRoom.contains(diaperInRoom2));

        testRemoveItem.clearItems(listOfItemsInRoom);

        //is the list empty?
        assertTrue(listOfItemsInRoom.isEmpty());
    }

    @Test
    public void testRoomExists() throws Exception
    {

        //create room in shape of '+' with five total
        //rooms ; one in center and one at each extremity
        Room base = new Room("test");
        Room up = new Room("test1");
        Room down = new Room("test2");
        Room left = new Room("test3");
        Room right = new Room("test4");

        //set base
        base.setLocation(up, down, left, right);

        //set up
        up.setLocation(Direction.NORTH, null);
        up.setLocation(Direction.SOUTH, base);
        up.setLocation(Direction.EAST, null);
        up.setLocation(Direction.WEST, null);

        //are there rooms around base?
        assertTrue(base.roomExists(Direction.NORTH));
        assertTrue(base.roomExists(Direction.SOUTH));
        assertTrue(base.roomExists(Direction.EAST));
        assertTrue(base.roomExists(Direction.WEST));

        //are there rooms around up?
        assertFalse(up.roomExists(Direction.NORTH));
        assertTrue(up.roomExists(Direction.SOUTH));
        assertFalse(up.roomExists(Direction.EAST));
        assertFalse(up.roomExists(Direction.WEST));

    }

    @Test
    public void testEnter() throws Exception
    {
        Room r1 = new Room("test");
        assertTrue("You entered the test room.".equals(r1.enter()));

    }

    @Test
    public void testExit() throws Exception
    {
        Room r1 = new Room("test");
        assertTrue("You left the test room.".equals(r1.exit()));
    }

    @Test
    public void testGetName() throws Exception
    {
        Room r1 = new Room("test");
        assertTrue("test".equals(r1.getName()));
    }

    @Test
    public void testSetName() throws Exception
    {
        Room r1 = new Room("testBefore");
        r1.setName("testAfter");
        assertTrue("testAfter".equals(r1.getName()));
    }
}
