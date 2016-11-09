public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        
       
        if(s1.length() == 0 || s1 == null){
            if(s2.equals(s3)){
                return true;
            }else{
                return false;
            }
        }
        if(s2.length() == 0 || s2 == null){
            if(s1.equals(s3)){
                return true;
            }else {
                return false;
            }
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        //state 
        int m = s1.length();
        int n = s2.length();
        
        boolean[][] state = new boolean[m+1][n+1];
        
        //initialize
        state[0][0] = true;
        for(int i = 1; i <= m; i++){
            state[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
        }
        for(int j = 1; j <= n; j++){
            state[0][j] = s2.substring(0,j).equals(s3.substring(0,j));
        }
      


        //function
        for(int i = 1; i < state.length; i++){
            for(int j = 1; j < state[0].length; j++){
                state[i][j] = (state[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1))) || (state[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)));
            }
        }
      
        
        //answer
        return state[m][n];
       
       
       
       
        
    }
}
