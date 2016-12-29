public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        
        List<String> path = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        if(s == null){
            return result;
        }
        helper(s, 0, path, result);
        return result;
    }
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
    public void helper(String s, int pos, List<String> path, List<List<String>> result){
        if(pos == s.length()){
            result.add(new ArrayList<String> (path));
            return;
        }
        for(int i = pos + 1; i <= s.length(); i++){
            String prefix = s.substring(pos, i);
            if(!isPalindrome(prefix)){
                continue;
            }
            path.add(prefix);
            helper(s, i, path, result);
            path.remove(path.size() - 1);
            
        }
    }
}
