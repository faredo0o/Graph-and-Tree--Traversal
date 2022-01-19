package graphProblems;

import com.sun.source.doctree.SeeTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ConnectedComponentsCount {
    public static void main(String[] args) {
        HashMap<Integer,int[]> graph=new HashMap();
        graph.put(0,new int[]{8,1,5});
        graph.put(1,new int[]{0});
        graph.put(5,new int[]{0,8});
        graph.put(8,new int[]{0,5});
        graph.put(2,new int[]{3,4});
        graph.put(3,new int[]{2,4});
        graph.put(4,new int[]{3,2});
        System.out.println(connectedComponent(graph));
    }
    public static int connectedComponent(HashMap<Integer,int[]> graph){
        Set<Integer>visited=new HashSet<>();
        int counter=0;
        for(int current: graph.keySet()){

           if( explore(graph,current,visited)) counter++;
        }
        return counter;
    }
    public static boolean explore(HashMap<Integer,int[]> graph,int src, Set<Integer> visited){

        if(visited.contains(src)) return false;
        visited.add(src);
        for (int neighbor :graph.get(src)){

            explore(graph,neighbor,visited);

        }
        return true;
    }
}
