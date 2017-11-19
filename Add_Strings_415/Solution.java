package Facebook.Add_Strings_415;

//解法，we begin from two arrays' rightmost character, each time move index to left by 1, if the index reach the leftmost of the array, we mark character as 0,
//if both arrays reached the array's leftmost index and carry bit is 0, then we have the result.
//we will append the result into the StringBuilder,
//then convert the StringBuilder into the string to return the result.

//time complexity: O(n+m)
//space complexity:O(n+m)
public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i != -1 || j != -1 || carry == 1) {

            //因为是从右往左走，所以index = -1 代表着string已经走完了
            //如果string 1 does not exceed the leftmost boundary，string 2 don't exceed the leftmost boundary or we still have carry on bit

            int a = i != -1 ? (num1Array[i--] - '0') : 0;  //if we already exceed the leftmost boundary of the string, we will assume current character is 0
            int b = j != -1 ? (num2Array[j--] - '0') : 0;
            int sum = a + b + carry;
            int reminder = sum%10;
            sb.insert(0, reminder);
            carry = sum / 10;
        }
        return sb.toString();
    }
}
