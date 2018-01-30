package Facebook.Sparse_matrix_multiplication_311;

//       z: Matrix A column     j: Matrix B column
//       i: Matrix A row        z: Matrix B row
//          z                   j
//      __________          _______
//     |          |        |       |
//   i |          |        |       |
//     |__________|      z |       |
//                         |       |
//                         |_______|
// A= 1  2      b =  1  3
//    3  4           2  4
// /time complex:O (z*i*j)
//space complex:O (i*j)

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int A_row = A.length;
        int A_col = A[0].length;
        int B_col = B[0].length;

        int[][] result = new int[A_row][B_col];
        for (int i = 0; i < A_row; i++) {
            for (int z = 0; z < A_col; z++) {
                if (A[i][z] != 0) {
                    //if value in A[i][z] == 0, to avoid the unnecessary loop, break the loop advanced
                    for (int j = 0; j < B_col; j++) {
                        if (B[z][j] != 0) {
                            result[i][j] += A[i][z] * B[z][j];
                        }
                    }
                }


            }
        }
        return result;
    }
}
