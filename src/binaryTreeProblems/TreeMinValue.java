package binaryTreeProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMinValue {
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
        System.out.println(exploreMinDepthFirstIterative(a));
        System.out.println(exploreMinValueBreadthFirstIterative(a));
        System.out.println(exploreMinDepthFirstRecursive(a));

    }

    public static int exploreMinDepthFirstRecursive(Node root){
        if(root==null)return Integer.MAX_VALUE;
        int minValueLeft=exploreMinDepthFirstRecursive(root.getLeft());

        int minValueRight=exploreMinDepthFirstRecursive(root.getRight());
       return Math.min((int)root.getValue(),Math.min(minValueRight,minValueLeft));

    }
    public static int exploreMinDepthFirstIterative(Node root){
        if(root==null)return Integer.MAX_VALUE;
        Stack<Node> nodes=new Stack<>();
        int minValue=Integer.MAX_VALUE;
        nodes.add(root);
        while(!nodes.empty()){
            Node current=nodes.pop();

            minValue=(int)current.getValue()<minValue?(int)current.getValue():minValue;
            if(current.getLeft()!=null)nodes.add(current.getLeft());
            if(current.getRight()!=null)nodes.add((current.getRight()));
        }
        return minValue;
    }
    public static int exploreMinValueBreadthFirstIterative(Node root){
        if(root==null)return Integer.MAX_VALUE;
        Queue<Node> nodes=new LinkedList<>();
        int minValue=Integer.MAX_VALUE;
        nodes.add(root);
        while(!nodes.isEmpty()){
            Node current=nodes.poll();
            minValue=(int)current.getValue()<minValue?(int)current.getValue():minValue;
            if(current.getLeft()!=null)nodes.add(current.getLeft());
            if(current.getRight()!=null)nodes.add(current.getRight());
        }
        return minValue;
    }
}
