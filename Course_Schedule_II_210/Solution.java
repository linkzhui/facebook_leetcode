package Facebook.Course_Schedule_II_210;


import java.util.*;

//Topological sorting: the sorting can be used in directed graph, to build a linear ordering of its vertices,
// the topological sorting if the graph has no loop

//we List<List<Integer>> graph to represent a graph, the index of the list represent the course_num and nested list
// means after you take course_num i, the nested list are means those courses require current course as pre_condition
//we go through the array, we add all course into list and also add this's course's precondition into the list, also we mark the inorder of every course,
//also we need a int array (not_taken) to store the all courses pre_condition number(需要上多少门其他的课才能上这个课)

//then we need a queue, we push those courses without pre_condition into the queue
//if the queue is not empty, we keep pop the element from the queue,then we need to add this element into result (list<Integer>),
//also we minus -1 for all other courses in the array require current course as pre_condtion, if we find one course's precondition have become zero,
// then that means we can take this course now, and we put this course into the queue.
public class Solution {
    public static void main(String[] args)
    {
        int[][] input = {};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.findOrder(2,input)));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] not_taken = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] pair:prerequisites)
        {
            //pair[1] is pre_course, after you take pair[0] course, you need to take pair[1]
            graph.get(pair[1]).add(pair[0]);
            not_taken[pair[0]]++;// =0  not taken yet
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;
        for(int i = 0;i<numCourses;i++)
        {
            if(not_taken[i]==0)
            {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int course_num = queue.remove();
            result[index++] = course_num;
            for(int j:graph.get(course_num))
            {
                not_taken[j]--;
                if(not_taken[j]==0)
                {
                    queue.add(j);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (not_taken[i] != 0)
                //a loop exist
                //check for the loop
                return new int[0];
        }
        return result;
    }
}
