package binaryTreeProblems;

public class TreeMaxSumPath {
    public static void main(String[] args) {
        Node a=new Node(3);
        Node b=new Node(4);
        Node c=new Node(11);
        Node d=new Node(2);
        Node e=new Node(4);
        Node f=new Node(1);
        a.setLeft(c);
        a.setRight(b);
        c.setLeft(e);
        c.setRight(d);
        b.setRight(f);
        System.out.println(maxPathSumDepthFirstRecursive(a));
    }
    public static int maxPathSumDepthFirstRecursive(Node root){
        if(root==null)return 0;
        int rightPathMax=(int)root.getValue()+maxPathSumDepthFirstRecursive(root.getRight());
        int leftPathMax=(int)root.getValue()+maxPathSumDepthFirstRecursive(root.getLeft());

        return Math.max(rightPathMax,leftPathMax);

    }
}
