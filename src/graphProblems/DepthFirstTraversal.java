package graphProblems;

import java.util.HashMap;
import java.util.Stack;

public class DepthFirstTraversal {
    public static void main(String[] args) {
        HashMap<Character,char[]> graph=new HashMap();
        graph.put('a',new char[]{'c','b'});
        graph.put('b',new char[]{'d'});
        graph.put('c',new char[]{'e'});
        graph.put('d',new char[]{'f'});
        graph.put('e',new char[]{});
        graph.put('f',new char[]{});
depthFirstPrintIterative(graph,'a');
        System.out.println("=============================>");
depthFirstPrintRecursive(graph,'a');
    }

    public static void depthFirstPrintIterative(HashMap<Character, char[]> graph, char source){
        Stack<Character> stack=new Stack<>();
        stack.add(source);
        while(!stack.empty()){
            char current=stack.pop();
            System.out.println(current);
            for (char neighbor:graph.get(current)){
                stack.push(neighbor);

            }
        }

    }
    public  static void depthFirstPrintRecursive(HashMap<Character,char[]> graph,char source){
        System.out.println(source);
        for(char neighbor :graph.get(source)){
            depthFirstPrintRecursive(graph,neighbor);
        }
    }
}
