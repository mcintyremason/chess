// Mason McIntyre
// driver.java
// driver class for chess game

import java.util.*;

class driver
{
   //static int bteamcount = 12, rteamcount = 12;
  public static void main(String[] args)
  {
    board B = new board();
    String state = "play";
    teams team = new teams();
    boolean turn = false;
    piece p;

    team.buildteam("black");
    team.buildteam("white");
    
    //team.dumpteam(true);
    //team.dumpteam(false);

    B.fillboard(team);
    B.drawboard();

    while(state != "end")
      {
	if(turn == false)
          System.out.println("white's TURN");
        else
          System.out.println("BLACK'S TURN");

	p = team.select(turn);

	switch(p.type)
	  {
	  case "pawn":
	    p = (pawn)p;
	    break;

	  case "rook":
	    p = (rook)p;
	    break;

	  case "knight":
	    p = (knight)p;
	    break;

	  case "bishop":
	    p = (bishop)p;
	    break;

	  case "queen":
	    p = (queen)p;
	    break;

	  case "king":
	    p = (king)p;
	    break;

	  default:
	    break;
	  }
	if(p.move(B))
	  {
	    B.drawboard();
	    turn = !turn;
	  }
        
      }
    
  }
}