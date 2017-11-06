package Facebook.Find_the_celebrity_277;

//rule 1: if a knows b, a is not possible celetrity, b is possible celetrity
//rule 2: celetrity don't know anyone

//step1: pick index 0 as possible celetrity, go through the array,
// check if possible celetrity know anyone, if possible celetrity know anyone,
// then pick that index as new possible celetrity
//
public class Solution {
//    public class Solution extends Relation {
//        public int findCelebrity(int n) {
//            int possible_celetrity = 0;
//            for(int i = 1;i<n;i++)
//            {
//                if(knows(possible_celetrity,i))
//                {
//                    //the possible_celetrity shouldn't know anyone
//                    possible_celetrity = i;
//                }
//            }
//            for(int i = 0;i<n;i++)
//            {
//                if(i==possible_celetrity || (i!=possible_celetrity && knows(i,possible_celetrity) && !knows(possible_celetrity,i)))
//                {
//                    continue;
//                }
//                else{
//                    return -1;
//                }
//            }
//            return possible_celetrity;
//        }
//    }
}
