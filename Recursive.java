/**
 * Methods completed by Timothy Hennessy CIS 340 Summer 2016.  Contains
 * methods for project 3.  The test client is RecursiveTester.java.
 * 
 * compilation: javac Recursive.java
 * Code compiled, executed, and tested on:
 *      Computer: Mac OS X version 10.11.5 running on x86_64
 *      Java:     1.8.0_91
 *      IDE/ver:  NetBeans IDE 8.1 (Build 201510222201)
 * 
 * execution:   See RecursiveTester.java
 * 
 * Methods completed by me include:
 * ---------------------------------------------------------------------------
 * int mcCarthy91(int n)
 * 
 * ArrayList<String> listMnemonics(String number)
 * 
 * void recursiveMnemonics(ArrayList<String> mnemonics, String mnemonicSoFar, 
 *      String digitsLeft)
 * 
 * String getBinary(int n)
 * 
 * String getBinary(int n, String bin)
 * 
 * String revString(String target)
 * 
 * String revString(String s, String newS, int pos)
 * 
 * boolean canFlowOffMap(int[][] map, int row, int col)
 * 
 * void canFlowOffMap(int[][] map, boolean[][] flow, int row, int col)
 * 
 * boolean testBoundaries(boolean[][] flow)
 * 
 * void drawTriangle(int depth, double[] tri)
 * 
 * void drawTriangles(double x1, double y1, double x2, double y2, double x3,
				     double y3, double minSide)
 *  
 */

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;


public class Recursive
{	

    /******************************************************************
     ******************************************************************/


    /**
     * McCarthy's 91 function.  
     * <br>pre: n > 0
     * Takes one of two actions based on the value of n.
     * (1) If n is greater than 100, return n - 10
     * (2) If n is less than 100, use nested recursion
     * For values of n less than 102, 91 will always be returned.
     * All other values will be n - 10
     * @param n
     * @return 91 if less than 102, otherwise n - 10
     */
    public int mcCarthy91(int n)
    {
	assert n > 0 : "Failed Precondition: mc91";
        // Base case
        if (n > 100)    
            return n - 10;
        // Recursive case
        else            
            return mcCarthy91(mcCarthy91(n + 11)); 
    }


    /******************************************************************
     ******************************************************************/
    // pre: s != null
    // post: reutrn true if every character in s is a digit ('0' through '9')
    private boolean allDigits(String s){
        assert s != null : "Failed precondition: allDigits";
        boolean allDigits = true;
        int i = 0;
        while(i < s.length() && allDigits){
            allDigits = s.charAt(i) >= '0' && s.charAt(i) <= '9';
            i++;
        }
        return allDigits;
    }
    
    /* pre: ch is a digit '0' through '9'
     * post: return the characters associated with this digit on a phone keypad
     */
    private String digitLetters(char ch){
	assert ('0' <= ch) && (ch <= '9') : "Failed precondition: digitLetters";
        String[] letters = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int index = (int)(ch - '0');
        return letters[index];
    }

    /**
     * Method calls a private helper method which will take an ArrayList,
     * an empty string, and a string. The ArrayList is used as an out 
     * parameter and contains the list of permutations produced from
     * the parameter number.
     * 
     * pre: number != null, all characters in number are digits
     * 
     * post: see tips section of assignment handout
     * 
     * @param number The number which will be used to create the list of
     * mnemonics.
     * @return an ArrayList containing all the mnemonics/permutations
     * resulting from the parameter number.
     */
    public ArrayList<String> listMnemonics(String number){
        assert number != null && allDigits(number): "Failed precondition: listMnemonics";
    	ArrayList<String> result = new ArrayList<String>();
    	recursiveMnemonics(result, "", number);
	return result;
    }


    /**
     * Recursively generates all the mnemonics (permutations) resulting from the
     * digits contained in digitsLeft.  Takes the next digit and gets the list
     * of letters associated with that digit.  The list of letters is used to
     * generate the permutations/mnemonics associated with the numbers.
     * 
     * pre: digitsLeft only contains numbers, no special characters
     * 
     * post: The string digitsLeft contains no more digits, it is off size 0
     * and the mnemonics generated have been added to the ArrayList mnemonics.
     * 
     * @param mnemonics is a list of strings, the mnemonics you have built up already
     * @param mnemonicSoFar is the current mnemonic you are working on building
     * @param digitsLeft is the string of digits that haven't been used to generate letters yet
     */
    private void recursiveMnemonics(ArrayList<String> mnemonics, String mnemonicSoFar, String digitsLeft)
    {
        // Base case
        if (digitsLeft.length() == 0)
        {
            // No digits remain, add mnemonicSoFar to ArrayList
            // NOTE: if there were no digits mnemonicSoFar can be
            // empty
            mnemonics.add(mnemonicSoFar);
            return;
        }
        // Recursive case
        else
        {
            // Store letters associated with first digit
            String digitOptions = digitLetters(digitsLeft.charAt(0));
            // One-by-one use each letter to generate mnemonics
            for (int i = 0; i < digitOptions.length(); i++)
                // Recursively call using first letter as mnemonicSoFar
                // and the remainder of the digitsLeft not including
                // the digit used for the letter
                recursiveMnemonics(mnemonics, mnemonicSoFar + 
                        digitOptions.charAt(i), digitsLeft.substring(1)); 
        }
    }

