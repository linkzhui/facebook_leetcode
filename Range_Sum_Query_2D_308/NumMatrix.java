package Facebook.Range_Sum_Query_2D_308;


//first we do some pre-process to calculate the pre_sum (from index 0 to col index) for each col
//the pre-process time is O(m*n) m is number of row for this matrix, n is number of col for this matrix
//then the time complexity to calculate sum region will be O(n): n is the total length of the region(长方形的长)
//then the time complexity to update the matrix will be O(m):  m is the current coordinate's row number to matrix.length-1;
public class NumMatrix {
    private int[][] colSums;
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if(   matrix           == null
                || matrix.length    == 0
                || matrix[0].length == 0   ){
            return;
        }

        this.matrix = matrix;

        int m   = matrix.length;
        int n   = matrix[0].length;
        colSums = new int[m + 1][n];
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < n; j++){
                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
            }
        }
    }
    //time complexity for the worst case scenario: O(m)
    public void update(int row, int col, int val) {
        for(int i = row + 1; i < colSums.length; i++){
            colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
        }

        matrix[row][col] = val;
    }
    //time complexity for the worst case scenario: O(n)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = 0;

        for(int j = col1; j <= col2; j++){
            ret += colSums[row2 + 1][j] - colSums[row1][j];
        }

        return ret;
    }
}
