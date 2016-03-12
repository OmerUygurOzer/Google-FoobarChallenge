/**
 * Created by Omer on 3/11/2016.
 */



/*
==================
This is the main class that will call contain and call all the answer() methods and classes
 */


public class Main {
    public static void main (String[] arg) {
        int[][] test= new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 2, 1}};
        test = ZombitInfection.answer(test,0,0,2);
        for(int i =0;i<test.length;i++){
            for(int k = 0;k<test[0].length;k++){
                System.out.print(test[i][k]);
            }
            System.out.println("");
        }
    }
}
