class Solution {
    public List<Integer> spiralOrder(int[][] matrix
                                    ) {
        int row1 = 0;
        int col1 = 0;
        int row2 = matrix.length;
        int col2 = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        while(row1 < row2 && col1 < col2){
            for(int i = col1; i < col2; i++) ans.add(matrix[row1][i]);
            row1++;
            
            for(int i = row1; i < row2; i++) ans.add(matrix[i][col2 - 1]);
            col2--;
            
            if(row1 < row2)
                for(int i = col2-1; i >= col1; i--) ans.add(matrix[row2-1][i]);
            row2--;
            if(col1 < col2)
                for(int i = row2 -1 ;i >= row1; i--) ans.add(matrix[i][col1]);
            col1++;
        }
        return ans;
    }
}