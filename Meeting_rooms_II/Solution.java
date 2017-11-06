package Facebook.Meeting_rooms_II;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

//array sort the Interval with their start time
//after the sort, if element1.end<element2.start, then we can merge those interval,
//the new interval will be push back to the priority queue
public class Solution {
    public int minMeetingRooms(Interval[] intervals)
    {
        if(intervals.length==0||intervals == null)
        {
            return 0;
        }
        Arrays.sort(intervals,(a, b)->(a.start-b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)->(a.end-b.end));
        for(Interval element:intervals)
        {
            if(pq.size() == 0 || pq.peek().end > element.start)
            {
                pq.offer(element);
            }
            else
            {
                //if pq.peek.end < element.start
                //those two interval can be merge
                Interval peek = pq.poll();
                pq.offer(new Interval(peek.start,element.end));
            }
        }
        return pq.size();
    }

     public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
