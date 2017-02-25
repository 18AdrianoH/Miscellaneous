
import java.util.*;



/**
 * TreeUtil contains the following methods for manipulating binary trees:
 * < put in your list of methods here>
 * @author Patrick Zhong
 * @version 11/20/2015
 *
 */
public class TreeUtil
{
    //used to prompt for command line input
    private static Scanner in = new Scanner(System.in);

    private static final boolean debug = false;

    /**
     * Returns leftmost object in tree
     * @param t root of tree
     * @return TreeNode object that is the leftmost
     */
    public static Object leftmost(TreeNode t)
    {
        // implement with a loop
        while (t.getLeft() != null)
        {
            t = t.getLeft();
        }
        return t;
    }

    /**
     * Returns rightmost object in tree
     * @param t root of tree
     * @return TreeNode object that is the rightmost
     */
    public static Object rightmost(TreeNode t)
    {
        // implement this recursively
        if (t.getRight() == null)
            return t;
        return rightmost(t.getRight());
    }

    /**
     * Returns depth of tree
     * @param t root of tree
     * @return integer depth
     */
    public static int maxDepth(TreeNode t)
    {
        if (t == null)
            return 0;
        int left = maxDepth(t.getLeft());
        int right = maxDepth(t.getRight());
        return (left > right) ? left + 1 : right + 1;
    }

    /**
     * create a random tree of the specif ied depth.  
     * No attempt to balance the tree is provided.
     * @param depth of the tree
     * @return TreeNode object that points to the generated tree
     */
    public static TreeNode createRandom(int depth)
    {
        if (Math.random() * Math.pow(2, depth) < 1)
            return null;
        return new TreeNode(((int)(Math.random() * 10)),
            createRandom(depth - 1),
            createRandom(depth - 1));
    }

    /**
     * Counts nodes in tree
     * @param t root of tree
     * @return integer number of nodes
     */
    public static int countNodes(TreeNode t)
    {
        if (t == null)
            return 0;
        return 1 + countNodes(t.getLeft()) + countNodes(t.getRight());
    }

    /**
     * Counts leaves in tree
     * @param t root of tree
     * @return integer number of leaves
     */
    public static int countLeaves(TreeNode t)
    {
        if (t.getLeft() == null && t.getRight() == null)
            return 1;
        else if (t.getLeft() == null)
            return countLeaves(t.getRight());
        else if (t.getRight() == null)
            return countLeaves(t.getLeft());
        else
            return countLeaves(t.getLeft()) + countLeaves(t.getRight());
    }

    /**
     * Walks through tree in preorder
     * @param t root of tree
     * @param display used to mark nodes
     */
    public static void preOrder(TreeNode t, TreeDisplay display)
    {
        if (t == null)
            return;
        display.visit(t);
        preOrder(t.getLeft(), display);
        preOrder(t.getRight(), display);
    }

    /**
     * Walks through tree in inorder
     * @param t root of tree
     * @param display used to mark nodes
     */
    public static void inOrder(TreeNode t, TreeDisplay display)
    {
        if (t == null)
            return;
        inOrder(t.getLeft(), display);
        display.visit(t);
        inOrder(t.getRight(), display);
    }

    /**
     * Walks through tree in postorder
     * @param t root of tree
     * @param display used to mark nodes
     */
    public static void postOrder(TreeNode t, TreeDisplay display)
    {
        if (t == null)
            return;
        postOrder(t.getLeft(), display);
        postOrder(t.getRight(), display); 
        display.visit(t);
    }

    /**
     * Fills given list the string version of a tree
     * @param t root of tree
     * @param list to fill
     */
    public static void fillList(TreeNode t, List<String> list)
    {
        if (t == null)
        {
            list.add("$");
            return;
        }
        list.add(t.getValue() + "");
        fillList(t.getLeft(), list);
        fillList(t.getRight(), list);
    }

    /**
     * saveTree uses the FileUtil utility class to save the tree rooted at t
     * as a file with the given file name
     * @param fileName is the name of the file to
     *  create which will hold the data values in the tree
     * @param t is the root of the tree to save
     */
    public static void saveTree(String fileName, TreeNode t)
    {
        List<String> list = new ArrayList<String>();
        fillList(t, list);
        FileUtil.saveFile(fileName, list.iterator());
    }

