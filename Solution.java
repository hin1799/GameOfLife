class GameOfLife{
  //class with the logic of the game

  public void gameOfLife(int[][] board) {
    //initializing neighbours
      int[] neighbors = {0, 1, -1};

      int rows = board.length;
      int cols = board[0].length;

      // Creating a copy of original board
      int[][] copyBoard = new int[rows][cols];
      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              copyBoard[i][j] = board[i][j];
          }
      }
      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {

              // Couting the live neighbours for each cell
              int liveNeighbors = 0;

              for (int k = 0; k < 3; k++) {
                  for (int m = 0; m < 3; m++) {
                      if (!(neighbors[k] == 0 && neighbors[m] == 0)) {
                          int r = (i + neighbors[k]);
                          int c = (j + neighbors[m]);

                          // Validity check of neighboring cell
                          if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                              liveNeighbors += 1;
                          }
                      }
                  }
              }

              //Rules implementation
              // Underpopulation and Overpopulation (Rules 1 and 3)
              if ((copyBoard[i][j] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                  board[i][j] = 0;
              }
              // Rule 4 Reproduction
              if (copyBoard[i][j] == 0 && liveNeighbors == 3) {
                  board[i][j] = 1;
              }
          }
      }
  }
  //Function used to print the board
  public void printBoard(int[][] board){
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
}


public class Solution {
    //Main function
    public static void main(String[] args){
      GameOfLife game=new GameOfLife();
      int board[][]={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
      System.out.println("Original board:");
      game.printBoard(board);
      game.gameOfLife(board);
      System.out.println("Next generation:");
      game.printBoard(board);
    }
}
