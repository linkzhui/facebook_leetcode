package Facebook.Valid_Number_65;

//Corner case:
// 1. is single E valid?
// 2. abc is not valid
// 3. can we add point after e?
// 4. do we need number before point?
// 5. point cannot exist twice
// 6. e cannot exist twice
// 7. -1 or +1 is that available?
// 8. 123 e -10, is that available?
public class Solution {
    public boolean isNumber(String s)
    {
        s = s.trim();
        boolean point_exist = false;
        boolean e_exist = false;
        boolean number = false;
        boolean number_after_e = true;
        for(int i =0;i<s.length();i++)
        {
            char element = s.charAt(i);
            if(element >= '0' && element <= '9')
            {
                number = true;
                number_after_e = true;
            }
            else if(element == '.')
            {
                if(e_exist||point_exist)
                {
                    //point cannot exist twice and cannot exist after e
                    return false;
                }
                point_exist = true;
            }
            else if(element == 'e')
            {
                //e cannot exist twice, there must have number before the e
                if(e_exist||!number)
                {
                    return false;
                }
                number_after_e = false;
                e_exist = true;
            }
            else if(element == '-' || element == '+')
            {
                // 123 e (+10) is valid, the + or - only can exist right after the e
                if(i!=0 && s.charAt(i-1) != 'e')
                {
                    return false;
                }
            }
            else{
                //other conditions
                return false;
            }
        }
        return number && number_after_e;
    }
}