    /**
     * buildTree takes in an iterator which will
     *  iterate through a valid description of
     *  a binary tree with String values. 
     *  Null nodes are indicated by "$" markers
     * @param it the iterator which will iterate over the tree description
     * @return a pointer to the root of the tree built by the iteration
     */
    public static TreeNode buildTree(Iterator<String> it)
    {
        String next = it.next();
        if (next.equals("$"))
            return null;
        
        TreeNode t = new TreeNode(next);
        t.setLeft(buildTree(it));
        t.setRight(buildTree(it));
        return t;
    }

    /**
     * read a file description of a tree and then build the tree
     * @param fileName is a valid file name for a file
     *  that describes a binary tree
     * @return a pointer to the root of the tree
     */
    public static TreeNode loadTree(String fileName)
    {
        Iterator<String> iterator = FileUtil.loadFile(fileName);
        TreeNode tree = buildTree(iterator);
        return tree;
    }
    
    /**
     * utility method that waits for a user to type text
     *  into Std Input and then press enter
     * @return the string entered by the user
     */
    private static String getUserInput()
    {
        return in.nextLine();
    }

    /**
     * plays a single round of 20 questions
     * postcondition:  plays a round of twenty questions,
     *                 asking the user questions as it
     *                 walks down the given knowledge tree,
     *                 lighting up the display as it goes;
     *                 modif ies the tree to include information learned.
     * @param t a pointer to the root of the game tree
     * @param display which will show the progress of the game
     */
    private static void twentyQuestionsRound(TreeNode t, TreeDisplay display)
    {   
        throw new RuntimeException("Write ME!");
    }

    /** 
     * plays a game of 20 questions
     * Begins by reading in a starting file and then plays multiple rounds
     * until the user enters "quit".  Then the final tree is saved
     */
    public static void twentyQuestions()
    {
        throw new RuntimeException("Write ME!");
    }

    /**
     * copy a binary tree
     * @param t the root of the tree to copy
     * @return a new tree, which is a complete copy
     *         of t with all new TreeNode objects
     *         pointing to the same values as t (in the same order, shape, etc)
     */
    public static TreeNode copy(TreeNode t)
    {
        if (t == null)
            return null;
        return new TreeNode(t.getValue(), 
            copy(t.getLeft()), copy(t.getRight()));
    }

    /**
     * tests to see if two trees have the same shape, but not necessarily the
     * same values.  Two trees have the same shape if they have TreeNode objects
     * in the same locations relative to the root
     * @param t1 pointer to the root of the first tree
     * @param t2 pointer to the root of the second tree
     * @return true if t1 and t2 describe trees
     *         having the same shape, false otherwise
     */
    public static boolean sameShape(TreeNode t1, TreeNode t2)
    {
        if ((t1 == null) != (t2 == null))
            return false;
        else if (t1 == null && t2 == null)
            return true;
        return sameShape(t1.getLeft(), t2.getLeft()) && 
            sameShape(t1.getRight(), t2.getRight());
    }

    /**
     * Generate a tree for decoding Morse code
     * @param display the display that will show the decoding tree
     * @return the decoding tree
     */
    public static TreeNode createDecodingTree(TreeDisplay display)
    {
        TreeNode tree = new TreeNode("Morse Tree");
        display.displayTree(tree);
        insertMorse(tree, "a", ".-", display);
        insertMorse(tree, "b", "-...", display);
        insertMorse(tree, "c", "-.-.", display);
        insertMorse(tree, "d", "-..", display);
        insertMorse(tree, "e", ".", display);
        insertMorse(tree, "f", "..-.", display);
        insertMorse(tree, "g", "--.", display);
        insertMorse(tree, "h", "....", display);
        insertMorse(tree, "i", "..", display);
        insertMorse(tree, "j", ".---", display);
        insertMorse(tree, "k", "-.-", display);
        insertMorse(tree, "l", ".-..", display);
        insertMorse(tree, "m", "--", display);
        insertMorse(tree, "n", "-.", display);
        insertMorse(tree, "o", "---", display);
        insertMorse(tree, "p", ".--.", display);
        insertMorse(tree, "q", "--.-", display);
        insertMorse(tree, "r", ".-.", display);
        insertMorse(tree, "s", "...", display);
        insertMorse(tree, "t", "-", display);
        insertMorse(tree, "u", "..-", display);
        insertMorse(tree, "v", "...-", display);
        insertMorse(tree, "w", ".--", display);
        insertMorse(tree, "x", "-..-", display);
        insertMorse(tree, "y", "-.--", display);
        insertMorse(tree, "z", "--..", display);
        display.displayTree(tree);
        return tree;
    }

