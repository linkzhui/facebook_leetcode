package Facebook.Maximum_Swap_670;

//Use buckets to record the last position of digit 0 ~ 9 in this num.
//Loop through the num array from left to right. For each position,
//we check whether there exists a larger digit in this num in its right side(start from 9 to current digit).
//We also need to make sure the position of this larger digit is behind the current one.
//If we find it, simply swap these two digits and return the result.

//step 1: we record last occurrence index for this number. therefore we need a integer array, the index for integer array is the num's value,
//the value for this array will be the last occurrence index  （int【3】 =2, 数字3最后出现的位置在index等于2的位置上）
//为什么要记录最左边的出现的位置，因为我们要把大的number换到前面去，换到左边去，这样才能保证数字最大

//  index 0     1   2   3
//例子：  1      9   1   9， 数字是1919，最大的转换时9911，我们要把rightmost 9和leftmost 1交换,这就是我们要记录数字最后出现的位置

//Loop through the num array from left to right. For each position,
//we check whether there exists a larger digit in this num in its right side(start from 9 to current digit).
//If we find it, simply swap these two digits and return the result.

public class Solution {

    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {

            //record every number's rightmost index
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {

            //从左边扫到右边,看看有没有比当前的number要大的值，同时在当前number的右边
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    //如果有值比当前的number要大，同时出现在当前的number right side
                    //
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }
}
