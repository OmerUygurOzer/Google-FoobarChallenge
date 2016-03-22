import java.math.BigInteger;

/**
 * Created by Omer on 3/13/2016.
 */
/*
Line up the captives
        ====================

        As you ponder sneaky strategies for assisting with the great rabbit escape, you realize that you have an opportunity to fool Professor Booleans guards into thinking there are fewer rabbits total than there actually are.

        By cleverly lining up the rabbits of different heights, you can obscure the sudden departure of some of the captives.

        Beta Rabbits statisticians have asked you for some numerical analysis of how this could be done so that they can explore the best options.

        Luckily, every rabbit has a slightly different height, and the guards are lazy and few in number. Only one guard is stationed at each end of the rabbit line-up as they survey their captive population. With a bit of misinformation added to the facility roster, you can make the guards think there are different numbers of rabbits in holding.

        To help plan this caper you need to calculate how many ways the rabbits can be lined up such that a viewer on one end sees x rabbits, and a viewer on the other end sees y rabbits, because some taller rabbits block the view of the shorter ones.

        For example, if the rabbits were arranged in line with heights 30 cm, 10 cm, 50 cm, 40 cm, and then 20 cm, a guard looking from the left side would see 2 rabbits (30 and 50 cm) while a guard looking from the right side would see 3 rabbits (20, 40 and 50 cm).

        Write a method answer(x,y,n) which returns the number of possible ways to arrange n rabbits of unique heights along an east to west line, so that only x are visible from the west, and only y are visible from the east. The return value must be a string representing the number in base 10.

        If there is no possible arrangement, return "0".

        The number of rabbits (n) will be as small as 3 or as large as 40
        The viewable rabbits from either side (x and y) will be as small as 1 and as large as the total number of rabbits (n).

        Languages
        =========

        To provide a Python solution, edit solution.py
        To provide a Java solution, edit solution.java

        Test cases
        ==========

        Inputs:
        (int) x = 2
        (int) y = 2
        (int) n = 3
        Output:
        (string) "2"

        Inputs:
        (int) x = 1
        (int) y = 2
        (int) n = 6
        Output:
        (string) "24"
*/
public class LineUpTheCaptives {

    /*
    Tallest rabbit needs to be selected first since it will block all rabbits behind it. It's index will be between x and n-y
    The algorithm is to sum all possible combinations of placements for each possible location of the tallest rabbit

     */

    public static int                  max = 40;
    public static BigInteger[]  cachedFact = new BigInteger[max];
    public static BigInteger[]  cachedSide = new BigInteger[max*max]; //Single arrays perform better

    public static String answer(int x, int y, int n) {

        BigInteger returner = BigInteger.ZERO;

        for(int i = x; i <= n- y + 1 ; ++i){
            returner = returner.add(combination(n-1,i-1).multiply(calcSide(x-1, i-1).multiply(calcSide(y-1, n-i))));
        }


        return returner.toString();
    }



    public static BigInteger calcSide(int s, int k){
        if(s==0){
            if ( k == 0 ) {return BigInteger.ONE;}
            return BigInteger.ZERO;
        }

        if(cachedSide[s + k*max]!=null){return cachedSide[s + k*max];}

        BigInteger returner = BigInteger.ZERO;

        for(int i = s; i <= k ; ++i){
            returner  = returner.add(combination(k-1, i-1).multiply(calcSide(s-1, i-1)).multiply(factorial(k-i)));
        }
        cachedSide[s + k*max] = returner;

        return returner;
    }


    //Formula
    //    n!
    // --------
    // r!(n-r)!
    //
    public static BigInteger combination(int n,int r){
        return factorial(n).divide(factorial(r).multiply(factorial(n-r)));
    }


    public static BigInteger factorial(int n){
        if (n == 0 || n==1) {return BigInteger.ONE;}
        if(cachedFact[n]==null){
            cachedFact[n]= BigInteger.valueOf(n).multiply(factorial(n-1));
            return cachedFact[n];
        }
        return cachedFact[n];
    }
}
