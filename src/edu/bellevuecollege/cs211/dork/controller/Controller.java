package edu.bellevuecollege.cs211.dork.controller;

import java.util.Scanner;

public class Controller 
{
	private static boolean gameOver;
	
	public static void main(String Args[])
	{
        //TODO: initialize scenario by constructing four rooms

        //TODO: initialize person objects

        //display initial prompt
	    initialMenu();

        //controller will have four rooms potentially in an array list


    }


    public static void initialMenu()
    {
        Scanner scan = new Scanner(System.in);
        while(!gameOver)
        {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Move");
            System.out.println("2. Show items in room");
            System.out.println("3. Manipulate item");
            System.out.println("4. Quit");
            System.out.println();
            System.out.print("Choice: ");

            //handle error cases
            if (!scan.hasNextInt())
            {
                System.out.println("\n**Please enter a valid integer.**\n");
            }

            int choice = scan.nextInt();

            if (choice >4 || choice < 1)
            {
                System.out.println("\n**Must select option number 1, 2, 3, or 4.**\n");
            }

            //good path
            switch(choice){

                case 1:

                case 2:

                case 3:

                case 4:

                    System.out.println();
                    System.out.println("May the dork be with you.");
                    gameOver = true;

            }
        }
    }
}
