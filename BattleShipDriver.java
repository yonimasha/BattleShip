/** BattleShipDriver combines everything from all classes
    to run a full game of Battleship. Decides who goes first
    and loops program until the player of computer loses and
    displays a message
*/

import java.util.Random;
import java.util.Scanner;

public class BattleShipDriver
{
   public static void main(String[] args)
   {
      //declare game
      Game battleShip = new Game();
      
      // declare variables
      Random r = new Random();
      int choice = r.nextInt(2);
      String[] compChoice;
      String userChoice;
      boolean validation = true;

      //declare scanners and move objects
      Scanner in = new Scanner(System.in);
      String move;
      Move m;
      
      //check to see who goes first
      System.out.println("Welcome to Battleship!\n");
      if(choice == 0)
      {
         System.out.println("The computer has won the coin toss and gets to go first.");
         System.out.println();
      }
      else
      {
         System.out.println("The player has won the coin toss and gets to go first.");
         System.out.println();
      }
      // loop game until one of the two loses
      while(battleShip.computerDefeated() == false && battleShip.userDefeated() == false)
      {
         validation = true;
         //computer code
         if(choice == 0)
         {
            System.out.println("Computer's turn. Press any key to continue:");
            in.nextLine();
            compChoice = battleShip.makeComputerMove();
            System.out.printf("Computer chose: %s\n\n", compChoice[0]);
            if(compChoice[1] == null)//check to see if ship is sunk
            {
               System.out.println(battleShip.toString());
               choice = 1;
            }
            else
            {
               System.out.println(battleShip.makeComputerMove()[0]);
               System.out.println(battleShip.toString());
               choice = 1;
            }   
            
         }
         //player code
         else
         {
            m = null;
            System.out.print("Your turn: ");

            //input validation
            while(validation)
            {
               try
               {  
                  
                  move = in.nextLine().toUpperCase();
                  System.out.println();
                  
                  while(move.length() < 2 || move.length() > 3)
                  {
                     System.out.print("Please enter a valid move: ");
                     move = in.nextLine().toUpperCase();
                     System.out.println();
                  } 

                  m = new Move(move);
                  
            
                  while(!battleShip.computer.moveAvailable(m))
                  {
                      System.out.print("Location not available, try again: ");
                      move = in.nextLine().toUpperCase();
                      System.out.println();
                      m = new Move(move);
                  }
              
                  userChoice = battleShip.makePlayerMove(move);
                  if(userChoice == null)
                  {
                      System.out.println(battleShip.toString());
                      choice = 0;
                  }
                  else
                  {
                      System.out.println(userChoice);
                      System.out.println(battleShip.toString());
                      choice = 0;
                  }  
                  validation = false;
               }
               catch(Exception e)
               {
                  System.out.print("Please enter a valid move: ");
            
               }
            }
            
         }
      }
      
      //display final message
      if(battleShip.computerDefeated() == true)
         System.out.print("Congratulations! You beat the computer!");
      else
         System.out.print("The computer beat you! Better luck next time");
   }
}