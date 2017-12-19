// teams.java
// make team of pieces
// Mason McIntyre

import java.util.*;

class teams extends piece
{
  static ArrayList<piece> bteam;
  static ArrayList<piece> rteam;
  
  public teams()
  {
    bteam = new ArrayList<piece>(16);
    rteam = new ArrayList<piece>(16);
  }

  public teams(int size)
  {
    bteam = new ArrayList<piece>(size);
    rteam = new ArrayList<piece>(size);
  }

  static piece select(boolean turn)
  {
    piece temp = null;
    System.out.println("Select a piece to move:");
    Scanner sc = new Scanner(System.in);
    String input = sc.next(); 
    
    if(turn == false) //white team     
      {
        for(int i = 0; i < 16; i++)
          {
            temp = rteam.get(i);
	                
	    if(input.compareTo(temp.name) == 0)
	      {
		System.out.println("You've selected to move piece: "+temp.name+"\n");
		break;
	      }
	    else if(i == 15)
	      {
		System.out.println("Invalid Selection");
		temp = select(turn);
	      }
	  }
	if(temp.alive == false)
	  {
	    System.out.println("That piece no longer exits!\n");
	    temp = select(turn);
	  }
      }

    if(turn == true) // black's turn
      {
        for(int i = 0; i < 16; i++)
          {
            temp = bteam.get(i);
	    
	    if(input.compareTo(temp.name) == 0)
	      {
		System.out.println("You've selected to move piece: "+temp.name+"\n");
		break;
	      }
	    else if(i == 15)
	      {
		System.out.println("Invalid Selection");
		temp = select(turn);
	      }
	  }
      }
    if(temp.alive == false)
      {
	System.out.println("That piece no longer exits!\n");
	temp = select(turn);
      }    
  
    return temp;
  }

  
  public void buildteam(String teamname)
  {
    makepawns(teamname);
    makerooks(teamname);
    makeknights(teamname);
    makebishops(teamname);
    makequeen(teamname);
    makeking(teamname);
  }

  public void makepawns(String teamname)
  {
    String name;
    pawn p;

    for(int i = 0; i < 8; i++)
      {
	if(teamname == "black")
	  {
	    name = String.format("P%d", i);
	    p = new pawn(name);
	    p.team = teamname;
	    bteam.add((piece)p);
	  }
	else
	  {
	    name = String.format("p%d", i);
	    p = new pawn(name);
	    p.team = teamname;
	    rteam.add((piece)p);
	  }
      }
  }

  public void makerooks(String teamname)
  {
    String name;
    rook p;

    for(int i = 0; i < 2; i++)
      {
	if(teamname == "black")
	  {
	    name = String.format("R%d", i);
	    p = new rook(name);
	    p.team = teamname;
	    bteam.add((piece)p);
	  }
	else
	  {
	    name = String.format("r%d", i);
	    p = new rook(name);
	    p.team = teamname;
	    rteam.add((piece)p);
	  }
      }
  }

  public void makeknights(String teamname)
  {
    String name;
    knight p;

    for(int i = 0; i < 2; i++)
      {
	if(teamname == "black")
	  {
	    name = String.format("K%d", i);
	    p = new knight(name);
	    p.team = teamname;
	    bteam.add((piece)p);
	  }
	else
	  {
	    name = String.format("k%d", i);
	    p = new knight(name);
	    p.team = teamname;
	    rteam.add((piece)p);
	  }
      }
  }

  public void makebishops(String teamname)
  {
    String name;
    bishop p;

    for(int i = 0; i < 2; i++)
      {
	if(teamname == "black")
	  {
	    name = String.format("B%d", i);
	    p = new bishop(name);
	    p.team = teamname;
	    bteam.add((piece)p);
	  }
	else
	  {
	    name = String.format("b%d", i);
	    p = new bishop(name);
	    p.team = teamname;
	    rteam.add((piece)p);
	  }
      }
  }

  public void makequeen(String teamname)
  {
    String name;
    queen p;

    if(teamname == "black")
      {
	name = "Qu";
	p = new queen(name);
	p.team = teamname;
	bteam.add((piece)p);
      }
    else
      {
	name = "qu";
	p = new queen(name);
	p.team = teamname;
	rteam.add((piece)p);
      }
  }

  public void makeking(String teamname)
  {
    String name;
    king p;

    
    if(teamname == "black")
      {
	name = "Ki";
	p = new king(name);
	p.team = teamname;
	bteam.add((piece)p);
      }
    else
      {
	name = "ki";
	p = new king(name);
	p.team = teamname;
	rteam.add((piece)p);
      }
  }

  public void remove(piece value) //Gives Error
  {
    if(value.team == "black")
      bteam.remove(value);
    if(value.team == "white")
      rteam.remove(value);
  }

  public void dumpteam(String teamname)
  {
    piece temp;

    if(teamname == "black")
      {
	for(int i = 0; i < 16; i++)
	  {
	    temp = (piece)bteam.get(i);
	    System.out.print(temp.name+" ");
	  }
	System.out.println();
      }

    if(teamname == "white")
      {
	for(int i = 0; i < 16; i++)
	  {
	    temp = (piece)rteam.get(i);
	    System.out.print(temp.name+" ");
	  }
	System.out.println();
      }
  }

  void act()
  {
    
  }
}
