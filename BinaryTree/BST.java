package BinaryTree;

public class BST {
    private BinaryTreeNode<Integer> root;
    private int size;

    public boolean isPresent(int x){
        return isPresentHelper(root, x);
    }
    // this function create for help above funtion in which use can not pass node
    private static boolean isPresentHelper(BinaryTreeNode<Integer>node, int x){
        if (node == null){
            return false;
        }
        else if(node.data == x){
            return true;
        }
        else if(x < node.data){
            // call on left side of tree
            return isPresentHelper(node.left, x);
        }
        else{
            // call on right side of tree
            return isPresentHelper(node.right, x);
        }
    }



    public void printTree(){
        printTreeHelper(root);
    }
    private static void printTreeHelper(BinaryTreeNode<Integer> node) {
        if(node == null){
            return;
        }
        System.out.print(node.data +": ");
        if(node.left != null){
            System.out.print("L"+node.left.data +", ");
        }
        if(node.right != null){
            System.out.print("R"+ node.right.data);
        }
        System.out.println();
        printTreeHelper(node.left);
        printTreeHelper(node.right);
    }


    public void insert(int x){
        root = insertHelper(root, x);
        size++;
    }
    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int x) {
        if(node == null ){
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
            return newRoot;
        }
        if(x >= node.data){
            node.right = insertHelper(node.right, x);
        }
        else{
            node.left = insertHelper(node.left, x);
        }
        return node;
    }


    public boolean deleteData(int x){
        BSTDeleteReturn output = deleteDataHelper(root, x);
        root = output.root;
        if(output.deleted){
            size--;
        }
        return output.deleted;
    }
    private static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x) {
        if(root == null){
            return new BSTDeleteReturn(null, false);
        }
        else if(root.data < x){
            BSTDeleteReturn outputRight = deleteDataHelper(root.right, x);
            root.right = outputRight.root;
            outputRight.root = root;
            return outputRight;
        }else if(root.data > x){
            BSTDeleteReturn outputLeft = deleteDataHelper(root.left, x);
            root.left = outputLeft.root;
            outputLeft.root = root;
            return outputLeft;
        }
        else{
            if(root.left == null && root.right == null){
                return new BSTDeleteReturn(null, true);
            }
            else if( root.left != null && root.right == null){
                return new BSTDeleteReturn(root.left, true);
            }else if(root.left == null && root.right != null){
                return new BSTDeleteReturn(root.right, true);
            }
            else{
                int maxRight = maximum(root.right);
                root.data = maxRight;
                BSTDeleteReturn outputRight = deleteDataHelper(root.right, maxRight);
                root.right = outputRight.root;
                return new BSTDeleteReturn(root, true);
            }
        }
    }

    private static int maximum(BinaryTreeNode<Integer> root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int largestLeft = maximum(root.left);
        int largestRight = maximum(root.right);
        return Math.max(root.data, Math.max(largestRight, largestLeft));
    }
}
