package BinaryTree;

import java.util.ArrayList;

public class BinaryTreeQuestions {

//Total Numers of nodes in given list:
    public static int numNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int count=0;
        count++;
        numNodes(root.left);
        count++;
        numNodes(root.right);
        return count+1;
    }
// Total numbers of leaves present in tree:
    public static int numLeaves(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return numLeaves(root.left) + numLeaves(root.right);
    }

    public static void main(String[] args) {
        System.out.println(numNodes(BinaryTreeByUser.takeInputBetter(true,0,false)));
    }
    
//Remove all leaves from tree:
    public static BinaryTreeNode<Integer> removeLeaves (BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        root.left = removeLeaves(root.left);
        root .right = removeLeaves(root.right);
        return root;
    }
// find the path of given element in a given tree:
    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            return null;
        }
        if(root.data == x){
            ArrayList<Integer> output = new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);
        if(leftOutput != null){
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
        if(rightOutput != null){
            rightOutput.add(root.data);
            return rightOutput;
        }

        return null; // when data is not exit in tree
    }
}