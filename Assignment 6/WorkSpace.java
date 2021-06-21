import java.lang.reflect.Array;
import java.util.Arrays;

public class WorkSpace {

    public static void main(String[] args){
        String[] a = new String[3];
        a[2] = "Hi";
        //int[] a = new int[10];
        int[] n = {0,1,2,3,4,5,6,7,8,9};
        int[] n2 = new int[n.length];
        //int[][] nn = {{1,2,3},{4,5,6},{7,8,9}};
        /*for(int i = 1; i <n2.length; i+=2){
            //a[i] = i + 1;
            n2[i] = n[i];
        }*/
        for (int i = 1; i< 5; i++){
            for (int j = 0; j<i;j++){
                System.out.print(n[i]);
            }
            System.out.print(" ");
        }
       // int[] n2 = new int[n.length];
       // for(int i = 0; i<n.length;i=i+2){
       //    n2[i] = n[i];
       // }
       System.out.println(Arrays.toString(Arrays.stream(n2).toArray()));
    }
}
