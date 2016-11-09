public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int maxlength = 0;
        for(String word : dict){
            maxlength = Math.max(maxlength, word.length());
        }
        
        //state
        int n = s.length();
        boolean[] state = new boolean[n+1];
        
        //initialize
        state[0] = true;
        //function
        for(int i = 1; i < state.length; i++){
            for(int j = i-1;  i - j <= maxlength && j >= 0; j--){
                // if(i - j > maxlength){
                //     continue;
                // }
                if(state[j] == true){
                   state[i] =  dict.contains(s.substring(j,i));
                   if(state[i] == true){
                       break;
                   }
                }
            }
        }
        
        //answer
        return state[n];
    }
}
