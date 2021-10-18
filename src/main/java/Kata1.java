/* package whatever; // don't place package name! */

import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
class MyClass
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int[][] input = getArgs();
        int[] expectedOutput = new int[]{10, 21, 23, 16};

        Motku motku = new Motku(input);
        check(motku,5,2,10);
        check(motku,6, 3, 21);
        check(motku,4, 3, 23);
        check(motku,4, 2, 16);
    }

    private static void check(Motku motku, int startNode, int distance, int expectedResult) {
        int result = motku.result(startNode, distance);
        String msg = result == expectedResult ? "OK" : result+" instead of "+expectedResult;
        System.out.println(msg);
    }

    private static int[][] getArgs() {
        int[][] retVal = new int[12][];
        retVal[0] = new int[]{6} ;
        retVal[1] = new int[]{5, 8, 7, 3, 2, 1};
        retVal[2] = new int[]{1, 2};
        retVal[3] = new int[]{1, 3};
        retVal[4] = new int[]{2, 4};
        retVal[5] = new int[]{3, 5};
        retVal[6] = new int[]{3, 6};
//        retVal[7] = new int[]{4} ;
//        retVal[8] = new int[]{5, 2};
//        retVal[9] = new int[]{6, 3};
//        retVal[10] = new int[]{4, 3};
//        retVal[11] = new int[]{4, 2};

        return retVal;
    }


}