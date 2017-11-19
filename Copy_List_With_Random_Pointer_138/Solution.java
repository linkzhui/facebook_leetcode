package Facebook.Copy_List_With_Random_Pointer_138;


import java.util.HashMap;
import java.util.Map;


//we can use iterative way to copy the original node, meanwhile, we need a hashmap to record the original node (key) and clone node (value),
// in order to deal with the random node, we need cloned random node point to clone node.

//time complexity: O(n+v)
//space complexity: O(n)


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0), cur = dummy;
        //we need a dummy node to record the clone node.
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            RandomListNode newNode;
            if (map.containsKey(head))
            {
                //we check hashmap, to make sure do we already create the clone of this node
                newNode = map.get(head);
            }
            else {
                //if node is not exist in hashmap
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            if (head.random != null) // current node's random maybe null or may not be null
            {
                if (map.containsKey(head.random))
                    newNode.random = map.get(head.random);
                else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            //keep iterative walk the linked list
            cur.next = newNode;
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
