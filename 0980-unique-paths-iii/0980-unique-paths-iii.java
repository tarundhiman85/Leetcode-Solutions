class Solution {
    //Asuming 4 directional walks as 4 directions
  public int paths(int i, int j, int n, int m, int [][] grid, int walkable)
    {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==-1 )
        {
            return 0;
        }
        if(grid[i][j]==2 ) {
            return walkable==0?1:0;
        }
        int temp = grid[i][j];
        grid[i][j]=-1;
        walkable--;
        int up = paths(i-1, j, n, m, grid, walkable);
        int down = paths(i+1, j, n, m, grid, walkable);
        int left = paths(i, j-1, n, m, grid, walkable);
        int right = paths(i, j+1, n, m, grid, walkable);
        grid[i][j]=temp;
        return up + down + left + right;
    }
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int i=0, j=0;
        int walkable = 0;
        for(int k=0; k<n; k++)
        {
            for(int l=0; l<m; l++)
            {
                if(grid[k][l]==1)
                {
                    i=k;
                    j=l;
                }
                else if(grid[k][l]==0)
                {
                    walkable++;
                }
            }
        }
        return paths(i, j, n, m, grid, walkable+1);
}
}