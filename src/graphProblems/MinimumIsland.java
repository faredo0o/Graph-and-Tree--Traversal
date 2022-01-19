package graphProblems;

import java.util.HashSet;
import java.util.Set;

public class MinimumIsland {
    public static void main(String[] args) {
        char[][] grid={ {'l','l','w','l','l'},
                        {'w','l','w','w','l'},
                        {'w','w','w','l','w'},
                        {'w','w','l','l','w'},
                        {'l','w','w','l','l'},
                        {'l','l','w','w','w'}};
        System.out.println(gridTraversal(grid));
    }
   public static int gridTraversal(char[][] grid){
        Set<String> visited=new HashSet<>();
        int minSize= Integer.MAX_VALUE;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[r].length;c++){
                int islandSize=minimumIsland(grid,r,c,visited);

                if (islandSize>0){
                    minSize=islandSize<minSize? islandSize:minSize;
                }

            }
        }
        return minSize;
   }
   public static int minimumIsland(char[][] grid, Integer r, Integer c,  Set<String> visited){
       boolean rawInBound=r>=0&&r<grid.length;
       if(!rawInBound)return 0;
       boolean columnInBound=c>=0&&c<grid[r].length;
       if(!columnInBound)return 0;
        if(visited.contains(r.toString()+','+c))return 0;
        if(grid[r][c]=='w')return 0;
        //islandSize++;
        visited.add(r.toString()+','+c);
        int islandSize=1;
       islandSize+= minimumIsland(grid,r-1,c,visited);
       islandSize+= minimumIsland(grid,r+1,c,visited);
       islandSize+= minimumIsland(grid,r,c-1,visited);
       islandSize+= minimumIsland(grid,r,c+1,visited);

        return islandSize;
   }
}
