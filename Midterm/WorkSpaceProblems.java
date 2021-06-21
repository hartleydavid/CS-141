import java.util.Random;

public class WorkSpaceProblems {

    public static void main(String[] args){

    }

    public static double chFIVEONE(double length, double width)throws IllegalArgumentException{
        if(length <= 0)throw new IllegalArgumentException("Length value of [" + length + "] is invalid");
        if(width <= 0)throw new IllegalArgumentException("Width value of [" + width + "] is invalid");
        return length * width;
    }
    public static void chFIVETWO(){
        Random r = new Random();
        System.out.printf("%7s | %7s | %7s \n", "Length", "Width", "Area");
        for(int i = 0; i <50;i++){
            int length = r.nextInt(100) +1;
            int width = r.nextInt(100) +1;
            double area = chFIVEONE(length, width);
            System.out.printf("%7d | %7d | %7.2f \n", length, width, area);
        }
    }
    public static void chFIVETHREE(){}
    public static void chFIVEFOUR(){}
    public static void chFIVEFIVE(){}
}
