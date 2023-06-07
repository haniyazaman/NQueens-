
import java.util.Scanner;

public class Main {
    //n * n board to place queens: 
    // 'Q' indicates Queen is present in that position, ' ' indicates NO queen
    public static char board[][]; 
    public static int solutionCount = 0;

    //check this position is SAFE based on all previous rows' queen placements?
    public static boolean okToPlace(int row, int column) {
// WRITE YOUR CODE HERE
    int i,j;
    if(row == 0 && column == 0){
          return false;
    }
    for(i = row-1; i >= 0; i--){
        //checks rows going up 
        if(board[i][column] == 'Q'){
            return false;
        }
    }
    for(j = column-1; j >= 0; j--){
      //columns to the left
      if(board[row][j] == 'Q'){
        return false;
      }
    }
    
    
    for(i = row-1, j = column -1; i >= 0 && j >= 0; i--, j--){
            //checks diagonally up and to the left
            if(board[i][j] == 'Q'){
                return false;
            }
    }
    for(i = row-1, j = column +1; i >= 0 && j < board[i].length; i--, j++){
        //up and to the right
        if(board[i][j] == 'Q'){
          return false;
        }
    }
    
    for(i = row; i < board.length; i++){
        for(j = column; j >= 0; j--){
          //down and to the left
            if(board[i][j] == 'Q'){
                return false;
            }
        }
    }
    for(i = row; i < board.length; i++){
      for(j = column; j < board[i].length; j++){
        //down and to the right
        if(board[i][j] == 'Q'){
          return false;
        }
      }
    }
    return true;
  }

    // recurisve function to place queens
    // increment solutionCount for each complete configuration 
    public static void placeQueens(int row) {
// WRITE YOUR CODE HERE;
    for(int column = 0; column < board[row].length; column++){
      if(okToPlace(row, column)){
        board[row][column] = 'Q';
        solutionCount++;
        break;
      } 
    }
        row++;
        if(row < board.length){
          placeQueens(row);
        }
    
}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //get the board size & initialize the board
        int boardSize = input.nextInt();
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                board[i][j] = ' ';

        // start with the first row & count # of valid configurations.
        placeQueens(0); 
        System.out.println(solutionCount);
    }
}



