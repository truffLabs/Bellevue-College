package edu.bellevuecollege.cs211.dork.model;
import edu.bellevuecollege.cs211.dork.items.Item;
import edu.bellevuecollege.cs211.dork.items.Openable;
import edu.bellevuecollege.cs211.dork.items.SippyCup;
import org.junit.Test;

public class PersonTest {
    @Test
    public void testPerson() throws Exception
    {
        Person someone = new Person("fun");
    }

    @Test
    public void testMove() throws Exception {

    }

    @Test
    public void testMove2() throws Exception {

    }

    @Test
    public void testAddItems() throws Exception
    {
        Person someone = new Person("someone");
        SippyCup sippyCup = new SippyCup("sippyCup");
        someone.addItems((Openable)sippyCup);

    }

    @Test
    public void testRemoveItems() throws Exception {

    }

    @Test
    public void testClearItems() throws Exception {

    }

    @Test
    public void testGetPersonsName() throws Exception {

    }

    @Test
    public void testSetPersonsName() throws Exception {

    }

    @Test
    public void testGetCurrentRoom() throws Exception {

    }

    @Test
    public void testSetCurrentRoom() throws Exception {

    }

    @Test
    public void testGetitemsOnPerson() throws Exception {

    }
}
