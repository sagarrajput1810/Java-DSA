package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeByUser {
//take input by the user for create Binary Tree
// this funtion work in pre order because first we fill parent and then child
    public static BinaryTreeNode<Integer> takeInputPre(){
        System.out.print("Enter the root data: ");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftchild = takeInputPre();
        BinaryTreeNode<Integer> rightchild = takeInputPre();
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
    
// for input in better way by the user:
// In this user aslo know in which parent node child node can be filled
// this funtion work in pre order because first we fill parent and then child
    public static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot){
            System.out.print("Enter root data: ");
        }
        else{
            if(isLeft){
                System.out.print("Enter left child of "+parentData+": ");
            }
            else{
                System.out.print("Enter right data of "+parentData+": ");
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        //Base case for recursion
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftchild = takeInputBetter(false,rootData,true);
        BinaryTreeNode<Integer> rightchild = takeInputBetter(false,rootData,false);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
// above both case is difficult for the user so Create a Function for take input level wise
// this can only done by the help of Queue
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s =new Scanner(System.in);
        System.out.println("Enter  root Data: ");
        int rootData = s.nextInt();

        if (rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildern = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildern.add(root);
         while(!pendingChildern.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChildern.poll();
            System.out.println("Enter left child of " + front.data);
            int left = s.nextInt();
            if(left != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChildern.add(leftChild);
            }
            System.out.println("Enter right child of " + front.data);
            int right = s.nextInt();
            if(right != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(left);
                front.left = rightChild;
                pendingChildern.add(rightChild);
            }
         }
         return root;

    }
    public static void main(String[] args) {
        // BinaryTreeNode<Integer> temp= takeInput();
        BinaryTreeNode<Integer> temp= takeInputBetter(true,0,false);
        BinaryTreeUse.printTreeDetailed(temp);
    }
}