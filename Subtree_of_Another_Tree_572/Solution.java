package Facebook.Subtree_of_Another_Tree_572;

//Question 1: Is there have duplicated element in this tree?
//if there is duplicated element in this tree, therefore we need to recursion every TreeNode, because every tree node is the possible root for subtree

//therefore, it have two recursion function, one recursion function is go through all the node in the original node,
//the second recursion function is used to determine if current subtree is same with another subtree

import Google.Tree.TreeNode;

//because, we need to run second recursion for every node in bigger tree,
//therefore the time complex: O(m*n) m is the total node for larger tree, n is total node for smaller tree
//space complexity: O(h) h is the deepest height for the tree.
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //this recursion method is used to go through every node in bigger tree
        if(s == null)
        {
            //termination condition
            return false;
        }
        else if(isSameSubTree(s,t))
        {
            //check if current subtree have same structure with another subtree
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);   //这里是只要有一个返回true，就是找到了相同的

    }
    private boolean isSameSubTree(TreeNode s, TreeNode t)
    {
        if(s == null && t == null)
        {
            //reach the end of the subtree, means current path, they have same structure
            return true;
        }
        else if(s==null || t == null)
        {
            //if one tree node is null, another is not null, means they don't have same structure
            return false;
        }
        else if(s.val!=t.val)
        {
            //they are not equal
            return false;
        }

        //otherwise, keep recursion to check its left child and right child also have same structure or not
        boolean left_child_result = isSameSubTree(s.left,t.left);
        boolean right_child_result = isSameSubTree(s.right,t.right);

        return left_child_result && right_child_result;  //左孩子和右孩子的structure也都要相同才能返回true
    }
}
