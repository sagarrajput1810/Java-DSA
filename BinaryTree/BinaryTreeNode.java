package BinaryTree;
// Binary tree mean which have 0 or 1 or 2 nodes
// First node called root or parent node
// this class have two property left and right for connect other nodes like linked list
public class BinaryTreeNode<t> {
    public t data;
    public BinaryTreeNode<t> left;
    public BinaryTreeNode<t> right;

    public BinaryTreeNode(t data){
        this.data = data;
    }
}
