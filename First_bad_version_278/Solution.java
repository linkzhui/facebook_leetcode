package Facebook.First_bad_version_278;

//binary search
//we will set a start point and end point, start point is 0, end point is n
//if isBadVersion(mid) is bad version, we know the current mid is potential solution,
// we need to check the interval between start and end, is there have more early bad version, therefore we set end = mid;
//if we find mid is good version, we know we can update the start to mid+1, cuz all the version from start to mid are good version
//we are use while loop, the break rule is start is end's neighbor.
public class Solution {

//    public int firstBadVersion(int n) {
//        int start = 0;
//        int end = n;
//        int mid;
//        while(start<end-1)
//        {
//            mid = start+(end-start)/2;
//            if(isBadVersion(mid))
//            {
//                end = mid;
//            }
//            else{
//                start = mid+1;
//            }
//        }
//        return isBadVersion(start)? start:end;
//    }
}
