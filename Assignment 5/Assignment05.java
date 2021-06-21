
/**
 *
 * @author Alexandra Vaschillo
 */
public class Assignment05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {   
        
        allTestsPointClass();
        allTestsRightTriangleClass();
        allTestsMyIntegerClass();       
        
    }
  
    public static void allTestsPointClass()
    { 
 
        System.out.println("\n----Tests for Point Class----\n");
        test01PointClass();
        test02PointClass();
 
    }
    public static void allTestsRightTriangleClass()
    { 
        System.out.println("\n----Tests for RightTriangle Class----\n");
        test01TriangleClass();
        test02TriangleClass();
        test03TriangleClass(); 
    }
    public static void allTestsMyIntegerClass()
    { 
        System.out.println("\n----Tests for MyInteger Class----\n");
        test01MyIntegerClass();
        test02MyIntegerClass();
        test03MyIntegerClass();
    }
    
    
    public static void test01PointClass()
    {
        
        double x1 = 33.1,  y1 = 44; // point  coordinates for setting
        double xx1 = 33.1, yy1= 44; //- expected point coordinates
 
//Test #1  
        Point point1 = new Point(); 
        point1.setX(x1);
        point1.setY(y1);
        if(point1.getX()==xx1 && point1.getY()== yy1) 
        {
            System.out.printf("%-80s%-10s\n", "Point TEST 01: Test for set and get methods",  "PASSED");
           
        }
        else  System.out.printf("%-80s%-10s\n", "Point TEST 01: Test for set and get methods",  "FAILED");

        double x11 = 1, y11= 1; //- expected point11 default coordinates

//Test #2
        Point point11 = new Point(); 
        if(point11.getX()==x11 && point11.getY()==y11) 
        {
            System.out.printf("%-80s%-10s\n", "Point TEST 01: Test for non-argument constuctor",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Point TEST 01: Test for non-argument constuctor",  "FAILED");
    }
    
  
    
    public static void test02PointClass()
    {
        double x2 = -925.5, y2 = 6; // point2  coordinates
        double xx2 = -925.5, yy2= 6; //- expected point2  coordinates
   //Test #1        
        Point point2 = new Point(x2, y2); 
        if(point2.getX()==xx2 && point2.getY()==yy2) 
        {
            System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for constructor with parameters",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for constructor with parameters",  "FAILED");    	

        double x1  = 125, y1 = 25; //  - original point coordinates
        double dx1 = 30, dy1 = -5; // - how the point moved
        double xx1 = 155, yy1 = 20; //- point after movement
        double rx1 = 20, ry1= -155; //- point after rotation

        Point point1 = new Point(); 
        point1.setX(x1);
        point1.setY(y1);
//Test #2          
        point1.move(dx1, dy1);
           
        if(point1.getX()==xx1 && point1.getY()==yy1) 
        {
            System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for move() method",  "PASSED");
            
        }
        else   System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for move() method",  "FAILED");
 //Test #3       
        point1.rotate();

        if(point1.getX()==rx1 && point1.getY()==ry1) 
        {
            System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for rotate() method",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for rotate() method",  "FAILED");

    }
    
    // set, get, throwing exceptions
    
    public static void test01TriangleClass()
    {
        
        double a1 = 10.1, b1 = 15.1; // legs for the set  method tests
        double aa1 = 10.1, bb1 = 15.1; // expected values for set method tests
        
        double a2 = -5, b2 = -5; // values for testting exceptions
        
//Test #1          
        RightTriangle tri1 = new RightTriangle();
        tri1.setLegA(a1);
        tri1.setLegB(b1);
        if(tri1.getLegA()==aa1 && tri1.getLegB()== bb1) 
        {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for set and get methods",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for set and get methods",  "FAILED");
 //Test #2  
        try
        {
            tri1.setLegA(a2);
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for setLegA and exception it must throw",  "FAILED");
        }
        catch (IllegalArgumentException e)
        {
             System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for setLegA and exception it must throw",  "PASSED");
            
        }
 //Test #3
        try
        {
            tri1.setLegB(b2);
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for setLegB and exception it must throw",  "FAILED");
        }
        catch (IllegalArgumentException e)
        {
             System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for setLegB and exception it must throw",  "PASSED");
             
        }

    }
    
    // constructors and exceptions
    public static void test02TriangleClass()
    {
        
        double a1 = 10.5, b1 = 15.3; // legs for constructor with parameters
        double aa1 = 10.5, bb1 = 15.3; // expected values to be set by constructor
        
        double aa2 = 1, bb2 = 1; // values for testing default constructor
        
        double a3 = -51, b3 = -8; // values for testing exceptions

 //Test #1       
        RightTriangle tri1 = new RightTriangle(a1, b1);
  
        if(tri1.getLegA()==aa1 && tri1.getLegB()== bb1) 
        {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constuctor with parameters",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constuctor with parameters",  "FAILED");
//Test #2        
        RightTriangle tri2 = new RightTriangle();
  
        if(tri2.getLegA()==aa2 && tri2.getLegB()== bb2) 
        {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for no-argument constuctor",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for no-argument constuctor",  "FAILED");
//Test #3        
        try
        {
            tri1.setLegA(a3);
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constructor and exception it must throw",  "FAILED");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constructor and exception it must throw",  "PASSED");
            
        }
//Test #4
        try
        {
            tri1.setLegB(b3);
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constructor and exception it must throw",  "FAILED");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constructor and exception it must throw",  "PASSED");
            
        }

    }
    // area, hypotenuse, perimeter, toString()

    public static void test03TriangleClass()
    {      
        double a1 = 3, b1 = 4; // legs 
        double hyp = 5;// expected hypotenuse 
        double perim = 12; // expected perimeter
        double area = 6; // expected area
        String str = "legA = 3.0,  legB = 4.0"; // expected toString() result
        
        RightTriangle tri1 = new RightTriangle();
        tri1.setLegA(a1);
        tri1.setLegB(b1);
  
        if(tri1.getArea() == area && tri1.getHypotenuse() == hyp && tri1.getPerimeter()==perim) 
        {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 03: Test for area, hypotenuse, and perimeter calculations",  "PASSED");
           
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 03: Test for area, hypotenuse, and perimeter calculations",  "FAILED");
   
        if(tri1.toString().equals(str)) 
        {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 03: Test for toString()",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 03: Test for toString()",  "FAILED");

    }
    
    public static void test01MyIntegerClass()
    { 
        int a = 55;
        int b = 102;
        int prime = 97;
        
 //Test #1       
        MyInteger num1 = new MyInteger(a);
        if(num1.toInteger()==a)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for constuctor",  "PASSED");
             
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for constuctor",  "FAILED");
  //Test #2       
        MyInteger num2 = new MyInteger(b);
        
        if(!num1.isEven()&& num1.isOdd()&& num2.isEven() && !num2.isOdd())
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for isEven() and isOdd()",  "PASSED");
           
        }
        else   System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for isEven() and isOdd()",  "FAILED");
  //Test #3           
        MyInteger num3 = new MyInteger(prime);
        if(num3.isPrime() && !num2.isPrime() && !num1.isPrime())
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for isPrime()",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for isPrime()",  "FAILED");

    }
    
    public static void test02MyIntegerClass()
    { 
        int a = 103;
        int b = 500;
        int prime = 919;
        
//Test #1          
        if(!MyInteger.isEven(a)&& MyInteger.isOdd(a)&& MyInteger.isEven(b) && !MyInteger.isOdd(b))
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for static isEven() and static isOdd()",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for static isEven() and static isOdd()",  "FAILED");
//Test #2          
        if(MyInteger.isPrime(prime) && MyInteger.isPrime(a) && !MyInteger.isPrime(b))
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for static isPrime()",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for static isPrime()",  "FAILED");
//Test #3        
        MyInteger num1 = new MyInteger(a);
        MyInteger num2 = new MyInteger(a);
        
        if(num1.equals(a) && num1.equals(num2))
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for both isEquals() methods",  "PASSED");
             
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for both isEquals() methods",  "FAILED");
        
    }
    
    public static void test03MyIntegerClass()
    { 
      

//Test #1       
       if(MyInteger.parseInt("2147483647") == 2147483647 && MyInteger.parseInt("12") == 12 && MyInteger.parseInt("0") == 0)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() with valid positive values",  "PASSED");
             
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() with valid positive values",  "FAILED");  
//Test #2       
       if(MyInteger.parseInt("-54321") == -54321 && MyInteger.parseInt("-2147483648") == -2147483648 && MyInteger.parseInt("-3") == -3)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() with valid negative values",  "PASSED");
             
        }
        else System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() with valid negative values",  "FAILED");
//Test #3
       try // overflow detection test
        {
            int k = MyInteger.parseInt("2147483648");
             System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() overflow",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() overflow",  "PASSED");
            
        }
//Test #4        
        try // underflow detection test
        {
            int k = MyInteger.parseInt("-2147483649");
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() underflow",  "FAILED"); 
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() underflow",  "PASSED");
            
        }
//Test #5
        try // non-digit characters detection test
        {
            int k = MyInteger.parseInt("4a5");
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() invalid digits",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() invalid digits",  "PASSED");
            
        }
//Test #6
        try // non-digit characters detection test (special case)
        {
            int k = MyInteger.parseInt("-");
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() invalid digits (just '-')",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() invalid digits (just '-')",  "PASSED");
            
        }

    }
}
