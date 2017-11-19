package Facebook.Clone_Graph_133;


import java.util.*;

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

//step 1: we need a hashmap, the key of the hashmap is original graph node, the value is cloned graph node
//step 2: iterative the original graph node's neighboor, if the neighboor is not exist in hashmap, we clone this graph node
//time complexity: O(n+v)
//space complexity: O(n)
public class Solution {

    //iterative
    public UndirectedGraphNode cloneGraphIterative(UndirectedGraphNode node)
    {
        if (node == null)
        {
            return null;
        }
        Map<Integer,UndirectedGraphNode> map = new HashMap<>(); //hashmap to store original node (key) and clone of node (value)
        Deque<UndirectedGraphNode>  queue = new ArrayDeque<>();
        UndirectedGraphNode clone_head = new UndirectedGraphNode(node.label); //new head of graph

        queue.offerFirst(node);
        map.put(node.label,clone_head);
        while(!queue.isEmpty())
        {
            UndirectedGraphNode temp_node = queue.pollFirst();
            for(UndirectedGraphNode element:temp_node.neighbors)
            {
                if(!map.containsKey(element.label))
                {
                    ////add to map and queue if this node hasn't been searched before
                    UndirectedGraphNode temp_node_neighbor = new UndirectedGraphNode(element.label);
                    map.put(element.label,temp_node_neighbor);
                    queue.offerFirst(element);
                }
                map.get(temp_node.label).neighbors.add(map.get(element.label));  //add neighbors to new created nodes
            }
        }
        return clone_head;
    }


    //DFS to clone the graph node's neightboor
    //recursion
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer,UndirectedGraphNode> map = new HashMap<>();
        return clone(node,map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node,Map<Integer,UndirectedGraphNode> map)
    {
        if(node == null)
        {
            return null;
        }
        UndirectedGraphNode clone = map.get(node.label);
        if(clone != null)
        {
            return clone;
        }
        clone = new UndirectedGraphNode(node.label);
        map.put(node.label,clone);
        for(UndirectedGraphNode element:node.neighbors)
        {
            clone.neighbors.add(clone(element,map));
        }
        return clone;
    }
}



