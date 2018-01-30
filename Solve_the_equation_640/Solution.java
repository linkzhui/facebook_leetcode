package Facebook.Solve_the_equation_640;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 1. put x on the left of the equal sign
    // 2. put all the number on the right of the equal sign
    public String coeff(String x) {
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9')

            return x.replace("x", "");
        return x.replace("x", "1");
    }
    public String solveEquation(String equation) {
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;

        //equation before "="
        for (String x: breakIt(lr[0])) {
            if (x.indexOf("x") >= 0) {
                // coefficient of x
                lhs += Integer.parseInt(coeff(x));
            } else
                rhs -= Integer.parseInt(x);
        }

        //equation after "="
        for (String x: breakIt(lr[1])) {
            if (x.indexOf("x") >= 0)
                //coefficient of x
                lhs -= Integer.parseInt(coeff(x));
            else
                rhs += Integer.parseInt(x);
        }
        if (lhs == 0) {
            if (rhs == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }
        return "x=" + rhs / lhs;
    }
    public List< String > breakIt(String s) {
        List < String > res = new ArrayList< >();
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (r.length() > 0)
                    res.add(r);
                r = "" + s.charAt(i);
            } else
                r += s.charAt(i);
        }
        res.add(r);
        return res;
    }
}


