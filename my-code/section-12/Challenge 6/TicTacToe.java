import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  /**
   * The main method is the entry point of the Tic Tac Toe game.
   * It initializes the game board, handles player turns, and determines the winner.
   *
   * @param args Command line arguments (not used in this program).
   */
  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    String[][] board = new String[3][3]; // Opps. Used String instead of char. Will fix it later.
    initializeBoard(board);

    printBoard(board);

    boolean aWinner = false;
    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("X's turn:");
        int[] rowColChoice = askUser(board);
        board[rowColChoice[0]][rowColChoice[1]] = "X";
        printBoard(board);
      } else {
        System.out.println("O's turn:");
        int[] rowColChoice = askUser(board);
        board[rowColChoice[0]][rowColChoice[1]] = "O";
        printBoard(board);
      }

      int winner = checkWin(board);
      if (winner == 3) {
        System.out.println("X wins!");
        aWinner = true;
        break;
      } else if (winner == -3) {
        System.out.println("O wins!");
        aWinner = true;
        break;
      }
    }

    if (!aWinner) {
      System.out.println("It's a tie!");
    }

    scan.close();
  }

  /**
   * Task 2 - Write a function that prints the board.
   * Function name - printBoard()
   * 
   * @param board (char[][])
   * 
   *              Inside the function:
   *              1. print a new line.
   *              2. print the board.
   *              • separate each row by two lines.
   *              • each row precedes a tab of space
   *              • each character in the grid has one space from the other
   *              character
   */
  private static void printBoard(String[][] board) {
    System.out.println("\n\t  0 1 2");

    for (int i = 0; i < board.length; i++) {
      System.out.print("\t" + i + " ");
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();
  }

  /**
   * Task 4 - Write a function that lets the user choose a spot
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   *         Inside the function
   *         1. Asks the user: - pick a row and column number:
   *         2. Check if the spot is taken. If so, let the user choose again.
   *         3. Return the row and column in an int[] array.
   * 
   */
  private static int[] askUser(String[][] board) {
    int[] rowColChoice = new int[2];
    int row = 0;
    int col = 0;
    boolean validChoice = false;

    while (!validChoice) {
      System.out.print("\tPick a row and column number: ");
      row = scan.nextInt(); // row
      col = scan.nextInt(); // column
      scan.nextLine();

      if (board[row][col].equals("_")) {
        validChoice = true;
      } else {
        System.out.println("\tSpot is taken. Choose again.");
      }
    }

    rowColChoice[0] = row;
    rowColChoice[1] = col;

    return rowColChoice;
  }

  /**
   * Task 6 - Write a function that determines the winner
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */
  private static int checkWin(String[][] board) {
    int rows = checkRows(board);
    if (Math.abs(rows) == 3)
      return rows;

    int columns = checkColumns(board);
    if (Math.abs(columns) == 3)
      return columns;

    int leftDiagonal = checkLeftDiagonal(board);
    if (Math.abs(leftDiagonal) == 3)
      return leftDiagonal;

    int rightDiagonal = checkRightDiagonal(board);
    if (Math.abs(rightDiagonal) == 3)
      return rightDiagonal;

    return -1;
  }

  
  /**
   * Checks each row of the TicTacToe board to determine if there is a winner.
   * 
   * This method iterates through each row of the given 2D array `board` and counts
   * the occurrences of "X" and "O". If a row contains three "X"s or three "O"s,
   * it returns the count (3 for "X" and -3 for "O"). If no row contains three of
   * the same symbol, it returns 0.
   * 
   * @param board A 2D array representing the TicTacToe board.
   * @return An integer indicating the result:
   *         - 3 if a row contains three "X"s (indicating "X" wins),
   *         - -3 if a row contains three "O"s (indicating "O" wins),
   *         - 0 if no row contains three of the same symbol.
   */
  private static int checkRows(String[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j].equals("X")) {
          count++;
        } else if (board[i][j].equals("O")) {
          count--;
        }
      }

      if (Math.abs(count) == 3) {
        return count;
      } else {
        count = 0;
      }
    }

    return count;
  }

  /**
   * Checks the columns of the TicTacToe board to determine if there is a winner.
   *
   * @param board A 2D array representing the TicTacToe board.
   *              Each element should be either "X", "O", or an empty string.
   * @return An integer representing the result:
   *         - A positive value (3) if "X" has won in any column.
   *         - A negative value (-3) if "O" has won in any column.
   *         - Zero if there is no winner in any column.
   */
  private static int checkColumns(String[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i].equals("X")) {
          count++;
        } else if (board[j][i].equals("O")) {
          count--;
        }
      }

      if (Math.abs(count) == 3) {
        return count;
      } else {
        count = 0;
      }
    }

    return count;
  }

  /**
   * Checks the left diagonal of the Tic-Tac-Toe board for a winning condition.
   * The left diagonal is defined as the diagonal from the top-left to the bottom-right.
   *
   * @param board A 2D array representing the Tic-Tac-Toe board.
   *              Each element of the array is expected to be either "X", "O", or an empty string.
   * @return An integer representing the count of "X" and "O" in the left diagonal.
   *         A positive count indicates more "X" than "O", a negative count indicates more "O" than "X",
   *         and zero indicates an equal number of "X" and "O".
   */
  private static int checkLeftDiagonal(String[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[i][i].equals("X")) {
        count++;
      } else if (board[i][i].equals("O")) {
        count--;
      }
    }

    return count;
  }

  /**
   * Checks the right diagonal of the Tic-Tac-Toe board for a winning condition.
   * The right diagonal is defined as the diagonal from the top-right to the bottom-left.
   *
   * @param board A 2D array representing the Tic-Tac-Toe board.
   *              It is assumed to be a 3x3 array with each cell containing either "X", "O", or an empty string.
   * @return An integer representing the count of "X" and "O" in the right diagonal.
   *         A positive count indicates more "X" than "O", a negative count indicates more "O" than "X",
   *         and zero indicates an equal number of "X" and "O".
   */
  private static int checkRightDiagonal(String[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[2 - i][i].equals("X")) {
        count++;
      } else if (board[2 - i][i].equals("O")) {
        count--;
      }
    }
    return count;
  }

  /**
   * Initializes the TicTacToe board by setting all positions to the default value "_".
   *
   * @param board The 2D array representing the TicTacToe board to be initialized.
   */
  private static void initializeBoard(String[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = "_";
      }
    }
  }
}
