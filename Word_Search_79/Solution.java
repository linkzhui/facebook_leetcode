package Facebook.Word_Search_79;

//通过dfs走path，然后用一个boolean【】【】来mark走过的路径 (如果boolean【】【】 不让用的话，那就用一个hashset来确保已经走过的点)
//step 1. 走matrix，如果当前的character是word的第一个char
//step 2. dfs走matrix

//time complexity: O(m*n) :m is the size of the matrix, n is the length of the word
//space complexity:O(m) we used a boolean[][] which have same size with char[][].
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','F'}};
        String s = "ABCCED";
        sol.exist(board,s);
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int x = 0;x<board[0].length;x++)
        {
            for(int y = 0;y<board.length;y++)
            {
                if(helper(board,word,0,visited,x,y))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int index, boolean[][] visited, int x, int y){
        if(index == word.length())
        {
            return true;
        }
        if(x<0 || x==board[0].length || y<0 || y==board.length || word.charAt(index)!=board[y][x]|| visited[y][x] )
        {
            //x or y out of boundary, and character is not the same
            return false;
        }
        visited[y][x] = true;
        //mark current coordinate is visited

        boolean result =  helper(board,word,index+1,visited,x+1,y)||helper(board,word,index+1,visited,x,y+1)||helper(board,word,index+1,visited,x-1,y)||helper(board,word,index+1,visited,x,y-1);
        visited[y][x] = false; //we need to return back to previous level, therefore we need to unmark current coordinate

        return result;
    }
}
