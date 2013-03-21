package edu.bellevuecollege.cs211.chapter17;

// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes fnumbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."

public class IntSearchTree
{
    private IntTreeNode overallRoot;

    public IntSearchTree()
    {
        overallRoot = null;
    }

    public IntSearchTree(IntTreeNode someRootNode)
    {
        this.overallRoot = someRootNode;
    }

    public void add(int someValue)
    {
        overallRoot = add(overallRoot, someValue);
    }

    public IntTreeNode add(IntTreeNode node, int value)
    {
        //base case
        if(node == null)
        {
            node = new IntTreeNode(value);
        }
        else if(value <= node.data)
        {
            //add left
            node.left = add(node.left, value);
        }
        else //value > node.data
        {
            //add right
             node.right = add(node.right, value);
        }
        return node;
    }

    public Boolean contains(int value)
    {
        return contains(overallRoot, value);
    }

    private Boolean contains(IntTreeNode node, int value)
    {
        //base case
        if(node == null)
        {
            return false;
        }
        else if(value == node.data)
        {
            return true;
        }
        else if(value < node.data)
        {
            return contains(node.left, value);
        }
        else if(value > node.data)
        {
            return contains(node.right, value);
        }

        return false;
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