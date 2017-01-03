class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        
        if(n <= 0){
            return 0;
        }
        search(result, cols, n);
        return result.size();
    }
    public void search( ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cols, int n){
        
        if(cols.size() == n){
            result.add(cols);
             return;
        }
        for(int colsindex = 0; colsindex < n; colsindex++){
            if(!isvalid(cols, colsindex)){
                continue;
            }
            cols.add(colsindex);
            search(result, cols, n);
            cols.remove(cols.size() - 1);
        }
        
    }
    public boolean isvalid(ArrayList<Integer> cols, int colsindex){
        int row = cols.size();
        for(int rowindex = 0; rowindex < cols.size(); rowindex++){
            if(cols.get(rowindex) == colsindex){
                return false;
            }
            if(Math.abs(rowindex - row) == Math.abs(cols.get(rowindex) - colsindex)){
                return false;
            }
        }
        return true;
    }
};

