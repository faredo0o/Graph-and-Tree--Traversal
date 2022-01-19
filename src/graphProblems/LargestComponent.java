package graphProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LargestComponent {
    public static void main(String[] args) {
        HashMap<Integer,int[]> graph=new HashMap();
        graph.put(0,new int[]{8,1,5});
        graph.put(1,new int[]{0});
        graph.put(5,new int[]{0,8});
        graph.put(8,new int[]{0,5});
        graph.put(2,new int[]{3,4});
        graph.put(3,new int[]{2,4});
        graph.put(4,new int[]{3,2});
        System.out.println(largestComponent(graph));
    }
    public static int largestComponent(HashMap<Integer,int[]>graph){
        Set<Integer> visited=new HashSet<>();
       int largestCounter=0;
       int componentCount=0;
        for(int key:graph.keySet()){
          //  if(visited.contains(key))return 0;
            //visited.add(key);
            componentCount=ComponentCount(graph,key,visited);
            largestCounter=componentCount>largestCounter? componentCount:largestCounter;


        }
        return largestCounter;
    }
    public static int ComponentCount(HashMap<Integer,int[]>graph,int current,Set<Integer>visited){
       int counter=1;
        if(visited.contains(current))return 0;
        visited.add(current);
        for(int node:graph.get(current)){

            counter+=ComponentCount(graph,node,visited);

        }

        return counter;
    }
}

