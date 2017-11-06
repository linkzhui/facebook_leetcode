package Facebook.Binary_tree_paths_257;

import Facebook.TreeNode;
import java.util.ArrayList;
import java.util.List;


//if node.left and node.right are both null, then we know we find a path
//therefore we implement recursion to traverse a tree
//the initial state is root node,
//then we expand root node to generate root.left child and root.right child
//we keep doing recursion to it's child node to find a path
//the termination condition will be 1. if root.left and root.right are both null or 2. current node is null
//the recursion function will need three parameters, the current node, stringbuilder to store the current path and list to store the final result
//in the recursion function, we will add current node into the stringbuilder, when we return back to previous level, we will delete current node
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(root == null)
        {
            return result;
        }

        helper(root,sb,result);
        return result;
    }
    private void helper(TreeNode root,StringBuilder sb, List<String> result)
    {
        if(root == null)
        {
            //current node is null
            return;
        }
        int length = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null)
        {
            //the path is find
            result.add(sb.toString());
        }
        else{
            //still have right child or left child
            sb.append("->");
            helper(root.left,sb,result);
            helper(root.right,sb,result);
        }
        sb.setLength(length); //remove the current node
    }
}
