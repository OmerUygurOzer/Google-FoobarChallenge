/**
 * Created by Omer on 3/11/2016.
 */



/*
==================
This is the main class that will call contain and call all the answer() methods and classes
 */


public class Main {
    public static void main (String[] arg) {
        int [] x= (MinionInterrogation.answer(new int[][]{{390, 185, 624}, {686, 351, 947}, {276, 1023, 1024}, {199, 148, 250}}));
        System.out.println();
        for(int i = 0;i<x.length;i++){
            System.out.print(x[i]);
        }
    }
}
