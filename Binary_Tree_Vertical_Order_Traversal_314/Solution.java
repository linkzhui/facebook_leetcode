package Facebook.Binary_Tree_Vertical_Order_Traversal_314;

import Facebook.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//scan the tree level by level,
//we mark the root node's index is 0, when we expand the root node, to generate it's left child and right child,
// we mark the left child, index - 1, right child index + 1
//when we expand a node, we mark his left child's index and right child's index
//also we mark two variables, min and max to set boundary of the index
//if node's index is in the boundary, we find the position of the element in the list, then update the nested list
//if the index is higher or lower than boundary, we update the boundary, then add a new list
//建立一个新的class mytreenode
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
        {
            return result;
        }
        //通过min和max来确定现在的boundary
        int min = 0;
        int max = 0;
        Deque<MyTreeNode> queue = new LinkedList<>();
        queue.offerLast(new MyTreeNode(0,root));
        result.add(new LinkedList<>());
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0;i<size;i++)
            {
                MyTreeNode node = queue.pollFirst();
                List<Integer> child_list = new LinkedList<>();

                if(node.node == null)
                {
                    continue;
                }
                else if(node.index>=min && node.index<=max)
                {
                    result.get(node.index-min).add(node.node.val);
                }

                else if(node.index<min)
                {
                    min = node.index;// update the min value
                    child_list.add(node.node.val);
                    result.add(0,child_list); //add a new linkedlist at front of the linkedlist

                }
                else{
                    //node.index>max
                    max = node.index;
                    child_list.add(node.node.val);
                    result.add(child_list);
                }
                queue.offerLast(new MyTreeNode(node.index-1,node.node.left));
                queue.offerLast(new MyTreeNode(node.index+1,node.node.right));
            }

        }
        return result;
    }

    private class MyTreeNode{
        int index;
        TreeNode node;
        public MyTreeNode(int index, TreeNode node)
        {
            this.index = index;
            this.node = node;
        }
    }
}
