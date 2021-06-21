/* B */
import java.io.IOException;
import java.io.PrintStream;

public class FinalWinter2021 {

	public static void main(String[] args) {
		
		PrintStream out = System.out;
		
		TestsProblem01.tests(out);
		TestsProblem02.tests(out);
      
      /* The following 3 test method calls have been commented out to make the code compile
      *  Please uncomment them in order to run the tests
      */ 
      System.out.println("\n--------\nAll tests for constructor, copy constructor, and equals() method are not running yet! \nPlease uncomment the test method calls in main()");
		TestsClassB.testsClassBConstr(out);
		TestsClassB.testsClassBCopyConstr(out);
		TestsClassB.testsClassBEquals(out);
	}

}
