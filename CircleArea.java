
import java.util.Scanner;

/**
 * @author David Hartley CS&141
 */
public class CircleArea {

    public static void main(String[] args) {
        // Create Scanner object for input
        Scanner input = new Scanner(System.in);
        // ********* Problem 2: Circle Area Problem ***********
        // TODO Implement the following step-by-step plan
        // 1. Declare double constant PI to hold 3.14
        double PI = 3.14;
        // 2. Declare a double variable to store radius
        double radius;
        // 3. Declare a double variable to store area
        double area;
        // 4. Prompt the user to enter radius.
        System.out.print("Enter a radius Value: ");
        // 5. Input radius and store it in variable
        radius = input.nextDouble();
        input.close();//Close scanner
        // 6. Calculate circle area. Find the formula on the web if you don't remember
        // it
        area = PI * Math.pow(radius, 2);
        // 7. Output the circle's radius and area values in user-friendly fashion
        System.out.println("Radius: " + radius);
        System.out.println("The Area calculated is: " +  (Math.round(area * 100) / 100.0));
        // ********* End of Circle Area Problem code area ***********
    }
}