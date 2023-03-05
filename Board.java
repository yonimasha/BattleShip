/** Board class initializes the game board.
    Takes in a file and places ships on layout.
    Class applies moves as well as makes
    sure those moves are available. 
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Board
{
   
   private ArrayList<ArrayList<CellStatus>> layout;
   private Fleet fleet;
   private static final int SIZE = 10;

   /** Constructor Board takes in a file name
       containing all the locations of the ships
       and puts each ship into the layout
       @param fileName, name of file 
   */
   public Board(String fileName)
   {
      Move s;
      Move f;
      String nextLine;
      fleet = new Fleet(); //declare fleet
      
      layout = new ArrayList<>(SIZE);
     
      //set every cell on layout to nothing
      for(int i = 1; i <= SIZE; i++)
      {
         ArrayList<CellStatus> row = new ArrayList<CellStatus>(SIZE);
         for(int j = 1; j <= SIZE; j++)
         {
            row.add(CellStatus.NOTHING);
         }
         layout.add(row);
      }
      
      //set ships between indicated cells in file
      try
      {
         Scanner infile = new Scanner(new File(fileName));
         while(infile.hasNext())
         {
            nextLine = infile.nextLine();
            
            if(nextLine.substring(0,1).equals("A"))
            {
               try
               {
                  s = new Move(nextLine.substring(2,5));
                  f = new Move(nextLine.substring(6,nextLine.length()));
               }
               catch(NumberFormatException nfe)
               {
                  s = new Move(nextLine.substring(2,4));
                  f = new Move(nextLine.substring(5,nextLine.length()));

               }
               if(s.row() == f.row())
               {
                  for(int c = s.col(); c <= f.col(); c++)
                  {
                     layout.get(s.row()).set(c, CellStatus.AIRCRAFT_CARRIER);
                  }
               }
               else
               {
                  for(int r = s.row(); r <= f.row(); r++)
                  {
                     layout.get(r).set(s.col(), CellStatus.AIRCRAFT_CARRIER);
                  }
               }
            }
            else if(nextLine.substring(0,1).equals("C")) 
            {
               try
               {
                  s = new Move(nextLine.substring(2,5));
                  f = new Move(nextLine.substring(6,nextLine.length()));
               }
               catch(NumberFormatException nfe)
               {
                  s = new Move(nextLine.substring(2,4));
                  f = new Move(nextLine.substring(5,nextLine.length()));

               }
               if(s.row() == f.row())
               {
                  for(int c = s.col(); c <= f.col(); c++)
                  {
                     layout.get(s.row()).set(c, CellStatus.CRUISER);
                  }
               }
               else
               {
                  for(int r = s.row(); r <= f.row(); r++)
                  {
                     layout.get(r).set(s.col(), CellStatus.CRUISER);
                  }
               }
            }
            else if(nextLine.substring(0,1).equals("D")) 
            {
               try
               {
                  s = new Move(nextLine.substring(2,5));
                  f = new Move(nextLine.substring(6,nextLine.length()-1));
               }
               catch(NumberFormatException e)
               {
                  s = new Move(nextLine.substring(2,4));
                  f = new Move(nextLine.substring(5,nextLine.length()));

               }
               if(s.row() == f.row())
               {
                  for(int c = s.col(); c <= f.col(); c++)
                  {
                     layout.get(s.row()).set(c, CellStatus.DESTROYER);
                  }
               }
               else
               {
                  for(int r = s.row(); r <= f.row(); r++)
                  {
                     layout.get(r).set(s.col(), CellStatus.DESTROYER);
                  }
               }
            }
            else if(nextLine.substring(0,1).equals("S")) 
            {
               try
               {
                  s = new Move(nextLine.substring(2,5));
                  f = new Move(nextLine.substring(6,nextLine.length()));
               }
               catch(NumberFormatException nfe)
               {
                  s = new Move(nextLine.substring(2,4));
                  f = new Move(nextLine.substring(5,nextLine.length()));

               }
               if(s.row() == f.row())
               {
                  for(int c = s.col(); c <= f.col(); c++)
                  {
                     layout.get(s.row()).set(c, CellStatus.SUB);
                  }
               }
               else
               {
                  for(int r = s.row(); r <= f.row(); r++)
                  {
                     layout.get(r).set(s.col(), CellStatus.SUB);
                  }
               }
            }
            else if(nextLine.substring(0,1).equals("B")) 
            {
               try
               {
                  s = new Move(nextLine.substring(2,5));
                  f = new Move(nextLine.substring(6,nextLine.length()));
               }
               catch(NumberFormatException nfe)
               {
                  s = new Move(nextLine.substring(2,4));
                  f = new Move(nextLine.substring(5,nextLine.length()));

               }
               if(s.row() == f.row())
               {
                  for(int c = s.col(); c <= f.col(); c++)
                  {
                     layout.get(s.row()).set(c, CellStatus.BATTLESHIP);
                  }
               }
               else
               {
                  for(int r = s.row(); r <= f.row(); r++)
                  {
                     layout.get(r).set(s.col(), CellStatus.BATTLESHIP);
                  }
               }
            }
         }
         
         
      }
      catch(IOException e)
      {  
         System.exit(1);
      }  
       
   }
   
   /** Method applyMoveToLayout takes in a move
       and applies it to a cell. Checks what type of
       ship is at that cell, sets it to the _HIT
       version of that ship, and returns the original
       status of that cell.
       @param m, Move object
       @return CellStatus
   */
   public CellStatus applyMoveToLayout(Move m)
   {
      if(layout.get(m.row()).get(m.col()).equals(CellStatus.AIRCRAFT_CARRIER))
      {
         layout.get(m.row()).set(m.col(), CellStatus.AIRCRAFT_CARRIER_HIT);
         return CellStatus.AIRCRAFT_CARRIER;
      }
      else if(layout.get(m.row()).get(m.col()).equals(CellStatus.CRUISER))
      {
         layout.get(m.row()).set(m.col(), CellStatus.CRUISER_HIT);
         return CellStatus.CRUISER;
      }
      else if(layout.get(m.row()).get(m.col()).equals(CellStatus.SUB))
      {
         layout.get(m.row()).set(m.col(), CellStatus.SUB_HIT);
         return CellStatus.SUB;
      }
      else if(layout.get(m.row()).get(m.col()).equals(CellStatus.DESTROYER))
      {
         layout.get(m.row()).set(m.col(), CellStatus.DESTROYER_HIT);
         return CellStatus.DESTROYER;
      }
      else if(layout.get(m.row()).get(m.col()).equals(CellStatus.BATTLESHIP))
      {
         layout.get(m.row()).set(m.col(), CellStatus.BATTLESHIP_HIT);
         return CellStatus.BATTLESHIP;
      }
      
      layout.get(m.row()).set(m.col(), CellStatus.NOTHING_HIT);
      return CellStatus.NOTHING_HIT;
   }
   
   /** Method moveAvailable takes a move
       and verifies whether that move
       can be performed or not
       @param m, Move object
       @return boolean
   */
   public boolean moveAvailable(Move m)
   {
      if(layout.get(m.row()).get(m.col()).equals(CellStatus.NOTHING) || layout.get(m.row()).get(m.col()).equals(CellStatus.AIRCRAFT_CARRIER)
         || layout.get(m.row()).get(m.col()).equals(CellStatus.CRUISER) || layout.get(m.row()).get(m.col()).equals(CellStatus.SUB) ||
         layout.get(m.row()).get(m.col()).equals(CellStatus.DESTROYER) || layout.get(m.row()).get(m.col()).equals(CellStatus.BATTLESHIP))
         return true;
      
      return false;
   }

   /** Method getLayout returns layout
       @return layout
   */
   public ArrayList<ArrayList<CellStatus>> getLayout()
   {
      return layout;
   }
   
   /** Method getFleet returns fleet
       @return fleet
   */
   public Fleet getFleet()
   {
      return fleet;
   }
   
   /** method gameOver returns a boolean
       indicating whether the game
       has ended or not
       @return boolean
   */
   public boolean gameOver()
   {
      return fleet.gameOver();
   }
   
   
}