// create a game board to place pieces onto
// Developed by Mason McIntyre

import java.util.*;

class board
{
  static Map<Integer, Map<Integer, piece>> grid;
  
  public board()
  {
    grid = new HashMap<Integer, Map<Integer, piece>>();
    
  }

  public Map<Integer, Map<Integer, piece>> Grid()
  {
    return grid;
  }

  static void fillboard(teams team)
  {
    Map<Integer, piece> row;
    int bcount = 0, rcount = 0;
    piece temp;
    int column = 0;

    for(int i = 0; i < 8; i++)
      {
	row = new HashMap<Integer, piece>();
	if(i == 0) //place back row of black
	  {
	    // initially place rooks, knights, bishops, queen, king

	    //left rook
	    bcount = 8; // pawns are 0-7
	    temp = (piece)team.bteam.get(bcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);
	    
	    //right rook
	    bcount++;
	    column = 7;
	    temp = (piece)team.bteam.get(bcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);

	    //left knight
	    bcount++;
	    column = 1;
	    temp = (piece)team.bteam.get(bcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);

	    //right knight
	    bcount++;
	    column = 6;
	    temp = (piece)team.bteam.get(bcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);

	    //left bishop
	    bcount++;
	    column = 2;
	    temp = (piece)team.bteam.get(bcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);
	    
	    //right bishop
	    bcount++;
	    column = 5;
	    temp = (piece)team.bteam.get(bcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);

	    //queen
	    bcount++;
	    column = 3;
	    temp = (piece)team.bteam.get(bcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);
	    
	    //king
	    bcount++;
	    column = 4;
	    temp = (piece)team.bteam.get(bcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);
	  }
	
	else if(i == 1)
	  {
	    for(int j = 0; j < 8; j++)
	      {
		temp = (piece)team.bteam.get(j);
		temp.x = j;
		temp.y = i;
		row.put(j, temp);
	      }
	  }
	
	else if(i == 6)
	  {
	    for(int j = 0; j < 8; j++)
	      {
		temp = (piece)team.rteam.get(j);
		temp.x = j;
		temp.y = i;
		row.put(j, temp);
	      }
	  }
	
	else if(i == 7) //place back row of red
	  {
	    //place rooks, knights, bishops, queen, king

	    //left rook
	    column = 0;
	    rcount = 8; // pawns are 0-7
	    temp = (piece)team.rteam.get(rcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);
	    
	    //right rook
	    rcount++;
	    column = 7;
	    temp = (piece)team.rteam.get(rcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);

	    //left knight
	    rcount++;
	    column = 1;
	    temp = (piece)team.rteam.get(rcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);

	    //right knight
	    rcount++;
	    column = 6;
	    temp = (piece)team.rteam.get(rcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);

	    //left bishop
	    rcount++;
	    column = 2;
	    temp = (piece)team.rteam.get(rcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);
	    
	    //right bishop
	    rcount++;
	    column = 5;
	    temp = (piece)team.rteam.get(rcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);

	    //queen
	    rcount++;
	    column = 3;
	    temp = (piece)team.rteam.get(rcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);
	    
	    //king
	    rcount++;
	    column = 4;
	    temp = (piece)team.rteam.get(rcount);
	    temp.x = column;
	    temp.y = i;
	    row.put(column, temp);
	  }
	
	grid.put(i, row);
      }
  }

  public void drawboard()
  {
    Map<Integer, Map<Integer, piece>> Grid = Grid();
    Map<Integer, piece> row;
    piece temp = null;

    System.out.println("      a    b    c    d    e    f    g    h  \n");

    for(int i = 0; i < 8; i++)
      {
	row = Grid.get(i);
	System.out.print(i+"  ");
	for(int j = 0; j < 8; j++)
	  { 
	    
	    if(row.get(j) != null)
	      {
		  System.out.print("| "+row.get(j).name+" ");
	      }
	    else
	      System.out.print("|    ");
	  }
	System.out.print("|\n");
	System.out.println("   |----|----|----|----|----|----|----|----|");
      }
  }

}