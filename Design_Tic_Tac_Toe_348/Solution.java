package Facebook.Design_Tic_Tac_Toe_348;

//The key observation is that in order to win Tic-Tac-Toe you must have the entire row or column.
// Thus, we don't need to keep track of an entire n^2 board. We only need to keep a count for each row and column.
// If at any time a row or column matches the size of the board then that player has won.

//To keep track of which player, I add one for Player1 and -1 for Player2.
// There are two additional variables to keep track of the count of the diagonals.
// Each time a player places a piece we just need to check the count of that row, column, diagonal and anti-diagonal.

//O(1) time for move
//O(2n) -> O(n): for length and width of the matrix
class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        //因为player 1 加的是正数，player 2加的是负数，所以一条线既有player1的棋子，又有player 2的棋子，这条线加起来就不会等于棋盘的size

        //因为走一个点，rows【】和cols【】都会更新，
        //所以比如palyer1 row 0走了横线，[0,0],[0,1],[0,2] -> 这样子rows【0】就相当于加了3次, rows[0]的值就等于棋盘的长度

        //再比如player 2 col 0 走了竖线， 【0，0】，【1，0】， 【2，0】所以col【0】就会等于3，
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col)
        {
            //走了斜角就++
            diagonal += toAdd;
        }

        if (col == (cols.length - row - 1))
        {
            //走了antidiagonal也++
            antiDiagonal += toAdd;
        }

        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size  ||
                Math.abs(antiDiagonal) == size)
        {
            return player;
        }

        return 0;
    }
}
