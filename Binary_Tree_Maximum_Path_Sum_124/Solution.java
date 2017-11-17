package Facebook.Binary_Tree_Maximum_Path_Sum_124;

// If we want to get max path sum, we can get max path sum of its left child and max path sum of its right child,
// to determine if current path sum bigger than past maximum path sum
// then we can calculate current path, if we choose current node as root of the path,
// and return current maximum path of sum as a child to its parent node.
import Google.Tree.TreeNode;

public class Solution {
    public int maxPathSum(TreeNode root)
    {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfs(root,max);
        return max[0];
    }
    private int dfs(TreeNode root,int[] max)
    {
        if(root == null)
        {
            return 0;
        }
        int left_child = Math.max(dfs(root.left,max),0);   //左孩子会不会给我正的contribution
        int right_child = Math.max(dfs(root.right,max),0); //right孩子会不会给我正的contribution
        int cur_max = Math.max(left_child+right_child+root.val,root.val); //以当前的node，作为path的root，看看maximum path sum是多少
        max[0] = Math.max(max[0],cur_max);  //比较一下当前点maximum path sum 和 max
        return Math.max(left_child,right_child)+root.val; //return 一条当前最大的maximum path sum 的边
    }
}
