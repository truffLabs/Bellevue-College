package edu.bellevuecollege.cs211.dork.model;

public class Person 
{
    //a person has a name
    private String personName;

    //a person has a type
    //TODO: should this be an ENUM...friend or foe?
    private String personType;

    //a person is in a room
    private Room currentRoom;

    //construct Person object with personsName parameter
    public void Person(String someName)
    {
        this.personName = someName;
        //TODO: do I want to initialize in a room, or specify later?
        this.currentRoom = null;
    }

    //a person can move to another room
    //TODO: do I pass in a direction as parameter or a room object?
    //TODO: trust client code to validate if room exists or good decision?
    public void move(Room goToRoom)
    {
        this.currentRoom = goToRoom;
    }

    public void move(Direction dir, Room goToRoom)
    {
        if(goToRoom.roomExists(dir))
        {
            this.currentRoom = goToRoom;
        }
        else
        {
            //TODO: return some condition to calling code
        }
    }


    public String getPersonsName() {
        return personName;
    }

    public void setPersonsName(String personsName) {
        this.personName = personsName;
    }

    public String getPersonsType() {
        return personType;
    }

    public void setPersonsType(String personsType) {
        this.personType = personsType;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
