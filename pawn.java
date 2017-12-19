/* Mason McIntyre */
/* pawn.java */

import java.util.*;

public class pawn extends piece
{
  boolean hasmoved;

  public pawn(String n)
  {
    name = n;
    type = "pawn";
    hasmoved = false;
  }

  boolean move(board B)
  {
 
    legalmove = false;
    sc = new Scanner(System.in);
    tocheckrow = new HashMap<Integer, piece>();
    tocheck = new piece();
    
    System.out.println("Select a coordinate to move your piece:");

    input = sc.next();

    if(input.length() == 2)
      {
	pickx = (int)input.charAt(0) - 97; /* - a */
	picky = (int)input.charAt(1) - 48; /* - 0 */
      }
    if(pickx < 0 || pickx > 7 || picky < 0 || picky > 7)
      {
        System.out.println("\nCoordinates are off the board.\n");
        return false;
      }


    row = B.Grid().get(y);
    if(B.Grid().get(picky) != null)
      tocheckrow = B.Grid().get(picky);
      
    if(tocheckrow.get(pickx) != null)
       tocheck = tocheckrow.get(pickx);
    
    if(team == "white") /* white team */
      {
	diffy = picky - y;
	if(diffy == -2 && x == pickx && tocheck.team == "unknown" && hasmoved == false)
	  {
	    row.put(x, null);
	    B.Grid().put(y, row);
	    row = B.Grid().get(picky);
	    y = picky;
	    x = pickx;
	    row.put(pickx, (piece)this);
	    B.Grid().put(picky, row);
	    legalmove = true;
	    hasmoved = true;
	  }
	else if(diffy == -1 && x == pickx && tocheck.team == "unknown")
	  {
	    row.put(x, null);
	    B.Grid().put(y, row);
	    row = B.Grid().get(picky);
	    y = picky;
	    x = pickx;
	    row.put(pickx, (piece)this);
	    B.Grid().put(picky, row);
	    legalmove = true;
	    hasmoved = true;
	  }
	else if(diffy == -1 && pickx == x+1 && tocheck.team == "black")
	  {
	    tocheck.alive = false;
	    row.put(x, null);
	    B.Grid().put(y, row);
	    row = B.Grid().get(picky);
	    y = picky;
	    x = pickx;
	    row.put(pickx, (piece)this);
	    B.Grid().put(picky, row);
	    legalmove = true;
	    hasmoved = true;
	  }
	else if(diffy == -1 && pickx == x-1 && tocheck.team == "black")
	  {
	    tocheck.alive = false;
	    row.put(x, null);
	    B.Grid().put(y, row);
	    row = B.Grid().get(picky);
	    y = picky;
	    x = pickx;
	    row.put(pickx, (piece)this);
	    B.Grid().put(picky, row);
	    legalmove = true;
	    hasmoved = true;
	  }
      }
    else if(team == "black") /* black team */
      {
	diffy = picky - y;
	if(diffy == 2 && x == pickx && tocheck.team == "unknown" && hasmoved == false)
	  {
	    row.put(x, null);
	    B.Grid().put(y, row);
	    row = B.Grid().get(picky);
	    y = picky;
	    x = pickx;
	    row.put(pickx, (piece)this);
	    B.Grid().put(picky, row);
	    legalmove = true;
	    hasmoved = true;
	  }

	else if(diffy == 1 && x == pickx && tocheck.team == "unknown")
	  {
	    row.put(x, null);
	    B.Grid().put(y, row);
	    row = B.Grid().get(picky);
	    y = picky;
	    x = pickx;
	    row.put(pickx, (piece)this);
	    B.Grid().put(picky, row);
	    legalmove = true;
	    hasmoved = true;
	  }
	else if(diffy == 1 && pickx == x+1 && tocheck.team == "white")
	  {
	    tocheck.alive = false;
	    row.put(x, null);
	    B.Grid().put(y, row);
	    row = B.Grid().get(picky);
	    y = picky;
	    x = pickx;
	    row.put(pickx, (piece)this);
	    B.Grid().put(picky, row);
	    legalmove = true;
	    hasmoved = true;
	  }
	else if(diffy == 1 && pickx == x-1 && tocheck.team == "white")
	  {
	    tocheck.alive = false;
	    row.put(x, null);
	    B.Grid().put(y, row);
	    row = B.Grid().get(picky);
	    y = picky;
	    x = pickx;
	    row.put(pickx, (piece)this);
	    B.Grid().put(picky, row);
	    legalmove = true;
	    hasmoved = true;
	  }
      }
    
    if(legalmove == false)
      System.out.println("\nInvalid Placement\n");
    
    diffx = 0;
    diffy = 0;

    return legalmove;
  }
}