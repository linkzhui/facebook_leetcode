package Facebook.Integer_to_English_Words_273;

//divide the Integer / 1000 each time, to get the result between 0 ~ 999, 1000 ~ (1000_000 - 1), ...
//then find num%1000 use helper function
//helper function have 4 cases:
//1. num = 0  2.num<20  3.num<100  4.num>100
public class Solution {

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num)
    {
        if(num == 0)
        {
            return "zero";
        }
        int i = 0;
        String words = "";
        while(num!=0)
        {
            if(num%1000!=0)
            {
                words = helper(num%1000)+" "+THOUSANDS[i]+words;
            }
            num /=1000;
            ++i;
        }
        return words;
    }

    private String helper(int num)
    {
        if(num == 0)
        {
            return "zero";
        }
        else if(num<20)
        {
            return LESS_THAN_20[num];
        }
        else if(num<100)
        {
            return TENS[num/10]+" "+helper(num%10);
        }
        else{
            return LESS_THAN_20[num/100]+"hundred "+helper(num%100);
        }
    }
}
