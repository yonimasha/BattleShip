/** Class UserBoard is a Board. Takes in file name
    and passes it to Board class. Contains methods
    that makes computer make moves against the user
    board randomly. 
*/


import java.util.Random;
import java.util.ArrayList;

public class UserBoard extends Board
{
   ArrayList<Move> moves;
   Random rand;
 
   /** Constructor user board takes a file name,
       passes it to the Board constructor and 
       initializes the possible moves for the computer 
       @param f, file name
   */
   public UserBoard(String f)
   {  
      super(f);
      Move m;
      moves = new ArrayList<>();
      for(int r = 0; r < 10; r++)
      {
         for(int c = 0; c < 10; c++)
         {
            m = new Move(r,c);
            moves.add(m);
         }  
      }

      rand = new Random();
   }
   
   /** method makeComputerMove has the computer
       making a random move to the user board
       using a list of all possible moves. Removes
       that move once it has been used.
       @return String[], an array of 2 strings, first index being move and second null or "sunk" message 
   */
   public String[] makeComputerMove()
   {
      String[] s = new String[2];
      int random = rand.nextInt(moves.size());
      Move mo = moves.get(random);
      moves.remove(random);

      super.applyMoveToLayout(mo);
      
      s[0] = mo.toString();
      
      if(super.getLayout().get(mo.row()).get(mo.col()).equals(CellStatus.AIRCRAFT_CARRIER))
      {
         if(super.getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER) == true)
            s[1] = "You sunk my Aircraft Carrier!";
            return s;
      }
      else if(super.getLayout().get(mo.row()).get(mo.col()).equals(CellStatus.CRUISER))
      {
         if(super.getFleet().updateFleet(ShipType.ST_CRUISER) == true)
            s[1] = "You sunk my Cruiser!";
            return s;
      }
      else if(super.getLayout().get(mo.row()).get(mo.col()).equals(CellStatus.SUB))
      {
         if(super.getFleet().updateFleet(ShipType.ST_SUB) == true)
            s[1] = "You sunk my Sub!";
            return s;
      }
      else if(super.getLayout().get(mo.row()).get(mo.col()).equals(CellStatus.DESTROYER))
      {
         if(super.getFleet().updateFleet(ShipType.ST_DESTROYER) == true)
            s[1] = "You sunk my Destroyer!";
            return s;
      }
      else if(super.getLayout().get(mo.row()).get(mo.col()).equals(CellStatus.BATTLESHIP))
      {
         if(super.getFleet().updateFleet(ShipType.ST_BATTLESHIP) == true)
            s[1] = "You sunk my Battleship!";
            return s;
      }
      
      s[1] = null;
      return s;
      
   }

   /** method toString returns a formatted
       user board
       @return String, formatted string
   */
   @Override
   public String toString()
   {
      String s = "   1  2  3  4  5  6  7  8  9  10\n";
      Move n;
      
      for(int r = 0; r < 10; r++)
      {
         n = new Move(r, 0);
         s += (n.toString().charAt(0) + "  ");
         for(int c = 0; c < 10; c++)
         {
            s += (super.getLayout().get(r).get(c).toString().charAt(1) + "  ");
         }
         s += "\n"; 
      }
      
      return s;
   }
   


}