    /******************************************************************
     ******************************************************************/

    /**
     * Takes an integer n and calls a recursive helper method
     * to generate the binary equivalent and return it as a string.
     * 
     * pre: n >= 0
     * 
     * post: Returns a String that represents N in binary.
     * All chars in returned String are '1's or '0's.
     * Most significant digit is at position 0.
     * 
     * @param n Integer to be converted to binary string
     * @return a binary string representation of n
     */
    public String getBinary(int n)
    {
        assert n >= 0 : "Failed precondition: getBinary"; 
        String binary = "";
        return getBinary(n, binary);
    }
    
    /**
     * Recursively generates binary representation of n.  Uses remainder of 
     * n divided by 2 and stores it into an in/out string parameter in such
     * a way that the bits are stored with the most significant bit at the
     * front. Calls itself with n halved until n is equal to 0.
     * 
     * pre: n >= 0 and bin is an in/out parameter used to store
     * the partial binary representation of n.
     * 
     * post: A string representing the binary of n is returned.
     * 
     * @param n the integer to be converted to binary
     * @param bin in/out parameter used to store intermediate binary
     * form
     * @return the finalized binary representation of n in bin
     */
    private String getBinary(int n, String bin)
    {
        // Base case
        if (n == 0)
            return bin;
        // Recursive case
        bin = Integer.toString(n % 2) + bin;
        return getBinary(n / 2, bin);
    }
    
    /******************************************************************
     ******************************************************************/

    /**
     * Called by client and passed a target string that is reversed.
     * Calls a recursive helper method to reverse target.
     * 
     * pre: target != null
     * 
     * post: returns a String that is the reverse of target
     * 
     * @param target sent from client to be reversed
     * @return the reversed version of target
     */
    public String revString(String target){
	assert target != null : "Failed precondition: revString";
        String newStr = "";
    	return revString(target, newStr, target.length() - 1);
    }
    
    private String revString(String s, String newS, int pos)
    {
	if (pos == 0)
	    return newS + s.charAt(pos);
	else
	{
	    newS = newS + s.charAt(pos);
	    return revString(s, newS, pos - 1);
	}
    }

    
    /******************************************************************
     ******************************************************************/

    
    /**
     * Determine if water at a given point on a map can flow off the map.
     * <br>pre: map != null, map.length > 0, 
     * map is a rectangular matrix, 0 <= row < map.length, 0 <= col < map[0].length
     * post: return true if a drop of water starting at the location 
     * specified by row, column can reach the edge of the map, false otherwise.
     * @param map The elevations of a section of a map.
     * @param row The starting row of a drop of water.
     * @param col The starting column of a drop of water.
     */
    public boolean canFlowOffMap(int[][] map, int row, int col){
    	assert map != null && map.length > 0 && isRectangular(map) && inbounds(row, col, map)
	    : "Failed precondition: canFlowOffMap";
        int M = map.length, N = map[0].length;
        boolean[][] flow = new boolean[M][N];           // auto init to false
        // recursive helper method which uses flow as an output param
        canFlowOffMap(map, flow, row, col);
        // if water can flow off the map a flow boundary element will have
        // the value of true
        return testBoundaries(flow);
    }
    
    /**
     * Implements a depth first search recursive back tracking algorithm
     * to ascertain if water can reach the edge of the map.  Uses the 
     * values provided by map to decide if the next move is possible.
     * The next move is only possible if the integer value of the next
     * move is less than the current value, if so a recursive call is 
     * made.  Marks any element visited as true in flow.  All unvisited 
     * values are unreachable and left their initialized value of false.
     * 
     * pre: This is an overloaded method that assumes original calling
     * method pre-conditions are satisfied. 
     * 
     * post: All elements up, down, left, right of map[row][col]
     * have been tested and if reachable called.  The flow array is
     * assigned true for each element visited.
     * 
     * @param map 2D integer array with values representing elevation
     * @param flow 2D boolean array for reachable elements
     * @param row current row position in map
     * @param col current column position in map
     */
    private void canFlowOffMap(int[][] map, boolean[][] flow, int row, int col)
    {
        assert map != null && map.length > 0 && isRectangular(map) && inbounds(row, col, map)
	    : "Failed precondition: canFlowOffMap";
        // Base cases
        if (row < 0 || row >= map.length)         return;
        if (col < 0 || col >= map[row].length)    return;
        // current map[row][col] must be true
        flow[row][col] = true;
        // short circuit if next move will be out-of-bounds AND
        // do not recurse unless next move is true
        // i.e., the next move element is less
        // than the current element 
        if (inbounds(row + 1, col, map) && (map[row + 1][col] < map[row][col]))
            canFlowOffMap(map, flow, row + 1, col); // down
        if (inbounds(row, col + 1, map) && (map[row][col + 1] < map[row][col]))
            canFlowOffMap(map, flow, row, col + 1); // right
        if (inbounds(row, col - 1, map) && (map[row][col - 1] < map[row][col]))
            canFlowOffMap(map, flow, row, col - 1); // left
        if (inbounds(row - 1, col, map) && (map[row - 1][col] < map[row][col]))
            canFlowOffMap(map, flow, row - 1, col); // up
    }
    
