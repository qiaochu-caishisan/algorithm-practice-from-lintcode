class pair{
    public int row;
    public int column;
    public int level;
    public pair(int a, int b, int c){
        this.row = a;
        this.column = b;
        this.level = c;
    }
}

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        
        for(String word : words){
            Queue<pair> queue = new LinkedList<>();
        char start = word.charAt(0);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == start){
                    queue.add(new pair(i, j, 0));
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        while(!queue.isEmpty()){
            pair node = queue.poll();
            int[][] visited = new int[board.length][board[0].length];
            visited[node.row][node.column] = 1;
            dfs(node, check(node, word, visited, board), set, word, visited, board);
            if(set.contains(1)){
                if(!result.contains(word))
                result.add(word);
            }
        }
       
        }
        
        return result;
    }
    public void dfs (pair node, ArrayList<pair> list, HashSet<Integer> set, String word, int[][] visited, char[][] board){
        //System.out.println("(" + node.row + "," + node.column + "," + node.level + ")");
        if(list.size() == 0 && node.level + 1 == word.length()){
            set.add(1);
            return;
        }else if(list.size() == 0){
            return;
        }
        for(pair temp : list){
            // System.out.println("(" + temp.row + "," + temp.column + "," + temp.level + ")");
            visited[temp.row][temp.column] = 1;
            dfs(temp, check(temp, word, visited, board), set, word, visited, board);
            if(set.contains(1)){
                break;
            }
            visited[temp.row][temp.column] = 0;
        }
    }
    public ArrayList<pair> check(pair node, String word, int[][] visited, char[][] board){
        ArrayList<pair> result = new ArrayList<>();
        pair left = new pair(node.row, node.column - 1, node.level+1);
        pair right = new pair(node.row, node.column + 1, node.level + 1);
        pair down = new pair(node.row+1, node.column, node.level + 1);
        pair up = new pair(node.row - 1, node.column, node.level+1);
        if(left.row >= 0 && left.row < board.length && left.column >= 0 && left.column < board[0].length && left.level < word.length()){
             if(board[left.row][left.column] == word.charAt(left.level) && visited[left.row][left.column] == 0){
            result.add(left);
            //visited[left.row][left.column] = 1;
        }
        }
       if(right.row >= 0 && right.row < board.length && right.column >= 0 && right.column < board[0].length && right.level < word.length()){
            if(board[right.row][right.column] == word.charAt(right.level) && visited[right.row][right.column] == 0){
            result.add(right);
            //visited[right.row][right.column] = 1;
        }
       }
       if(down.row >= 0 && down.row < board.length && down.column >= 0 && down.column < board[0].length && down.level < word.length()){
           if(board[down.row][down.column] == word.charAt(down.level) && visited[down.row][down.column] == 0){
            result.add(down);
            //visited[down.row][down.column] = 1;
        }
       }
        if(up.row >= 0 && up.row < board.length && up.column >= 0 && up.column < board[0].length && up.level < word.length()){
            if(board[up.row][up.column] == word.charAt(up.level) && visited[up.row][up.column] == 0){
            result.add(up);
            //visited[up.row][up.column] = 1;
        }
        }
        return result;
        
    }
    
}
