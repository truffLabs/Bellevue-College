package edu.bellevuecollege.cs211.dork.controller;

import java.util.Scanner;

public class Controller 
{
	private static boolean gameOver;
	
	public static void main()
	{
		Scanner scan = new Scanner(System.in);
		while(!gameOver)
		{
			System.out.println("What would you like to do?");
			System.out.println("1. Move");
			System.out.println("2. Show items in room");
			System.out.println("3. Manipulate item");
			System.out.println("4. Quit");
			
			if (!scan.hasNextInt())
			{
				continue;
			}
			
			int choice = scan.nextInt();
			if (choice >4 || choice < 1)
			{
				continue;
			}
			
		}
		
	}
}
