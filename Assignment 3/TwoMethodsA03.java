/**
 * @author David Hartley
 */

public class TwoMethodsA03 {

    /**
     * Method finds and returns the largest digit in a given number
     *
     * @param num the number to analyze
     * @return the largest digit
     */
    public static int getLargestDigit(int num) {
        if (num < 0) num *= -1;//Always make the number positive
        if (num == 0) return 0;//Exit case, if no numbers remain return 0
        //Recursive -- Find the larger digit out of the last digit compared to the next digit to the left
        return Math.max(num % 10, getLargestDigit(num / 10));
    }

    /**
     * Method calculates and returns the sum of fractions 1/2+2/3+...+ a/(a+1)
     *
     * @param n the limit of the fraction pattern
     * @return the sum of fractions; returns -1 if the parameter value is less than 1
     */
    public static double fractionSum(int n) {
        if (n < 1) return -1;//if n is less than 1, return -1
        if (n == 1) return 0.5;//exit case: if n is 1, return 0.5. (n/n+1)
        //Recursive solution -- n/(n+1) plus the next n value (one less than current stack)
        //1.0 to keep it from converting to int division
        return (n / (n + 1.0)) + fractionSum(n - 1);
    }

    /**
     * A set of tests for getLargestDigit() method.
     */
    public static void testGetLargestDigit() {
        //*** Test 1 ***// 
        if (getLargestDigit(-5) == 5 && getLargestDigit(0) == 0 && getLargestDigit(9) == 9)
            System.out.println("Test 1 for getLargestDigit() PASSED");
        else System.out.println("Test 1 for getLargestDigit() Failed");

        //*** Test 2 ***//
        if (getLargestDigit(5565) == 6 && getLargestDigit(9881) == 9 && getLargestDigit(12348) == 8 && getLargestDigit(33) == 3)
            System.out.println("Test 2 for getLargestDigit() PASSED");
        else System.out.println("Test 2 for getLargestDigit() Failed");

    }

    /**
     * A set of tests for testFractionSum() method
     */
    public static void testFractionSum() {
        //*** Test 1 ***//
        if (fractionSum(-55) == -1 && fractionSum(0) == -1) System.out.println("Test 1 for fractionSum() PASSED");
        else System.out.println("Test 1 for fractionSum() Failed");

        //*** Test 2 ***//
        if (fractionSum(1) == 0.5) System.out.println("Test 2 for fractionSum() PASSED");
        else System.out.println("Test 2 for fractionSum() Failed");

        //*** Test 3 ***//
        if (Math.round(fractionSum(5) * 100.0) / 100.0 == 3.55) System.out.println("Test 3 for fractionSum() PASSED");
        else System.out.println("Test 3 for fractionSum() Failed");

        //*** Test 4 ***//
        if (Math.round(fractionSum(250) * 1000.0) / 1000.0 == 244.895)
            System.out.println("Test 4 for fractionSum() PASSED");
        else System.out.println("Test 4 for fractionSum() Failed");

        //*** Test 5 ***//
        if (Math.round(fractionSum(251) * 1000.0) / 1000.0 == 245.891)
            System.out.println("Test 5 for fractionSum() PASSED");
        else System.out.println("Test 5 for fractionSum() Failed");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        testGetLargestDigit();
        testFractionSum();
    }


}
