package Facebook.Multiply_Strings_43;

//                56
//             *  22
//__________________
//                12
//               10
//               12
//              10
//                                                             p1    p2
// the result of num1[i] * num2[j] will be placed at indices [i+j,i+j+1]

//the corner case: 999999 * 0 = 00000000
//after we get the result, we need to check the result to avoid this case


//time complexity: O(n*m) : the n is the length of the string num1, and the m is the length of the string num2
public class Solution {
    public String multiply(String num1,String num2)
    {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m+n]; //the final multiplication will be less than m+n
        for(int i = m - 1;i >= 0;i--)
        {
            for(int j = n - 1;j>=0; j--)
            {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = mul+result[p2]; //we add original result in position p2 with the multiplication result

                result[p1] += sum/10;
                result[p2] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p:result)
        {
            if(!(sb.length() == 0 && p == 0))
            {
                //to avoid the case 000000000
                sb.append(p);
            }
        }
        return sb.length() == 0? "0":sb.toString();
    }
}
