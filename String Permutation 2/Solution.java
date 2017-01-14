public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        
        List<String> result = new ArrayList<>();
        if(str == null || str.length() == 0){
            result.add(new String());
            return result;
        }
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        str = new String(temp);
        StringBuilder sb = new StringBuilder();
        int[] visited = new int[str.length()];
        helper(result, sb, str, visited);
        return result;
    }
    
    public void helper(List<String> result, StringBuilder sb, String str, int[] visited){
        
        if(sb.length() == str.length()){
                result.add(sb.toString());
                return;
            
        }
        
        for(int i = 0; i < str.length(); i++){
            if(visited[i] == 1){
                continue;
            }
            //如果不用这一步剪枝 就需要在最前面的出口地方加上result是否已经contains结果 这样的话其实就会导致超时  所以这道题的剪枝是必须的
            if(i != 0){
                if((str.charAt(i) == (str.charAt(i - 1)) && visited[i-1] == 0)){
                 continue;
             }
            }
            sb.append(str.charAt(i));
            visited[i] = 1;
            helper(result, sb, str, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = 0;
        }
    }
}
