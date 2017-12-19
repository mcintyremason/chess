/* Mason McIntyre */
/* bishop.java */

import java.util.*;

public class bishop extends piece
{
  public bishop(String n)
  {
    name = n;
    type = "bishop";
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

    
    diffy = y - picky;
    diffx = pickx - x;

    if(diffx > 0 && diffy > 0)
      {
	for(int i = y-1, j = x+1 ; i > picky; i--, j++)
	  {
	    if(B.Grid().get(i) != null)
	      tocheckrow = B.Grid().get(i);
	    if(tocheckrow.get(j) != null)
	      tocheck = tocheckrow.get(j);
	    legalmove = true;
	    if(tocheck.team != "unknown")
	      {
		legalmove = false;
		blocked = true;
		blockx = tocheck.x + 97; /* + 'a' */
		blocky = tocheck.y;
	      }
	  }
      }
    else if(diffx < 0 && diffy > 0)
      {
	for(int i = y+1, j = x-1; i < picky; i++, j--)
	  {
	    if(B.Grid().get(i) != null)
	      tocheckrow = B.Grid().get(i);
	    if(tocheckrow.get(j) != null)
	      tocheck = tocheckrow.get(j);
	    legalmove = true;
	    if(tocheck.team != "unknown")
	      {
		legalmove = false;
		blocked = true;
		blockx = tocheck.x + 97; /* + 'a' */
		blocky = tocheck.y;
	      }
	  }
      }
    else if(diffx > 0 && diffy < 0)
      {
	for(int i = y+1, j = x+1; i < pickx; i++, j++)
	  {
	    if(B.Grid().get(i) != null)
	      tocheckrow = B.Grid().get(i);
	    if(tocheckrow.get(j) != null)
	      tocheck = tocheckrow.get(j);
	    legalmove = true;
	    if(tocheck.team != "unknown")
	      {
		legalmove = false;
		blocked = true;
		blockx = i + 97; /* + 'a' */
		blocky = tocheck.y;
	      }
	  }
      }
    else if(diffx < 0 && diffy < 0)
      {
	for(int i = y-1, j = x-1; i < pickx; i--, j--)
	  {
	    if(B.Grid().get(i) != null)
	      tocheckrow = B.Grid().get(i);
	    if(tocheckrow.get(j) != null)
	      tocheck = tocheckrow.get(j);
	    legalmove = true;
	    if(tocheck.team != "unknown")
	      {
		legalmove = false;
		blocked = true;
		blockx = i + 97; /* + 'a' */
		blocky = tocheck.y;
	      }
	  }
      }

    if(B.Grid().get(picky) != null)
      tocheckrow = B.Grid().get(picky);
    if(tocheckrow.get(pickx) != null)
      tocheck = tocheckrow.get(pickx);
	
    if(blocked == false && tocheck.team != team && legalmove == true)
      {
	if(team == "white" && tocheck.team == "black") /* white team */
	  tocheck.alive = false; 
	else if(team == "black" && tocheck.team == "white") /* black team */
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
      

    if(legalmove == false)
      System.out.println("\nInvalid Placement\n");
    if(blocked == true)
      System.out.println("You're movement is blocked at point ("+(char)blockx+","+blocky+")\n");

    diffx = 0;
    diffy = 0;

    return legalmove;
  }

}