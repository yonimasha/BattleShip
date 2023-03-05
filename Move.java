/** Move class, a class that takes a row and a column from the user or computer
    and sets it to one Move object. Works with both numbers(row and column) and
    standard battleship moves (Ex. E1 or B2). 
*/


public class Move
{
   // instance variables
   private int row;
   private int col;
   
   /** First Move constructor takes in two
       ints representing a row and a column
       @param r, row
       @param c, column
   
   */
   public Move(int r, int c)
   {  
      row = r;
      col = c;
   }
   
   /** Second Move contructor takes in a string
       representing a move based on standard 
       battleship rules(Ex. E1)
       @param s, Move in string format
   
   */
   public Move(String s)
   {
      // Check to see which row the move is in
      if(s.substring(0,1).equals("A"))
      {
         row = 0;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      if(s.substring(0,1).equals("B"))
      {
         row = 1;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      if(s.substring(0,1).equals("C"))
      {
         row = 2;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      if(s.substring(0,1).equals("D"))
      {
         row = 3;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      if(s.substring(0,1).equals("E"))
      {
         row = 4;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      if(s.substring(0,1).equals("F"))
      {
         row = 5;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      if(s.substring(0,1).equals("G"))
      {
         row = 6;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      if(s.substring(0,1).equals("H"))
      {
         row = 7;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      if(s.substring(0,1).equals("I"))
      {
         row = 8;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      if(s.substring(0,1).equals("J"))
      {
         row = 9;
         col = Integer.parseInt(s.substring(1, s.length())) - 1;
      }
      
   }
   
   /** method row() returns 
       the row of the move
       @return row   
   */
   public int row()
   {
      return row;
   }
   
   /** method col() returns
       column of the move
       @return column
   */
   public int col()
   {
      return col;
   }
   
   /** method toString() returns a
       move in the appropriate battleship
       form
       @return formatted String   
   */
   
   @Override
   public String toString()
   {
      if(row == 1)
         return String.format("B%d", col+1);
      else if(row == 2)
         return String.format("C%d", col+1);
      else if(row == 3)
         return String.format("D%d", col+1);
      else if(row == 4)
         return String.format("E%d", col+1);
      else if(row == 5)
         return String.format("F%d", col+1);
      else if(row == 6)
         return String.format("G%d", col+1);
      else if(row == 7)
         return String.format("H%d", col+1);
      else if(row == 8)
         return String.format("I%d", col+1);
      else if(row == 9)
         return String.format("J%d", col+1);
         
      return String.format("A%d", col + 1);

   }






}