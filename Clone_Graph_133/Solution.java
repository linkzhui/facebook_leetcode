package Facebook.Clone_Graph_133;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

//step 1: we need a hashmap, the key of the hashmap is original graph node, the value is cloned graph node
//step 2: iterative the original graph node's neighboor, if the neighboor is not exist in hashmap, we clone this graph node
//DFS to clone the graph node's neightboor
public class Solution {
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
