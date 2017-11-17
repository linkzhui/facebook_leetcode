package Facebook.Monotonic_1006;

//计算出第一个和第二个之间的difference，然后根据走loop，比较前后的差值是不是都是一样l
public class Solution {
    public boolean order(int[] array) {
        if (array == null || array.length <=1 ) {
            return false;
        }

        int diff = array[1] - array[0];
        for(int i = 2;i<array.length;i++) {
            if (array[i] - array[i - 1] != diff)
            {
                return false;
            }
        }
        return true;

    }

}
