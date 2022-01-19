package graphProblems;

import java.util.HashSet;
import java.util.Set;

public class IslandCount {
    public static void main(String[] args) {
        char[][] grid={ {'l','l','w','l','l'},
                        {'w','l','w','w','l'},
                        {'l','w','w','l','w'},
                        {'w','w','l','l','w'},
                        {'l','w','w','l','l'},
                        {'l','l','w','w','w'}};

        System.out.println(countIslands(grid));
    }
    public static int countIslands(char[][] grid){

       int counter=0;
        Set<String> visited=new HashSet<>();


        for(int r=0;r<grid.length;r++){

            for(int c=0;c<grid[r].length;c++){

                   if(exploreIsland(grid,r,c,visited)){
                       counter++;
                   }

            }

        }
        return counter;
    }
    public static boolean exploreIsland(char[][] grid,Integer r,Integer c,Set<String> visited){
        boolean rawInBounds=r>=0&&r<grid.length;
        if(!rawInBounds)return false;
        boolean columnInBounds=c>=0&&c<grid[r].length;
        if(!columnInBounds) return false;
        if(visited.contains(r.toString()+','+c.toString())) return false;
        if(grid[r][c]=='w')return false;

       visited.add(r.toString()+','+c.toString());
       exploreIsland(grid,r-1,c,visited);
       exploreIsland(grid,r+1,c,visited);
       exploreIsland(grid,r,c-1,visited);
       exploreIsland(grid,r,c+1,visited);

        return true;
    }
}
