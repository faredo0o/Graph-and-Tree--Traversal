package binaryTreeProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeIncludesProblem {
    public static void main(String[] args) {
        Node a=new Node('a');
        Node b=new Node('b');
        Node c=new Node('c');
        Node d=new Node('d');
        Node e=new Node('e');
        Node f=new Node('f');
        Node j=new Node('j');
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);
        //c.setLeft(j);
        System.out.println(treeIncludesDepthFirstIterative(a,f));
        System.out.println(treeIncludesDepthFirstRecursive(a,j));
        System.out.println(treeIncludesBreadthFirstIterative(a,e));
    }
    public static boolean treeIncludesDepthFirstIterative(Node root,Node target){
       if(root==null||target==null)return false;
        if(root.getValue()==target.getValue())return true;
        Stack<Node> nodes=new Stack<>();
        nodes.add(root);
        while(!nodes.empty()){
            Node current=nodes.pop();
            if(current.getValue()==target.getValue()) return true;
            if(current.getRight()!=null)nodes.add(current.getRight());
            if(current.getLeft()!=null)nodes.add((current.getLeft()));
        }
        return false;

    }
    public static boolean treeIncludesDepthFirstRecursive(Node root,Node target){

        if(root==null||target==null) return false;
        if(root.getValue()==target.getValue())return true;
      return  treeIncludesDepthFirstRecursive(root.getRight(),target)|| treeIncludesDepthFirstRecursive(root.getLeft(),target);


    }
    public static boolean treeIncludesBreadthFirstIterative(Node root,Node target){
        if(root==null||target==null)return false;

        Queue<Node> nodes=new LinkedList();
        nodes.add(root);
        while(!nodes.isEmpty()){
            Node current=nodes.poll();
            if(current.getValue()==target.getValue())return true;
            if(current.getLeft()!=null)nodes.add(current.getLeft());
            if(current.getRight()!=null)nodes.add(current.getRight());

        }
        return false;

    }
}
