/**
 * Created by Omer on 3/11/2016.
 */



/*
==================
This is the main class that will call contain and call all the answer() methods and classes
 */


public class Main {
    public static void main (String[] arg) {
        double[] y = new double[]{2.2999999999999998, 15.0, 102.40000000000001, 3486.8000000000002};
        double[] x = new double[]{23.0, 150.0, 1024.0, 34868.0};


        int answer = RabbitTestSubjects.answer(y,x);
        System.out.println(answer);
    }
}
