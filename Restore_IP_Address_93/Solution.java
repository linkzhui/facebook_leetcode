package Facebook.Restore_IP_Address_93;


import java.util.ArrayList;
import java.util.List;

//ip address: 4 parts, each parts should 0 <= ip <=256
//corner case: 00
//dfs, the depth of the tree should be 4, at each level, we can add 0<=ip<=256,
// therefore each level will have 3 different situations: length equal to 1, length equal to 2, length equal to 3

//time complexity: O(3^4): totoal level is 4,
//space complexity: O(3^4 * n): n is the length of the string
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private void restoreIp(String ip, List<String> solutions, int cur_index, String restored, int count) {
        if (count == 4)
        {
            if(cur_index == ip.length())
            {
                solutions.add(restored);
            }
            return;
        }

        for (int i=1; i<4; i++) {
            if (cur_index+i > ip.length())
                break;
            String s = ip.substring(cur_index,cur_index+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256))
                break;
            restoreIp(ip, solutions, cur_index+i, restored+s+(count==3?"" : "."), count+1);
        }
    }
}
