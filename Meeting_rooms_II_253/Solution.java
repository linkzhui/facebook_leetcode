package Facebook.Meeting_rooms_II_253;


//sort the array, the start of the interval as reference
//then use priority queue to find the sub_interval, the priority queue rule is mark end time of the interval as reference to build a min heap
//because we sort the array, therefore the start time in array is ascending order
//if current start time is bigger then min_heap_peek,
//the time interval can merge
//otherwise add the new time interval back into the pq


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Definition for an interval.
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }



public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)->(a.end-b.end));
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });
        for(Interval element:intervals)
        {
            Interval peek= pq.peek();
            if(peek==null)
            {
                pq.offer(element);
            }
            else if(peek.end<=element.start)
            {
                //the element's start is less or equal than pq's peek's end time
                pq.poll();
                pq.offer(new Interval(peek.start,element.end));
            }
            else{
                //the element's start is larger than pq's peek's end time
                pq.offer(element);
            }
        }
        return pq.size();
    }
}

