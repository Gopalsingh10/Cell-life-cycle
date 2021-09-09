package project12;

import java.util.Scanner;

public class Celllifecycle {
	
	 int [][] grid;	//2-d array 
	  int rows;	
	  int columns;
	  public void set(int [][] grid,int ROWS,int COLUMNS)
	  {
	    this.rows=ROWS;
	    this.columns=COLUMNS;
	    this.grid=new int[rows][columns];
	    for(int i=0;i<ROWS;i++)
	      for(int j=0;j<COLUMNS;j++)
	      this.grid[i][j]=grid[i][j];  
	  }
	

	     public void  gameOfLife()	//to check alive and dead cells near a specific sell
	     {
	           for (int i = 0; i < rows; i++)
	          {
	                     for (int j = 0; j < columns; j++)
	                   {
	                      int Cell = grid[i][j];
	                     getcellcount(i,j,Cell);
	                      
	                  }
	            }

	             
	     }
	     
	     public void getcellcount(int i,int j,int Cell) 	//to count alive and dead cells 
	     {
	                int count=0;
	        
	                 if (i-1 >= 0 && grid[i-1][j]==1)
	                   count++; 
	                 
	                 if(i+1 <rows && grid[i+1][j]==1)
	              
	                 count++;
	                
	              
	              
	              
	              if(j-1 >=0 && grid[i][j-1]==1)
	              {
	                count++;
	                
	              }
	              
	              if(j+1 <columns && grid[i][j+1]==1)
	              {
	                count++;
	                
	              }
	              
	              //lower right side diagonal
	              if(j>=0 && j<columns-1 && i>=0 && i<rows-1)
	              {  
	                 if(grid[i+1][j+1]==1)
	                   count++;
	                     
	                  // grid[b][d]=5;
	              }
	              
	              //upper left side diagonal
	              if(i>0 && i<rows && j>0 && j<columns)
	              {
	                if(grid[i-1][j-1]==1)
	                  count++;
	                    
	                  //grid[a][c]=5;
	              }
	              
	              //lower left side diagonal
	              if(j>0 && j<columns && i>=0 && i<rows-1)
	              {
	                if(grid[i+1][j-1]==1)
	                  count++;
	                    
	                  //grid[b][c]=5;
	              }
	              
	              //upper side right diagonal
	              if(i>0 && i<rows && j>=0 && j<columns-1)
	              {
	                if(grid[i-1][j+1]==1)
	                  count++;
	                  
	              }
	              
	              if(Cell==1)
	              {  
	              if(count<2)
	                grid[i][j]=0;
	              
	              if(count>3)
	                grid[i][j]=0;
	              
	              if(count==2|| count==3)
	              {
	                grid[i][j]=grid[i][j];
	              }
	              }
	              
	              if(Cell==0)
	              {
	                if(count==3)
	                grid[i][j]=1;
	              }
	              
	}
	     
	     public void getnextgeneration()
	     {
	    	//printing next generation
	 		for(int i=0;i<rows;i++)
	 		{
	 			for(int j=0;j<columns;j++)
	 			{
	 				if(grid[i][j]==1)
	 					System.out.print("[ALIVE]		");
	 				else
	 					System.out.print("DEAD	    	");
	 			}
	 			System.out.println();
	 			System.out.println();
	 		}
	     }
	     
	//main method
	public static void main(String args[])
	{
		//scanner class
		Scanner gg=new Scanner(System.in);
		
		int r,c;
		int t=1;
		
		
		//tacking input for row 
		System.out.println("Enter row :: ");
		r=gg.nextInt();
		
		
		//input for column
		System.out.println("Enter column :: ");
		c=gg.nextInt();
		
		//current array
		int grid[][]=new int[r][c];
		int i,j;
		
		
		System.out.println("Enter Cells  :: ");
		System.out.println();
		System.out.println("1 FOR ALIVE CELL ");
		System.out.println("0 FOR DEAD CELL");
		
		//input for current cell
		for(i=0;i<r;i++)
		{
			for(j=0;j<c;j++)
			{
		
				int n=gg.nextInt();
				if(n==0||n==1) {
					grid[i][j]=n;
				}
				else
					System.out.println("!!! YOU HAVE ENTER A WRONG INPUT !!!");
				
			}
		}
		
		//printing current cells
		for(i=0;i<r;i++)
		{
			for(j=0;j<c;j++)
			{
				if(grid[i][j]==1)
					System.out.print("[ALIVE]		");
				else
					System.out.print("DEAD	    	");
			}
			System.out.println("\n\n");
		}
		
		
		
		
		Celllifecycle obj=new Celllifecycle();
		
		obj.set(grid, r, c);
		obj.gameOfLife();
		
		do
		{
		System.out.println("1. print Next Generation "+"\n2. Get cell info ");
		System.out.println("Enter your choice ? ");
		int n=gg.nextInt();
		
		switch(n)	//Switch case for multiple options
		{
		case 1:	//case 1 for next generation
		{
			System.out.println("Next Generation :: \n");
			
			
			obj.getnextgeneration();
		}
		break;
		
		case 2:	//case 2 for cell status
		{
			System.out.println("Enter row ? :: ");
			int r1=gg.nextInt();
			
			System.out.println("Enter column ? ::");
			int c1=gg.nextInt();
			
			for( i=0;i<r;i++)
			{
				for( j=0;j<c;j++)
				{
					if(grid[r1][c1]==grid[i][j])
					{
						if(grid[r1][c1]==1)
						{
							System.out.println("Cell status [ALIVE] ");
						}
						else
							System.out.println("cell status [DEAD] ");
					}
					break;
				}
				break;
			}
		}
		}
		
		System.out.println("Do you want to continue ? 1 for yes and 0 for no :: ");
		t=gg.nextInt();
		}while(t!=0);
		
	
	}
}
