package binaryTreeProblems;

public class Node {
    private  Object value;
    private Node right=null;
    private Node left=null;

    Node(Object value){
        this.value=value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
