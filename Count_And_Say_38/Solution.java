package Facebook.Count_And_Say_38;


//走1到n步，每次扫描之前的string，
//利用prev来记录上一个character，然后利用count来记录这个character重复了多少次
//如果碰到不同的character,就把当前的character和count加到stringbuilder里面
public class Solution {
    public String countAndSay(int n) {
        String number = "1";
        for(int i =2; i<=n; i++)
        {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char prev = ' ';
            for(int j =0; j<number.length(); j++)
            {
                if(j==0||prev==number.charAt(j))
                {
                    //如果是j == 0 （没有prev）或者prev等于现在的char
                    count++;
                }
                else{
                    //把count 和 char的结果加到stringbuilder里面
                    sb.append(count);
                    sb.append(prev);
                    count=1;
                }
                prev=number.charAt(j);
            }
            sb.append(count);
            sb.append(prev);
            number = sb.toString();
        }
        return number;
    }
}
