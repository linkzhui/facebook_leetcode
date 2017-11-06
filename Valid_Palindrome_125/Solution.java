package Facebook.Valid_Palindrome_125;

//Assumption: is that case sensitivity,(lower case, upper case)
//only letter and digitis are consider the valid element for palindrome
//two case: string is even number or odd number
//start<end suit for both two cases
//is character case sensitive, lower case or upper case

public class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
                return false;
            }
        }
        return true;
    }
}