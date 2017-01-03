class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        search(result, cols, n);
        return result;
    }
    
    public void search(ArrayList<ArrayList<String>> result, ArrayList<Integer> cols, int n){
        if(cols.size() == n){
            result.add(drawchessboard(cols));
            return;
        }
        //在backtracking算法中总会有一个for循环 就是意味着从第几个地方开始寻找起来，比如colsindex = 1的时候就是代表着0那个第一个位置是queen的情况已经找完了 现在要从代表着1的那个第二个位置开始找起来了
        for(int colsindex = 0; colsindex < n; colsindex++){
            if(!isvalid(cols, colsindex)){
                continue;
            }
            //cols是一个integer的arraylist 它里面存放的是一系列的数字 第几个数字是多少就意味着第几行的queen在哪一个位置
            cols.add(colsindex);
            search(result, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    public ArrayList<String> drawchessboard(ArrayList<Integer> cols){
        ArrayList<String> chessboard = new ArrayList<>();
        for(int i = 0; i < cols.size(); i++){
            //stringbuilder是一个很强大的类 对于处理string来说 很好用
            StringBuilder string = new StringBuilder();
            for(int j = 0; j < cols.size(); j++){
                if(j == cols.get(i)){
                    string.append('Q');
                }else{
                    string.append('.');
                }
            }
            chessboard.add(string.toString());
            
        }
        return chessboard;
    }
    public boolean isvalid(ArrayList<Integer> cols, int colsindex){
        int row = cols.size();
        for(int rowindex = 0; rowindex < cols.size(); rowindex++){
            //判断是否是同一列
            if(cols.get(rowindex) == colsindex){
                return false;
            }
            //判断是否是对角线 对角线判断：对于任意(i1, col[i1])和(i2, col[i2])，只有当abs(i1-i2) = abs(col[i1]-col[i2])时，两皇后才在同一对角线
            if(Math.abs(rowindex - row) == Math.abs(cols.get(rowindex) - colsindex)){
                return false;
            }
        }
        return true;
    }
};
