package edu.bellevuecollege.cs211.chapter17;

import edu.bellevuecollege.cs211.chapter17.*;

// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes fnumbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."

public class IntSearchTreeClient
{
    public static void main(String[] args)
    {
        int[] numbers = {18, -1, 73, 59, 100, 16, 2, 33, -100};

        IntSearchTree st1 = new IntSearchTree();

        for(int i : numbers)
        {
            st1.add(i);
        }

        st1.printSideways();
    }
}