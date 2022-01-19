package graphProblems;

import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        char[][] edges={{'w','x'},{'x','y'},{'z','y'},{'z','v'},{'w','v'}};
        System.out.println(buildGraph(edges));
        System.out.println(findShortestPath(buildGraph(edges),'w','y',0));

    }
    public static int findShortestPath(HashMap<Character,HashSet<Character>> graph,char src,char dst,int distance){
        Queue<Character> nodes=new LinkedList<>();
        Queue<Integer> edges=new LinkedList<>();
        Set<Character>visited=new HashSet<>();

        nodes.add(src);
        edges.add(distance);


        while(!nodes.isEmpty()){

            char current=nodes.poll();
            distance=edges.poll();
            visited.add(current);
           // distance++;
            if(current==dst){
                return distance;
            }
            for(char neighbor : graph.get(current)){
               if(!visited.contains(neighbor)){
                   nodes.add(neighbor);
                   edges.add(distance+1);
                   visited.add(neighbor);

               }

            }

        }

        return distance;
    }
    //Method to build a graph from array of edges
    public static HashMap<Character, HashSet<Character>> buildGraph(char[][] edges){
        HashMap<Character,HashSet<Character>>graph=new HashMap<>();
        for (char[] edge:edges){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0],new HashSet<>());
                graph.get(edge[0]).add(edge[1]);
            }else if(graph.containsKey(edge[0])){
                graph.get(edge[0]).add(edge[1]);
            }
            if(!graph.containsKey(edge[1])){
                graph.put(edge[1],new HashSet<>());
                graph.get(edge[1]).add(edge[0]);
            }else if(graph.containsKey(edge[1])){
                graph.get(edge[1]).add(edge[0]);

            }
        }
        return graph;
    }
}
