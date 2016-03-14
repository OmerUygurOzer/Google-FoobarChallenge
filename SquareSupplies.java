/**
 * Created by Omer on 3/13/2016.
 */
/*
Square supplies
===============

With the zombie cure injections ready to go, it's time to start treating our zombified rabbit friends (known as zombits) at our makeshift zombit treatment center. You need to run out really fast to buy some gauze pads but you only have 30 seconds before you need to be back.

Luckily, the corner store has unlimited gauze pads in squares of all sizes. Jackpot! The pricing is simple - a square gauze pad of size K x K costs exactly K * K coins. For example, a gauze pad of size 3x3 costs 9 coins.

You're in a hurry and the cashier takes a long time to process each transaction. You decide the fastest way to get what you need is to buy as few gauze pads as possible, while spending all of your coins (you can always cut up the gauze later if you need to). Given that you have n coins, what's the fewest number of gauze pads you can buy?

Write a method answer(n), which returns the smallest number of square gauze pads that can be bought with exactly n coins.

n will be an integer, satisfying 1 <= n <= 10000.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (int) n = 24
Output:
    (int) 3

Inputs:
    (int) n = 160
Output:
    (int) 2

 */
public class SquareSupplies {
    public static int answer(int n) {

        /* To find the minimum amount of gauzes needed I square root my money and round down the result. Then square that value and substract it from the remaining of your money.
           This will always give you the highest possible square within your money. Repeat until there is no money left. it will work since 1 can be perfectly squared with 1 .
         */

        int leftOver = n;
        int currentGauze = 0;

        boolean cont = true;
        while(cont){
            double s = Math.sqrt(leftOver);
            int rem = (int) s;
            leftOver -= rem*rem;
            currentGauze++;
            cont = leftOver!=0;
        }
        return currentGauze;

    }
}
