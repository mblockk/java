/*
* 3134 Data Structures 
* HW3 Problem 1
* Tester for Problem 1
*/
import java.net.URL;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tester {
	public static void checkExit() throws FileNotFoundException, IOException {
		String path = System.getProperty("user.dir");
		File f = new File(path + "/ExpressionTree.java");
		BufferedReader r = new BufferedReader(new FileReader(f));
		String line = r.readLine();
		while (line != null) {
			if (line.contains("System.exit"))
				System.out.println("System.exit EXISTS");	
			line = r.readLine();
		}
	}

  public static void main(String[] args) throws FileNotFoundException, IOException {
		checkExit(); 

/*		System.out.println("\nTest 1");
		ExpressionTree tree = new ExpressionTree("4");
		System.out.println("Eval:  " + tree.eval());
		System.out.println("Postfix:  " + tree.postfix());
		System.out.println("Prefix:  "+tree.prefix());
		System.out.println("Infix:  "+tree.infix());
*/
		System.out.println("\nTest 2");
		ExpressionTree tree = new ExpressionTree("4 10 +");
		System.out.println("Eval:  " + tree.eval());
		System.out.println("Postfix:  " + tree.postfix());
		System.out.println("Prefix:  "+tree.prefix());
		System.out.println("Infix:  "+tree.infix());

		System.out.println("\nTest 3");
		tree = new ExpressionTree("2 3 + 8 4 / *");
		System.out.println("Eval:  " + tree.eval());
		System.out.println("Postfix:  " + tree.postfix());
		System.out.println("Prefix:  "+tree.prefix());
		System.out.println("Infix:  "+tree.infix());


		System.out.println("\nTest 4");
		tree = new ExpressionTree("2 3 1 - + 8 4 / *");
		System.out.println("Eval:  " + tree.eval());
		System.out.println("Postfix:  " + tree.postfix());
		System.out.println("Prefix:  "+tree.prefix());
		System.out.println("Infix:  "+tree.infix());
		
		System.out.println("\nTest 5");
	try {
    	tree = new ExpressionTree("3 2 - 5");
	}
	catch (Exception e) {
    	System.out.println("Exception thrown: " + e);
	}

	System.out.println("\nTest 6");
	try {
    	tree = new ExpressionTree("2 *");
	}
	catch (Exception e) {
    	System.out.println("Exception thrown: " + e);
		}
  }
}
