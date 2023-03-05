/** Class ComputerBoard is a Board. Takes in a
    fileName and passes it to Board class. Has multiple methods
    to make moves against the computer board and print the board
*/

public class ComputerBoard extends Board
{
 
   /** Constructor ComputerBoard takes
       in a fileName and passes it to the
       Board class
   */
   public ComputerBoard(String fileName)
   {
      super(fileName);     
   }

   /** Method makePlayerMove takes in a 
       move and returns a String if the
       ship was sunk or not
       @param m, Move object
       @return formatted string
   */
   public String makePlayerMove(Move m)
   {
      
      super.applyMoveToLayout(m); //apply move
      boolean b; //declare variable to make some code more readable
      
      //check which ship was hit and changes the board. Returns a String if the ship was sunk
      if(super.getLayout().get(m.row()).get(m.col()).equals(CellStatus.AIRCRAFT_CARRIER_HIT))
      {
         b = super.getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER);
         if(b == true) 
         {
            // change _HIT values to _SUNK values
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 10; c++)
               {
                  if(getLayout().get(r).get(c).equals(CellStatus.AIRCRAFT_CARRIER_HIT))
                     getLayout().get(r).set(c, CellStatus.AIRCRAFT_CARRIER_SUNK);
               }
            }
            
            return String.format("You sunk my Aircraft Carrier!"); 
         }      
      }
      else if(super.getLayout().get(m.row()).get(m.col()).equals(CellStatus.CRUISER_HIT))
      {
         b = super.getFleet().updateFleet(ShipType.ST_CRUISER);
         if(b == true) 
         {
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 10; c++)
               {
                  if(getLayout().get(r).get(c).equals(CellStatus.CRUISER_HIT))
                     getLayout().get(r).set(c, CellStatus.CRUISER_SUNK);
               }
            }
            
            return String.format("You sunk my Cruiser!");   
         }
      }
      else if(super.getLayout().get(m.row()).get(m.col()).equals(CellStatus.DESTROYER_HIT))
      {
         b = super.getFleet().updateFleet(ShipType.ST_DESTROYER);
         if(b == true) 
         {
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 10; c++)
               {
                  if(getLayout().get(r).get(c).equals(CellStatus.DESTROYER_HIT))
                     getLayout().get(r).set(c, CellStatus.DESTROYER_SUNK);
               }
            }
            
            return String.format("You sunk my Destroyer!");  
         } 
      }
      else if(super.getLayout().get(m.row()).get(m.col()).equals(CellStatus.SUB_HIT))
      {
         b = super.getFleet().updateFleet(ShipType.ST_SUB);
         if(b == true) 
         {
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 10; c++)
               {
                  if(getLayout().get(r).get(c).equals(CellStatus.SUB_HIT))
                     getLayout().get(r).set(c, CellStatus.SUB_SUNK);
               }
            }
            
            return String.format("You sunk my Submarine!"); 
         }  
      
      }
      else if(super.getLayout().get(m.row()).get(m.col()).equals(CellStatus.BATTLESHIP_HIT))
      {
         b = super.getFleet().updateFleet(ShipType.ST_BATTLESHIP);
         if(b == true) 
         {
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 10; c++)
               {
                  if(getLayout().get(r).get(c).equals(CellStatus.BATTLESHIP_HIT))
                     getLayout().get(r).set(c, CellStatus.BATTLESHIP_SUNK);
               }
            }
            
            return String.format("You sunk my Battleship!");  
         } 
      }
      
      return null;
   }
   
   /** Method toString returns the computer's
       board
       @return formatted String
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
            s += (super.getLayout().get(r).get(c).toString().charAt(0) + "  ");
         }
         s += "\n"; 
      }
      
      return s;

   
   }


}