package Facebook.Divide_Two_Integers_29;


//solution 1:除数减去被除数,但是如果除数很大，被除数很小，时间会很长

//solution 2: bit operation: (better solution)
// 16 / 3 = 5 -> 1+4 -> (2^0+2^2) -> 2^0 * 3 + 2^2 * 3
//通过bit operation，找到solution bit的位置

//被除数每次 *2（向左移动一位）去靠近被除数，被除数减去新的除数如此循环。
//如果发现被除数大于除数，那就计算新的reminder，然后把reminder重新除于被除数
//通过bit operation, 把partial result 加到result里面
public class Solution {
    public int divide(int dividend, int divisor) {
        long result = 0;
        int sign = 1;
        long a_dividend = dividend;
        long a_divisor = divisor;
        if (a_dividend < 0) {
            a_dividend = -a_dividend;
            sign = -1;
        }
        if (a_divisor < 0) {
            a_divisor = -a_divisor;
            sign = -sign;
        }

        if (dividend == 0) {
            if (divisor == 0) {
                return Integer.MAX_VALUE;
            }
            return 0;
        }

        while (a_dividend >= a_divisor) {
            long result2 = 1;
            long a_divisor2 = a_divisor;
            while (a_dividend - (a_divisor2 << 1) >= 0) {
                //每次让被除数乘以2，直到被除数非常接近除数（就是被除数再乘以2就会超过除数），
                //我们知道了这个被除数移动了多少步，这个步数就是我们要的solution的那个bit位置
                a_divisor2 <<= 1;
                result2 <<= 1;
            }
            long remainder = a_dividend - a_divisor2;

            result = result | result2; //这里的 | 是 or的意思，就是把当前的bit position加到result里面，
            a_dividend = remainder; //then we update the dividend to remaninder to keep find the next bit in the result
        }



        if(sign == -1) {
            result = -result;
            if (result < Integer.MIN_VALUE) {
                result = Integer.MAX_VALUE;
            }
        } else {
            if(result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            }
        }

        return (int) result;
    }

}
