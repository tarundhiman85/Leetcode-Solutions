class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], 1);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        int size = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    size = Math.max(size, check(i, j, grid));
                }
            }
        }
        return size;
    }

    public int check(int i, int j, int[][] grid){

        int sizeL = 0;
        int sizeR = 0;
        int sizeU = 0;
        int sizeD = 0;

        while(i - sizeL >= 0 && grid[i-sizeL][j] == 1){
            sizeL++;
        }
        while(i + sizeR < grid.length && grid[i+sizeR][j] == 1){
            sizeR++;
        }
        while(j - sizeU >= 0 && grid[i][j-sizeU] == 1){
            sizeU++;
        }
        while(j + sizeD < grid[0].length && grid[i][j+sizeD] == 1){
            sizeD++;
        }

        int size = 0;
        size = Math.min(Math.min(Math.min(sizeL, sizeR), sizeU), sizeD);

        return size;
    }
}