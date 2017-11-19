package Facebook.Inorder_Successor_in_BST_285;

//问一下TreeNode可以带parent指针不？输入只有一个TreeNode，没有root。所以一定要和面试官好好交流，写代码之前问清楚输入输出是什么才行。。

//Solution 1: iteration (4ms)
// The idea is to compare root's value with p's value if root is not null, and consider the following two cases:
// root.val > p.val. In this case, root can be a possible answer, so we store the root node first and call it res. However, we don't know if there is anymore node on root's left that is larger than p.val. So we move root to its left and check again.
// root.val <= p.val. In this case, root cannot be p's inorder successor, neither can root's left child. So we only need to consider root's right child, thus we move root to its right and check again.
// We continuously move root until exhausted. To this point, we only need to return the res in case 1.'

//solution 2:Solution 2: recursion (5ms)
//上面那种方法也可以写成递归形式，写法也比较简洁，但是需要把思路理清，
// 当根节点值小于等于p节点值，说明p的后继节点一定在右子树中，所以对右子节点递归调用此函数，
// (if current node is less than p node, then the possible result exist in the current node's right child)

// 如果根节点值大于p节点值，那么有可能根节点就是p的后继节点，或者左子树中的某个节点是p的后继节点，所以先对左子节点递归调用此函数，
// 如果返回空，说明根节点是后继节点，返回即可，如果不为空，则将那个节点返回。
//if current node is bigger than p node, the current node is possible result node, then we keep recursion for current node's left child
//to find any less than current node, but bigger than p node (node < current possible result && node > p node)


// 这种解法可以用作模板，求BST的inorder successor和predecessor

//模板 [BST InOrder Successor / Predecessor]



//solution 3: 如果有parent的话
//inorder 的走法，即便这颗树不是bst也可以解除答案
//case 1: current node have right child, then result must exist in the it's right child
//case 2: if current node don't have right child, then we according it's parent to find the result
        // 2.1 if current node is parent's left child, then it's parent is its successor (只有当前节点是parent左孩子的话，parent才会比当前节点要大)
        // 2.2 if current node is parent's right child, then keep looking for its parent,(当前节点是parent的右孩子的话，parent会比当前节点要小)

import Google.Tree.TreeNode;

public class Solution {

    // -----------------------------------solution 1 iterator

    public TreeNode inorderSuccessor_iteraotr(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                //当前的node比p node大，当前的node就是可能的答案
                res = root;

                //然后继续找当前点的左孩子，看有没有比当前点小，但是比p node值大的其他的node
                root = root.left;
            } else     root = root.right;
        }
        return res;
    }

    // -----------------------------------solution2  successor
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)   return null;
        if (root.val > p.val) {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        } else    return inorderSuccessor(root.right, p);
    }

    // -----------------------------------solution2 predecessor
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null)   return null;
        if (root.val < p.val) {
            TreeNode right = inorderSuccessor(root.right, p);
            return right == null ? root : right;
        } else    return inorderPredecessor(root.left, p);
    }


    // -----------------------------------solution 3 with parent
//    public TreeNode inOrderSuccessor(TreeNode n) {
//        if (n == null)	return null;
//        if (n.right != null)
//            return leftMostChild(n.right);
//        else {
//            TreeNode cur = n, p = n.parent;
//            while (p != null && p.left != cur) {
                    //只要它不是parent的left孩子，或者只要当前节点没有到root,
                    //因为只要当前节点是parent的左孩子，就找到结果了 （parent就是结果）
//                cur = p;
//                p = p.parent;
//            }
//            return p;
//        }
//    }
//    private TreeNode leftMostChild(TreeNode node) {
//        while (node.left != null)
//            node = node.left;
//        return node;
//    }
}
