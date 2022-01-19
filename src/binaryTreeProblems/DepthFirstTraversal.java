package binaryTreeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstTraversal {
    public static void main(String[] args) {
        Node a=new Node('a');
        Node b=new Node('b');
        Node c=new Node('c');
        Node d=new Node('d');
        Node e=new Node('e');
        Node f=new Node('f');
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);
        System.out.println(depthFirstIterativeValues(a));
        System.out.println("=========================");
        List<Object> resultList=new ArrayList<>();
        System.out.println( depthFirstRecursiveValues(a,resultList));
    }
    public static List<Object> depthFirstIterativeValues(Node root){
        Stack<Node> stack=new Stack<>();
        List<Object> resultList=new ArrayList<>();
        if(root==null) return resultList;
        stack.add(root);
        while(!stack.empty()){
            Node current=stack.pop();
            resultList.add(current.getValue());
           // System.out.println(current.getValue());
           if(current.getLeft()!=null) stack.add(current.getLeft());
            if(current.getRight()!=null) stack.add(current.getRight());

        }
        return resultList;

    }
    public static List<Object> depthFirstRecursiveValues(Node root,List<Object> resultList){
        if(root==null)return resultList;
        resultList.add(root.getValue());
      //System.out.println(root.getValue());
        if(root.getRight()==null&&root.getLeft()==null) return resultList;
        if(root.getLeft()!=null)depthFirstRecursiveValues(root.getLeft(),resultList);
        if(root.getRight()!=null)depthFirstRecursiveValues(root.getRight(),resultList);
        return resultList;
    }
}

