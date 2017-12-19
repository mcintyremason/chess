// Pieces to be mapped to the board
// in this case checkers
// Developed by Mason McIntyre

import java.util.*;

class piece extends Object
{
  String name, type, team; //false == white : true == black
  boolean alive, legalmove, blocked; 
  int x, y;
  Map<Integer, piece> row, tocheckrow;
  Scanner sc;
  String input;
  int pickx;
  int picky;
  int diffx, diffy; //difference in y values of chosen placement and positioning of selected piece                                                                                      
  piece tocheck;

  public piece()
  {
    team = "unknown";
    name = "unkouwn";
    alive = true;
    type = "unknown";
  }

  public piece(String n)
  {
    team = "unknown";
    name = n;
    alive = true;
    type = "unknown";
  }
  
  boolean move(board B)
  {
    return legalmove;
  }
}