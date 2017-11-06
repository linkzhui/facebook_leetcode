package Facebook.Serialize_and_deserialize_binary_tree_297;


//给一棵树，转换成string
//level by level print the tree
import Facebook.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static void main(String[] args)
    {
        String input = "1 2 3 null null 4 5";
        Codec sol = new Codec();
        TreeNode root = sol.deserialize(input);
        System.out.println(sol.serialize(root));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
        {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode node =  queue.poll();
            if(node==null)
            {
                sb.append("null ");
                continue;
            }
            sb.append(node.val+" ");
            queue.offer(node.left);
            queue.offer(node.right);
//            if(node.left!=null)
//            {
//                queue.offer(node.left);
//            }
//            if(node.right!=null)
//            {
//                queue.offer(node.right);
//            }


        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")
        {
            return null;
        }
        String[] str=data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        queue.offer(root);
        for(int i = 1;i<str.length;i++)
        {
            TreeNode node = queue.poll();
            if(!str[i].equals("null"))
            {
                //left node
                node.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.left);
            }

            if(!str[++i].equals("null"))
            {
                //right node
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.right);
            }
        }
        return root;

    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
