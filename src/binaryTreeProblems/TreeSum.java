package binaryTreeProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSum {
    public static void main(String[] args) {
        Node a=new Node(3);
        Node b=new Node(4);
        Node c=new Node(11);
        Node d=new Node(2);
        Node e=new Node(4);
        Node f=new Node(1);
        //Node j=new Node('j');
        a.setLeft(c);
        a.setRight(b);
        c.setLeft(e);
        c.setRight(d);
        b.setRight(f);
        System.out.println(treeSumDepthFirstRecursive(a));
        System.out.println(treeSumDepthFirstIterative(a));
        System.out.println(treeSumBreadthFirstIterative(a));

    }
    // Binary tree sum using DepthFirst Recursive Technique
    public static int treeSumDepthFirstRecursive(Node root){
        if(root==null)return 0;
       int num=Integer.parseInt(root.getValue().toString());

      return (int)root.getValue()+treeSumDepthFirstRecursive(root.getLeft())+treeSumDepthFirstRecursive(root.getRight());
    }
    // Binary tree sum using DepthFirst Iterative Technique
    public static int treeSumDepthFirstIterative(Node root){
        if(root==null)return 0;
        Stack<Node> nodes=new Stack<>();
        nodes.add(root);
        int sum=0;
        while(!nodes.empty()){
            Node current=nodes.pop();
            sum+=(int)current.getValue();
            if(current.getRight()!=null)nodes.add(current.getRight());
            if(current.getLeft()!=null)nodes.add(current.getLeft());
        }
        return sum;
    }

    // Binary tree sum using BreadthFirst Iterative Technique
    public static int treeSumBreadthFirstIterative(Node root){
        if(root==null)return 0;
        Queue<Node> nodes=new LinkedList<>();
        nodes.add(root);
        int sum=0;
        while(!nodes.isEmpty()){
            Node current=nodes.poll();
            sum+=(int)current.getValue();
            if(current.getRight()!=null)nodes.add(current.getRight());
            if(current.getLeft()!=null)nodes.add(current.getLeft());
        }
        return sum;
    }
}
