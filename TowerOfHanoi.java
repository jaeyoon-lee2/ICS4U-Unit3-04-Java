/*
* This program gets number of disks as input,
* use recursion to solve the Tower of Hanoi and show the text of solution.
*
* @author  Jay Lee
* @version 1.0
* @since   2020-05-10
*/
// package ca.mths.unit3.unit04.java.main;

import java.util.Scanner;

public final class TowerOfHanoi {
    private TowerOfHanoi() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /** default value of start peg. */
    public static final int START_PEG = 1;
    /** default value of end peg. */
    public static final int END_PEG = 3;
    /** Constant value of peg. */
    public static final int PEG_NUMBER = 6;

    /**
    * This method uses recursion to solve the Tower of Hanoi.
    * @param ndisks
    * @param startPeg
    * @param endPeg
    */
    public static void hanoi(final int ndisks, final int startPeg,
                             final int endPeg) {
        // This is the recursive Towers of Hanoi solution
        if (ndisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg
                               + " to peg " + endPeg);
        } else {
            hanoi(ndisks - 1, startPeg, PEG_NUMBER - startPeg - endPeg);
            System.out.println("Move disk " + ndisks + " from peg "
                               + startPeg + " to peg " + endPeg);
            hanoi(ndisks - 1, PEG_NUMBER - startPeg - endPeg, endPeg);
        }
    }

    /**
    * This method gets number of disks,
    * passes to procedure called hanoi.
    * @param args
    */
    public static void main(final String[] args) {
        Scanner myObj = new Scanner(System.in);

        // Input
        System.out.println("Towers of Hanoi program\n");
        System.out.print("How many disks would you like in your tower (1->): ");

        try {
            int numberOfDisks = Integer.parseInt(myObj.nextLine());
            hanoi(numberOfDisks, START_PEG, END_PEG);
        } catch (Exception ex) {
            System.err.println("Invalid input.");
        }

        System.out.println("\nDone.");
    }
}
