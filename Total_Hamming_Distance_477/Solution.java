package Facebook.Total_Hamming_Distance_477;


//Solution 1: use XOR, {1,2,3}->{1 XOR 2, 1 XOR 3, 2 XOR 3}   ********************(不是最优解)************************
//then we calculate the how many 1 in the result, the number of 1 in the XOR result will be hamming distance
// the total time complex is O(n! * 32)  n! is the number of possible combination,
// 32 is each integer is 32 bits, we need to go through all integer to calculate the hamming distance

//Solution 2:
//按位统计各整数的二进制0与1的个数之和，分别记为zero[i], 和one[i]
//如果有3个数：{0，0，1} all possible combination for those 3 numbers to calculate hamming distance will be (# of 1) * (# of 0)
//therefore，if we convert the integer into binary, we do bit operation to calculate how many 1 and how many 0 at each bit in every integer.

//举例子：
//     index :  3210           3210          3210
//     nums 1:  1101   nums 2: 0010  nums 3: 0000


//at index 0:           total 0: 2            total 1: 1
//at index 1:           total 0: 2            total 1: 1

//then after we calculate total number the one and total number zero at each bit, we can calculate this bit's total hamming distance,
//after we go through all 32 bits, we will get the final result

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int j=0;j<32;j++) {
            //calculate the hamming distance according to each bit position (from least significant bit position to most significant)
            //根据bit的位置来分别计算每个bit position上的hamming distance
            int bitCountForOne = 0;
            for (int i=0;i<nums.length;i++)
            {
                //how many 1 in current bit position 计算当前bit的位置有多少个1
                bitCountForOne += (nums[i] >> j) & 1;   //calculate total number of 1 at this bit position
            }

            //calculate total number of 0 at this bit position
            int bitCountForZero = nums.length - bitCountForOne;

            total += bitCountForOne*bitCountForZero;   // number of one * number of zero is total hamming distance at current bit position
        }
        return total;
    }

}
