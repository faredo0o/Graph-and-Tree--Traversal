package graphProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HasPathProblem {
    public static void main(String[] args) {
        HashMap<Character,char[]> graph=new HashMap();
        graph.put('f',new char[]{'g','i'});
        graph.put('g',new char[]{'h'});
        graph.put('h',new char[]{});
        graph.put('i',new char[]{'g','k'});
        graph.put('j',new char[]{'i'});
        graph.put('k',new char[]{});
        System.out.println(hasPathDepthFirst(graph,'f','k'));
        System.out.println("=======================>");
        System.out.println(hasPathBreadthFirst(graph,'f','k'));
    }

    //Depth First Recursive
    public static boolean hasPathDepthFirst(HashMap<Character,char[]> graph, char src, char des){
        if(src==des) return true;

           for(char neighbor : graph.get(src)){
               if( hasPathDepthFirst(graph,neighbor,des)) return true;
            }

        return false;
    }
    //Breadth First Iterative
    public static boolean hasPathBreadthFirst(HashMap<Character,char[]>graph,char src,char des){
        Queue<Character> queue=new LinkedList<Character>();
        queue.add(src);
        while (!queue.isEmpty()){
            char current=queue.poll();
            if (current==des) return true;
            for(char neighbor : graph.get(current)){

                queue.add(neighbor);
            }
        }
        return false;
    }
}
