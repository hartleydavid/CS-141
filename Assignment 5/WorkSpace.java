import java.util.Scanner;

public class WorkSpace {

    public static void main(String[] args){

        MyInteger integer = new MyInteger(6);
        //int num = MyInteger.parseInt("-56987");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Value: ");
        String userInput = input.nextLine();
        int num = MyInteger.parseInt(userInput);
        System.out.println(num);
    }



    public static void displayCords(Point printPoint, int num){
        System.out.println("Point " + num + " Cords- x:"
                + printPoint.getX() + ", y:" + printPoint.getY());
    }
}
