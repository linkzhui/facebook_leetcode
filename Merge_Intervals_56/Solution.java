package Facebook.Merge_Intervals_56;



//QUESTION? the array is linkedlist or arraylist, if it is LinkedList, we gona use Iterator to go through the LinkedList,
//if array is ArrayList, we only need for loop to go through the whole array

//the merge rule: current.start<previous.end

//step1: sort the array first, the sort rule is according to the first index of the element
//step2: go throug the list, the merge rule is if current.start<previous.end, then those two interval can merge together,
//the new interval's end index will be math.max(prev.end,current.end);
import Google.LinkedList.ListNode;

import java.util.*;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        if (intervals instanceof ArrayList) {
            return helperArrayList(intervals);
        } else {
            return helperLinkedList(intervals);
        }
    }

    private List<Interval> helperArrayList(List<Interval> list) {
        //the current.start >= previous.end
        List<Interval> result = new LinkedList<>();
        if (list == null || list.size() == 0) {
            return result;
        }
        result.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            Interval prev = result.get(result.size()-1);
            if (list.get(i).start <= prev.end) {
                result.set(result.size() - 1, new Interval(prev.start, Math.max(prev.end,list.get(i).end)));
            } else {
                result.add(list.get(i));
            }
        }
        return result;
    }

    private List<Interval> helperLinkedList(List<Interval> list)
    {
        List<Interval> result = new LinkedList<>();
        if(list == null || list.size()==0)
        {
            return result;
        }
        result.add(list.get(0));
        Iterator<Interval> it = list.iterator();
        while(it.hasNext())
        {
            Interval cur = it.next();
            Interval prev = list.get(list.size()-1);
            if(cur.start<=prev.end)
            {
                result.set(result.size()-1,new Interval(prev.start,Math.max(prev.end,cur.end)));
            }
            else{
                result.add(cur);
            }
        }
        return list;
    }
    class Interval{
        int start;
        int end;
        Interval(){
            start = 0;
            end = 0;
        }
        Interval(int s, int e)
        {
            start = s;
            end = e;
        }
    }

}
