/************************************************************************
 * Code completed by Timothy Hennessy CIS 340 Summer 2016
 * 
 * This file requires Recursive.java and StdDraw.java.  As long
 * as those files are in the same directory or the java class
 * path, this file will compile.  No command line arguments or 
 * user input is required.
 * 
 * Methods tested include:
 * int mcCarthy91(int)
 * ArrayList<String> listMnemonics(String)
 * String getBinary(int)
 * String revString(String)
 * boolean canFlowOffMap(int[][],int,int)
 * drawTriangle()
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

public class RecursiveTester
{
    public static void main(String[] args)
    {	
        Recursive r = new Recursive();

	boolean passedAll = true;
	for(int i = 1; i <= 101 && passedAll; i++)
	    passedAll = r.mcCarthy91(i) == 91;

	if(passedAll)
	    System.out.println( "Test 1 passed. McCarthy 91");
	else
	    System.out.println( "Test 1 failed. McCarthy 91");

	if( r.mcCarthy91(102) == 92)
	    System.out.println( "Test 2 passed. McCarthy 91");
	else
	    System.out.println( "Test 2 failed. McCarthy 91");

	if( r.mcCarthy91(10000) == 9990)
	    System.out.println( "Test 3 passed. McCarthy 91");
	else
	    System.out.println( "Test 3 failed. McCarthy 91");
        
        if( r.mcCarthy91(900) == 890)
	    System.out.println( "Test 4 passed. McCarthy 91");
	else
	    System.out.println( "Test 4 failed. McCarthy 91");
        
        if( r.mcCarthy91(910) == 900)
	    System.out.println( "Test 5 passed. McCarthy 91");
	else
	    System.out.println( "Test 5 failed. McCarthy 91");
        
        if( r.mcCarthy91(925) == 915)
	    System.out.println( "Test 6 passed. McCarthy 91");
	else
	    System.out.println( "Test 6 failed. McCarthy 91");

        
	ArrayList<String> mnemonics = r.listMnemonics("1");
	ArrayList<String> expected = new ArrayList<String>();
	expected.add("1");
 
	if( mnemonics.equals(expected))
	    System.out.println( "Test 7 passed. Phone mnemonics.");
	else
	    System.out.println( "Test 7 failed. Phone mnemonics.");
        
	mnemonics = r.listMnemonics("22");
	Collections.sort(mnemonics);
	expected.clear();
	expected.add("AA");
	expected.add("AB");
	expected.add("AC");
	expected.add("BA");
	expected.add("BB");
	expected.add("BC");
	expected.add("CA");
	expected.add("CB");
	expected.add("CC");
	Collections.sort(expected);
        
	if( mnemonics.equals(expected))
	    System.out.println( "Test 8 passed. Phone mnemonics.");
	else
	    System.out.println( "Test 8 failed. Phone mnemonics.");

	mnemonics = r.listMnemonics("110010");
	expected.clear();
	expected.add("110010");
        if( mnemonics.equals(expected))
            System.out.println( "Test 9 passed. Phone mnemonics.");
        else
            System.out.println( "Test 9 failed. Phone mnemonics.");
        
        mnemonics = r.listMnemonics("23");
	Collections.sort(mnemonics);
	expected.clear();
	expected.add("AD");
	expected.add("AE");
	expected.add("AF");
	expected.add("BD");
	expected.add("BE");
	expected.add("BF");
	expected.add("CD");
	expected.add("CE");
	expected.add("CF");
	Collections.sort(expected);
        
	if( mnemonics.equals(expected))
	    System.out.println( "Test 10 passed. Phone mnemonics.");
	else
	    System.out.println( "Test 10 failed. Phone mnemonics.");
        
        mnemonics = r.listMnemonics("212");
        Collections.sort(mnemonics);
        expected.clear();
	expected.add("A1A");
	expected.add("A1B");
	expected.add("A1C");
	expected.add("B1A");
	expected.add("B1B");
	expected.add("B1C");
	expected.add("C1A");
	expected.add("C1B");
	expected.add("C1C");
	Collections.sort(expected);
        
	if( mnemonics.equals(expected))
	    System.out.println( "Test 11 passed. Phone mnemonics.");
	else
	    System.out.println( "Test 11 failed. Phone mnemonics.");
        
        mnemonics = r.listMnemonics("121");
        Collections.sort(mnemonics);
        expected.clear();
	expected.add("1A1");
	expected.add("1B1");
	expected.add("1C1");
	Collections.sort(expected);
        
	if( mnemonics.equals(expected))
	    System.out.println( "Test 12 passed. Phone mnemonics.");
	else
	    System.out.println( "Test 12 failed. Phone mnemonics.");
        
        // [WJ, WK, WL, XJ, XK, XL, YJ, YK, YL, ZJ, ZK, ZL]
        mnemonics = r.listMnemonics("95");
        Collections.sort(mnemonics);
        expected.clear();
	expected.add("WJ");
	expected.add("WK");
	expected.add("WL");
	expected.add("XJ");
	expected.add("XK");
	expected.add("XL");
	expected.add("YJ");
	expected.add("YK");
	expected.add("YL");
        expected.add("ZJ");
        expected.add("ZK");
        expected.add("ZL");
	Collections.sort(expected);
        
	if( mnemonics.equals(expected))
	    System.out.println( "Test 13 passed. Phone mnemonics.");
	else
	    System.out.println( "Test 13 failed. Phone mnemonics.");
        
	String binary = r.getBinary(13);
	String expectedBinary = "1101";        
	if( binary.equals(expectedBinary) )
	    System.out.println( "Test 14 passed. get binary.");
	else
	    System.out.println( "Test 14 failed. get binary");

	binary = r.getBinary(64);
	expectedBinary = "1000000";
	if( binary.equals(expectedBinary) )
	    System.out.println( "Test 15 passed. get binary");
	else
	    System.out.println( "Test 15 failed. get binary");
        
        binary = r.getBinary(129);
	expectedBinary = "10000001";
	if( binary.equals(expectedBinary) )
	    System.out.println( "Test 16 passed. get binary");
	else
	    System.out.println( "Test 16 failed. get binary");
        
        binary = r.getBinary(127);
	expectedBinary = "1111111";
	if( binary.equals(expectedBinary) )
	    System.out.println( "Test 17 passed. get binary");
	else
	    System.out.println( "Test 17 failed. get binary");
        
        binary = r.getBinary(256);
	expectedBinary = "100000000";
	if( binary.equals(expectedBinary) )
	    System.out.println( "Test 18 passed. get binary");
	else
	    System.out.println( "Test 18 failed. get binary");
        
        binary = r.getBinary(255);
	expectedBinary = "11111111";
	if( binary.equals(expectedBinary) )
	    System.out.println( "Test 19 passed. get binary");
	else
	    System.out.println( "Test 19 failed. get binary");

	String rev = r.revString("target");
	if( rev.equals("tegrat") )
	    System.out.println( "Test 20 passed. reverse string.");
	else
	    System.out.println( "Test 20 failed. reverse string.");

	rev = r.revString("Calvin and Hobbes");
	if( rev.equals("sebboH dna nivlaC") )
	    System.out.println( "Test 21 passed. reverse string.");
	else
	    System.out.println( "Test 21 failed. reverse string.");
        
        rev = r.revString("tacocat is a palindrome so is racecar");
	if( rev.equals("racecar si os emordnilap a si tacocat") )
	    System.out.println( "Test 22 passed. reverse string.");
	else
	    System.out.println( "Test 22 failed. reverse string.");
        
        rev = r.revString("ReVeRsE");
	if( rev.equals("EsReVeR") )
	    System.out.println( "Test 23 passed. reverse string.");
	else
	    System.out.println( "Test 23 failed. reverse string.");
        
        rev = r.revString("a");
	if( rev.equals("a") )
	    System.out.println( "Test 24 passed. reverse string.");
	else
	    System.out.println( "Test 24 failed. reverse string.");
        
	int[][] world = {{5,5,5,5,5,5},
			 {5,5,5,5,5,5},
			 {5,5,5,5,5,5},
			 {5,5,4,4,5,5},
			 {5,5,3,3,5,5},
			 {5,5,2,2,5,5},
			 {5,5,5,1,5,5},
			 {5,5,5,-2,5,5}};

	if( r.canFlowOffMap(world,0,0))
	    System.out.println( "Test 25 passed. can flow off map.");
	else
	    System.out.println( "Test 25 failed. can flow off map.");

	if( !r.canFlowOffMap(world,1,1))
	    System.out.println( "Test 26 passed. can't flow off map.");
	else
	    System.out.println( "Test 26 failed. can't flow off map.");

	if( r.canFlowOffMap(world,3,3))
	    System.out.println( "Test 27 passed. can flow off map.");
	else
	    System.out.println( "Test 27 failed. can flow off map.");

	if( r.canFlowOffMap(world,1,5))
	    System.out.println( "Test 28 passed. can flow off map.");
	else
	    System.out.println( "Test 28 failed. can flow off map.");

	world = new int[][]
	    {{10, 10, 10, 10, 10, 10, 10},
	     {10, 10, 10,  5, 10, 10, 10},
	     {10, 10, 10,  6, 10, 10, 10},
	     {10, 10, 10,  7, 10, 10, 10},
	     {5,   6,  7,  8,  7,  6, 10},
	     {10, 10, 10,  7, 10, 10, 10},
	     {10, 10, 10,  6, 10, 10, 10},
	     {10, 10, 10,  5, 10, 10, 10},
	     {10, 10, 10, 10, 10, 10, 10},
	    };

	if( !r.canFlowOffMap(world,3,3))
	    System.out.println( "Test 29 passed. can't flow off map.");
	else
	    System.out.println( "Test 29 failed. can't flow off map.");

	if( r.canFlowOffMap(world,4,3))
	    System.out.println( "Test 30 passed. can flow off map.");
	else
	    System.out.println( "Test 30 failed. can flow off map.");
        
        world = new int[][]
	    {{16, 16, 16, 16, 16, -1, 16},
	     {16, 12, 13, 14, 16,  0, 16},
	     {16, 11, 16, 15, 16,  1, 16},
	     {16, 10, 16, 16, 16,  2, 16},
	     {16,  9, 16, 16, 16,  3, 16},
	     {16,  8,  7,  6,  5,  4, 16},
	     {16, 16, 16, 16, 16, 16, 16},
	    };
        
        if( r.canFlowOffMap(world,3,3))
	    System.out.println( "Test 31 passed. can flow off map.");
	else
	    System.out.println( "Test 31 failed. can flow off map.");
        
        world = new int[][]
	    {{10, 10, 10, 10, 10, 10},
	     {10, 10,  8,  7,  6,  5},
	     {10, 10,  9, 10,  7, 10},
	     {10,  9, 10,  9,  8, 10},
	     {10,  8,  9,  8,  7, 10},
	     {10, 10, 10, 10, 10, 10},
	    };
        
        if( r.canFlowOffMap(world,3,2))
	    System.out.println( "Test 32 passed. can flow off map.");
	else
	    System.out.println( "Test 32 failed. can flow off map.");
        
        world = new int[][]
	    {{16, 16, 16, 16, 16, 16, 16},
	     {16, 15, 14, 16, 16, 16, 16},
	     {16, 16, 13, 12, 16, 16, 16},
	     {16, 16, 16, 11, 16, 16, 16},
	     {16,  8,  9, 10, 16, 16, 16},
	     {16,  7, 16, 16, 16, 16, 16},
	     {16,  6,  5,  4,  3,  2,  1},
	     {16, 16, 16, 16, 16, 16, 16},
	    };
        
        if( r.canFlowOffMap(world,1,1))
	    System.out.println( "Test 33 passed. can flow off map.");
	else
	    System.out.println( "Test 33 failed. can flow off map.");
        
        if( !r.canFlowOffMap(world,3,5))
	    System.out.println( "Test 34 passed. can't flow off map.");
	else
	    System.out.println( "Test 34 failed. can't flow off map.");
        
        world = new int[][]
	    {{10, 10, 10, 10, 10, 10},
	     {10,  8,  9,  8,  7, 10},
	     {10,  9, 10,  9,  8, 10},
	     {10,  8,  9,  8,  7, 10},
	     {10,  7,  8,  7,  6, 10},
	     {10, 10, 10, 10, 10, 10},
	    };
  
        if( !r.canFlowOffMap(world,2,2))
	    System.out.println( "Test 35 passed. can't flow off map.");
	else
	    System.out.println( "Test 35 failed. can't flow off map.");
        
	r.drawTriangle(6);
    }
}
