//import java.util.Random;
/**
 * A class that represents a (finite) board for Conway's Life.
 * 
 * @author Milo
 */

public class Life
{
    //the playing board
    public Cell [][] board;
    //rows
    public int r;
    //column
    public int c;

    /**
     * start up function main for running the prog outside blue jays
     * @param args - typical main input option for args, noimpl for this time
     */
    public static void main(String[] args) {
        boolean myOutput;
        
        //Testing out the cell functions
        System.out.println("");
        System.out.println("Testing Cell CLass default Constructor and is Alive Method..........."); // Display the string.
        Cell c;
        c = new Cell();
        myOutput = c.isAlive();
        System.out.println("Output is " + myOutput);
        
        //Test out calling class with param
        System.out.println("");
        System.out.println("Testing Cell CLass overloaded with true Constructor and is Alive Method..........."); // Display the string.
        Cell anotherCell;
        anotherCell = new Cell(true);
        myOutput = anotherCell.isAlive();
        System.out.println("Output is " +  myOutput);

        //Test out calling life constructor
        System.out.println("");
        System.out.println("Testing Life CLass Constructor with 10 and 10 paramaters for board..........."); // Display the string.
        Life myLife = new Life(10,10);
        System.out.println("Number of rows are: " + myLife.r);
        System.out.println("Number of columns are: " + myLife.c);

        //Calling into the countLivingNeighbors method a couple times based on the life class we made
        System.out.println("");
        System.out.println("Testing countLivingNeighbors Method with multiple calls below..........."); // Display the string.
        int iOutCount =0;
        iOutCount = myLife.countLivingNeighbors(5,5);
        System.out.println("Living cells count by 5, 5 are:" + iOutCount);

        /**calling the countLivingNeighbors function multiple ways */
        /**calling the countLivingNeighbors function multiple ways */
       
        //Calling into the countLivingNeighbors method a couple times based on the life class we made
        iOutCount =0;
        iOutCount = myLife.countLivingNeighbors(4,3);
        System.out.println("Living cells count by 4, 3 are:" + iOutCount);

        //Calling into the countLivingNeighbors with the y  or column being 0 so it should skip the y-1 or col-1
        iOutCount =0;
        iOutCount = myLife.countLivingNeighbors(5,0);
        System.out.println("Living cells count by 5, 0 are:" + iOutCount);

        //Calling into the countLivingNeighbors with the x  or row being 0 so it should skip the x-1 or row-1
        iOutCount =0;
        iOutCount = myLife.countLivingNeighbors(0,5);
        System.out.println("Living cells count by 0, 5 are:" + iOutCount);

        //Calling into the countLivingNeighbors with the x  or row being 0  and y or col being 0 so it should skip the x-1 or row-1 and y-1 or col -1
        iOutCount =0;
        iOutCount = myLife.countLivingNeighbors(0,0);
        System.out.println("Living cells count by 0, 0 are:" + iOutCount);

        //Call the next Generation
        //Calling into the countLivingNeighbors method a couple times based on the life class we made
        System.out.println("");
        System.out.println("Testing nextGeneratio Method to create new board..........."); // Display the string.
        myLife.nextGeneration();
        System.out.println("New Borad created with next Generation Call");

    } 

    /**
     * A constructor for a new Life game
     * @param width the width of the board (in squares)
     * @param height the height of the board (in squares)
     */
    public Life(int height, int width)  //*JBswitched the params from orig to hight first to match instructions
    {
        board = new Cell [height][width];
        r = height;
        c = width;
        this.fillRandom(); //JB* moved this to after the global assignments
    }

    /**
     * Updates the board for the next generation
     */
    public void nextGeneration()  //JB* changed the vars to more descriptive
    {
        Cell[][] board2;
        board2 = new Cell [r][c];
        for (int aRow = 0; aRow < r; aRow++){
            //if(a ==25){
            //System.out.println("help me");
            //}
            for(int bCol = 0; bCol < c; bCol++){
                if (board[aRow][bCol].isAlive() == true){
                    if (this.countLivingNeighbors(aRow,bCol) == 2 || this.countLivingNeighbors(aRow,bCol) == 3){
                        Cell c1 = new Cell (true);
                        board2[aRow][bCol] = c1;
                    }
                }
                //this else may never get hit since its in the or above
                else if (this.countLivingNeighbors(aRow,bCol) == 3){  
                    Cell c1 = new Cell (true);
                    board2[aRow][bCol] = c1;
                }
                else{
                    Cell c1 = new Cell (false);
                    board2[aRow][bCol] = c1; 
                }
            }
        }
        board = board2;
    }

