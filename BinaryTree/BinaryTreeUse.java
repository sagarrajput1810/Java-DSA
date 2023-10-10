package BinaryTree;

public class BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> rootleft = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rootright = new BinaryTreeNode<>(3);
        root.left = rootleft;
        root.right = rootright;
        BinaryTreeNode<Integer> rootleftright = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> rootrightleft = new BinaryTreeNode<>(5);
        rootleft.right = rootleftright;
        rootright.left = rootrightleft;

      //  printTree(root);
        printTreeDetailed(root);
    }

    public static void printTree(BinaryTreeNode<Integer> root){
        //TODO take care of base case
        if(root == null){
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
        
        // if(root.left != null){
        //     printTree(root.left);
        // }
        // if(root.right != null){
        //     printTree(root.right);
        // } this is long method
    }
// we want to print data like this   1 :l2 , r3   Detailed of node  l data and r data
    public static void printTreeDetailed(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data +": ");
        if(root.left != null){
            System.out.print("L"+root.left.data +", ");
        }
        if(root.right != null){
            System.out.print("R"+ root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }
// Create an function for height of the tree:
public static int height(BinaryTreeNode<Integer> root){
    if (root == null){
        return 0;
    }

    int leftHeight = height (root.left);
    int rightHeight = height(root.right);
    return 1 + Math.max(leftHeight, rightHeight);
}


// Balanced tree is ( |height of left node - height of right node| <= 1 ) this condition can apply at every Node.
    public static boolean isBalanced( BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        
        return isLeftBalanced && isRightBalanced;
    }
// this balanced check function have very high time complexcity
// so we create better function which have low time compecity
// for this we want to create a class which have two property (height, and isbalanced)
     public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        if(root == null){
            int height = 0;
            boolean isBal = true;
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }

        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
        boolean isBal = true;
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);
        if(Math.abs(leftOutput.height - rightOutput.height) > 1){
            isBal = false;
        }

        if(!leftOutput.isBalanced  || !rightOutput.isBalanced){
            isBal = false;
        }
        
        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
     }
//we create more better funtion for check isBST:
     public static boolean isBST(BinaryTreeNode<Integer> root, int minRange, int maxRange){
        if(root == null){
            return true;
        }
        if(root.data < minRange || root.data > maxRange){
            return false;
        }

        boolean isLeft = isBST(root.left, minRange, root.data-1);
        boolean isRight = isBST(root.right, root.data, maxRange);
        return isLeft && isRight;
     }

     
// Diameter of tree -  Distance between two fartest Node:
public static int diameter(BinaryTreeNode<Integer> root){
    if (root == null){
        return 0;
    }
    int option1 = height(root.left) + height(root.right);
    int option2 = diameter(root.left);
    int option3 = diameter(root.right);

    return Math.max(option1, Math.max(option2, option3));
}
}