package binaryTreeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTraversal {
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
        System.out.println(breadthFirstTraversalIterative(a));
    }
    public static List<Object>breadthFirstTraversalIterative(Node root){
        List<Object> resultList=new ArrayList<>();
        if(root==null)return resultList;
        Queue<Node> nodes=new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            Node current=nodes.poll();
            resultList.add(current.getValue());
           if(current.getLeft()!=null) nodes.add(current.getLeft());
           if(current.getRight()!=null)nodes.add(current.getRight());
        }
        return resultList;
    }
}
