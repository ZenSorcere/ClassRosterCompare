//*******************************************************************
// ClassReader - Pre-Ch10(ArrayLists) thought experiment
//  
// I wanted to write a java program that would examine all 3 class
//  rosters for my Spring2020 quarter, and return who is taking all
//  3 classes with me.
//
// I created 3 text files with the names of all the students. I then 
//  wanted to access the files and save them to arrays, then compare
//  the arrays to return the commonalities to determine who else is 
//  taking the same three classes.
//
// Turns out, ArrayLists were the answer.
//
// I then output the resulting Lists to text files.
// 
//By: Michael Gilson
//Date: 4/20/2020 
//*******************************************************************


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class ClassReader {

	public static void main(String[] args) throws FileNotFoundException {
		//establish File objects from created roster text files.
		File f1 = new File("ITC155Roster.txt");
		File f2 = new File("ITC255Roster.txt");
		File f3 = new File("WEB150Roster.txt");
		// checks if files exists
		System.out.println("F1 Exists returns " + f1.exists());
		System.out.println("F2 Exists returns " + f2.exists());
		System.out.println("F3 Exists returns " + f3.exists());
		// checks if files can be read (boolean T/F)
		System.out.println("F1 Can Read returns " + f1.canRead());
		System.out.println("F2 Can Read returns " + f2.canRead());
		System.out.println("F3 Can Read returns " + f3.canRead());
		
		// checks size of files
		System.out.println("F1 Length returns " + f1.length());
		System.out.println("F2 Length returns " + f2.length());
		System.out.println("F3 Length returns " + f3.length());
		
		// returns full file location paths
		System.out.println("F1 Aboslute Path returns " + f1.getAbsolutePath());
		System.out.println("F2 Aboslute Path returns " + f2.getAbsolutePath());
		System.out.println("F3 Aboslute Path returns " + f3.getAbsolutePath());
		System.out.println();
		
		// creates ArrayList of Strings for rosterJava
		ArrayList<String> rosterJava = new ArrayList<String>();
		// accesses file
		Scanner input1 = new Scanner(new File("ITC155Roster.txt")); 
        // while loop to go through file, and for each line, add to rosterJava ArrayList
        while (input1.hasNextLine()) {
            String next = input1.nextLine();
            rosterJava.add(next);
        } //end input1 while loop
        
        // creates ArrayList of Strings for rosterSysAnl
     	ArrayList<String> rosterSysAnl = new ArrayList<String>();
     	// accesses file
     	Scanner input2 = new Scanner(new File("ITC255Roster.txt")); 
        // while loop to go through file, and for each line, add to rosterSysAnl ArrayList
        while (input2.hasNextLine()) {
             String next = input2.nextLine();
             rosterSysAnl.add(next);
        } //end input2 while loop
        
        // creates ArrayList of Strings for rosterJS
     	ArrayList<String> rosterJS = new ArrayList<String>();
     	// accesses file
     	Scanner input3 = new Scanner(new File("WEB150Roster.txt")); 
        // while loop to go through file, and for each line, add to rosterJS ArrayList
        while (input3.hasNextLine()) {
             String next = input3.nextLine();
             rosterJS.add(next);
        } //end input3 while loop
        
        
        // create List to retain all common elements between rosterJava and rosterSysAnl
        List<String> javSysAnl = new ArrayList<String>(rosterJava);
        javSysAnl.retainAll(rosterSysAnl);
        System.out.println();
        // print out the list of commonalities along with number(the size of the javSysAnl list)
    	System.out.println("Taking both Java2 and Systems Anlysis(" + javSysAnl.size() + "): " + javSysAnl);
    	
    	// create List to retain all common elements between rosterJava and rosterJS
    	List<String> javJS = new ArrayList<String>(rosterJava);
    	javJS.retainAll(rosterJS);
    	System.out.println();
    	// print out the list of commonalities along with number(the size of the javJS list)
    	System.out.println("Taking both Java2 and Javascript(" + javJS.size() + "): " + javJS);
    	
    	// create List to retain all common elements between rosterSysAnl and rosterJS
    	List<String> SysAnlJS = new ArrayList<String>(rosterSysAnl);
    	SysAnlJS.retainAll(rosterJS);
    	System.out.println();
    	// print out the list of commonalities along with number(the size of the SysAnlJS list)
    	System.out.println("Taking both Systems Anlysis and Javascript(" + SysAnlJS.size() + "): " + SysAnlJS);
    	
    	
    	// create List to retain all common elements between the first commonality(javSysAnl) and rosterJS
    	//   to get the commonalities across all three rosters.
    	List<String> all3 = new ArrayList<String>(javSysAnl);
    	all3.retainAll(rosterJS);
    	System.out.println();
    	// print out the list of commonalities along with number(the size of the all3 list)
    	System.out.println("All 3 classes in common(" + all3.size() + "): " + all3);
    	
    	
    	// output result of comparisons to txt files. a For loop goes through each value in the indicated
    	//   list, and prints to a new line in the created file.
    	PrintStream output1 = new PrintStream(new File("All3Classes.txt"));
    	for (String value : all3) {
    		output1.println(value);
    	}
    	PrintStream output2 = new PrintStream(new File("Java2andJS.txt"));
    	for (String value : javJS) {
    		output2.println(value);
    	}
    	PrintStream output3 = new PrintStream(new File("Java2andSystemsAnalysis.txt"));
    	for (String value : javSysAnl) {
    		output3.println(value);
    	}
    	PrintStream output4 = new PrintStream(new File("SystemsAnalysisandJS.txt"));
    	for (String value : SysAnlJS) {
    		output4.println(value);
    	}
    	// closes each of the newly created files
		output1.close();
		output2.close();
		output3.close();
		output4.close();

    	
		} //end Main

	
	} //end ClassReader class


