/* Mason McIntyre */
/* knight.java */

import java.util.*;

public class knight extends piece
{
  public knight(String n)
  {
    name = n;
    type = "knight";
  }

  boolean move(board B)
  {
    int blockx = 0, blocky = 0;
    sc = new Scanner(System.in);
    legalmove = false;
    tocheckrow = new HashMap<Integer, piece>();
    tocheck = new piece();
    blocked = false;

    System.out.println("Select a coordinate to move your piece:");

    input = sc.next();

    if(input.length() == 2)
      {
        pickx = (int)input.charAt(0) - 97; /* - 'a' */                                                     
	picky = (int)input.charAt(1) - 48; /* - '0' */                                              
      }
    if(pickx < 0 || pickx > 7 || picky < 0 || picky > 7)
      {
        System.out.println("\nCoordinates are off the board.\n");
        return false;
      }

    row = B.Grid().get(y);

    if(team == "white") /* white team */                                                            
      {
        if(pickx == x+2 && picky == y-1)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x+1 && picky == y-2)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x-1 && picky == y-2)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x-2 && picky == y-1)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x+1 && picky == y+2)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x+2 && picky == y+1)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x-1 && picky == y+2)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x-2 && picky == y+1)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }

        if(legalmove == true && tocheck.team != team)
          {
            if(tocheck.team == "black")
              tocheck.alive = false;
            row.put(x, null);
            B.Grid().put(y, row);
            row = B.Grid().get(picky);
            y = picky;
            x = pickx;
            row.put(pickx, (piece)this);
            B.Grid().put(picky, row);
            legalmove = true;
          }

      }
    else if(team == "black") /* black team */
      {
	if(pickx == x+2 && picky == y-1)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x+1 && picky == y-2)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x-1 && picky == y-2)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x-2 && picky == y-1)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x+1 && picky == y+2)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x+2 && picky == y+1)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x-1 && picky == y+2)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }
	else if(pickx == x-2 && picky == y+1)
          {
	    if(B.Grid().get(picky) != null)
	      tocheckrow = B.Grid().get(picky);
	    if(tocheckrow.get(pickx) != null)
	      tocheck = tocheckrow.get(pickx);
	    legalmove = true;
          }

        if(legalmove == true && tocheck.team != team)
          {
            if(tocheck.team == "white")
              tocheck.alive = false;
            row.put(x, null);
            B.Grid().put(y, row);
            row = B.Grid().get(picky);
            y = picky;
            x = pickx;
            row.put(pickx, (piece)this);
            B.Grid().put(picky, row);
            legalmove = true;
          }

      }

    if(legalmove == false)
      System.out.println("\nInvalid Placement\n");
    if(blocked == true)
      System.out.println("You're movement is blocked at point ("+(char)blockx+","+blocky+")\n");

    diffx = 0;
    diffy = 0;

    return legalmove;
  }

}