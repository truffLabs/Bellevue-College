package edu.bellevuecollege.cs211.chapter17;

// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes fnumbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."


import java.util.*;

public class IntTree {

    private IntTreeNode overallRoot;

    public IntTree()
    {
        overallRoot = null;
    }


    public IntTree(IntTreeNode someRootNode)
    {
        this.overallRoot = someRootNode;
    }

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    //Exercise #1
    public int sum()
    {
        return sum(overallRoot);
    }

    //Exercise #1
    private int sum(IntTreeNode someRoot)
    {
        //handle empty Binary Tree
        if(someRoot == null)
        {
            return 0;
        }
        else
        {
            return someRoot.data + sum(someRoot.left) + sum(someRoot.right);
        }
    }

    //Exercise #3
    public int countEmpty()
    {
        return countEmpty(overallRoot);
    }

    //Exercise #3
    private int countEmpty(IntTreeNode someRoot)
    {
        //first base case
        if(someRoot == null)
        {
            return 1;
        }
        //second base case...both null
        else if (someRoot.left == null && someRoot.right == null)
        {
            return 2;
        }
        //third base case...left null
        else if(someRoot.left == null)
        {
            return 1 + countEmpty(someRoot.right);
        }
        //last base case...right null
        else if(someRoot.right == null)
        {
            return 1 + countEmpty(someRoot.left);
        }
        else
        {
            return countEmpty(someRoot.left) + countEmpty(someRoot.right);
        }
    }

    //Exercise #4
    //TODO: not working yet
    public int depthSum()
    {
        int depth = 1;
        return depthSum(overallRoot, depth);
    }

    private int depthSum(IntTreeNode someNode, int someDepth)
    {
        if(someNode == null)
        {
            return 0;
        }
        else
        {
            return someDepth * someNode.data + depthSum(someNode.left, someDepth+1) + depthSum(someNode.right, someDepth+1);
        }
    }

    //Exercise #5
    public int countEvenBranches()
    {
        return countEvenBranches(overallRoot);
    }

    //Exercise #5
    private int countEvenBranches(IntTreeNode someRoot)
    {
        //null base case
        if(someRoot == null)
        {
            return 0;
        }
        //leaf base case
        else if (someRoot.left == null && someRoot.right == null)
        {
            return 0;
        }
        //branch recursive case
        else
        {
            //check if node is even
            if(someRoot.data %2 == 0)
            {
                return 1 + countEvenBranches(someRoot.left) + countEvenBranches(someRoot.right);
            }
            //ignore, but recurse

            return countEvenBranches(someRoot.left) + countEvenBranches(someRoot.right);
        }
    }

    //Exercise #6
    public void printLevel(int someNum)
    {
        if(someNum < 1)
        {
            throw new IllegalArgumentException();
        }

        int leftLevel = 1, rightLevel = 1;

        printLevel(leftLevel, rightLevel, someNum, this.overallRoot);
    }

    //Exercise #6
    private void printLevel(int leftLevel, int rightLevel, int targetLevel, IntTreeNode someRoot)
    {
        if(someRoot == null)
        {
            //do nothing
        }
        else if(leftLevel == targetLevel)
        {
            System.out.println(someRoot.data);
        }
        else if(rightLevel == targetLevel)
        {
            System.out.println(someRoot.data);
        }
        else
        {
            leftLevel++;
            printLevel(leftLevel, rightLevel, targetLevel, someRoot.left);
            rightLevel++;
            printLevel(leftLevel, rightLevel, targetLevel, someRoot.right);
        }
    }

    //Exercise #7
    public void printLeaves()
    {
        printLeaves(overallRoot);
    }

    //Exercise #7
    private void printLeaves(IntTreeNode someNode)
    {
        if(someNode == null)
        {
            //do nothing
        }
        else if(someNode.left == null && someNode.right == null)
        {
            System.out.print(someNode.data + " ");
        }
        else
        {
            printLeaves(someNode.left);
            printLeaves(someNode.right);
        }
    }

    //Exercise #12
    public void numberNodes()
    {
        numberNodes(overallRoot, 1);
    }

    private int numberNodes(IntTreeNode someNode, int someNum)
    {
        if(someNode == null)
        {
            return someNum;
        }
        else
        {
            someNode.data = someNum;
            someNum = numberNodes(someNode.left, someNum+1);
            someNum =numberNodes(someNode.right, someNum);
        }
        return someNum;
    }



    //Exercise #13
    public void removeLeaves()
    {
        //IntTreeNode prevRoot = overallRoot;
        removeLeaves(overallRoot);
    }

    //Exercise #13
    private void removeLeaves(IntTreeNode someRoot)
    {
        //empty list
        if(someRoot == null)
        {
            return;
        }

        if (someRoot.left != null && someRoot.left.left == null && someRoot.left.right == null)
        {
            someRoot.left = null;
        }
        else
        {
            removeLeaves(someRoot.left);
        }

        if (someRoot.right != null && someRoot.right.left == null && someRoot.right.right == null)
        {
            someRoot.right = null;
        }
        else
        {
            removeLeaves(someRoot.right);
        }
    }

    //Exercise 15
    public void completeToLevel(int someNum)
    {
        if(someNum < 1)
        {
            throw new IllegalArgumentException();
        }

        int leftLevel = 1, rightLevel = 1;

        completeToLevel(overallRoot, leftLevel, rightLevel, someNum);
    }

    //Exercise 15
    private void completeToLevel(IntTreeNode someNode, int leftLevel, int rightLevel, int targetLevel)
    {
        if(someNode == null)
        {
            return;
        }
        //target level base case
        else if(leftLevel == targetLevel || rightLevel == targetLevel)
        {
            return;
        }
        //identify if branch node
        else if(someNode.left == null && someNode.right != null)
        {
            someNode.left = new IntTreeNode(-1);
        }
        else if(someNode.right == null && someNode.left != null)
        {
            someNode.right = new IntTreeNode(-1);
        }
        else
        {
            leftLevel++;
            completeToLevel(someNode.left, leftLevel, rightLevel, targetLevel);
            rightLevel++;
            completeToLevel(someNode.right, leftLevel, rightLevel, targetLevel);
        }
    }

    //Exercise 17
    public void tighten()
    {
        tighten(overallRoot);
    }

    //Exercise 17
    private void tighten(IntTreeNode someNode)
    {
        //null case
        if(someNode == null || someNode.left == null || someNode.right == null)
        {
            return;
        }
        //one branch node case
        if(someNode.left.left != null && (someNode.left.left != null && someNode.left.right == null))
        {
            someNode.left = someNode.left.left;
            tighten(someNode);
        }
        //one branch node case
        else if(someNode.right.right != null && (someNode.right.right != null && someNode.right.left == null))
        {
            someNode.right = someNode.right.right;
            tighten(someNode);
        }
        else
        {
            tighten(someNode.left);
            tighten(someNode.right);
        }
    }

    public void add(int someValue)
    {
        add(overallRoot, someValue);
    }
    private IntTreeNode add(IntTreeNode someNode, int someValue)
    {
        //if the tree is empty, create root node
        if(someNode == null)
        {
            someNode = new IntTreeNode(someValue);
        }
        else if(someValue <= someNode.data)
        {
            //add left
            someNode.left = add(someNode.left, someValue);
        }
        else
        {
            //add right
            someNode.right = add(someNode.right, someValue);
        }

        return someNode;
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

    public IntTreeNode getOverallRoot()
    {
        return overallRoot;
    }
}