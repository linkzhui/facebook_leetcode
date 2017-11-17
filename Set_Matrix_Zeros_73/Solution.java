package Facebook.Set_Matrix_Zeros_73;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length ==0)
        {
            return;
        }
        boolean first_row_zero = false;
        boolean first_column_zero = false;
        for(int i = 0;i<matrix[0].length;i++)
        {
            if(matrix[0][i] == 0)
            {
                first_row_zero = true;
                break;
            }
        }

        for(int i = 0;i<matrix.length;i++)
        {
            if(matrix[i][0] == 0)
            {
                first_column_zero = true;
                break;
            }
        }

        for(int i = 1; i<matrix[0].length; i++)
        {
            for(int j = 1; j<matrix.length; j++)
            {
                if(matrix[j][i] == 0)
                {
                    matrix[0][i] = 0;
                    //row 0，column i的位置设为0；

                    matrix[j][0] = 0;
                    //column 0, row j 位置设置为0；
                }
            }
        }

        for(int i =1;i<matrix[0].length;i++)
        {
            if(matrix[0][i] == 0)
            {
                for(int j = 0;j<matrix.length;j++)
                {
                    matrix[j][i] = 0;
                }
            }

        }

        for(int i = 1;i<matrix.length;i++) {
            if (matrix[i][0] == 0)
            {
                for(int j = 0;j<matrix[0].length;j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        if(first_row_zero)
        {
            for(int i = 0;i<matrix[0].length;i++)
            {
                matrix[0][i] = 0;
            }
        }

        if(first_column_zero)
        {
            for(int i = 0;i<matrix.length;i++)
            {
                matrix[i][0] = 0;
            }
        }
    }

}
