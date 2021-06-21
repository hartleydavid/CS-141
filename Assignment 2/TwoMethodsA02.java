
/**
 * @author David Hartley
 */
public class TwoMethodsA02 {
    /**
     * Method checks if a triangle with given lengths of sides is a right triangle
     *
     * @param a triangle side
     * @param b triangle side
     * @param c triangle side
     * @return true if the triangle is right, false if it is not
     */
    public static boolean isRightTri(int a, int b, int c) {
        //Swaps values if C is not the largest side
        int temp;//Temporary Int for swapping values
        if (a > c && a > b) {//if side a is the largest, swap a and c
            temp = a;
            a = c;
            c = temp;
        } else if (b > c && b > a) {//if b is the largest, swap b and c
            temp = b;
            b = c;
            c = temp;
        }
        //A^2 + B^2 = C^2 to find if a right triangle
        //C will always be the largest side, values were swapped if needed
        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
    }

    /**
     * The method takes hour, minute, and "am", "pm" components of the time stamp of the moment when car crosses the bridge and calculates the toll rate.
     * If any of the time stamp components are invalid, -1 is being returned as an error code.
     *
     * @param hour hour component of the time stamp
     * @param min  minute component of the time stamp
     * @param amPm either string "am" or "pm", component of the time stamp
     * @return the toll rate
     */
    public static double toll520Bridge(int hour, int min, String amPm) {
        //If timezone is out of range or there is a typo, return -1
        if (hour < 0 || hour > 12 || min < 0 || min > 59 || !(amPm.equals("am") || amPm.equals("pm"))) {
            return -1;//exit case
        }
        //convert time to military time
        int time = convertToMilitaryTime(hour, min, amPm);
        //System.err.println("Hour: " + hour + " Min: " + min + " Military Time: " + time);
        //Return the toll amount in respective time frame
        if (time >= 0 && time <= 459) return 1.25;//Midnight (12am) -> 4:59am
        if (time >= 500 && time <= 759) return 1.40;//5am -> 7:59am
        if (time >= 800 && time <= 1059) return 2.05;//8am -> 10:59am
        if (time >= 1100 && time <= 1759) return 2.65;//11am -> 5:59pm
        if (time >= 1800 && time <= 2059) return 2.05;//6pm -> 8:59pm
        if (time >= 2100 && time <= 2259) return 1.40;//9pm -> 10:59pm
        //If none of the above, then it will be the final hour. Invalid times are removed by the exit case
        return 1.25;//11pm -> 11:59

    }

    /**
     * Converts the input time stamp to military time zone
     *
     * @param hour hour component of the time stamp
     * @param min  minute component of the time stamp
     * @param amPm either string "am" or "pm", component of the time stamp
     * @return the military time
     */
    public static int convertToMilitaryTime(int hour, int min, String amPm) {
        if (hour == 12) hour = 0; //if 12 am/pm time, set hour to 0 from 12am -> 0000
        if (amPm.equals("pm")) min += 1200;//if pm add the 1200 to account for 12am-12pm time
        return (hour * 100) + min;//converts times to military time
    }


    public static void testIsRightTri() {
        //*** Test 1 ***//
        if (isRightTri(3, 4, 5)) System.out.println("Test 1 for isRightTri() PASSED");
        else System.out.println("Test 1 for isRightTri() Failed");

        //*** Test 2 ***//     
        if (isRightTri(4, 5, 3)) System.out.println("Test 2 for isRightTri() PASSED");
        else System.out.println("Test 2 for isRightTri() Failed");

        //*** Test 3 ***//     
        if (isRightTri(5, 4, 3)) System.out.println("Test 3 for isRightTri()) PASSED");
        else System.out.println("Test 3 for isRightTri() Failed");

        //*** Test 4 ***//     
        if (isRightTri(3, 5, 4)) System.out.println("Test 4 for isRightTri() PASSED");
        else System.out.println("Test 4 for isRightTri() Failed");

        //*** Test 5 ***//     
        if (isRightTri(5, 3, 4)) System.out.println("Test 5 for isRightTri() PASSED");
        else System.out.println("Test 5 for isRightTri() Failed");

        //*** Test 6 ***//     
        if (isRightTri(4, 3, 5)) System.out.println("Test 6 for isRightTri() PASSED");
        else System.out.println("Test 6 for isRightTri() Failed");

        //*** Test 7 ***//     
        if (!isRightTri(4, 4, 5)) System.out.println("Test 7 for isRightTri() PASSED");
        else System.out.println("Test 7 for isRightTri() Failed");
    }

