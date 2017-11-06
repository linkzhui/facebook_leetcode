package Facebook.Add_Binary_67;


//use bit operation, carry bit + character at a + character at b;
//if sum%2=1 current bit is 1
//if sum/2=1 carry on bit is 1

//time complex is O(Math.max(a.length(),b.length());
//space complex is O(Math.max(a.length(),b.length()+1);

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();

    }
    public String addBinary(String a, String b)
    {
        StringBuilder sb = new StringBuilder();
        int a_length = a.length()-1; //the first bit is the right most bit of the string
        int b_length = b.length()-1;
        int carry = 0;
        while(a_length>=0 || b_length>=0)
        {
            if(a_length>=0)
            {
                carry+=a.charAt(a_length--)-'0';
            }
            if(b_length>=0)
            {
                carry+=b.charAt(b_length--)-'0';
            }
            sb.insert(0,carry%2); //the current bit is 1 or 0
            carry/=2;  //the carry bit is 1 or 0
        }
        if(carry==1)
        {
            sb.insert(0,'1');
        }
        return sb.toString();
    }
}