    /**
     * Takes a 2D boolean array and test the elements comprising
     * the boundaries.  I.e., the first row, last row, first column,
     * and last column.
     * 
     * pre: flow != null 
     * 
     * post: All boundary elements were inspected, if any were true
     * true was returned.  If all boundary (aka edge) elements were
     * false, then false was returned.
     * 
     * @param flow array containing true for any element water can reach,
     * false otherwise
     * @return if water can make it to any element in the boundary, or
     * edge return true, otherwise water cannot make it edge return false
     */
    public boolean testBoundaries(boolean[][] flow)
    {
        if (flow == null)
            System.out.println("Error: testBoundaries parameter is null");
        // Test first row and last row
        int totalRows = flow.length, totalCols = flow[0].length;
        for (int i = 0; i < totalCols; i++)
        {
            if (flow[0][i] || flow[totalRows-1][i])
                return true;
        }
        // Test first col and last col
        for (int i = 0; i < totalRows; i++)
        {
            if (flow[i][0] || flow[i][totalCols-1])
                return true;
        }
        return false;
    }
    
    /**
     * Prints out the contents of a boolean array.  Used to
     * test canFlowOffTheMap. Prints out an asterisk for
     * true values and a dash for false values.
     * @param a boolean array
     */
    public void printArray(boolean[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i])
                System.out.print("* ");
            else
                System.out.print("- ");
        }
        System.out.println("\n");
    }


    /******************************************************************
     ******************************************************************/

    private static double mid(double x1, double x2){
	return (x1+x2)/2.0;
    }

    /**
     * Draw a Sierpinski triangle of a specified depth (number of levels of recursion)
     * @param depth
     * @param tri - an array of six double values, representing the three points of a triangle:
     *   (x1,y1), (x2,y2), (x3,y3) as {x1, y1, x2, y2, x3, y3}
     **/
    public void drawTriangle(int depth, double[] tri)
    {
        // make set of points more specific to algorithm, kind of redudant
        // but seeks to make code more clear
        double x1 = tri[0], y1 = tri[1], x2 = tri[2], y2 = tri[3],
                x3 = tri[4], y3 = tri[5];
        // Each activation divides the triangles line segments in half
        double x1to2 = mid(x1, x2), y1to2 = mid(y1, y2);
        double x1to3 = mid(x1, x3), y1to3 = mid(y1, y3);
        double x2to3 = mid(x2, x3), y2to3 = mid(y2, y3);
        // Base case
        if (depth == 0)
        {
            drawTriangles(x1, y1, x2, y2, x3, y3, 0);    
        }
        // Recursive case
        else
        { 
            drawTriangle(depth - 1, new double[] {x1, y1, x1to2, y1to2, x1to3, y1to3});
            drawTriangle(depth - 1, new double[] {x1to2, y1to2, x2, y2, x2to3, y2to3});
            drawTriangle(depth - 1, new double[] {x1to3, y1to3, x2to3, y2to3, x3, y3});
        }
    }

    /**
     * This method draws a triangle using the StdDraw.java library. Takes
     * six points used in drawing the triangle. Does not use minSide. Still
     * not really sure why it is there if we have the entire set of points
     * needed for the triangle.
     * @param x1 
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param minSide 
     */
    public static void drawTriangles(double x1, double y1, double x2, double y2, double x3,
				     double y3, double minSide)
    {
        // Draw the prettiest triangle you ever did see!
        StdDraw.line(x1, y1, x2, y2);
        //StdDraw.show(1000);
        StdDraw.line(x2, y2, x3, y3);
        //StdDraw.show(1000);
        StdDraw.line(x1, y1, x3, y3);
    }
        
    /**
     * Create a Sierpinski triangle
     * @param depth > 0; // number of levels of triangle to draw
     */
    public void drawTriangle(int depth){
	StdDraw.setPenRadius(.002);
	
	StdDraw.show(0);
	double[] tri={ 0.0, 0.0,
		       0.5, 1.0,
		       1.0, 0.0
	};
        drawTriangle(depth, tri); 
        StdDraw.show(0);

    }

    /******************************************************************
     ******************************************************************/
    

    /*
     * pre: mat != null, 
     */
    private boolean inbounds(int r, int c, int[][] mat){
    	assert mat != null : "Failed precondition: inbounds";
    	return r >= 0 && r < mat.length && mat[r] != null && c >= 0 && c < mat[r].length;
    }
    
    /* pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat)
    {	assert (mat != null) && (mat.length > 0) : "Violation of precondition: isRectangular";

	boolean correct = true;
	final int numCols = mat[0].length;
	int row = 0;
	while( correct && row < mat.length)
	    {	correct = (mat[row] != null) && (mat[row].length == numCols);
		row++;
	    }
	return correct;
    }


}