    /**
     * helper method for building a Morse code decoding tree.
     * postcondition:  inserts the given letter into the decodingTree,
     *                 in the appropriate position, as determined by
     *                 the given Morse code sequence; lights up the display
     *                 as it walks down the tree
     * @param decodingTree is the partial decoding tree
     * @param letter is the letter to add
     * @param code is the Morse code for letter
     * @param display is the display that will show progress as the method  
     *        walks down the tree
     */
    private static void insertMorse(TreeNode decodingTree, String letter,
    String code, TreeDisplay display)
    {
        String nextCode = "";
        
        if (code.equals(""))
        {
            decodingTree.setValue(letter);
            display.visit(decodingTree);
            return;
        }
        else if (code.length() > 1)
            nextCode = code.substring(1, code.length());
        
        if (code.substring(0, 1).equals("."))
        {
            if (decodingTree.getLeft() == null)
                decodingTree.setLeft(new TreeNode(""));
            insertMorse(decodingTree.getLeft(), letter, nextCode, display);
        }
        else
        {
            if (decodingTree.getRight() == null)
                decodingTree.setRight(new TreeNode(""));
            insertMorse(decodingTree.getRight(), letter, nextCode, display);
        }
    }

    /**
     * decodes Morse code by walking the decoding tree
     *      according to the input code
     * @param decodingTree is the Morse code decoding tree
     * @param cipherText is Morse code consisting of dots, dashes, and spaces
     * @param display is the display object that will show the decoding progress
     * @return the string represented by cipherText
     */
    public static String decodeMorse(TreeNode decodingTree, 
        String cipherText, TreeDisplay display)
    {
        return decodeMorseHelper(decodingTree,
            cipherText, display, decodingTree);
    }
    
    /**
     * Helper for decodeMorse
     * @param decodingTree is the Morse code decoding tree
     * @param cipherText is Morse code consisting of dots, dashes, and spaces
     * @param display is the display object that will show the decoding progress
     * @param fullDecodingTree is a complete, untouched decoding tree.
     * @return the string represented by cipherText
     */
    public static String decodeMorseHelper(TreeNode decodingTree,
        String cipherText, TreeDisplay display, TreeNode fullDecodingTree)
    {
        //It was either use a helper(this) or create a new decoding tree
        //for every new letter so for efficiency's sake I used a helper
        display.visit(decodingTree);
        if (cipherText.length() == 0)
            return (String)decodingTree.getValue();
        
        String fC = cipherText.substring(0, 1);
        System.out.println(cipherText);
        if (fC.equals("."))
            return decodeMorseHelper(decodingTree.getLeft(),
                cipherText.substring(1, cipherText.length()),
                display, fullDecodingTree);
        else if (fC.equals("-"))
            return decodeMorseHelper(decodingTree.getRight(),
                cipherText.substring(1, cipherText.length()),
                display, fullDecodingTree);
        else if (cipherText.length() >= 2 &&
            cipherText.substring(0, 2).equals("  "))
            return (String)decodingTree.getValue() + " " +
                decodeMorseHelper(fullDecodingTree,
                cipherText.substring(2, cipherText.length()),
                display, fullDecodingTree);
        else if (cipherText.length() >= 1 &&
            cipherText.substring(0, 1).equals(" "))
            return (String)decodingTree.getValue() +
                decodeMorseHelper(fullDecodingTree,
                cipherText.substring(1, cipherText.length()),
                display, fullDecodingTree);
        else
            return (String)decodingTree.getValue();
    }

    /**
     * optional work
     */
    public static int eval(TreeNode expTree)
    {
        throw new RuntimeException("Write ME!");
    }

    /**
     * optional work
     */
    public static TreeNode createExpressionTree(String exp)
    {
        throw new RuntimeException("Write ME!");
    }

    /**
     * debug printout
     * postcondition: out is printed to System.out
     * @param out the string to send to System.out
     */

    private static void debugPrint(String out)
    {
        if (debug) System.out.println("debug: " + out);
    }
}