    public static void testToll520Bridge() {
        //*** Test 1 ***//  
        if (toll520Bridge(5, 20, "aa") == -1) System.out.println("Test 1 for toll520Bridge() PASSED");
        else System.out.println("Test 1 for toll520Bridge() Failed");

        //*** Test 2 ***//  
        if (toll520Bridge(5, 65, "am") == -1) System.out.println("Test 2 for toll520Bridge() PASSED");
        else System.out.println("Test 2 for toll520Bridge() Failed");

        //*** Test 3 ***//  
        if (toll520Bridge(15, 15, "am") == -1) System.out.println("Test 3 for toll520Bridge() PASSED");
        else System.out.println("Test 3 for toll520Bridge() Failed");

        //*** Test 4 ***//  
        if (toll520Bridge(12, 0, "am") == 1.25 && toll520Bridge(4, 59, "am") == 1.25 && toll520Bridge(3, 35, "am") == 1.25)
            System.out.println("Test 4 for toll520Bridge() PASSED");
        else System.out.println("Test 4 for toll520Bridge() Failed");

        //*** Test 5 ***//  
        if (toll520Bridge(5, 0, "am") == 1.4 && toll520Bridge(7, 59, "am") == 1.4 && toll520Bridge(6, 03, "am") == 1.4)
            System.out.println("Test 5 for toll520Bridge() PASSED");
        else System.out.println("Test 5 for toll520Bridge() Failed");

        //*** Test 6 ***//  
        if (toll520Bridge(8, 0, "am") == 2.05 && toll520Bridge(10, 59, "am") == 2.05 && toll520Bridge(9, 15, "am") == 2.05)
            System.out.println("Test 6 for toll520Bridge() PASSED");
        else System.out.println("Test 6 for toll520Bridge() Failed");

        //*** Test 7 ***//  
        if (toll520Bridge(11, 0, "am") == 2.65 && toll520Bridge(4, 59, "pm") == 2.65 && toll520Bridge(3, 55, "pm") == 2.65)
            System.out.println("Test 7 for toll520Bridge() PASSED");
        else System.out.println("Test 7 for toll520Bridge() Failed");

        //*** Test 8 ***//  
        if (toll520Bridge(6, 0, "pm") == 2.05 && toll520Bridge(8, 59, "pm") == 2.05 && toll520Bridge(6, 15, "pm") == 2.05)
            System.out.println("Test 8 for toll520Bridge() PASSED");
        else System.out.println("Test 8 for toll520Bridge() Failed");

        //*** Test 9 ***//  
        if (toll520Bridge(9, 0, "pm") == 1.4 && toll520Bridge(10, 59, "pm") == 1.4 && toll520Bridge(9, 3, "pm") == 1.4)
            System.out.println("Test 9 for toll520Bridge() PASSED");
        else System.out.println("Test 9 for toll520Bridge() Failed");

        //*** Test 10 ***//  
        if (toll520Bridge(11, 0, "pm") == 1.25 && toll520Bridge(11, 59, "pm") == 1.25 && toll520Bridge(11, 40, "pm") == 1.25)
            System.out.println("Test 10 for toll520Bridge() PASSED");
        else System.out.println("Test 10 for toll520Bridge() Failed");
    }


    /**
     * Method main()contains all the tests
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        testIsRightTri();
        testToll520Bridge();

    }

}