    /**
     * Returns whether or not a cell is alive.
     * @param x the x coord of the cell row
     * @param y the y coord of the cell column
     * @return whether the cell is alive or not
     */
    public boolean isAlive(int xRow, int yCol) //JB* renamed yCol to reflect its a column
    {
        return board[xRow][yCol].isAlive(); //JB* swapped to have xRow first, made more descriptive variables
    }

    /**
     * Returns the number of living neighbors next to a cell.
     * @param xRow the x coord of the cell
     * @param yCol the y coord of the cell
     * @return the number of living neighbors next to the cell
     */
    public int countLivingNeighbors(int xRow, int yCol) //JB* changed variable to be more descriptive
    {
        int count = 0;

        for(int iRow = xRow -1; iRow < xRow + 1; iRow++)
        {
            if(iRow >0 && iRow < r)
            {
                for(int iCol = yCol - 1; iCol < yCol +1; iCol++)
                {
                    if(iCol > 0 && iCol < c)
                    {
                        if (board[iCol][iRow].isAlive()== true)
                        {
                                        count += 1;
                        }
                    }
                }
            }
        }
        return count;

        // int count = 0;  
        // if (xRow == c){
        //     if (yCol == r){
        //         if (board[yCol-1][xRow-1].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol-1][xRow].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol][xRow-1].isAlive()== true){
        //             count += 1;
        //         }
        //     }
        //     else if (yCol == 0){
        //         if (board[yCol][xRow-1].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol+1][xRow-1].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol+1][xRow].isAlive()== true){
        //             count += 1;
        //         }
        //     }
        //     else {
        //         if (board[yCol-1][xRow-1].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol-1][xRow].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol][xRow-1].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol+1][xRow-1].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol+1][xRow].isAlive()== true){
        //             count += 1;
        //         }
        //     }
        // }
        // else if (xRow == 0){
        //     if (yCol == 0){
        //         if (board[yCol][xRow+1].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol+1][xRow].isAlive()== true){
        //             count += 1;
        //         }
        //         if (board[yCol+1][xRow+1].isAlive()== true){
        //             count += 1;
        //         }
        //         else if (yCol == r) {
        //             if (board[yCol-1][xRow].isAlive()== true){
        //                 count += 1;
        //             }
        //             if (board[yCol-1][xRow+1].isAlive()== true){
        //                 count += 1;
        //             }
        //             if (board[yCol][xRow+1].isAlive()== true){
        //                 count += 1;
        //             }
        //         }
        //         else {
        //             if (board[yCol-1][xRow].isAlive()== true){
        //                 count += 1;
        //             }
        //             if (board[yCol-1][xRow+1].isAlive()== true){
        //                 count += 1;
        //             }
        //             if (board[yCol][xRow+1].isAlive()== true){
        //                 count += 1;
        //             }
        //             if (board[yCol+1][xRow].isAlive()== true){
        //                 count += 1;
        //             }
        //             if (board[yCol+1][xRow+1].isAlive()== true){
        //                 count += 1;
        //             }
        //         }
        //     }
        //     else if (yCol == 0)
        //         if (board[yCol][xRow-1].isAlive()== true){
        //             count += 1;
        //         }
        //     if (board[yCol][xRow+1].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol+1][xRow-1].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol+1][xRow].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol+1][xRow+1].isAlive()== true){
        //         count += 1;
        //     }
        // }
        // else if (yCol == r){
        //     if (board[yCol-1][xRow-1].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol-1][xRow].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol-1][xRow+1].isAlive()== true){
        //         count += 1;
        //     }  
        //     if (board[yCol][xRow-1].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol][xRow+1].isAlive()== true){
        //         count += 1;
        //     }   
        // }
        // else{
        //     if (board[yCol-1][xRow-1].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol-1][xRow].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol-1][xRow+1].isAlive()== true){
        //         count += 1;
        //     }  
        //     if (board[yCol][xRow-1].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol][xRow+1].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol+1][xRow-1].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol+1][xRow].isAlive()== true){
        //         count += 1;
        //     }
        //     if (board[yCol+1][xRow+1].isAlive()== true){
        //         count += 1;
        //     }
        // }    
        // return count;
    }

/**
 * Fills the board with random cells
 */
    public void fillRandom()
    {
        //row loop
        for (int iRow = 0; iRow < r; iRow++) //JB made iterator variables more descriptive
        {
            //column loop
            for(int iCol = 0; iCol < c; iCol++)
            {
                Cell c1 = new Cell ();
                board[iRow][iCol]= c1;   
            }
        }
    }
}
