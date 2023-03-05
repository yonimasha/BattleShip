/**
   Game class
*/

public class Game
{

   ComputerBoard computer;
   UserBoard player;

   public Game()
   {
      computer = new ComputerBoard("compFleet.txt");
      player = new UserBoard("userFleet.txt");
   
   }
   
   public String[] makeComputerMove()
   {
      String[] s = new String[2];
      s = player.makeComputerMove();
      return s;
   }
   
   public String makePlayerMove(String s)
   {
      String string;
      Move m = new Move(s);
      string = computer.makePlayerMove(m);
      return string;
   }
   
   public boolean computerDefeated()
   {
      if(computer.gameOver() == true)
         return true;
      return false;
   }
   
   public boolean userDefeated()
   {
      if(player.gameOver() == true)
         return true;
      return false;
   }
   
   @Override
   public String toString()
   {  
      return String.format("Computer Board:\n%s\n\nPlayer Board:\n%s", computer.toString(),
                              player.toString());  
   }

}