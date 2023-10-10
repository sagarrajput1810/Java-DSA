package BinaryTree;
// Binary Search tree
// shorted tree means for each node (Left subtree data < root data <= right sub tree data).
public class BSTPractice {

// find the node in shorted tree of given data:
public static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int data) {
    if(root == null){
        return null;
    }
    if (root.data == data){
        return root;
    }
    else if (data < root.data){
        return findNode(root.left, data);
    }
    else{
        return findNode(root.right, data);
    }
    }
// print data of BST between k1 and k2 where k1,k2 is Integer
    public static void printBetweenK1K2(BinaryTreeNode<Integer> root, int k1, int k2){
        if (root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            System.out.println(root.data);
        }
        else if(root.data >k1){
            printBetweenK1K2(root.left, k1, k2);
        }
        else{
            printBetweenK1K2(root.right, k1, k2);
        }
    }

// Create a function for create shorted and balanced tree with the help of given shorted array.
// for this we find middle element for root node and do again this process for sub trees.



// Create a  function for check Is given root is BST or not:
    public static boolean isBST(BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }
        int leftMax = maximum(root.left);
        if(leftMax >= root.data){
            return false;
        }
        int rightMin = minimum(root.right);
        if(rightMin < root.data){
            return false;
        }
        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        return isLeftBST && isRightBST;
    }
    private static int minimum(BinaryTreeNode<Integer> root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
    private static int maximum(BinaryTreeNode<Integer> root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int largestLeft = maximum(root.left);
        int largestRight = maximum(root.right);
        return Math.max(root.data, Math.max(largestRight, largestLeft));
    }

// Check is Bst in better way or lest time complaxcity
    public static isBSTReturn isBST2(BinaryTreeNode<Integer> root){
        if(root == null){
            isBSTReturn leftAns = new isBSTReturn(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
            return leftAns;
        }
         isBSTReturn leftAns = isBST2(root.left);
         isBSTReturn rightAns = isBST2(root.right);

         int min =Math.min(root.data, Math.min(leftAns.min, rightAns.min));
         int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
         boolean isBST = true;
         if(leftAns.max >= root.data){
            isBST = false;
         }
         if(rightAns.min < root.data){
            isBST = false;
         }
         if(!leftAns.isBST){
            isBST = false;
         }
         if(!rightAns.isBST){
            isBST = false;
         }

         isBSTReturn ans = new isBSTReturn(min, max, isBST);
         return ans;
    }

    public static void main(String[] args) {

    }
}
