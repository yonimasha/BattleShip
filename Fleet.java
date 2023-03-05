/** Fleet class has a relationship with the Board class. It initializes
    the ship fields and updates the game accordingly. If every ship has
    been sunk the Fleet class indicates that.
*/

public class Fleet
{
   // instance variables
   Ship battleShip;
   Ship aircraftCarrier;
   Ship cruiser;
   Ship sub;
   Ship destroyer;
   
   /** Fleet's only constructor initializes each ship
       according to its type.
   */
   public Fleet()
   {
      battleShip = new Battleship();
      aircraftCarrier = new AircraftCarrier();
      cruiser = new Cruiser();
      sub = new Submarine();
      destroyer = new Destroyer();
   }
   
   /** Method updateFleet takes in a ShipType
       and indicates that the ship has been hit.
       Returns true or false depending on if
       the ship has been sunk or not
       @param s, Ship type
       @return boolean
   */
   public boolean updateFleet(ShipType s)
   {
      if(s.equals(ShipType.ST_BATTLESHIP))
      {  
         battleShip.hit();
         if(battleShip.getSunk() == true)
            return true;
      }
      if(s.equals(ShipType.ST_AIRCRAFT_CARRIER))
      {  
         aircraftCarrier.hit();
         if(aircraftCarrier.getSunk() == true)
            return true;
      }
      if(s.equals(ShipType.ST_CRUISER))
      {  
         cruiser.hit();
         if(cruiser.getSunk() == true)
            return true;
      }
      if(s.equals(ShipType.ST_SUB))
      {  
         sub.hit();
         if(sub.getSunk() == true)
            return true;
      }
      if(s.equals(ShipType.ST_DESTROYER))
      {  
         destroyer.hit();
         if(destroyer.getSunk() == true)
            return true;
      }
      
      return false;
   }
   
   /** Method gameOver() returns a boolean
       indicating if the game has ended yet
       @return boolean
   
   */
   public boolean gameOver()
   {
      if(battleShip.getSunk() == true && aircraftCarrier.getSunk() == true && cruiser.getSunk() == true && sub.getSunk() == true
         && destroyer.getSunk() == true)
      {
         return true;
      }
      
      return false;
   }


}