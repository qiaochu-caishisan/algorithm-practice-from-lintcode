public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    private boolean[][] getIsPalindrome(String s){
        //state
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        
        //initialize
        for(int i = 0; i < s.length(); i++){
            isPalindrome[i][i] = true;
        }
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                isPalindrome[i][i+1] = true;
            }else{
                isPalindrome[i][i+1] = false;
            }
        }
        
        //function
      for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        
        //answer
        return isPalindrome;
        
    }
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        //state
        int n = s.length();
        int[] state = new int[n+1];
        
        //initialize
        state[0] = 0;

        //function
        for(int i = 1; i < state.length; i++){
            state[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(isPalindrome[j][i-1]){
                    state[i] = Math.min(state[i], state[j]+1);
                }
            }
        }
        
        
        return state[n] - 1;
        
        
    }
}
