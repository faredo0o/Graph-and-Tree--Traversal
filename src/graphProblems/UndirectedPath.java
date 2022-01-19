package graphProblems;

import java.util.*;

public class UndirectedPath {
    public static void main(String[] args) {
        char[][]edges={{'i','j'},{'k','i'},{'m','k'},{'k','l'},{'o','n'}};

        System.out.println(buildGraph(edges));
        System.out.println(hasPathDepthFirstRecursive(buildGraph(edges),'n','o',new HashSet<Character>()));
        System.out.println(hasPathDepthFirstIterative(buildGraph(edges),'n','o',new HashSet<Character>()));
        System.out.println(hasPathBreadthFirstIterative(buildGraph(edges),'k','n',new HashSet<Character>()));

    }
//UnDirected graph Has path DepthFirst Recursive solution
    public static boolean hasPathDepthFirstRecursive(HashMap<Character,List<Character>> graph, char src, char des, Set<Character> visited){
        if(src==des) return true;
        if(visited.contains(src))return false;
        visited.add(src);


        for(char neighbor : graph.get(src)){
//           if(!visited.contains(neighbor)) {
//               visited.add(neighbor);
               if (hasPathDepthFirstRecursive(graph, neighbor, des, visited)) return true;
          // }
        }
        return false;
    }

    //Undirected Graph Has path DepthFirst iterative solution
    public static boolean hasPathDepthFirstIterative(HashMap<Character,List<Character>> graph,char src,char dst,Set<Character> visited){
        Stack<Character> nodes=new Stack();
        nodes.add(src);
        char current=src;
        while(!nodes.empty()){
            current=nodes.pop();
            if(current==dst) return true;
            if(visited.contains(current)) return false;
            visited.add(current);

            for(char neighbor:graph.get(current) ){

                nodes.add(neighbor);

            }
        }

        return false;
    }

    //Undirected Graph Has Path BreadthFirst Iterative solution
static boolean hasPathBreadthFirstIterative(HashMap<Character,List<Character>> graph,char src,char dst,Set<Character> visited){
        Queue<Character> nodes=new LinkedList();
        nodes.add(src);
        while(!nodes.isEmpty()){

            char current=nodes.poll();
            if(current==dst)return true;
            if(visited.contains(current))return false;
            visited.add(current);
            for(char neighbor :graph.get(current)){
                nodes.add(neighbor);
            }
        }
        return false;
}
    // Building graph from edge set
    public static HashMap<Character,List<Character>> buildGraph(char[][] edges){
        HashMap<Character, List<Character>> graph=new HashMap<>();
        for(char[] edge : edges){

          if(!graph.containsKey(edge[0])){
              graph.put(edge[0],new ArrayList<>());
              graph.get(edge[0]).add(edge[1]);
          }
          else if(graph.containsKey(edge[0])){
              graph.get(edge[0]).add(edge[1]);
          }
            if(!graph.containsKey(edge[1])){
                graph.put(edge[1],new ArrayList<>());
                graph.get(edge[1]).add(edge[0]);
            }
            else if(graph.containsKey(edge[1])){
                graph.get(edge[1]).add(edge[0]);
            }
        }
        return graph;
    }
}

