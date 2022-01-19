package graphProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstPrint {
    public static void main(String[] args) {
        HashMap<Character,char[]> graph=new HashMap();
        graph.put('a',new char[]{'c','b'});
        graph.put('b',new char[]{'d'});
        graph.put('c',new char[]{'e'});
        graph.put('d',new char[]{'f'});
        graph.put('e',new char[]{});
        graph.put('f',new char[]{});
        breadthFirstPrint(graph,'a');
    }
    public static void breadthFirstPrint(HashMap<Character,char[]> graph,char source){
        Queue<Character> queue=new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()){
            char current=queue.poll();
            System.out.println(current);
            for (char neighbor : graph.get(current)){
                queue.add(neighbor);
            }
        }

    }
}
