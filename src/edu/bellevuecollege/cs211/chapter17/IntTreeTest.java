package edu.bellevuecollege.cs211.chapter17;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Not exhaustive at all, but sets up each of the reference trees and tests basic functionality.
 */
public class IntTreeTest
{
    IntTree ref1;
    IntTree ref2;
    IntTree ref3;
    IntTree refNull;

    @Before
    public void setUp() throws Exception
    {
        IntTreeNode ref1Root = new IntTreeNode(3, new IntTreeNode(5, new IntTreeNode(1, null, null), null),
            new IntTreeNode(2, new IntTreeNode(4, null, null), new IntTreeNode(6, null, null)));

        ref1 = new IntTree(ref1Root);

        //ref1.printSideways();

        IntTreeNode ref2Root = new IntTreeNode(2, new IntTreeNode(8, new IntTreeNode(0, null, null), null),
                new IntTreeNode(1, new IntTreeNode(7, new IntTreeNode(4, null, null), null),
                        new IntTreeNode(6, null, new IntTreeNode(9, null, null))));

        ref2 = new IntTree(ref2Root);

        //ref2.printSideways();

        IntTreeNode ref3Root = new IntTreeNode(2, new IntTreeNode(3, new IntTreeNode(8, null, null),
                new IntTreeNode(7, null, null)), new IntTreeNode(1, null, null));

        ref3 = new IntTree(ref3Root);

        //ref3.printSideways();

        refNull = new IntTree();
    }

    public void testSum() throws Exception
    {
        assertEquals(21, ref1.sum());
        assertEquals(37, ref2.sum());
        assertEquals(21, ref3.sum());
        assertEquals(0, refNull.sum());
    }

    @Test
    public void testCountEmpty() throws Exception
    {
        assertEquals(7, ref1.countEmpty());
        assertEquals(9, ref2.countEmpty());
        assertEquals(6, ref3.countEmpty());
        assertEquals(1, refNull.countEmpty());
    }

    @Test
    public void testDepthSum() throws Exception
    {
        assertEquals(50, ref1.depthSum());
    }

    @Test
    public void testCountEvenBranches() throws Exception
    {
        assertEquals(1, ref1.countEvenBranches());
        assertEquals(3, ref2.countEvenBranches());
        assertEquals(1, ref3.countEvenBranches());
        assertEquals(0, refNull.countEvenBranches());
    }

    @Test
    public void testPrintLevel() throws Exception
    {
        //ref3.printLevel(3);
    }

    //test value less than 1
    @Test (expected = IllegalArgumentException.class)
    public void testPrintLevelBad() throws Exception
    {
        ref2.printLevel(0);
    }

    //test empty list
    @Test
    public void testPrintLevelBad2() throws Exception
    {
        //no exception should be thrown here
        refNull.printLevel(1);
    }

    @Test
    public void testPrintLeaves() throws Exception
    {
        //ref2.printLeaves();
    }

    @Test
    public void testNumberNodes() throws Exception
    {
        ref1.numberNodes();
        ref1.printSideways();
    }

    @Test
    public void testRemoveLeaves() throws Exception
    {
        ref1.removeLeaves();
        ref2.removeLeaves();
        ref3.removeLeaves();
        //shouldn't throw an exception
        refNull.removeLeaves();

        System.out.println("R1: \n");
        ref1.printSideways();
        System.out.println("\n");
        System.out.println("R2: ");
        System.out.println("\n");
        ref2.printSideways();
        System.out.println("\n");
        System.out.println("R3: ");
        System.out.println("\n");
        ref3.printSideways();
    }
}
