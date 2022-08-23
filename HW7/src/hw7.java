import java.util.ArrayList;

/**
 * Stater Class
 */
public class hw7 {
    /**
     * Main function
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        System.out.println("Part 1\n");
        
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(1);
        nums.add(4);
        nums.add(7);
        nums.add(6);
        

        BinaryTree<Integer> left = new BinaryTree<>(9,null,null);
        BinaryTree<Integer> right = new BinaryTree<>(10,null,null);
        BinaryTree<Integer> structure = new BinaryTree<>(8,left,right);
        BinaryTree<Integer> tmp = new BinaryTree<>(11,null,structure);
        BinaryTree<Integer> tmp2 = new BinaryTree<>(12,tmp,null);


        System.out.println("Binary Tree's Structure");
        System.out.println(tmp2);
        System.out.println();

        System.out.println("Elements in the Array");
        System.out.println(nums);
        System.out.println();

        part1(tmp2,nums);

        System.out.println("\n\nPart 2\n");

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add( 1); 
        bst.add( 2); 
        bst.add( 3); 
        bst.add( 4); 
        bst.add( 5); 
        bst.add( 6); 
        bst.add( 7); 
       
        System.out.println("\tUnbalanced Binary Search Tree");
        System.out.println(bst);
        System.out.println("\n");



        AVLTree<Integer> avl =  part2(bst);
        System.out.println("\tBalanced AVL Tree");

        System.out.println(avl);
        
    }
    /**
     * The function takes in a BinaryTree and an ArrayList, sorts the ArrayList, and then inserts the
     * elements of the ArrayList into the BinaryTree in order
     * 
     * @param bt BinaryTree<E>
     * @param al ArrayList<E>
     */
    @SuppressWarnings("unchecked")
    public static <E> void part1(BinaryTree<E> bt, ArrayList<E> al)
    {
        al.sort(null);

        System.out.println("Sorted Array");
        System.out.println(al);
        System.out.println();
        
        bt.inOrderTraverse(bt.root,al);

        System.out.println("Binary Search Tree's Structure with Array's Elements");
        System.out.println(bt);
        System.out.println();
    }


    /**
     * > This function takes a BST and returns an AVL tree with the same elements that are balanced.
     * 
     * @param bst a BinarySearchTree<E> object
     * @return An AVLTree that is a balanced copy of the BST.
     */
    @SuppressWarnings("unchecked")
    public static <E extends Comparable<E>> AVLTree<E> part2(BinarySearchTree<E> bst)
    {
        AVLTree<E> avlt = new AVLTree<>();

        for (E elm : bst) {
            avlt.add(elm);
        }

        return avlt;
    }




}
